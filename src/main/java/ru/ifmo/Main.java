package ru.ifmo;

import ru.ifmo.reader.FileReader;
import ru.ifmo.reader.FileReaderImpl;
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
        FileReader reader = new FileReaderImpl();
        FileWriter writer = new FileWriterImpl();;

        try {
            boolean isOpened = reader.open(args[0]);
            if (!isOpened) {
                System.out.println("Cannot open file " + args[0]);
                System.exit(2);
            }
            isOpened = writer.open(args[1]);
            if (!isOpened) {
                System.out.println("Cannot open file " + args[1]);
                System.exit(3);
            }
            int read = 0;
            do {
                read = reader.read();
                if (read > 0)
                    writer.write(read);
            } while (read > 0);
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            reader.close();
            writer.close();
        }
    }
}
