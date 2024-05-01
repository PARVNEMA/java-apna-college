import java.util.LinkedList;

public class LL{
    static class node{
        int data;
        node next;

        public node(int d){
            this.data=d;
            this.next=null;
        }
    }
    public static node head;
    public static node tail;

    
    public static int intersectionnode(node head1,node head2){
        
        while(head2!=null){
            node temp=head1;
            while(temp!=null){
                if(temp.data==head2.data){
                  return temp.data;
                }
                temp=temp.next;
            }
            head2=head2.next;
        }
        return -1;
    }
    public static void deletem(LinkedList<Integer>l,int n,int m){
        for(int i=0;i<l.size();i++){
            node temp=head;
            if(i==n){
                
  temp.next=temp.next.next.next;

            }
            temp=temp.next;

        }
    }
    public static void printll(LinkedList<Integer>l){
        if(l.isEmpty()){
            return;
        }
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }System.out.println();
    }
    public static void main(String[] args) {
       LinkedList<Integer>l=new LinkedList<>();
       l.addLast(1);
       l.addLast(2);
       l.addLast(3);
       l.addLast(4);
       l.addLast(5);
       l.addLast(6);
 printll(l);
       deletem(l, 2, 2);
       printll(l);
}
}
    
