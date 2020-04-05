package allhomework.fitness.club;

import allhomework.fitness.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Actions {
    private Person person;
    private LocalDateTime cameToFitness;
    private LocalDateTime leftFitness;
    private String zone;

    public Actions(LocalDateTime cameToFitness, String zone, Person person) {
        setCameToFitness(cameToFitness);
        setZone(zone);
        setPerson(person);
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");

    public LocalDateTime getCameToFitness() {
        return cameToFitness;
    }

    public void setCameToFitness(LocalDateTime cameToFitness) {
        this.cameToFitness = cameToFitness;
    }

    public LocalDateTime getLeftFitness() {
        return leftFitness;
    }

    public void setLeftFitness(LocalDateTime leftFitness) {
        this.leftFitness = leftFitness;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        if (getLeftFitness() == null) {
            return "Информация о посетителе:\n" +
                    person.getSurName() + " " + person.getName() + " " + person.getFatherName() + "\n" +
                    "Дата и время прибытия: " + formatter.format(getCameToFitness()) + "\n" +
                    "Зона посещения: " + getZone() + "\n";
        }else {
            return "Информация о посетителе:\n" +
                    person.getSurName() + " " + person.getName() + " " + person.getFatherName() + "\n" +
                    "Дата и время прибытия: " + formatter.format(getCameToFitness()) + "\n" +
                    "Дата и время ухода: " + formatter.format(getLeftFitness()) + "\n" +
                    "Зона посещения: " + getZone() + "\n";
        }
    }
}
