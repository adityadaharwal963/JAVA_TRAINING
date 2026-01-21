import java.util.Arrays;

public class Stack<T> {
    private T[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.stack = (T[]) new Object[capacity];
        this.top = 0;
    }

    public void push(T item) {
        stack[top++] = item;
    }

    public T pop() {
        return stack[--top];
    }
    public T peek() {
        if (top > 0)
            return stack[top-1];
        return null;
    }

    boolean isEmpty(){
        return top == 0;
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(stack) +
                '}';
    }
}
