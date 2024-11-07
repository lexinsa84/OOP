package view;

import presenter.Presenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUi implements View {
    private final Scanner scanner;
    private final SimpleDateFormat dateFormatter;
    private final Presenter presenter;
    private boolean exit;
    private final Menu menu;

    public ConsoleUi() {
        this.dateFormatter = new SimpleDateFormat();
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        exit = true;
        menu = new Menu(this);
    }

    @Override
    public void start() {
        while (exit) {
            hello("Добрый день! Выберите одно из действий:");
            printMenu();
            execute();
        }
    }

    private static void hello(String x) {
        System.out.println(x);
    }

    private void printMenu() {
        printAnswer(menu.menu());
    }

    private void execute() {
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


    public void showError(String x) {
        System.out.println(x);
    }

    public void finish() {
        exit = false;
        System.out.println("Всего доброго!");
    }

    public void getSortByBirth() {
        presenter.sortByAge();
    }

    public void getSortByName() {
        presenter.sortByName();
    }

    public void printFamilyTree() {
        presenter.printPersonInfo();
    }

    public void addPersonInput() {
        hello("Введите имя:");
        String firstName = scanner.nextLine();
        hello("Введите фамилию");
        String lastName = scanner.nextLine();
        hello("Введите отчество:");
        String patronymic = scanner.nextLine();
        hello("Введите день:");
        int day = scanner.nextInt();
        hello("Введите месяц");
        int month = scanner.nextInt();
        hello("Введите год:");
        int year = scanner.nextInt();
        hello("Введите пол:");
        String gender = scanner.nextLine();

        String birthString = day + "." + month + "." + year;

        LocalDate birth = null;
        try {
            birth = LocalDate.of(year, month, day);

        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты. Попробуйте снова.");
        }

        presenter.addStudent(firstName, lastName, patronymic, birth, gender);
    }

    @Override
    public void printAnswer(String answer) {
        hello(answer);
    }
}
