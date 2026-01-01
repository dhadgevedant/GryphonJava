public class LinkedList {
    // a program to create a linked list and perform basic operations like insertion, deletion, and display
    private Node head;
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // Insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return; 
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    // Delete a node by value
    public void delete(int key) {
        Node current = head, prev = null;
        if (current != null && current.data == key) {
            head = current.next; // Changed head
            return;
        }
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }
        if (current == null) return; // Key not found
        prev.next = current.next; // Unlink the node
    }   
    // Display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    // Main method to test the linked list operations
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        System.out.println("Linked List after insertion:");
        list.display(); 
        list.delete(20);
        System.out.println("Linked List after deletion of 20:");
        list.display();
    }
}