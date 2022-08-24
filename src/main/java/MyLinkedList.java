public class MyLinkedList {
    class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int maxIndex = -1; // последний узел

    public MyLinkedList() {

    }

    /**
     * Получить номер индексного узла в связанном списке.
     * Если индекс недействителен, вернуть -1.
     *
     * @param index
     * @return int
     */
    public int get(int index) {
        if (index > maxIndex || index < 0) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        if (maxIndex == -1) {
            head = tail = new Node(val, null);
            // голова и хвост один узел а указателя на следующй узел у них нет
        } else {
            head = new Node(val, head);
        }
        maxIndex++;
    }

    /**
     * Добавляет узел со значением val в качестве последнего элемента связанного списка.
     *
     * @param val int
     */
    public void addAtTail(int val) {
        if (maxIndex == -1) {
            head = tail = new Node(val, null);
        } else {
            Node lastNode = new Node(val, null);
            tail.next = lastNode;
            tail = lastNode;
        }
        maxIndex++;
    }

    /**
     * Добавить узел со значением val перед индексным узлом в связанном списке.
     *
     * @param index перед которым добавить
     * @param val   что добавить
     */
    public void addAtIndex(int index, int val) {
        if (index > maxIndex + 1) {
            // а если -1 индекс ? то в добавляем в начало или ошибку выкидывать?
            return;
        }
        if (index <= 0) {
            addAtHead(val);
        } else if (index == maxIndex + 1) {
            addAtTail(val);
        } else {
            Node nodeForIndex = head;
            for (int i = 1; i < index; i++) {
                nodeForIndex = nodeForIndex.next; //1
            }
            // 1 -> 2
            nodeForIndex.next = new Node(val, nodeForIndex.next);
            maxIndex++;
        }
    }

    /**
     * Удалить индексный узел в связанном списке, если индекс действителен.
     *
     * @param index номер узла который надо удалить
     */
    public void deleteAtIndex(int index) {
        if (index > maxIndex || maxIndex == -1 || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head == null) {
                //если всего один элемент в списке
                tail = null;
            }
        } else {
            Node beforIndex = head;
            for (int i = 1; i < index; i++) {
                beforIndex = beforIndex.next; // 1
            }

            if (beforIndex.next.next == null) {
                beforIndex.next = null;
                tail = beforIndex;
            } else {
                beforIndex.next = beforIndex.next.next;
            }
        }
        maxIndex--;
    }
}

/*
["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
[[],            [1],        [3],        [1,2],        [1],      [1]        ,[1]]

 */