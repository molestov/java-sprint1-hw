import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {

            if (userInput == 1) {
                System.out.println(Messages.ENTER_MONTH_NUM);
                int monthNum = scanner.nextInt();
                System.out.println(Messages.ENTER_DAY_NUM);
                int dayNum = scanner.nextInt();
                System.out.println(Messages.ENTER_VALUE);
                int dayValue = scanner.nextInt();
                stepTracker.saveDaySteps(monthNum, dayNum, dayValue);
            } else if (userInput == 2) {
                System.out.println(Messages.ENTER_MONTH_NUM);
                int monthNum = scanner.nextInt();
                stepTracker.printMonthStatistic(monthNum);
            } else if (userInput == 3) {
                System.out.println(Messages.ENTER_NEW_GOAL);
                int monthGoal = scanner.nextInt();
                stepTracker.editStepsGoal(monthGoal);
            } else {
                System.out.println(Messages.UNKNOWN_COMMAND);
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println(Messages.EXIT_PROCESS);
    }

    private static void printMenu() {
        System.out.println(Messages.MAIN_MENU);
    }
}