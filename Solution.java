/**
 * Definition for singly-linked list.
 **/
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode trv = head;
        
        ArrayList<Integer> low = new ArrayList<Integer>();
        ArrayList<Integer> high = new ArrayList<Integer>();
        
        while(trv != null) {
            if(trv.val < x)
                low.add(trv.val);
            else 
                high.add(trv.val);
            trv = trv.next;
        }
        
        ListNode trv2 = head;
        int count = 0;
        
        while(trv2 != null) {
            if(count < low.size()) 
                trv2.val = low.get(count);
            
            else
                trv2.val = high.get(count - low.size());
            count++;
            trv2 = trv2.next;
        }
        
        return head;
            
        
    }
}