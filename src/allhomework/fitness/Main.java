package allhomework.fitness;

import allhomework.fitness.club.Fitness;
import allhomework.fitness.ticket.DayTicket;
import allhomework.fitness.ticket.FullTicket;
import allhomework.fitness.ticket.SingleTicket;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Person person1 = new Person("Алексей", "Валерьевич", "Вакуленко");
        Person person2 = new Person("Дмитрий", "Александрович", "Любимов");
        Person person3 = new Person("Иван", "Иванович", "Иванов");

        Fitness fitness = new Fitness("Fitness House");

        fitness.setOpenFitness(true);


        fitness.saleTicket(person1);

        fitness.goToFitness(person1);

        fitness.leftTheFitness(person1);

        fitness.close();
    }
}
