package allhomework.localdatetime.zoneddatetime;

/*Самолет летит из Сиднея в Оттаву с двумя остановками в Хьюстоне и Вашингтоне.
        Самолет вылетает из Сиднея (дата любая, например 16 июня 2020) в 19:00 (время местное для Сиднея).
        Время в пути Сидней -  Хьюстон - 15 часов 35 минут
        Время ожидания в аэропорту Хьюстона - 1 час
        Время в пути  Хьюстон - Вашингтон - 2 часа 49 минут
        Время ожидания в аэропорту Вашингтона - 1 час 10 минут
        Время в пути Вашингтон - Оттава - 1 час 40 минут
        Вывести в консоль:
        Время прибытия! в аэропорт Оттавы (время местное для Оттавы)
        Время вылета! из аэропорта Хьюстона (время местное для Хьюстона)
        Время вылета! из аэропорта Вашингтона (время местное для Вашингтона)
        Часовые пояса:
        Сидней - Australia/Sydney
        Хьюстон - America/Chicago
        Вашингтон - America/New_York
        Оттава - America/Toronto*/

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class ZonedDate {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        LocalDateTime someDateTime = LocalDateTime.now();
        ZonedDateTime sydneyTime = someDateTime.atZone(ZoneId.of("Australia/Sydney"));
        System.out.println("Вылет из Сиднея в Хьюстон " + formatter.format(sydneyTime) + " по местному времени \n" +
                "Время полета из Сиднея в Хьюстон продлится 15 часов 35 минут");
        someDateTime = someDateTime.plusHours(15).plusMinutes(35);
        ZonedDateTime houston = someDateTime.atZone(ZoneId.of("America/Chicago"));
        System.out.println("Время прибытия в Хьюстон " + formatter.format(houston) + " по местному времени\n" +
                "Время ожидания в аэропорту Хьюстона составит 1 час");
        someDateTime = someDateTime.plusHours(1);
        houston = someDateTime.atZone(ZoneId.of("America/Chicago"));
        System.out.println("Время вылета из аэропорта Хьюстона в Вашингтон " + formatter.format(houston) + " по местному времени\n" +
                "Время полета Хьюстон - Вашингтон составит 2 часа 49 минут");
        someDateTime = someDateTime.plusHours(2).plusMinutes(49);
        ZonedDateTime washington = someDateTime.atZone(ZoneId.of("America/New_York"));
        System.out.println("Время прибытия в Вшингтон " + formatter.format(washington) + " по местному времени\n" +
                "Время ожидания в аэропорту Вашингтона составит 1 час 10 минут");
        someDateTime = someDateTime.plusHours(1).plusMinutes(10);
        washington = someDateTime.atZone(ZoneId.of("America/New_York"));
        System.out.println("Время вылета из Вашинтона в Оттаву " + formatter.format(washington) + "  по местному времени\n" +
                "Время полета Вашингтон - Оттава составит 1 час 40 минут");
        LocalDateTime finishDateTime = someDateTime.plusHours(1).plusMinutes(40);
        ZonedDateTime ottawa = finishDateTime.atZone(ZoneId.of("America/Toronto"));
        System.out.println("Время прибытия в аэропорт Оттавы " + formatter.format(ottawa) + " о местному времени");
    }
}
