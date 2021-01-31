package temp;
import java.util.Stack;

public class EvalRPN {
    // 输入: ["4", "13", "5", "/", "+"]
    // 输出: 6
    // 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(val1 + val2);
                    break;
                case "-":
                    int val4 = stack.pop();
                    int val3 = stack.pop();
                    stack.push(val3 - val4);
                    break;
                case "*":
                    int val6 = stack.pop();
                    int val5 = stack.pop();
                    stack.push(val5 * val6);
                    break;
                case "/":
                    int val8 = stack.pop();
                    int val7 = stack.pop();
                    stack.push(val7 / val8);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.peek();
    }
}
