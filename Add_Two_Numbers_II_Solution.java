public class Add_Two_Numbers_II_Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String str1 = "";
        String str2 = "";

        while(l1 != null) {
            str1 += String.valueOf(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            str2 += String.valueOf(l2.val);
            l2 = l2.next;
        }

        BigInteger a = new BigInteger(str1);
        BigInteger b = new BigInteger(str2);
        String result = "" + a.add(b);

        ListNode head = new ListNode();
        ListNode curr = head;
        for (char ch : result.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            ListNode node = new ListNode(digit);
            curr.next = node;
            curr = curr.next;
        }
        return head.next;
    }
}