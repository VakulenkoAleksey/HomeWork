package allhomework.fitness.club;

import allhomework.fitness.Person;
import allhomework.fitness.ticket.DayTicket;
import allhomework.fitness.ticket.FullTicket;
import allhomework.fitness.ticket.SingleTicket;
import allhomework.fitness.ticket.Tickets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;

public class Fitness {
    private String name;
    //    private Tickets tickets;
    private DayTicket dayTicket;
    private SingleTicket singleTicket;
    private FullTicket fullTicket;
    private Person[] inGum = new Person[20];
    private Person[] inPool = new Person[20];
    private Person[] onGroupClass = new Person[20];
    private ArrayList<Journal> journals = new ArrayList<>(); //список поситителей
    private boolean openFitness;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Fitness(String name) {
        setName(name);
    }

    public void setJournal(Journal journal) {
        this.journals.add(journal);

    }

    public Journal getJournal(Person person) {
        for (Journal j : journals) {
            if (j.getPerson().equals(person)) {
                return j;
            }
        }
        return null;
    }

    public boolean isOpenFitness() {
        return openFitness;
    }

    public void setOpenFitness(boolean openFitness) {
        this.openFitness = openFitness;
        if (openFitness) {
            System.out.println("Фитнес клуб открыт");
        } else {
            System.out.println("Фитнес клуб закрыт");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean feeInGum() {
        for (Person person : inGum) {
            if (person == null) {
                return true;
            }
        }
        return false;
    } //проверка мест в зале

    public Boolean freeInPool() {
        for (Person person : inPool) {
            if (person == null) {
                return true;
            }
        }
        return false;
    } // проверка мест в басе

    public Boolean freeOnGroupClass() {
        for (Person person : onGroupClass) {
            if (person == null) {
                return true;
            }
        }
        return false;
    } // проверка мест в групклассе

    public void addInGum(Person person) {
        for (int i = 0; i < this.inGum.length; i++) {
            if (this.inGum[i] == null) {
                this.inGum[i] = person;
                break;
            }
        }
    } // добавление пользователя в зал

    public void letInGum(long phone) {
        for (int i = 0; i < inGum.length; i++) {
            if (inGum[i] != null && inGum[i].getPhone() == phone)
                inGum[i] = null;
        }
    }

    public void addInPool(Person person) {
        for (int i = 0; i < this.inPool.length; i++) {
            if (this.inPool[i] == null) {
                this.inPool[i] = person;
                break;
            }
        }
    } // добавление пользователя в басик

    public void letInPool(long phone) {
        for (int i = 0; i < inPool.length; i++) {
            if (inPool[i] != null && inPool[i].getPhone() == phone)
                inPool[i] = null;
        }
    }

    public void addOnGroupClass(Person person) {
        for (int i = 0; i < this.onGroupClass.length; i++) {
            if (this.onGroupClass[i] == null) {
                this.onGroupClass[i] = person;
                break;
            }
        }
    } // добавление пользователя в групкласс

    public void letInGroupClass(long phone) {
        for (int i = 0; i < onGroupClass.length; i++) {
            if (onGroupClass[i] != null && onGroupClass[i].getPhone() == phone)
                onGroupClass[i] = null;
        }
    }

    public Boolean timeDayTicket(DayTicket ticket) {
        LocalTime time = LocalTime.now();
        return time.isAfter(ticket.getStartTime()) && time.isBefore(ticket.getFinishTime());
    } //проверка дневного фбона до 16 часов

    public boolean validationTestTicket(Tickets tickets) {
        if (LocalDate.now().isBefore(tickets.getActiveUntil())) {
            return true;
        }
        return false;
    } //проветка срока годности клиента

    public void registrationInGum(Person person, LocalDateTime date) {
        addInGum(person);
        getJournal(person).setActions(new Actions(date, "Спорт зал", person));
        System.out.println(getJournal(person).getLastActions());
    } //регистрация в зал

    public void registrationOnGroupClass(Person person, LocalDateTime date) {
        addOnGroupClass(person);
        getJournal(person).setActions(new Actions(date, "Групповые занятия", person));
        System.out.println(getJournal(person).getLastActions());
    } // регистрация в групп класс

    public void registrationInPool(Person person, LocalDateTime date) {
        addInPool(person);
        getJournal(person).setActions(new Actions(date, "Бассеин", person));
        System.out.println(getJournal(person).getLastActions());
    } // регистрация в бассеин

    public void dayTicket(Person person, LocalDateTime date) throws IOException {
        System.out.println("Время Вашего посещения ограничено до 16 часов 00 минут.\n" +
                "Вам доступны следующие зоны для посещения:\n" +
                "#1-Тренажерный зал.\n" +
                "#2-Групповые занятия.\n" +
                "Введите номер зоны посещения:");
        while (true) {
            String number = reader.readLine();
            if (!(number.isEmpty())) {
                if (number.equals("1")) {
                    registrationInGum(person, date);
                    break;
                } else if (number.equals("2")) {
                    registrationOnGroupClass(person, date);
                    break;
                } else {
                    System.out.println("Введите корректную зону для посещения\n" +
                            "#1-Тренажерный зал.\n" +
                            "#2-Групповые занятия.");
                }
            } else {
                System.out.println("Введена пустая строка\n" +
                        "#1-Тренажерный зал.\n" +
                        "#2-Групповые занятия.");
            }
        }
    }

    public void saleTicket(Person person) throws IOException {
        if (isOpenFitness()) {
            LocalDate now = LocalDate.now();
            LocalDate second = person.getBornDate();
            long between = Period.between(second, now).getYears();
            if (between >= 18) { //проверяем возраст покупателя
                System.out.println(person.getName() + " " + person.getFatherName() +
                        ", здравствуйте, какой абонимент желаете преобрести? №1-Разовый, №2-Дневной, №3-Полный \n" +
                        "Введите просто номер абонимента:");
                while (true) {
                    String number = reader.readLine();
                    if (!(number.isEmpty())) {
                        switch (number) {
                            case "1":
                                singleTicket = new SingleTicket("Разовый");
                                if (getJournal(person) != null) {
                                    getJournal(person).setTickets(singleTicket);
                                } else {
                                    Journal journal = new Journal(person);
                                    journal.setTickets(singleTicket);
                                    setJournal(journal);
                                }
                                person.setTicketAvailability(true);
                                break;
                            case "2":
                                dayTicket = new DayTicket("Девной");
                                Journal journal = new Journal(person);
                                journal.setTickets(dayTicket);
                                setJournal(journal);
                                person.setTicketAvailability(true);
                                System.out.print(person.getName() + " " + person.getFatherName() + " ");
                                dayTicket.setActiveUntil(now);
                                break;
                            case "3":
                                fullTicket = new FullTicket("Полный");
                                journal = new Journal(person);
                                journal.setTickets(fullTicket);
                                setJournal(journal);
                                person.setTicketAvailability(true);
                                System.out.print(person.getName() + " " + person.getFatherName() + " ");
                                fullTicket.setActiveUntil(now);
                                break;
                            case "нет":
                                break;
                            default:
                                System.out.println("Введите корректный номер \"1, 2, 3\"\n" +
                                        "Если передумали преобретать введите слово \"Нет\".");
                        }
                        break;
                    } else {
                        System.out.println("Вы ничего не ввели!\n" +
                                "Введите корректный номер \"1, 2, 3\"\n" +
                                "Если передумали преобретать введите слово \"Нет\".");
                    }
                }
            } else {
                System.out.println(person.getName() + " " + person.getFatherName() +
                        " извените, но поссещение нашего фитнес клуба разрешается с 18 лет!\n");
            }
        } else {
            System.out.println(name + " закрыт.");
        }
    }  //продажа абона пользователю

    public void goToFitness(Person person) throws IOException {  // посещение фитнеса
        LocalDateTime nowDate = LocalDateTime.now();
        String str;
        if (isOpenFitness()) { //работает ли фитнес
            if (person.isTicketAvailability()) {
                System.out.println(person.getName() + " " + person.getFatherName() + " Добро пожаловать в " + name);
                System.out.println("Предъявите ваш билет");
                if (getJournal(person).getTickets() instanceof DayTicket) { //проверяем тип абонимента
                    if (validationTestTicket((DayTicket) getJournal(person).getTickets())) {
                        if (timeDayTicket((DayTicket) getJournal(person).getTickets())) {//проверка времени для посещения
                            if (feeInGum() && freeOnGroupClass()) { //проверка свободных мест в зале и групклассе
                                dayTicket(person, nowDate);
                            } else if (feeInGum()) { // когда место только в зале
                                System.out.println("Свободные места остались только в зале, готовы пойти/n" +
                                        "\"Да/Нет\"");
                                str = reader.readLine();
                                if (str.equalsIgnoreCase("да")) {
                                    registrationInGum(person, nowDate);
                                } else {
                                    System.out.println("Ждем Вас в другой день");
                                }
                            } else if (freeOnGroupClass()) { // когда место только в групклассе
                                System.out.println("Свободные места остались только в группклассе, готовы пойти/n" +
                                        "\"Да/Нет\"");
                                str = reader.readLine();
                                if (str.equalsIgnoreCase("да")) {
                                    registrationOnGroupClass(person, nowDate);
                                } else {
                                    System.out.println("Ждем Вас в другой день");
                                }
                            }
                        } else {
                            System.out.println("Ваше вмемя посещения  клуба " + name + " ограничено с 8 до 16 часов.\n" +
                                    "Ждем вас в другой день.\n");
                        }
                    } else {
                        person.setTicketAvailability(false);
                        getJournal(person).setTickets(null);
                    }
                } else if (getJournal(person).getTickets() instanceof FullTicket) { //проверяем тип абонимента
                    if (validationTestTicket((FullTicket) getJournal(person).getTickets())) {
                        System.out.println("Выбирите зону для посещения\n" +
                                "#1-Тренажерный зал.\n" +
                                "#2-Групповые занятия.\n" +
                                "#3-Бассеин.");
                        while (true) {
                            str = reader.readLine();
                            if (str.equals("1")) {
                                if (feeInGum()) {
                                    registrationInGum(person, nowDate);
                                    break;
                                } else {
                                    System.out.println("В спорт зале нет свободных мест, выберите другую зону посещения\n" +
                                            "Для отмены введите \"Нет\"");
                                }
                            } else if (str.equals("2")) {
                                if (freeOnGroupClass()) {
                                    registrationOnGroupClass(person, nowDate);
                                    break;
                                } else {
                                    System.out.println("В групповых занятиях нет свободных мест, выберите другую зону посещения\n" +
                                            "Для отмены введите \"Нет\"");
                                }
                            } else if (str.equals("3")) {
                                if (freeInPool()) {
                                    registrationInPool(person, nowDate);
                                    break;
                                } else {
                                    System.out.println("В бассейне нет свободных мест, выберите другую зону посещения\n" +
                                            "Для отмены введите \"Нет\"");
                                }
                            } else if (str.equalsIgnoreCase("нет")) {
                                break;
                            } else {
                                System.out.println("Введите корректное число");
                            }
                        }
                    } else {
                        person.setTicketAvailability(false);
                        getJournal(person).setTickets(null);
                    }
                } else if (getJournal(person).getTickets() instanceof SingleTicket) { //проверяем тип абонимента
                    System.out.println("Выбирите зону для посещения\n" +
                            "#1-Тренажерный зал.\n" +
                            "#2-Групповые занятия.\n" +
                            "#3-Бассеин.");
                    while (true) {
                        str = reader.readLine();
                        if (str.equals("1")) {
                            if (feeInGum()) {
                                registrationInGum(person, nowDate);
                                break;
                            } else {
                                System.out.println("В спорт зале нет свободных мест, выберите другую зону посещения\n" +
                                        "Для отмены введите \"Нет\"");
                            }
                        } else if (str.equals("2")) {
                            if (freeOnGroupClass()) {
                                registrationOnGroupClass(person, nowDate);
                                break;
                            } else {
                                System.out.println("В групповых занятиях нет свободных мест, выберите другую зону посещения\n" +
                                        "Для отмены введите \"Нет\"");
                            }
                        } else if (str.equals("3")) {
                            if (freeInPool()) {
                                registrationInPool(person, nowDate);
                                break;
                            } else {
                                System.out.println("В бассейне нет свободных мест, выберите другую зону посещения\n" +
                                        "Для отмены введите \"Нет\"");
                            }
                        } else if (str.equalsIgnoreCase("нет")) {
                            break;
                        } else {
                            System.out.println("Введите корректное число");
                        }
                    }
                }
            } else {
                System.out.println("Ваш абонимент отсутствует.\n");

            }
        } else {
            System.out.println("Фитнес клуб закрыт, время работы с 8 до 22");
        }
    }

    public void leftTheFitness(Person person) {
        try {
            getJournal(person).getLastActions().setLeftFitness(LocalDateTime.now());
            if (getJournal(person).getTickets() instanceof SingleTicket) {
                person.setTicketAvailability(false);
                getJournal(person).setTickets(null);
            }
            letZone(person);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Посититель " + person.getSurName() + " " + person.getName() + " " +
                    person.getFatherName() + " в зале отсутствует!\n");
        }

    }

    public void letZone(Person person) {
        switch (getJournal(person).getLastActions().getZone()) {
            case "Спорт зал":
                letInGum(person.getPhone());
                System.out.println(getJournal(person).getLastActions());
                break;
            case "Групповые занятия":
                letInGroupClass(person.getPhone());
                System.out.println(getJournal(person).getLastActions());
                break;
            case "Бассеин":
                letInPool(person.getPhone());
                System.out.println(getJournal(person).getLastActions());
                break;
        }
    }

    public void close() {
        for (Person person : inGum) {
            if (person != null) {
                leftTheFitness(person);
            }
        }
        for (Person person : inPool) {
            if (person != null) {
                leftTheFitness(person);
            }
        }
        for (Person person : onGroupClass) {
            if (person != null) {
                leftTheFitness(person);
            }
        }
        System.out.println("\n Фитнес клуб закрыт");
    }
}
