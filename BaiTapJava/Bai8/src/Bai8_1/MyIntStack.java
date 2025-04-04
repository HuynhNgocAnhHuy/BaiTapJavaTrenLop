package Bai8_1;

public class MyIntStack {
	private int[] contents;
    private int tos;  

    public MyIntStack(int capacity) {
        contents = new int[capacity];
        tos = -1;  
    }

    public void push(int element) {
        contents[++tos] = element;
    }

    public int pop() {
        return contents[tos--];
    }

    public int peek() {
        return contents[tos];
    }

    public boolean isEmpty() {
        return tos < 0;
    }

    public boolean isFull() {
        return tos == contents.length - 1;
    }
}
