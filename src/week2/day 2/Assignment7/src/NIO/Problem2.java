package NIO;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class Problem2 {
    /*
    2. Directory Watcher System
    Problem Statement:
    Develop a utility that continuously monitors a folder and prints a message whenever a file is
    created, modified, or deleted using WatchService.
    Concepts used:
    Path, WatchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE
     */
    static void watchEvent(){

        // Directory to be watched
        Path directoryPath = Paths.get("myFolder");

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {

            // Register  events
            directoryPath.register(
                    watchService,
                    ENTRY_CREATE,
                    ENTRY_MODIFY,
                    ENTRY_DELETE
            );

            System.out.println("Watching directory: " + directoryPath.toAbsolutePath());

            //  watching
            while (true) {
                WatchKey key = watchService.take(); // waits for an event

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    Path fileName = (Path) event.context();

                    if (kind == ENTRY_CREATE) {
                        System.out.println("File created: " + fileName);
                    } else if (kind == ENTRY_MODIFY) {
                        System.out.println("File modified: " + fileName);
                    } else if (kind == ENTRY_DELETE) {
                        System.out.println("File deleted: " + fileName);
                    }
                }


                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }

        } catch (IOException | InterruptedException e) {
             System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        watchEvent();
    }
}
