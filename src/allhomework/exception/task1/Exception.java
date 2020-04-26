package allhomework.exception.task1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.jar.JarException;

public class Exception {
    public static void main(String[] args) {
        try {
            throwException(Status.JAR_ERROR);
//            throwException(Status.ACCESS_DENIED);
//            throwException(Status.FILE_NOT_FOUND);
        } catch (JarException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } catch (FileNotFoundException | AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }

    static void throwException(Status status) throws JarException, AccessDeniedException, FileNotFoundException {
            switch (status) {
                case JAR_ERROR:
                    throw new JarException();
                case ACCESS_DENIED:
                    throw new AccessDeniedException("Адрес не найден");
                case FILE_NOT_FOUND:
                    throw new FileNotFoundException("File не найден");
            }
    }

    enum Status {
        FILE_NOT_FOUND,
        ACCESS_DENIED,
        JAR_ERROR;
    }
}
