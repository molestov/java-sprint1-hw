import java.util.Arrays;

public class StepTracker {
    int stepsGoal = 10000;
    Converter converter = new Converter();
    MonthData[] monthData = new MonthData[12];

    public StepTracker() {
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }

    public void saveDaySteps(int monthNum, int dayNum, int dayValue) {
        if (checkUserInput(dayValue)) {
            monthData[monthNum].days[dayNum - 1] = dayValue;
        } else {
            System.out.println(Messages.ERROR_INPUT);
        }
    }

    public boolean checkUserInput(int userInput) {
        return userInput > 0;
    }

    public void editStepsGoal(int stepsGoal) {
        if (checkUserInput(stepsGoal)) {
            this.stepsGoal = stepsGoal;
        } else {
            System.out.println(Messages.ERROR_INPUT);
        }
    }

    public void printStepsNumByDays(int monthNum){
        System.out.println(Messages.STEPS_BY_DAYS);
        for(int i = 0; i < monthData[monthNum].days.length; i++) {
            System.out.println(i + 1 + Messages.DAY + monthData[monthNum].days[i]);
        }
    }

    public int printSumOfStepsByMonth(int monthNum) {
        int sumOfSteps = 0;
        for(int i = 0; i < monthData[monthNum].days.length; i++) {
            sumOfSteps += monthData[monthNum].days[i];
        }
        return sumOfSteps;
    }

    public void printMaxSteps(int monthNum) {
        int maxValue = Arrays.stream(monthData[monthNum].days)
                .max()
                .getAsInt();
        System.out.println(Messages.MAX_STEPS + maxValue);
    }

    public void printAverageStepsNum(int monthNum) {
        int averageStepsNum = printSumOfStepsByMonth(monthNum) / monthData[monthNum].days.length;
        System.out.println(Messages.AVERAGE_STEPS + averageStepsNum);
    }

    public void printKm(int monthNum) {
        double km = converter.stepsToKm(printSumOfStepsByMonth(monthNum));
        System.out.println(Messages.MONTH_KM + km);
    }

    public void printCalories(int monthNum) {
        double cal = converter.stepsToCalories(printSumOfStepsByMonth(monthNum));
        System.out.println(Messages.CALORIES_BURN + cal);
    }

    public void printBestSeries(int monthNum) {
        int maxFoundedSeries = 0;
        int maxFounded = 0;
        for (int i = 0; i < monthData[monthNum].days.length; i++) {
            if (monthData[monthNum].days[i] >= stepsGoal) {
                maxFounded++;
                if (maxFoundedSeries < maxFounded) {
                    maxFoundedSeries = maxFounded;
                }
            } else {
                maxFounded = 0;
            }
        }
        System.out.println(Messages.BEST_SERIES + maxFoundedSeries);
    }
    public void printMonthStatistic(int monthNum){
        printStepsNumByDays(monthNum);
        System.out.println(Messages.STEPS_SUM + printSumOfStepsByMonth(monthNum));
        printMaxSteps(monthNum);
        printAverageStepsNum(monthNum);
        printKm(monthNum);
        printCalories(monthNum);
        printBestSeries(monthNum);
    }
}
