package DS.most_orig.level1.Queue;

public class MainQueue {

	public static void main(String[] args) {

		ArrayQueue queue = new ArrayQueue();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);

		System.out.println(queue.toString());
		System.out.println(queue.dequeue());

		System.out.println(queue.toString());
		System.out.println(queue.dequeue());

		System.out.println(queue.toString());
		System.out.println(queue.dequeue());

		System.out.println(queue.toString());
		System.out.println(queue.dequeue());

		System.out.println(queue.toString());
		
		queue.enqueue(5);
		queue.enqueue(6);
		
		System.out.println(queue.toString());

		System.out.println("queue.isEmpty() = " + queue.isEmpty());
	}

}
