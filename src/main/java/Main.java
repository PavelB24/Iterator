public class Main {
    public static void main(String[] args) {
        LinkedDeQueueImpl impl1 = new LinkedDeQueueImpl();
        var linkedList = new SimpleLinkedListImpl<Integer>();
        linkedList.insertFirst(15);
        linkedList.insertFirst(156);
        linkedList.insertFirst(78);
        linkedList.insertFirst(884);
        linkedList.insertFirst(79);
        linkedList.insertFirst(154);



        for (Integer num : linkedList) {
            System.out.println(num);

        }

    }
}
