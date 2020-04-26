package allhomework.homeworkenum;

public class Main {
    public static void main(String[] args) {
        User director = new User("вакуленко Алексей Валерьевич", Position.DIRECTOR);
        Store store = new Store("Магазин", director);

        store.newStaff("петров-Рудыковский петр петрович", "М");
        store.newStaff("Иванов иван Иванович", Position.MANAGER);

        store.newStaff("Пупкин Иван Николаевич", "п");
        store.newStaff("Старшов игорь Васильевич", "про");
        store.newStaff("Меньшев Дмитрий Петрович", "продавец");
        store.newStaff("петров Петр петрович", Position.SELLER);
        store.newStaff("сидоров Сергей Валентинович", Position.SELLER);
        store.newStaff("Калашников константин Дмитриевич", Position.SELLER);


        store.newStaff("Никитин никита александрович", "кур");
        store.newStaff("Кошкин Евгений Александрович", "к");
        store.newStaff("Кулаков Борис борисович", "курьер");
        store.newStaff("Пупкин Денис Витальевич", Position.COURIER);
        store.newStaff("Ракин Сергей Владимирович", Position.COURIER);
        store.newStaff("Поздняк Николай Васильевич", Position.COURIER);



        store.newStaff("Поздний Евгений Васильевич", Position.MANAGER); //менеджер не требуется



//        store.getInfoStaff("кош");  //поиск сотрудника по имени(или фрагменту имени)

//        store.getInfoStaff(Position.MANAGER); //поиск сотрудника по должности

        store.getAllInfoStaff(); //вывод информации о всех сотрудниках
    }
}
