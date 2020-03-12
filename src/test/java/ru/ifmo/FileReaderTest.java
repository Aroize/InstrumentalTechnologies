package ru.ifmo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created on 13.02.2020
 *
 * @author Ilia Ilmenskii
 * Project : SampleProject
 */

public class FileReaderTest {

    private String testString = "I don't want to fail this test\n kek";

    @Test
    public void testContent() throws IOException {
        File myFile = new File("test_input.txt");
        if (!myFile.createNewFile())
            throw new IOException("Cannot create new file");
        java.io.FileWriter javaWriter = new java.io.FileWriter(myFile);
        javaWriter.write(testString);
        javaWriter.close();
        ru.ifmo.reader.FileReader reader = new ru.ifmo.reader.FileReaderImpl();
        try {
            assert reader.open(myFile.getPath());
            byte[] stringBytes = testString.getBytes();
            byte[] testBytes = new byte[stringBytes.length];
            int len = reader.readInBuffer(testBytes);
            assert len == stringBytes.length;
            for (int i = 0; i < stringBytes.length; i++) {
                assert stringBytes[i] == testBytes[i];
            }
            assert reader.read() < 0;
            ArrayList<Integer> arr = new ArrayList<>();
        } catch (IOException e) {
            assert false;
        } finally {
            reader.close();
            boolean del = myFile.delete();
        }
    }
}
