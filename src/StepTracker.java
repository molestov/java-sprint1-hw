import java.util.Arrays;

public class StepTracker {

    int stepsGoal = 10000;
    Converter converter = new Converter();
    MonthData[] MonthData = new MonthData[12];

    public StepTracker() {
        for (int i = 0; i < MonthData.length; i++) {
            MonthData[i] = new MonthData();
        }
    }

    public void saveDaySteps(int monthNum, int dayNum, int dayValue) {
        MonthData[monthNum].days[dayNum - 1] = dayValue;
    }

    public boolean checkUserInput(int userInput) {
        return userInput > 0;
    }

    public void editStepsGoal(int stepsGoal) {
        if (checkUserInput(stepsGoal)) {
            this.stepsGoal = stepsGoal;
        } else {
            System.out.println("Введено неверное значение");
        }
    }

    public void printStepsNumByDays(int monthNum){
        System.out.println("Шаги по дням: ");
        for(int i = 0; i < MonthData[monthNum].days.length; i++) {
            System.out.println(i + 1 + " день: " + MonthData[monthNum].days[i]);
        }
    }

    public int printSumOfStepsByMonth(int monthNum) {
        int sumOfSteps = 0;
        for(int i=0; i < MonthData[monthNum].days.length; i++) {
            sumOfSteps += MonthData[monthNum].days[i];
        }
        return sumOfSteps;
    }

    public void printMaxSteps(int monthNum) {
        int maxValue = Arrays.stream(MonthData[monthNum].days)
                .max()
                .getAsInt();
        System.out.println("Макисмальное колличество шагов: " + maxValue);
    }

    public void printAverageStepsNum(int monthNum) {
        int averageStepsNum = printSumOfStepsByMonth(monthNum) / MonthData[monthNum].days.length;
        System.out.println("Среднее колличество шагов за месяц: " + averageStepsNum);
    }

    public void printKm(int monthNum) {
        double km = converter.stepsToKm(printSumOfStepsByMonth(monthNum));
        System.out.println("Пройдено за месяц киллометров: " + km);
    }

    public void printCalories(int monthNum) {
        double cal = converter.stepsToCalories(printSumOfStepsByMonth(monthNum));
        System.out.println("Сожжено за месяц киллокалорий: " + cal);
    }

    public void printBestSeries(int monthNum) {
        int maxFoundedSeries = 0;
        int maxFounded = 0;
        for (int i = 0; i < MonthData[monthNum].days.length; i++) {
            if (MonthData[monthNum].days[i] >= stepsGoal) {
                maxFounded++;
                if (maxFoundedSeries < maxFounded) {
                    maxFoundedSeries = maxFounded;
                }
            } else {
                maxFounded = 0;
            }
        }
        System.out.println("Лучшая серия: " + maxFoundedSeries);
    }
}
