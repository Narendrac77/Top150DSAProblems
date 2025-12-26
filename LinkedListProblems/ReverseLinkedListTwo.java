package LinkedListProblems;

//https://leetcode.com/problems/reverse-linked-list-ii/description/
public class ReverseLinkedListTwo {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right){
        if(head == null || left == right) return head;

        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode prev = dummy;

        //Move prev to node before left
        for(int i = 1; i < left; i++){
            prev = prev.next;
        }

        //Reverse sublist
        ListNode curr = prev.next;

        for(int i = 0; i < right - left; i++){
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }

    // Print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Build list: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head);

        head = reverseBetween(head, 2, 4);

        System.out.print("Reversed: ");
        printList(head);
    }
    
}
