import java.util.PriorityQueue;
import java.util.Queue;

class PriorityQueueEg {

    public static void main(String[] args) {
        // Creating empty priority queue
        Queue<Integer> pQueue
                = new PriorityQueue<>();

        // Adding items to the pQueue
        // using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        /* The elements of the priority queue are ordered according to the natural ordering, or by a Comparator provided
        at queue construction time, depending on which constructor is used. */

        // Printing the top element of
        // the PriorityQueue
        System.out.println(pQueue.peek()); //10

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.peek()); //10 and removes 10, so that queue becomes 20, 15

        // Printing the top element again
        System.out.println(pQueue.peek()); //should be 20

        System.out.println("Priority Queue");
        for (Integer item :
                pQueue) {
            System.out.println(item);
        }

        //10, 20, 15

        // Printing the top element of
        // the PriorityQueue
        pQueue.peek();
        System.out.println("Priority Queue after peek");
        for (Integer item :
                pQueue) {
            System.out.println(item);
        }

        // Printing the top element and removing it
        // from the PriorityQueue container
        pQueue.poll();
        System.out.println("Priority Queue after poll");
        for (Integer item :
                pQueue) {
            System.out.println(item);
        }

        // Printing the top element again
        pQueue.peek();
        System.out.println("Priority Queue after peek");
        for (Integer item :
                pQueue) {
            System.out.println(item);
        }
    }
}
