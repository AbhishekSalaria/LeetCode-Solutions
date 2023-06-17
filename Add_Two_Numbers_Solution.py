class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        ls1,ls2 = "",""
        while(l1.next != None):
            ls1 += str(l1.val)
            l1 = l1.next
        ls1 += str(l1.val)
        while(l2.next != None):
            ls2 += str(l2.val)
            l2 = l2.next
        ls2 += str(l2.val)
        ls1,ls2 = int(ls1[::-1]),int(ls2[::-1])
        result = list(str(ls1+ls2))
        l3 = ListNode(0)
        ptr = l3
        for data in result[::-1]:
            ptr.next = ListNode(data)
            ptr = ptr.next
        return l3.next
