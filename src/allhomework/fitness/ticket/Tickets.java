package allhomework.fitness.ticket;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;

public abstract class Tickets {
    protected String name;
    protected boolean pool;
    protected boolean gum;
    protected boolean groupClass;

    protected LocalDate activeUntil; //активен до

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Tickets(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActiveUntil(LocalDate activeUntil) {
        this.activeUntil = activeUntil;
    }

    public LocalDate getActiveUntil() {
        return activeUntil;
    }






}
