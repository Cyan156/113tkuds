class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Q6_PrintReverseList {
    public static void main(String[] args) {
        // 建立鏈結串列：1 -> 2 -> 3 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.print("Reverse print: ");
        printReverse(head);  // 輸出：3 2 1
    }

    public static void printReverse(ListNode head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.val + " ");
    }
}
