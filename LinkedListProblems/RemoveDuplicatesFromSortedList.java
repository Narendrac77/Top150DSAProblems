package LinkedListProblems;

public class RemoveDuplicatesFromSortedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        
    }

    public static ListNode deleteDuplicates(ListNode head){
        if(head == null) return head;

        ListNode temp = head;

        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            } else{
                temp = temp.next;
            }
        }
        return head;
    }
}
