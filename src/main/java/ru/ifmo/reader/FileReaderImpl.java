package ru.ifmo.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created on 13.02.2020
 *
 * @author Ilia Ilmenskii
 * Project : SampleProject
 */
public class FileReaderImpl implements FileReader {

    private FileInputStream inputStream;

    @Override
    public boolean open(String path) {
        return open(new File(path));
    }

    public boolean open(File file) {
        if (!file.exists() || !file.isFile() || !file.canRead())
            return false;
        if (inputStream != null)
            throw new IllegalStateException("Current stream isn't closed. Close previous stream before using new");
        try {
            inputStream = new FileInputStream(file);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public int readInBuffer(byte[] buffer) throws IOException {
        return inputStream.read(buffer);
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public void close() {
        try {
            inputStream.close();

        } catch (IOException e) {
            System.out.println(e);
        } finally {
          inputStream = null;
        }
    }
}
