package allhomework.fitness.ticket;


public class SingleTicket extends Tickets implements Gum, Pool {

    public SingleTicket(String name) {
        super(name);
    }

    @Override
    public boolean isGum() {
        return this.gum;
    }

    @Override
    public void setGum(boolean gum) {
        this.gum = gum;
    }

    @Override
    public boolean isPool() {
        return this.pool;
    }

    @Override
    public void setPool(boolean pool) {
        this.pool = pool;
    }
}
