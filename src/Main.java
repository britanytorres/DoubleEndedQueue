public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Deque<String> d1 = new ResizingArrayDeque<>();
        // some test code here
        d1.addFirst("Tom");
        d1.addLast("Bob");


        Deque<String> d2 = new SinglyLinkedDeque<>();
        // some test code here

    }
}