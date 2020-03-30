package allhomework.homework6.task2;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(120, "Moscow Street", 200);
        Cat cat2 = new Cat(140, "Moscow New Street", 220);
//        cat1.fightCat(cat2);
//        System.out.println(cat1.heath);
//        cat2.fightCat(cat1);
//        System.out.println(cat2);

        while ( cat1.heath > 0 && cat2.heath > 0){
            cat1.fightCat(cat2);
            if (cat1.heath > cat2.heath){
                System.out.println(cat1.getClass().getSimpleName());
            }else {
                System.out.println(cat2.getClass().getName());
            }

        }
    }
}
