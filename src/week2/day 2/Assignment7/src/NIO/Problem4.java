package NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Problem4 {
    /*
    Secure File Backup Tool
    Problem Statement:
    Create a tool that scans a directory and backs up only new or modified files to another folder
    using NIO.2.
    Use Files.walk() and Files.copy() with appropriate options.
    Concepts used:
    Files.walk(), Files.copy(), StandardCopyOption.REPLACE_EXISTING
     */

    static void fileBackup() {

        Path source = Paths.get("source");
        Path backup = Paths.get("backup");

        try{
        Files.walk(source).forEach(path -> {
            try {
                Path target = backup.resolve(source.relativize(path));

                if (Files.isDirectory(path)) {
                    Files.createDirectories(target);
                } else {
                    Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);
                }

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        });

        System.out.println("Backup completed.");
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        fileBackup();
    }
}
