package allhomework.homework19.messages;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }

    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket())) {
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            System.out.println("Ответ от сервера:\n" + fromServer);
        }
    }

    public void start() throws Exception {

        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Что бы узнать список команд, введите \"/help\"");
        String text;
        boolean bool = true;
        while (bool) {
            System.out.println("Введите сообщение");
            text = scanner.nextLine();
            if (text.equalsIgnoreCase("/exit")){
                break;
            }
            try {
                sendAndPrintMessage(SimpleMessage.getInstance(name, text));

            } catch (Exception e) {
                System.out.println("Сервер не отвечает!\nПовторить попытку подключения? [ Y/N ]");

                while (true) {
                    String str = scanner.nextLine().toLowerCase();
                    if (str.equals("n")) {
                        bool = false;
                        break;
                    }else if (str.equals("y")){
                        break;
                    }else {
                        System.out.println("Не корректный ввод");
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8099;
        String ip = "127.0.0.1";
        try {
            new Client(ip, port).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
