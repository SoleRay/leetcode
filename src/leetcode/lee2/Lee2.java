package leetcode.lee2;

public class Lee2 {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(8);

        l11.next = l12;

        ListNode l21 = new ListNode(0);

        ListNode listNode = addTwoNumbers(l11, l21);

        while(listNode!=null){

            if(listNode.next!=null){
                System.out.print(listNode.val+"->");
            }else {
                System.out.print(listNode.val);
            }

            listNode = listNode.next;
        }

        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);

        ListNode current = head;

        int carry = 0;

        while(l1!=null || l2!=null){

            int v1 = l1 == null?0:l1.val;
            int v2 = l2 == null?0:l2.val;
            int sum = v1 + v2 + carry;

            carry = sum /10;

            current.next = new ListNode(sum);
            current = current.next;

            if(l1!=null){
                l1 = l1.next;
            }

            if(l2!=null){
                l2 = l2.next;
            }
        }

        if(carry!=0){
            ListNode node = new ListNode(carry);
            current.next = node;
        }

        return head.next;
    }
}


