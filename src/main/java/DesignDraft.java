public class DesignDraft {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtHead(1);
        ll.addAtTail(3);
        ll.addAtIndex(1, 2);
        ll.get(1);
        ll.deleteAtIndex(1);

        System.out.println(ll.get(1));
    }
}
/*
["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
[[],            [1],        [3],        [1,2],        [1],      [1]        ,[1]]

 */