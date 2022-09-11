import java.util.Stack;

public class Implement_Queue_Using_Stacks {
    Stack<Integer> stack1;
    Stack <Integer> stack2;

    public Implement_Queue_Using_Stacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        this.stack1.push(x);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public int peek() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.peek();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public boolean empty() {
        return (stack2.empty() && stack1.empty());
    }
}
