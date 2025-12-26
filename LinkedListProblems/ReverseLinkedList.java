package LinkedListProblems;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNodeOperations lOperations = new ListNodeOperations();
        lOperations.add(5);
        lOperations.add(4);
        lOperations.add(3);
        lOperations.add(2);
        lOperations.add(1);
        lOperations.printList();

        ListNode head = lOperations.head;
        
        ListNode reverse = reverseList(head);

        System.out.println();
        
        lOperations.printListReverse(reverse);


    }
}
