
public class linkedlist1 {
  public static class node{
        int data;
        node next;
        public node(int data){
            this.data=data;
            this.next=null;
        }
        
    }
    public static node head;
    public static node tail;

    public void addlast(int data){
        node newnode=new node(data);
        if(head==null){
            head =tail=newnode;
            return ;
        }
        tail.next=newnode;
        tail=newnode;
    }

    public static  boolean iscycle(){
        node slow=head;
        node fast=head;

        while(fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow ==fast){
                return true; //its a cycle;
             }
           

        } return false;
    }
    public static void removecycle(){
        //detect cycle
        node slow=head;
        node fast=head;
        boolean cycle=false;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
               cycle =true;
               break;
            }
            
            }
            if(cycle ==false){
                return ;
        }
        //step 2
        slow=head;
        node prev=null;
        while(slow!=fast){ prev=fast;

            slow=slow.next;
           
            fast=fast.next;

        }
        //remove cycle
        prev.next=null;
    }

    public void zigzag(){
        //mid
        node slow=head;
        node fast=head.next;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        node mid=slow;

        //reverse half
        node curr=mid.next;
        mid.next=null;
        node prev=null;
        node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        
        node left=head;
        node right=prev;
        node nextl;
        node nextr;

        //merge
        nextl=left.next;
        left.next=right;
        nextr=right.next;
        right.next=nextl;

        left=nextl;
        right=nextr;}

    }
    public static void print(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
         
            temp=temp.next;
        }
        System.out.println("null");
    }


    public static void main(String args[]){
     
    linkedlist1 l=new linkedlist1();
   
    l.addlast(1);
    l.addlast(2);
    l.addlast(3);
    l.addlast(4);
    l.addlast(5);

    print();
    l.zigzag();
    print();

 }
}
