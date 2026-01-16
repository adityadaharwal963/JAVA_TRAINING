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
        for(int i=0;i<bracket.length;i++){
            if(bracket[i]=='{'|| bracket[i]=='['||bracket[i]=='('){
                stack.push(bracket[i]);
            }else {
                if(!stack.isEmpty() && match(stack.peek(),bracket[i])){
                    stack.pop();
                }else {
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
