import java.util.Arrays;
import java.util.HashSet;


public class Main {

    static String reverseString(String s){
        Stack<Character> stack = new Stack<>(s.length());
        char[] string = s.toCharArray();
        for(char c : string){
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    static boolean isMatch(char a,char b){
        if (a=='{' && b=='}') return true;
        if (a=='(' && b==')') return true;
        if (a=='[' && b==']') return true;
        return false;
    }

    static void isBalance(String s){
        Stack<Character> stack = new Stack<>(s.length());
        char[] equation = s.toCharArray();
        HashSet<Character> specialOpen = new HashSet<>();
        specialOpen.add('{');
        specialOpen.add('[');
        specialOpen.add('(');

        HashSet<Character> specialClose = new HashSet<>();
        specialOpen.add('}');
        specialOpen.add(']');
        specialOpen.add(')');

        for(char c : equation){
            if(specialOpen.contains(c)){
                stack.push(c);
            }
            if(specialClose.contains(c)){
                if(isMatch(stack.peek(),c)){
                    stack.pop();
                }else {
                    break;
                }
            }

        }

        if (stack.isEmpty()){
            System.out.println("Balance");
        }else {
            System.out.println("Not Balance");
        }
    }


    static void nextGreatestElement(int[] arr){
        Stack<Integer> stack = new Stack<Integer>(arr.length);
        int[] array = new int[arr.length];
        // 4, 5, 2, 10
        // -1 10 10 5
        // 10
        for(int i=arr.length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek()<arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                array[i] = -1;
            }else {
                array[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(array));
    }

    static void evaluatePostfix(String equation){
        // expect a valid postfix equation
        char[] _equation = equation.toCharArray();
        Stack<Integer> stack = new Stack<>(equation.length());
        for(char i : _equation){
            if(Character.isDigit(i)){
                stack.push(Integer.parseInt(String.valueOf(i)));
            }else {
                int v1 = stack.pop(), v2 = stack.pop();
                if(i=='*'){
                    stack.push(v1*v2);
                }else if(i=='/'){
                    stack.push(v1/v2);
                }else if(i=='+'){
                    stack.push(v1+v2);
                }else if(i=='-'){
                    stack.push(v1-v2);
                }
            }
        }

        System.out.println(stack.pop());
    }
}
