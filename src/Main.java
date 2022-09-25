import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker StepTracker = new StepTracker();
        monthData[] monthData = new monthData[12];
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new monthData();
        }
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {

            if (userInput == 1) {
                System.out.println("Введите номер месяца (1-12):");
                int monthNum = scanner.nextInt();
                System.out.println("Введите номер дня (1-30):");
                int dayNum = scanner.nextInt();
                System.out.println("Введите значение:");
                int dayValue = scanner.nextInt();
                StepTracker.addMonthValue(monthNum, dayNum, dayValue, monthData);
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца (1-12):");
                int monthNum = scanner.nextInt();
                StepTracker.printStepsNumByDays(monthNum, monthData);
                System.out.println("Общее колличество шагов за месяц: " + StepTracker.printSumOfStepsByMonth(monthNum, monthData));
                StepTracker.printMaxSteps(monthNum, monthData);
                StepTracker.printAverageStepsNum(monthNum, monthData);
                StepTracker.printKm(monthNum, monthData);
                StepTracker.printCalories(monthNum, monthData);
                StepTracker.printBestSeries(monthNum, StepTracker, monthData);
            } else if (userInput == 3) {
                System.out.println("Введите новую цель по шагам:");
                int monthGoal = scanner.nextInt();
                StepTracker.editStepsGoal(monthGoal);
            } else {
                System.out.println("Введена неизвестная команда");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        String[] menu = {"1. Ввести количество шагов за определённый день",
                "2. Напечатать статистику за определённый месяц",
                "3. Изменить цель по количеству шагов в день",
                "0. Выйти из приложения"};

        System.out.println("Выберите действие:");

        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }
}