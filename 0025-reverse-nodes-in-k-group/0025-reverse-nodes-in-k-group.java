class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }

        int times=count/k;

        temp=head;

        ListNode pre=null;
        ListNode result=null;

        ListNode pre2=null;

        int num=k;


        while(times>0 ){
            ListNode start=temp;

            while(num>0){
                ListNode no=temp.next;
                temp.next=pre;
                pre=temp;
                temp=no;
                num--;
            }
            
            if(result==null){
               result=pre;
            }
            if (pre2 != null) {
                pre2.next = pre;
            }

                start.next=temp;
                pre2=start;

                pre=null;

                num=k;
                times--;   
        }

        return result;




    }
}
