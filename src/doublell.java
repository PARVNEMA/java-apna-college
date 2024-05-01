public class doublell {
    public class node{
        int data;
        node prev;
        node next;
        public node(int data){
            this.data=data;
            next=null;
            prev=null;

        }

    }
    public static node head;
    public static node tail;
    public static int size;

    public void addf(int data){
        node newnode=new node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }
    public void addl(int data){
        node newnode=new node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        newnode.prev=tail;
        tail=newnode;
}

public int removef(){
    if(head==null){
        System.out.println("dll is empty");
    }
    if(size==1){
        int val=head.data;
        head=tail=null;
        size--;
        return val;
     
    }
    int val=head.data;
    head=head.next;
    head.prev=null;
    return val;

}
public int removel(){
    if(head==null){
        System.out.println("dll is empty");

    }
    if(size==1){
        int val=tail.data;
        head=tail=null;
        return val;
    }

    int val=tail.data;
    tail=tail.prev;
    tail.next=null;
    return val;
}
    public void print(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void reverse(){
        node curr=head;
        node prev=null;
        node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }


    public static void main(String[] args) {
        doublell dll=new doublell();
        dll.addl(3);
        dll.addl(2);
        dll.addl(1);
       dll.print();
       dll.reverse();
       dll.print();

    }
}
