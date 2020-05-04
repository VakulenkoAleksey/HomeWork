package allhomework.homework18.task1;

// Разбить файл (информацию из одного файла записать в 2 разных файла)
// Склеить файл (информацию из нескольких файлов записать в один файл)


import java.io.*;

public class Stream {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\Aleksey\\Desktop\\file1.txt");
        File file2 = new File("C:\\Users\\Aleksey\\Desktop\\file2.txt");
        File file3 = new File("C:\\Users\\Aleksey\\Desktop\\file3.txt");
        File file4 = new File("C:\\Users\\Aleksey\\Desktop\\file4.txt");
        writeToFile(file1, "hello world", false);
        String text1 = readFromFile(file1);
        System.out.println("Записали в file1: " + text1);

        writeToFile(file2, text1.substring(0, (text1.length() / 2)), false);
        System.out.println("Записали в file2 " + text1.substring(0, (text1.length() / 2)));
        writeToFile(file3, text1.substring(text1.length() / 2), false);
        System.out.println("Записали в file3 " + text1.substring(text1.length() / 2));

        System.out.println("записываем file2 и file3 в file4");

        writeToFile(file4, readFromFile(file2, file3), false);

//        String text2 = readFromFile(file2);
//        String text3 = readFromFile(file3);
//        writeToFile(file4, text2, false);
//        writeToFile(file4, text3, true);

        System.out.println(readFromFile(file4));

    }

    public static String readFromFile(File file) throws IOException {
        String string = null;
        try (FileInputStream fileInput = new FileInputStream(file);
             ByteArrayOutputStream arrayOut = new ByteArrayOutputStream()) {
            byte[] buf = new byte[128];
            int data;
            while ((data = fileInput.read(buf)) > 0) {
                arrayOut.write(buf, 0, data);
            }
            string = new String(arrayOut.toByteArray());
        }
        return string;
    }

    public static String readFromFile(File... files) throws IOException {
        try (SequenceInputStream stream = new SequenceInputStream(new FileInputStream(files[0]),
                new FileInputStream(files[1]));
             ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            byte[] bytes = new byte[256];
            int data;
            while ((data = stream.read(bytes)) > 0) {
                bout.write(bytes, 0, data);
            }
            return bout.toString();
        }
    }

    private static void writeToFile(File file, String data, boolean append) throws IOException {
        try (BufferedOutputStream bufferedOutput = new BufferedOutputStream(new FileOutputStream(file, append))) {
            bufferedOutput.write(data.getBytes());
        }
    }
}