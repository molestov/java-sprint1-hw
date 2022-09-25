public class Converter {
    public static double stepsToKm(int steps) {
        double result = steps * 0.00075;
        return result;
    }
    public static double stepsToCalories(int steps) {
        double result = steps * 0.05;
        return result;
    }
}
