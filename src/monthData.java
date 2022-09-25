import java.util.Arrays;

//Класс для хранения данных по месяцам
public class monthData {
    int[] days = new int[30];

    public monthData() {
        Arrays.fill(days, 0); //Заполняем каждый созданный объект нулями
    }
}
