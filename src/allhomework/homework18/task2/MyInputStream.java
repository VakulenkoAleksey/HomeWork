package allhomework.homework18.task2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class MyInputStream extends FilterInputStream {

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected MyInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        byte key = 111;
        return in.read()^key;
    }

}

