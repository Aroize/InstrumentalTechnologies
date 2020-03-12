package ru.ifmo.transfer;

import ru.ifmo.reader.FileReader;
import ru.ifmo.reader.FileReaderImpl;
import ru.ifmo.writer.FileWriter;
import ru.ifmo.writer.FileWriterImpl;

import java.io.IOException;

/**
 * Created on 12.03.2020
 *
 * @author Ilia Ilmenskii
 * Project : SampleProject
 */
public class FileTransferImpl implements FileTransfer {


    /**
     * Transfer File
     * <p>
     * Transfers content of one file to another
     * @param inFile - string, that represents input file path
     * @param outFile - string, that represents output file path
     * @return true if everything went successfully; false if smth went wrong
     */
    @Override
    public boolean transfer(String inFile, String outFile) {
        FileReader reader = new FileReaderImpl();
        FileWriter writer = new FileWriterImpl();;

        try {
            boolean isOpened = reader.open(inFile);
            if (!isOpened) {
                System.out.println("Cannot open file " + inFile);
                return false;
            }
            isOpened = writer.open(outFile);
            if (!isOpened) {
                System.out.println("Cannot open file " + outFile);
                return false;
            }
            int read = 0;
            do {
                read = reader.read();
                if (read > 0)
                    writer.write(read);
            } while (read > 0);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            reader.close();
            writer.close();
        }
    }
}
