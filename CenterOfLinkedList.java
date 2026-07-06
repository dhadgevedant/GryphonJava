public class CenterOfLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node findCenter(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    // Function to add a new node at the end of the linked list
    //pass reference of head and tail node
    public static Node AddNode(Node head, Node tail, int newData) {
        
        Node newNode = new Node(newData);

        if(head.next == tail){
            
            tail = newNode;

            head.next = newNode;
            
            tail = tail.next;
            return newNode;
        }
        tail.next = newNode;
        tail = tail.next;   

        return newNode;
    }

    public static void main(String[] args) {
        
        
        Node head = new Node(1);
        Node tail = new Node(0);
        head.next = tail;


        tail = AddNode(head, tail, 2);
        tail = AddNode(head, tail, 3);
        // tail = AddNode(head, tail, 4);
        // tail = AddNode(head, tail, 5);

        //print linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        Node center = findCenter(head);
        if (center != null) {
            System.out.println("Center of the linked list is: " + center.data);
        } else {
            System.out.println("The linked list is empty.");
        }
    }
}
