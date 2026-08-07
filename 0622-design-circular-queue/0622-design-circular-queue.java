class MyCircularQueue {
    class dequeue{
        int data;
        dequeue next=null;
        dequeue(int val){
            this.data=val;
        }
        dequeue(int val, dequeue next){
            this.data=val;
            this.next=next;
        }
    }
    dequeue head=null;
    int limit=0;
    int count=0;


    public MyCircularQueue(int k) {
        this.limit=k;
    }
    
    public boolean enQueue(int value) {
        if(count==limit) return false;
        if (head == null) {
            head = new dequeue(value);
            head.next = head;
            count++;
            return true;
        }

        count++;

        dequeue temp=head;

        while(temp.next!=head){
            temp=temp.next;
        }

        temp.next=new dequeue(value,head);

        return true;

    }
    
    public boolean deQueue() {

        if(count==0) return false;
        if(count==1){
            head=null;
            count=0;
            return true;
        }

        dequeue temp=head;

        while(temp.next!=head){
            temp=temp.next;
        }

        temp.next=head.next;
        head=head.next;
        count--;

        return true;


    }
    
    public int Front() {
        if(head==null) return -1;
        return head.data;
    }
    
    public int Rear() {

        if(head==null) return -1;
        
        dequeue temp=head;

        while(temp.next!=head){
            temp=temp.next;
        }
        return temp.data;
    }
    
    public boolean isEmpty() {
        if(count==0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(limit==count){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */