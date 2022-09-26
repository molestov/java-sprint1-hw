import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker StepTracker = new StepTracker();
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
                StepTracker.saveDaySteps(monthNum, dayNum, dayValue);
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца (1-12):");
                int monthNum = scanner.nextInt();
                StepTracker.printStepsNumByDays(monthNum);
                System.out.println("Общее колличество шагов за месяц: " + StepTracker.printSumOfStepsByMonth(monthNum));
                StepTracker.printMaxSteps(monthNum);
                StepTracker.printAverageStepsNum(monthNum);
                StepTracker.printKm(monthNum);
                StepTracker.printCalories(monthNum);
                StepTracker.printBestSeries(monthNum);
            } else if (userInput == 3) {
                System.out.println("Введите новую цель по шагам:");
                int monthGoal = scanner.nextInt();
                StepTracker.editStepsGoal(monthGoal);
            } else {
                System.out.println("Введена неизвестная команда");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        String menu = "Выберите действие:\n" +
                "1. Ввести количество шагов за определённый день\n" +
                "2. Напечатать статистику за определённый месяц\n" +
                "3. Изменить цель по количеству шагов в день\n" +
                "0. Выйти из приложения";

        System.out.println(menu);

    }
}