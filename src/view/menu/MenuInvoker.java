package view.menu;

import model.note.Note;
import presenter.NotebookPresenter;
import view.NotebookView;
import view.View;
import view.commands.CommandImpl;
import view.menu.Menu;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuInvoker implements NotebookView, View {
    private final Map<Integer, CommandImpl> commands = new HashMap<>();
    private final NotebookPresenter notebookPresenter;
    private final Menu menu;
    private final Scanner scanner;
    private boolean running;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public MenuInvoker() {
        this.scanner = new Scanner(System.in);
        running = true;
        notebookPresenter = new NotebookPresenter(this);
        menu = new Menu(this);
    }

    public void finish() {
        running = false;
        System.out.println("Всего доброго!");

    }

    private static void hello(String x) {
        System.out.println(x);
    }
    private void readInt(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }
    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {

            return false;
        }
    }
    private boolean checkTextForInt(String text) {
        return text.matches("[0-9]+");
    }
    public void addNotes(){
        LocalDateTime dateTime;
        while (true) {
            dateTime = readDateTime("Введите дату и время записи (например, 01.11.2023 19:00): ");
            if (dateTime != null) break;
        }
        hello("Введите описание записи: ");
        String description = scanner.nextLine();
        notebookPresenter.addNote(dateTime, description);
    }
    public void ShowNotesForDate(){
        LocalDate date = readDate("Введите дату (например, 01.11.2023): ");
        if (date != null) {
            notebookPresenter.showNotesForDate(date);
        }
    }
    public void showNotesForWeek() {
        DayOfWeek dayOfWeek = readDayOfWeek("Введите день недели (например, Понедельник): ");
        if (dayOfWeek != null) {
            LocalDate startOfWeek = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate endOfWeek = startOfWeek.plusDays(6);
            notebookPresenter.showNotesForWeek(startOfWeek, endOfWeek);
        }
    }
    public void saveNotes() {
        hello("Введите имя файла для сохранения записей: ");
        String filename = scanner.nextLine();
        if (isValidFilename(filename)) {
            notebookPresenter.saveNote(filename);
        } else {
            System.out.println("Ошибка: Неверное имя файла.");
        }
    }
    public void loadNotes() {
        System.out.print("Введите имя файла для загрузки записей: ");
        String filename = scanner.nextLine();
        while (!isValidFilename(filename)) {
            System.out.println("Ошибка: Неверное имя файла.");
            System.out.print("Введите корректное имя файла: ");
            filename = scanner.nextLine();
        }
        notebookPresenter.loadNote(filename);
    }
    private boolean isValidFilename(String filename) {
        return filename != null && !filename.trim().isEmpty() && filename.matches("^[\\w,\\s-]+\\.[A-Za-z]{3}$");
    }
    private DayOfWeek readDayOfWeek(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "понедельник" -> {
                    return DayOfWeek.MONDAY;
                }
                case "вторник" -> {
                    return DayOfWeek.TUESDAY;
                }
                case "среда" -> {
                    return DayOfWeek.WEDNESDAY;
                }
                case "четверг" -> {
                    return DayOfWeek.THURSDAY;
                }
                case "пятница" -> {
                    return DayOfWeek.FRIDAY;
                }
                case "суббота" -> {
                    return DayOfWeek.SATURDAY;
                }
                case "воскресенье" -> {
                    return DayOfWeek.SUNDAY;
                }
                default -> {
                    System.out.println("Ошибка: неверный день недели.");
                    return null;
                }
            }
        }
    }
    private LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ошибка: неверный формат даты. Ожидаемый формат: дд.ММ.гггг.");
            }
        }
    }
    @Override
    public void displayNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            hello("Записей не найдено.");
        } else {
            notes.forEach(note -> System.out.println(note));
        }
    }
    private LocalDateTime readDateTime(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return LocalDateTime.parse(input, dateTimeFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ошибка: неверный формат даты и времени. Ожидаемый формат: дд.ММ.гггг чч:мм.");
            }
        }
    }
    @Override
    public void displayMessage(String message) {
        hello(message);
    }

    @Override
    public void displayError(String errorMessage) {
        System.err.println("Ошибка: " + errorMessage);
    }

    @Override
    public void start() {
        while (running) {
            hello("\nВыберите действие:");
            printMenu();
            readInt();
        }
    }

    private void printMenu() {
        displayMessage(menu.menu());
    }
}

