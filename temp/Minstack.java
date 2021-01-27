import java.util.Stack;

public class Minstack {
    private Stack<Integer> min;
    private Stack<Integer> stack;

    public Minstack() {
        min = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if (!stack.empty()) {
            stack.pop();
            min.pop();
        }
    }

    public int top() {
        if (!stack.empty()) {
            return stack.peek();
        } else {
            return -1;
        }
    }

    public int getMin() {
        if (!min.empty()) {
            return min.peek();
        } else {
            return -1;
        }
    }
}