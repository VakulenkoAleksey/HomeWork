package allhomework.fitness.ticket;

import java.time.LocalDate;

public class FullTicket extends Tickets implements Gum, Pool, GroupClass {
    public FullTicket(String name) {
        super(name);
    }

//    @Override
    public void setActiveUntil(LocalDate bought) {
        System.out.println("На сколько лет приобретаете абонитент? Максимум 3 года!\n" +
                "Введите число:");
        try {
            int i = Integer.parseInt(reader.readLine());
            if (i == 3) {
                System.out.println("Билет куплен сроком на " + i + " года!"  + "\n");
//                super.setActiveUntil(bought.plusYears(i));
                activeUntil = bought.plusYears(i);
            } else if (i == 2) {
                System.out.println("Билет куплен сроком на " + i + " года!" + "\n");
//                super.setActiveUntil(bought.plusYears(i));
                activeUntil = bought.plusYears(i);
            } else if (i == 1) {
                System.out.println("Билет куплен сроком на " + i + " год!" + "\n");
//                super.setActiveUntil(bought.plusYears(i));
                activeUntil = bought.plusYears(i);
            } else {
                System.out.println("Не корректное число, билет куплен сроком на 1 год о умолчанию!" + "\n");
//                super.setActiveUntil(bought.plusYears(1));
                activeUntil = bought.plusYears(1);
            }
        } catch (Exception e) {
            System.out.println("Не корректный ввод, билет куплен сроком на 1 год по умолчанию!" + "\n");
//            super.setActiveUntil(bought.plusYears(1));
            activeUntil = bought.plusYears(1);
        }
    } //устанавливает срок годности абонимента

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

    @Override
    public boolean isGroupClass() {
        return this.groupClass;
    }

    @Override
    public void setGroupClass(boolean groupClass) {
        this.groupClass = groupClass;
    }
}
