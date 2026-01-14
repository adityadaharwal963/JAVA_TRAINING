package NIO;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Problem3 {
    /*
    Log File Analyzer
    Problem Statement:
    Write a program that reads a very large log file using MappedByteBuffer and counts:
    • Total number of lines
    • Number of ERROR messages
    • Number of WARNING messages
    Concepts used:
    FileChannel.map(), MappedByteBuffer, high-performance file reading
     */
    static void logFilesAnalyzer() throws IOException {

        Path filePath = Path.of("app.log");

        long totalLines = 0;
        long errorCount = 0;
        long warningCount = 0;

        FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.READ);

        MappedByteBuffer buffer =
                fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

        StringBuilder line = new StringBuilder();

        while (buffer.hasRemaining()) {
            char ch = (char) buffer.get();

            if (ch == '\n') {
                totalLines++;

                String currentLine = line.toString();

                if (currentLine.contains("ERROR")) {
                    errorCount++;
                }

                if (currentLine.contains("WARNING")) {
                    warningCount++;
                }

                line.setLength(0); // clear line
            } else if (ch != '\r') {
                line.append(ch);
            }
        }

        // for last line if no newline at end
        if (line.length() > 0) {
            totalLines++;
            String lastLine = line.toString();

            if (lastLine.contains("ERROR")) {
                errorCount++;
            }
            if (lastLine.contains("WARNING")) {
                warningCount++;
            }
        }

        fileChannel.close();

        System.out.println("Total Lines   : " + totalLines);
        System.out.println("ERROR Count   : " + errorCount);
        System.out.println("WARNING Count : " + warningCount);
    }

    public static void main(String[] args) {
        try{
            logFilesAnalyzer();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
