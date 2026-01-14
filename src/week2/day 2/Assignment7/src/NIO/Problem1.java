package NIO;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Problem1 {

    /*
    1. Large File Copy Tool
    Problem Statement:
    Create a program that copies a large file (100MB or more) from one location to another using
    FileChannel and ByteBuffer.
    The program should display the time taken to complete the copy.
    Concepts used:
    FileChannel, ByteBuffer, performance comparison with java.io
     */
private static final int BUFFER_SIZE = 16 * 1024; // 16 KB

    public static void main(String[] args) throws Exception {


            String source = "100mb-examplefile-com.txt";
            String destinationNIO = "100mb-examplefile-com" + "-nio"+".txt";
            String destinationIO = "100mb-examplefile-com" + "-io"+".txt";;

            long nioTime = copyUsingNIO(source, destinationNIO);
            long ioTime = copyUsingIO(source, destinationIO);

            System.out.println(" Performance ");
            System.out.println("NIO (FileChannel) Time : " + nioTime + " ms");
            System.out.println("IO  (Streams) Time    : " + ioTime + " ms");
        }


        private static long copyUsingNIO(String source, String destination) throws IOException {
            long start = System.currentTimeMillis();

            try (FileChannel inChannel = new FileInputStream(source).getChannel();
                 FileChannel outChannel = new FileOutputStream(destination).getChannel()) {

                ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

                while (inChannel.read(buffer) > 0) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }

            return System.currentTimeMillis() - start;
        }


        private static long copyUsingIO(String source, String destination) throws IOException {
            long start = System.currentTimeMillis();

            try (InputStream in = new BufferedInputStream(new FileInputStream(source));
                 OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;

                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }

            return System.currentTimeMillis() - start;
        }

}
