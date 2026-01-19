import java.util.Stack;

public class ReverseStringWithStack {
    static void reverseStackString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        System.out.println("Reverse: "+stringBuilder.toString());
    }

    public static void main(String[] args) {
        reverseStackString("Hello");
    }

}
