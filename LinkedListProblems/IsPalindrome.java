package LinkedListProblems;

public class IsPalindrome {
    public static void main(String[] args) {
        
    }

    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;

        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        ListNode secondHalf = reverse(slowNode);

        ListNode firstHalf = head;
        
        while(secondHalf != null){
            if(secondHalf.val != firstHalf.val){
                return false;
            }
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }

        return true;
    }

    public ListNode reverse(ListNode node){
        ListNode prev = null, curr = node;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
