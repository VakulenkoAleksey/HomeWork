package allhomework.fitness;

import allhomework.fitness.ticket.Tickets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Person {
    private String name;
    private String surName;
    private String fatherName;
    private long phone;
    private LocalDate bornDate;
    private boolean ticketAvailability; //наличие билета


    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Person(String name, String fatherName, String surName) {
        setName(name);
        setFatherName(fatherName);
        setSurName(surName);
        setBornDate();
        phone = ((long) (89990000001L + Math.random())+ 9999998);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        this.bornDate = LocalDate.ofEpochDay(randomDay);
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isTicketAvailability() {
        return ticketAvailability;
    }

    public void setTicketAvailability(boolean ticketAvailability) {
        this.ticketAvailability = ticketAvailability;
    }






}
