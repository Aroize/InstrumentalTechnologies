package ru.ifmo.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created on 13.02.2020
 *
 * @author Ilia Ilmenskii
 * Project : SampleProject
 */
public class FileWriterImpl implements FileWriter {

    private FileOutputStream outputStream;

    @Override
    public boolean open(String path) {
        return open(new File(path));
    }

    public boolean open(File file) {
        if (!file.exists() || !file.isFile() || !file.canRead())
            return false;
        if (outputStream != null)
            throw new IllegalStateException("Current stream isn't closed. Close previous stream before using new");
        try {
            outputStream = new FileOutputStream(file);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public void write(int c) throws IOException {
        outputStream.write(c);
    }

    @Override
    public void write(byte[] b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void close() {
        try {
            outputStream.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            outputStream = null;
        }
    }
}
