package DS.most_orig.level1.Stack;

public class MainStack {

	public static void main(String[] args) {
		MyStack stack = new MyStack();


		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println(stack.pop());

		System.out.println(stack.pop());

		System.out.println(stack.peek());

		System.out.println(stack.isEmpty());

		System.out.println(stack);


	}

}
