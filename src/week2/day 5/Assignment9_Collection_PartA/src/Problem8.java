import java.util.Stack;

public class Problem8 {
    /*
    Balanced Brackets Using Stack
    Problem Statement:
    Given a string containing brackets {}, [], (), determine whether the string is balanced.
    Input:
    {[()]}
    Output:
    Balanced
     */

    static boolean match(char a, char b){
        if(a == '{' && b=='}') return true;
        if(a=='(' && b==')') return true;
        if(a=='[' && b==']') return true;
        return false;
    }
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String brackets = "{[({)}]}";

        char[] bracket = brackets.toCharArray();
        boolean balanced = true;
        for (char c : bracket) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && match(stack.peek(), c)) {
                    stack.pop();
                } else {
                    balanced = false;
                    break;
                }
            }
        }
        if(balanced){
            System.out.println("Balanced");
        }else {
            System.out.println("Unbalanced");
        }
    }

}
