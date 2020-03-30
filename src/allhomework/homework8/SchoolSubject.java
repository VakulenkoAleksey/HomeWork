package allhomework.homework8;

public abstract class SchoolSubject {
    public static final String[] schoolSubject;


    static {
        schoolSubject = new String[]{
                "математика",
                "алгебра",
                "математика",
                "алгебра",
                "биология",
                "рисование",
                "химия",
                "география",
                "геометрия",
                "история",
                "литература",
                "музыка",
                "физкультура",
                "физика",
                "труды"};
    }

    public static String randomSubject() {
        return schoolSubject[((int) (Math.random() * 15))];
    }
}
