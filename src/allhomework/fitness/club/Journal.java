package allhomework.fitness.club;

import allhomework.fitness.Person;
import allhomework.fitness.ticket.Tickets;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Journal {
    private Person person;
    private ArrayList<Actions> actions = new ArrayList<>();
    private Tickets tickets;


    public Journal(Person person) {
        setPerson(person);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Actions getActions(int i ) {
        return actions.get(i);
    }


    public Actions getLastActions(){
        if (actions.size() > 1) {
            for (int i = 0; i < actions.size() - 1; i++) {
                for (int j = 0; j < actions.size(); j++) {
                    if (actions.get(i).getCameToFitness().isAfter(actions.get(j).getCameToFitness())) {
                        return actions.get(i);
                    }
                }
            }
        }else {
            return actions.get(0);
        }
        return null;
    }

    public void setActions(Actions actions) {
        this.actions.add(actions);
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public Tickets getTickets() {
        return tickets;
    }

}
