import java.util.Arrays;

public class StepTracker {

    int stepsGoal = 10000;

    //Добавляем данные за день
    public void addMonthValue(int monthNum, int dayNum, int dayValue, monthData[] monthData) {
        monthData[monthNum].days[dayNum-1] = dayValue;
    }

    //Проверяем ввод пользователя на отрицательное значение
    public boolean checkUserInput(int userInput) {
        if(userInput > 0) return true;
        else return false;
    }

    //Вводим новую цель по шагам
    public void editStepsGoal(int stepsGoal) {
        if(checkUserInput(stepsGoal)) {
            this.stepsGoal = stepsGoal;
        } else {
            System.out.println("Введено неверное значение");
        }
    }

    //Выводим данные за каждый день в опередленном месяце
    public void printStepsNumByDays(int monthNum, monthData[] monthData){
        System.out.println("Шаги по дням: ");
        for(int i = 0; i < monthData[monthNum].days.length; i++) {
            System.out.println(i + 1 + " день: " + monthData[monthNum].days[i]);
        }
    }
    //Выводим сумму всех шагов за месяц
    public int printSumOfStepsByMonth(int monthNum, monthData[] monthData) {
        int sumOfSteps = 0;
        for(int i=0; i < monthData[monthNum].days.length; i++) {
            sumOfSteps += monthData[monthNum].days[i];
        }
        return sumOfSteps;
    }
    //Ищем максимальное значение шагов за месяц
    public void printMaxSteps(int monthNum, monthData[] monthData) {
        int maxValue = Arrays.stream(monthData[monthNum].days).max().getAsInt();
        System.out.println("Макисмальное колличество шагов: " + maxValue);
    }
    //Выводим среднее значение по шагам за месяц
    public void printAverageStepsNum(int monthNum, monthData[] monthData) {
        int averageStepsNum = printSumOfStepsByMonth(monthNum, monthData) / monthData[monthNum].days.length;
        System.out.println("Среднее колличество шагов за месяц: " + averageStepsNum);
    }
    //Выводим пройденное расстояние в киллометрах
    public void printKm(int monthNum, monthData[] monthData) {
        Converter converter = new Converter();
        double km = converter.stepsToKm(printSumOfStepsByMonth(monthNum, monthData));
        System.out.println("Пройдено за месяц киллометров: " + km);
    }
    //Считаем сожженые каллории
    public void printCalories(int monthNum, monthData[] monthData) {
        Converter converter = new Converter();
        double cal = converter.stepsToCalories(printSumOfStepsByMonth(monthNum, monthData));
        System.out.println("Сожжено за месяц киллокалорий: " + cal);
    }
    //Ищем лучшую серию за месяц
    public void printBestSeries(int monthNum, StepTracker stepTracker, monthData[] monthData) {
        int maxFoundedSeries = 0;
        int maxFounded = 0;
        for(int i=0; i < monthData[monthNum].days.length; i++) {
            if (monthData[monthNum].days[i] >= stepTracker.stepsGoal) {
                maxFounded++;
                if(maxFoundedSeries<maxFounded) {
                    maxFoundedSeries = maxFounded;
                }
            } else {
                maxFounded = 0;
            }
        }
        System.out.println("Лучшая серия: " + maxFoundedSeries);
    }
}
