import java.util.Scanner;

public class SolutionPartA {
    static void problem2(){
        //string compressor
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        StringBuilder stringBuilder = new StringBuilder(input);
        int deleteCount = 0; // track in deleted repeating element
        int insertCount = 0; // track inserted digits
        int charFrequency = 1;
        char curr = stringBuilder.charAt(0);
        for(int i=1;i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i-deleteCount+insertCount)==curr){
                charFrequency++;
                stringBuilder.deleteCharAt(i-deleteCount+insertCount);
                deleteCount++;
            }else {
                curr = stringBuilder.charAt(i-deleteCount+insertCount);
                stringBuilder.insert(i-deleteCount+insertCount,charFrequency);
                insertCount++;
                charFrequency=1;
            }
        }
        System.out.println(stringBuilder.toString());
        sc.close();
    }

    static void problem3(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split(" ");
        StringBuffer sb;
        for(int i=0;i<array.length;i++){
             sb = new StringBuffer(array[i]);
            System.out.print(sb.reverse() +" ");
        }
        sc.close();
    }

    static void problem_4(){
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

    static void problem5(){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try{
            System.out.println(Integer.valueOf(input));
            System.out.println("It's Integer");
        }catch (NumberFormatException e){
            System.out.println("Not an Integer");
        }
        try{
            System.out.println(Double.valueOf(input));
            System.out.println("It's Double");
        }catch (NumberFormatException e){
            System.out.println("Not an Double");
        }
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            System.out.println(Boolean.valueOf(input));
            System.out.println("It's Boolean");
        }else {
            System.out.println("Not an Boolean");
        }
        sc.close();
    }
    static void problem10(){
        String[] transaction = {"5000", "12000", "3000", "15000"};
        int highest = Integer.MIN_VALUE;
        int sum = 0;
        for(String str: transaction){
            int trans = Integer.parseInt(str);
            if(trans>highest){
                highest = trans;
            }
            sum+=trans;
        }

        System.out.println("Highest "+ highest);
        System.out.println("Avg " + (sum/transaction.length));
    }
}
