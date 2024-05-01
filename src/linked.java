import java.util.*;
public class linked {
    static class node{
        int val;
        node next;

        public node (int val){
            this.val=val;
            this.next=null;
        }
    }
    public static void printll(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
    }
    public static void swap(int key1,int key2,node head){
        node temp=head;
        node prev=null;
        while(temp.val!=key1){
            prev=temp;
            temp=temp.next;
        }
        node temp2=head;
        node prev2=null;
        while(temp2.val!=key2){
            prev2=temp2;
            temp2=temp2.next;
        }
  
  prev.next=temp2;
  prev2.next=temp;

  node curr=temp.next;
  temp.next=temp2.next;
  temp2.next=curr;
 
  
    }
    public static void oddeven(node head){
        node end = head;
node prev = null;
node curr = head;
while (end.next != null)
end = end.next;
node new_end = end;
while (curr.val %2 !=0 && curr != end){
new_end.next = curr;
curr = curr.next;
new_end.next.next = null;
new_end = new_end.next;
}
if (curr.val %2 ==0){
head = curr;
while (curr != end){
if (curr.val % 2 == 0){
prev = curr;
curr = curr.next;
}
else{
prev.next = curr.next;
curr.next = null;
new_end.next = curr;
//namannema0704@gmail.com
new_end = curr;
curr = prev.next;
}
}
}
else prev = curr;
if (new_end != end && end.val %2 != 0){
prev.next = end.next;
end.next = null;
new_end.next = end;
}
}
    
    public static void main(String[] args) {
        LinkedList<Integer>l=new LinkedList<>();
       node head=new node(8);
       node newnode=new node(12);
       head.next=newnode;
       head.next.next=new node(3);
       head.next.next.next=new node(4);
       head.next.next.next.next=null;

       printll(head);
      oddeven(head);
     printll(head);
    }
}
