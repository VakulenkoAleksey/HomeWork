package allhomework.localdatetime.daysleft;

//Допустим,  занятия закончатся 20 июня 2020 года.
//Сколько занятий осталось, если они проходят 3 раза в неделю (пн, ср, пт)?

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysLeft {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 6, 20);
        System.out.println(daysLeft(date));
    }

    public static int daysLeft(LocalDate date){
        int dayCount = 0;
        LocalDate now = LocalDate.now();
        long between = ChronoUnit.DAYS.between(now, date);
        DayOfWeek monday = DayOfWeek.MONDAY;
        DayOfWeek wednesday = DayOfWeek.WEDNESDAY;
        DayOfWeek friday = DayOfWeek.FRIDAY;
        for (int i = 0; i < between; i++){
            DayOfWeek dayOfWeek = now.getDayOfWeek();
            if (dayOfWeek.equals(monday) || dayOfWeek.equals(wednesday) || dayOfWeek.equals(friday)){
                dayCount++;
            }
            now = now.plusDays(1);
        }
        return dayCount;
    }
}
