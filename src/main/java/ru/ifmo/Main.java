package ru.ifmo;

import ru.ifmo.reader.FileReader;
import ru.ifmo.reader.FileReaderImpl;
import ru.ifmo.transfer.FileTransfer;
import ru.ifmo.transfer.FileTransferImpl;
import ru.ifmo.writer.FileWriter;
import ru.ifmo.writer.FileWriterImpl;

import java.io.IOException;

/**
 * Created on 13.02.2020
 *
 * @author Ilia Ilmenskii
 * Project : SampleProject
 */

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Need Input File and Output file paths");
            System.exit(1);
        }
        FileTransfer transfer = new FileTransferImpl();
        boolean result = transfer.transfer(args[0], args[1]);
        if (result) {
            System.out.println("Everything is OK");
        } else {
            System.out.println("Oops");
        }
    }
}
