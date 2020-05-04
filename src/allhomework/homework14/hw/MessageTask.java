package allhomework.homework14.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int low = 0, medium = 0, high = 0, urgent = 0;
        for (Message ms : messageList) {
            switch (ms.getPriority()) {
                case LOW:
                    low++;
                case HIGH:
                    high++;
                case MEDIUM:
                    medium++;
                case URGENT:
                    urgent++;
            }
        }
        System.out.println(MessagePriority.LOW + " = " + low + "\n" + MessagePriority.MEDIUM + " = " +
                medium + "\n" + MessagePriority.HIGH + " = " + high + "\n" + MessagePriority.URGENT + " = " + urgent);
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        //при генерации очень большого числа code вылетает memory error, впринципе понятно почему))
        //просто хотел сделать более универсальнее(на генерацию кода больше 10), но не хватило мозгов и времени)))).
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Message ms : messageList) {
            if (ms.getCode() >= arrayList.size()) {
                int n = ms.getCode() - arrayList.size();
                for (int i = 0; i <= n; i++) {
                    arrayList.add(0);
                }
            }
            int i = arrayList.get(ms.getCode());
            arrayList.set(ms.getCode(), i+1);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > 0){
                System.out.println("Количество сообщений для кода \"" + i + "\" = " + arrayList.get(i));
            }
        }
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        //hashset
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i<messageList.size(); ) {
            if (Collections.frequency(messageList, messageList.get(i)) == 1){
                messages.add(messageList.get(i));
                messageList.remove(i);
                continue;
            }
            i++;
        }
        System.out.println("Кол-во уникальных сообщений = " + messages.size());
        messages.forEach(System.out::println);
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        int n = messageList.size();
        for (int i = 0; i<n; ) {
            int m = Collections.frequency(messageList, messageList.get(i));
            if (m > 1){
                for (int j = 0; j < m; j++) {
                    messageList.remove(i);
                    n -= m;
                }
                continue;
            }
            i++;
        }
        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        int count = 0;
        System.out.println("До удаления:");
        messageList.forEach(System.out::println);
        for (int i = 0; i < messageList.size(); ) {
            if (messageList.get(i).getPriority().equals(priority)){
                messageList.remove(i);
                count++;
                continue;
            }
            i++;
        }
        System.out.println("\nПосле удаления:");
        messageList.forEach(System.out::println);
        System.out.println("Удалено " + count + " элементов с приоритетом " + priority);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        int count = 0;
        System.out.println("До удаления:");
        messageList.forEach(System.out::println);
        for (int i = 0; i < messageList.size(); ) {
            if (messageList.get(i).getPriority().equals(priority)){
                i++;
                count++;
                continue;
            }
            messageList.remove(i);
        }
        System.out.println("\nПосле удаления:");
        messageList.forEach(System.out::println);
        System.out.println("Осталось " + count + " элементов с приоритетом " + priority);
    }

    public static void main(String[] args) {
        // вызов методов
        List<Message> messages = MessageGenerator.generate(34);
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        removeEach(messages, MessagePriority.LOW);
        removeOther(messages, MessagePriority.LOW);
        uniqueMessageCount(messages);
        uniqueMessagesInOriginalOrder(messages).forEach(System.out::println);
    }
}
