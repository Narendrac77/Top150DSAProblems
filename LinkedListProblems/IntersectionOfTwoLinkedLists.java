package LinkedListProblems;

public class IntersectionOfTwoLinkedLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        int diff = Math.abs(sizeA - sizeB);
        ListNode tempA = headA;
        ListNode tempB = headB;
        if(sizeA > sizeB){
             tempA = getToSameSize(tempA, diff);
        } else {
             tempB = getToSameSize(tempB, diff);
        }
        return getIntersection(tempA, tempB);
    }

    public static ListNode getToSameSize(ListNode head, int size){
        for(int i = 0; i < size; i++){
            head = head.next;
        }
        return head;
    }

    public static ListNode getIntersection(ListNode headOne, ListNode headTwo){
        while(headOne != null && headTwo != null){
            if(headOne == headTwo){
                return headOne;
            } 
            headOne = headOne.next;
            headTwo = headTwo.next;
        }
        return null;
    }


    public static int getSize(ListNode head){
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
}
