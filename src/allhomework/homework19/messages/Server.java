package allhomework.homework19.messages;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private int port;
    private Connection connection;

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен...");
            int countConnections = 0;
//            Map<Client, Integer> allCountConnections = new HashMap<>();

            while (true){
                Socket clientSocket = serverSocket.accept();
                connection = new Connection(clientSocket);
                SimpleMessage message = connection.readMessage();
                System.out.println(message);
                countConnections++;
                    String text = "/help -  список доступных команд \n" +
                            "/count - количество подключений сервера\n" +
                            "/ping - время за которое сообщение доходит до сервера и возвращается обратно \n" +
                            "/exit - выйти из программы (завершение программы)";

                switch (message.getText()){
                    case "/help":
                        connection.sendMessage(SimpleMessage.getInstance(text));
                        break;
                    case "/count":
                        String count ="Кол-во подключений к серверу: " + countConnections;
                        connection.sendMessage(SimpleMessage.getInstance(count));
                        break;
                    case "/ping":
                        long time = ChronoUnit.MILLIS.between(message.getDateTime(), LocalDateTime.now());
                        String mls = "Время отклика сервера: " + time + "milliseconds";
                        connection.sendMessage(SimpleMessage.getInstance(mls));
                        break;
                    default:
                        connection.sendMessage(SimpleMessage.getInstance("Server", "hello"));
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int port = 8099;
        String ip = "127.0.0.1";
        Server server = new Server(port);
        try {
            server.start();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
