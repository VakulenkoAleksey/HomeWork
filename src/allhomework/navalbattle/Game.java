package allhomework.navalbattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Game {
    private char[][] battlefield1 = new char[10][10];
    private char[][] battlefield2 = new char[10][10];
    private final int singleShip = 4;
    private final int doubleShip = 3;
    private final int tripleShip = 2;
    private final int quadrupleShip = 1;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Random random = new Random();
    String[] array = new String[]{"а", "б", "в", "г", "д", "е", "ж", "з", "и", "к"};
    int single = 0;
    int twin = 0;
    int triple = 0;
    int quadruple = 0;

    boolean b = random.nextBoolean();

    public Game() {
        setBattlefield1();
    }

    public void setBattlefield1() {
        battlefield1[0][0] = 1;
        battlefield1[1][2] = 7;
        battlefield1[1][3] = 7;
        battlefield1[1][4] = 7;
        battlefield1[1][5] = 7;
        battlefield1[3][1] = 2;
        battlefield1[3][4] = 5;
        battlefield1[3][7] = 6;
        battlefield1[3][8] = 6;
        battlefield1[3][9] = 6;
        battlefield1[4][1] = 2;
        battlefield1[4][4] = 5;
        battlefield1[5][4] = 5;
        battlefield1[6][2] = 1;
        battlefield1[6][7] = 3;
        battlefield1[7][7] = 3;
        battlefield1[8][1] = 4;
        battlefield1[8][2] = 4;
        battlefield1[8][5] = 1;
        battlefield1[9][8] = 1;
    }

    public void start() {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        while (!(single == singleShip && twin == doubleShip && triple == tripleShip && quadruple == quadrupleShip)) {
            int x = consoleX();
            int y = consoleY();

            int i = fire(y, x);
            switch (i) {
                case 1:
                    if (checkFire(y, x)) {
                        System.out.println("Уничтожен однопалубный корабль.\n");
                        single++;
                        battlefield2[y][x] = '+';
                        if (single == 4) {
                            System.out.println("Уничтожены все однопалубные корабли.\n");
                        }
                    } else {
                        System.out.println("Даже молния не бьет в одну точку дважды!\n");
                    }
                    break;
                case 2:
                    if (checkFire(y, x)) {
                        System.out.println("Попадание.\n");
                        battlefield2[y][x] = '+';
                        a++;
                        if (a == 2) {
                            System.out.println("Уничтожен двухпалубный корабль.\n");
                            twin++;
                        }
                        if (twin == doubleShip) {
                            System.out.println("Уничтожены все двухпалубные корабли.\n");
                        }
                    } else {
                        System.out.println("Даже молния не бьет в одну точку дважды!\n");
                    }
                    break;
                case 3:
                    if (checkFire(y, x)) {
                        System.out.println("Попадание.\n");
                        battlefield2[y][x] = '+';
                        b++;
                        if (b == 2) {
                            System.out.println("Уничтожен двухпалубный корабль.\n");
                            twin++;
                        }
                        if (twin == doubleShip) {
                            System.out.println("Уничтожены все двухпалубные корабли.\n");
                        }
                    } else {
                        System.out.println("Даже молния не бьет в одну точку дважды!\n");
                    }
                    break;

                case 4:
                    if (checkFire(y, x)) {
                        System.out.println("Попадание.\n");
                        battlefield2[y][x] = '+';
                        c++;
                        if (c == 2) {
                            System.out.println("Уничтожен двухпалубный корабль.\n");
                            twin++;
                        }
                        if (twin == doubleShip) {
                            System.out.println("Уничтожены все двухпалубные корабли.\n");
                        }
                    } else {
                        System.out.println("Даже молния не бьет в одну точку дважды!\n");
                    }
                    break;

                case 5:
                    if (checkFire(y, x)) {
                        System.out.println("Попадание.\n");
                        battlefield2[y][x] = '+';
                        d++;
                        if (d == 3) {
                            System.out.println("Уничтожен трехпалубный корабль.\n");
                            triple++;
                        }
                        if (triple == tripleShip) {
                            System.out.println("Уничтожены все трехпалубные корабли.\n");
                        }
                    } else {
                        System.out.println("Даже молния не бьет в одну точку дважды!\n");
                    }
                    break;

                case 6:
                    if (checkFire(y, x)) {
                        System.out.println("Попадание.\n");
                        battlefield2[y][x] = '+';
                        e++;
                        if (e == 3) {
                            System.out.println("Уничтожен трехпалубный корабль.\n");
                            triple++;
                        }
                        if (triple == tripleShip) {
                            System.out.println("Уничтожены все трехпалубные корабли.\n");
                        }
                    } else {
                        System.out.println("Даже молния не бьет в одну точку дважды!\n");
                    }
                    break;

                case 7:
                    if (checkFire(y, x)) {
                        System.out.println("Попадание.\n");
                        battlefield2[y][x] = '+';
                        f++;
                        if (f == 4) {
                            System.out.println("Уничтожен четырехпалубный корабль.\n");
                            quadruple++;
                        }
                    } else {
                        System.out.println("Даже молния не бьет в одну точку дважды!\n");
                    }
                    break;

                case 0:
                    if (checkFire(y, x)) {
                        System.out.println("Промах!\n");
                        battlefield2[y][x] = '+';
                    } else {
                        System.out.println("Даже молния не бьет в одну точку дважды!\n");
                    }
                default:
                    break;
            }
        }
        System.out.println("Все корабли уничтожены!\n" +
                "Игра окончена!");
    }

    public int consoleY() {
        int y = 0;
        System.out.println("Введите число по оси \"Y\"");
        while (true) {
            try {
                y = Integer.parseInt(reader.readLine());
                if (y > 0 && y < 11) {
                    break;
                }
                System.out.println("Введите корректное число по оси \"Y\"");
            } catch (Exception e) {
                System.out.println("Введите корректное число по оси \"Y\"");
            }
        }
        return y - 1;
    }

    public int consoleX() {
        String str;
        int x = 0;
        System.out.println("Введите букву по оси \"X\"\n" +
                "\"А\",\"Б\",\"В\",\"Г\",\"Д\",\"Е\",\"Ж\",\"З\",\"И\",\"К\"");
        while (true) {
            try {
                str = reader.readLine();
                if (str.length() == 1) {
                    for (int i = 0; i < array.length; i++) {
                        if (array[i].equalsIgnoreCase(str)) {
                            x = i;
                            break;
                        }
                    }
                    break;
                }
                System.out.println("Введите корректно букву по оси \"X\"");
            } catch (Exception e) {
                System.out.println("Введите корректно букву по оси \"X\"");
            }
        }
        return x;
    }

    private int fire(int y, int x) {
        return battlefield1[y][x];
    }

    private boolean checkFire(int y, int x) {
        return battlefield2[y][x] != '+';
    }

//    static void methodWide(int i) {
//        System.out.println("int");
//    }

//    static void methodWide( Integer i ) {
//        System.out.println("Integer");
//    }
    static void methodWide( Short i ) {
        System.out.println("Short");
    }
    static void methodWide( short i ) {
        System.out.println("short");
    }
    static void methodWide( Long i ) {
        System.out.println("long");
    }
    static void methodWide( long i ) {
        System.out.println("long");
    }

}
