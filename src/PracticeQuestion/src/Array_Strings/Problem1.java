package Array_Strings;

public class Problem1 {

    static void letterBetweenIndexs(String str,int index1, int index2) {
        char[] charArray = str.toCharArray();
        if(index1>=index2){
            System.out.println("Index2 should be greater than Index1");
            return;
        }
        if(index1 > str.length()-1 || index1 <0 ){
            System.out.println("<Index1>is greater than the word length / is less than 0");
            return;
        }
        if(index2 > str.length()-1 ){
            System.out.println("<Index2>is greater than the word length / is less than 0");
            return;
        }

        System.out.println(str.substring(index1,index2));
    }
}
