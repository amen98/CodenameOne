package java.io;
/**
 * Abstract class for writing to character streams. The only methods that a subclass must implement are write(char[], int, int), flush(), and close(). Most subclasses, however, will override some of the methods defined here in order to provide higher efficiency, additional functionality, or both.
 * Since: JDK1.1, CLDC 1.0 See Also:OutputStreamWriter, Reader
 */
public abstract class Writer implements AutoCloseable {
    /**
     * The object used to synchronize operations on this stream. For efficiency, a character-stream object may use an object other than itself to protect critical sections. A subclass should therefore use the object in this field rather than this or a synchronized method.
     */
    protected java.lang.Object lock;

    /**
     * Create a new character-stream writer whose critical sections will synchronize on the writer itself.
     */
    protected Writer(){
         //TODO codavaj!!
    }

    /**
     * Create a new character-stream writer whose critical sections will synchronize on the given object.
     * lock - Object to synchronize on.
     */
    protected Writer(java.lang.Object lock){
         //TODO codavaj!!
    }

    /**
     * Close the stream, flushing it first. Once a stream has been closed, further write() or flush() invocations will cause an IOException to be thrown. Closing a previously-closed stream, however, has no effect.
     */
    public abstract void close() throws java.io.IOException;

    /**
     * Flush the stream. If the stream has saved any characters from the various write() methods in a buffer, write them immediately to their intended destination. Then, if that destination is another character or byte stream, flush it. Thus one flush() invocation will flush all the buffers in a chain of Writers and OutputStreams.
     */
    public abstract void flush() throws java.io.IOException;

    /**
     * Write an array of characters.
     */
    public void write(char[] cbuf) throws java.io.IOException{
        return; //TODO codavaj!!
    }

    /**
     * Write a portion of an array of characters.
     */
    public abstract void write(char[] cbuf, int off, int len) throws java.io.IOException;

    /**
     * Write a single character. The character to be written is contained in the 16 low-order bits of the given integer value; the 16 high-order bits are ignored.
     * Subclasses that intend to support efficient single-character output should override this method.
     */
    public void write(int c) throws java.io.IOException{
        return; //TODO codavaj!!
    }

    /**
     * Write a string.
     */
    public void write(java.lang.String str) throws java.io.IOException{
        return; //TODO codavaj!!
    }

    /**
     * Write a portion of a string.
     */
    public void write(java.lang.String str, int off, int len) throws java.io.IOException{
        return; //TODO codavaj!!
    }

}
