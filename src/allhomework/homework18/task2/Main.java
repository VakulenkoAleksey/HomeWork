package allhomework.homework18.task2;

//        Написать свои реализации InputStream и OutputStream,
//        которые будут расширять FilterInputStream и FilterOutputStream (классы, позволяющие
//        создавать декораторы (обертки)).
//        В переопределяемых методах (read и write)
//        необходимо дешифровать и шифровать данные (использовать xor ^).
//        Данные реализации - обертки (декораторы) над любыми InputStream и OutputStream,
//        например, если речь идет о записи в файл,
//        то Ваш метод write шифрует данные и потом вызывает метод write fileOutputStream,
//        метод read вызыовает метд read fileInputStream и потом дешифрует полученниые данные.
//        Объекты fileOutputStream и fileInputStream будут передаваться в конструкторы
//        Ваших реализаций InputStream и OutputStream.

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\Aleksey\\Desktop\\file1.txt");
        File file2 = new File("C:\\Users\\Aleksey\\Desktop\\EncryptedFile.txt");
        File file3 = new File("C:\\Users\\Aleksey\\Desktop\\DecryptionFile.txt");
        fileEncryption(file1, file2);
        fileDecryption(file2, file3);
    }

    public static void fileEncryption(File text, File fileForEncrypt) throws IOException { // шифрование
        try (MyOutputStream myOutput = new MyOutputStream(new FileOutputStream(fileForEncrypt));
            BufferedInputStream bufferedInput = new BufferedInputStream(new FileInputStream(text))) {
            byte[] bytes = bufferedInput.readAllBytes();
            for (int i = 0; i < bytes.length; i++) {
                myOutput.write(bytes[i]);
            }
        }
    } // шифрование/расшифровка при записи файла

    public static void fileDecryption(File encryptedFile, File fileForDecryption) throws IOException { // расшифровка
        try (MyInputStream myInput = new MyInputStream(new FileInputStream(encryptedFile));
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(new FileOutputStream(fileForDecryption))) {
            int data;
            while ((data = myInput.read()) > 0) {
                bout.write(data);
            }
            bufferedOutput.write(bout.toByteArray());
        }
    } // шифрование/расшифровка при чтении файла
}