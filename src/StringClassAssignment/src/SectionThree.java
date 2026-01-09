public class SectionThree {
    /*
    StringBuilder Class
    9. Efficient String Modifications
        ○ Write a program using StringBuilder to perform the following on a string:
        ■ Delete characters between index 2 and 5.
        ■ Append " Efficient Programming".
        ■ Reverse the entire string.
    10. Word Count and Modification
         ○ Use StringBuilder to count the number of words in a sentence and append the
    word count at the end.
    11. Performance Benchmarking
         ○ Write a program to compare the performance of String, StringBuffer, and
    StringBuilder for concatenating 10,000 strings.
     */

    static void problem_9(){
        String myString = "THIS COOL COURSE ";
        StringBuilder builder = new StringBuilder(myString);
        builder.delete(2,5);
        System.out.println(builder);
        builder.append("Efficient Programming");
        System.out.println(builder);
        System.out.println(builder.reverse());
    }

    static void problem_10(){
        String myString = "THIS COOL COURSE";
        StringBuilder builder = new StringBuilder(myString);
        System.out.println(builder);
        String[] arr = builder.toString().trim().split(" ");
        int wordCount = arr.length;
        builder.append(wordCount);
        System.out.println(builder);
    }

    static void problem_11(){
        String a = "aa";
        String string = "a";
        StringBuffer stringBuffer  = new StringBuffer(string);
        StringBuilder stringBuilder = new StringBuilder(string);
        //String
        long starttime  = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            string = string.concat(a);
        }
        long endtime  = System.currentTimeMillis();
        long timetaken = (endtime-starttime);
        System.out.println("Time By String: " + timetaken+"ms");

        starttime  = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            stringBuffer.append(a);
        }
        endtime  = System.currentTimeMillis();
        timetaken = (endtime-starttime);
        System.out.println("Time By StringBuffer: " + timetaken+"ms");

        starttime  = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            stringBuilder.append(a);
        }
        endtime  = System.currentTimeMillis();
        timetaken = (endtime-starttime);
        System.out.println("Time By StringBuilder: " + timetaken+"ms");

    }

    public static void main(String[] args) {
        problem_11();
    }
}
