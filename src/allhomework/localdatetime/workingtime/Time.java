package allhomework.localdatetime.workingtime;

//Есть три рабочие смены :
//        с 7:00 до 15:00
//        с 15:00 до 23:00
//        с 23:00 до 7:00
//        Определить, какая сейчас смена (относительно текущего времени)

import java.time.LocalTime;

public class Time {
    public static void main(String[] args) {
        workTime();
    }

    public static void workTime(){
        LocalTime now = LocalTime.now();
        LocalTime time1 = LocalTime.of(7, 00);
        LocalTime time2 = LocalTime.of(15, 00);
        LocalTime time3 = LocalTime.of(23, 00);
        if (now.isAfter(time1) && now.isBefore(time2)){
            System.out.println("1-я смена!");
        } else if (now.isAfter(time2) && now.isBefore(time3)) {
            System.out.println("2-я смена!");
        } else if (now.isAfter(time3) && now.isBefore(time1)) {
            System.out.println("3-я смена!");
        }
    }
}
