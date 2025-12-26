package LinkedListProblems;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        
    }

    public static ListNode middleNode(ListNode head){
        if(head == null) return null;
         ListNode slowPointer = head;
         ListNode fastPointer = head;

         while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
         }

         return slowPointer;
    }
}
