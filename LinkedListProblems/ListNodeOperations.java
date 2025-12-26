package LinkedListProblems;

public class ListNodeOperations {
    ListNode head;
    ListNode tail;

    public void add(int val) {
         ListNode newNode = new ListNode(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printList(){
        ListNode temp = head;
        while(temp != null){
            if(temp.next != null){
            System.out.print(temp.val + " -> ");
            } else{
                System.out.print(temp.val);
            }
            temp = temp.next;
        }
    }

        public void printListReverse(ListNode head){
        ListNode temp = head;
        while(temp != null){
            if(temp.next != null){
            System.out.print(temp.val + " -> ");
            } else{
                System.out.print(temp.val);
            }
            temp = temp.next;
        }
    }
}
