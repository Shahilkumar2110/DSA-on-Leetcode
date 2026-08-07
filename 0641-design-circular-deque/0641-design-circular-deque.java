

class MyCircularDeque {

    class dequeue{
        int data;
        dequeue next=null;
        dequeue pre=null;
        dequeue(int val){
            this.data=val;
        }
        dequeue(int val, dequeue next){
            this.data=val;
            this.next=next;
        }
        dequeue(int data,dequeue next, dequeue pre){
            this.data=data;
            this.next=next;
            this.pre=pre;
        }
    }
    dequeue head=null;
    int limit=0;
    int count=0;

    public MyCircularDeque(int k) {
        this.limit=k;
    }
    
    public boolean insertFront(int value) {
        if(count==limit) return false;
        if(count==0){
             head = new dequeue(value);
            head.next = head;
            head.pre = head;
            count++;    
            return true;
        }

        dequeue last=head.pre;
        last.next=new dequeue(value,head,last);
        head.pre=last.next;
        head=last.next;
        count++;
        return true;

    }
    
    public boolean insertLast(int value) {
        if(count==limit) return false;
        if(count==0){
            head=new dequeue(value);
            head.next = head;
            head.pre = head;
            count++;
            return true;
        }

        dequeue last=head.pre;
        last.next=new dequeue(value,head,last);
        head.pre=last.next;
        count++;
        return true;
    }
    
    public boolean deleteFront() {
        if(count==0) return false;
        if(count==1){
            head=null;
            count--;
            return true;
        }

        dequeue last=head.pre;
        head=head.next;
        head.pre=last;
        last.next=head;
        count--;
        return true;

    }
    
    public boolean deleteLast() {
        if(count==0) return false;
        if(count==1){
            head=null;
            count--;
            return true;
        }

        dequeue last=head.pre;
        last.pre.next=head;
        head.pre=last.pre;

count--;
        return true;
        
    }
    
    public int getFront() {
        if(count==0) return -1;
        return head.data;
    }
    
    public int getRear() {
        if(count==0) return -1;
        return head.pre.data;
    }
    
    public boolean isEmpty() {
        if(count==0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(count==limit) return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */