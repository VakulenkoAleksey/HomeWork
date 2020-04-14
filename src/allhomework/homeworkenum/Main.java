package allhomework.homeworkenum;

public class Main {
    public static void main(String[] args) {
        User director = new User("Вакуленко Алексей Валерьевич", Position.DIRECTOR);
        Shop shop = new Shop("Магазин", director);

        User manager = new User("Петров Петр Петрович", Position.MANAGER);
        User manager1 = new User("Иванов Иван Иванович", Position.MANAGER);

        User seller = new User("Пупкин Иван Николаевич", Position.SELLER);
        User seller1 = new User("Старшов Игорь Васильевич", Position.SELLER);
        User seller2 = new User("Меньшев Дмитрий Петрович", Position.SELLER);
        User seller3 = new User("Петров Петр Петрович", Position.SELLER);
        User seller4 = new User("Сидоров Сергей Валентинович", Position.SELLER);
        User seller5 = new User("Калашников Константин Дмитриевич", Position.SELLER);

        User courier = new User("Никитин Никита Александрович", Position.COURIER);
        User courier1 = new User("Кошкин Евгений Александрович", Position.COURIER);
        User courier2 = new User("Кулаков Борис Борисович", Position.COURIER);
        User courier3 = new User("Пупкин Денис Витальевич", Position.COURIER);
        User courier4 = new User("Ракин Сергей Владимирович", Position.COURIER);
        User courier5 = new User("Поздняк Николай Васильевич", Position.COURIER);

        shop.addAllStaff(manager,manager1,seller,seller1,seller2,seller3,seller4,seller5,
                courier,courier1,courier2,courier3,courier4,courier5);


//        User manager3 = new User("Поздний Евгений Васильевич", Position.MANAGER);
//        shop.addStaff(manager3);


        shop.getInfoStaff("кош");  //поиск сотрудника по имени(или фрагменту имени)
        System.out.println("*************************************\n");
        shop.getInfoStaff(Position.SELLER); //поиск сотрудника по должности
        System.out.println("*************************************\n");
        shop.getAllInfoStaff(); //вывод информации о всех сотрудниках
    }
}
