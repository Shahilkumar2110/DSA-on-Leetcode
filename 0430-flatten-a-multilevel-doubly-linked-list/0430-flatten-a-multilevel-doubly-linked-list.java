/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return null;
        }

        funct(head);
        return head;
    }

    Node funct(Node head){
        if(head==null){
            return null;
        }

        if(head.next==null && head.child==null){
            return head;
        }

        if(head.child!=null){
            Node post=head.next;

            Node children=head.child;
            head.child=null;

            head.next=children;
            children.prev=head;

            Node front=funct(children);
            front.next=post;
            if(post!=null){
                post.prev=front;
            }
        }
        return funct(head.next);
    }
}