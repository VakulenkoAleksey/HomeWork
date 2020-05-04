package allhomework.homework18.task2;


import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class MyOutputStream extends FilterOutputStream {
    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            <code>null</code> if this instance is to be
     *            created without an underlying stream.
     */
    public MyOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        byte key = 111;
        out.write(b ^ key);
    }
}
