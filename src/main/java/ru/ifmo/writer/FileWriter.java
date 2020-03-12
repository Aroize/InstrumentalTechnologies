package ru.ifmo.writer;

import java.io.IOException;

/**
 * Created on 13.02.2020
 *
 * @author Ilia Ilmenskii
 * Project : SampleProject
 */
public interface FileWriter {

    boolean open(final String path);

    void write(int c) throws IOException;

    void write(byte[] b) throws IOException;

    void close();
}
