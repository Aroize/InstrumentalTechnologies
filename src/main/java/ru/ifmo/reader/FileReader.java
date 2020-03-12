package ru.ifmo.reader;

import java.io.IOException;

/**
 * Created on 13.02.2020
 *
 * @author Ilia Ilmenskii
 * Project : SampleProject
 */
public interface FileReader {

    /**
     * Open file method
     * <p>
     * Method opens file to read it
     * @param path path of file, to read
     */
    boolean open(final String path);


    /**
     * @param buffer buffer to read in
     * @return count of read symbols
     * @throws IOException thrown by InputStream
     */
    int readInBuffer(byte[] buffer) throws IOException;

    /**
     * @return read symbols
     * @throws IOException thrown by InputStream
     */
    int read() throws IOException;

    void close();
}
