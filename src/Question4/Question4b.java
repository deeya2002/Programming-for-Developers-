package Question4;
//Question 4 b)

// Define a Node class to represent a node in a linked list
class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}

// Define a Question 4b class to sort a linked list and count the number of steps required
class Question4b {
    Node head;

    // A method to sort the linked list and count the number of steps required
    public int sort() {
        int steps = 0;
        Node current = head;
        while (current.next != null) { // Loop through the linked list until the end is reached
            if (current.val > current.next.val) { // If the current node's value is greater than the next node's value
                current.next = current.next.next; // Remove the next node by skipping over it
                steps++; // Increment the steps counter
            } else {
                current = current.next; // Move to the next node
            }
        }
        return steps;
    }

    // A main method to test the sorting and step counting functionality
    public static void main(String[] args) {
        // Create a new linked list
        Question4b list = new Question4b();
        list.head = new Node(5);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(1);

        // Sort the list and count the steps
        int steps = list.sort();

        System.out.println("Steps required to sort the list: " + steps);
    }
}
