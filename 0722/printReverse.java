public static void printReverse(ListNode head) {
    if (head == null) {
        return;
    }
    printReverse(head.next);  // 先递归到链表末尾
    System.out.print(head.val + " ");  // 从后向前打印
}