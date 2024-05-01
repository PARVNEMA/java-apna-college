import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
public class ar{
   static Queue<Integer>q=new LinkedList<>();
    public static void reverse(int k){
    Stack<Integer>s=new Stack<>();
    if(q.isEmpty()==true||k>q.size()){
        return;
    }
    if(k<=0){
        return ;
    }
  //  Queue<Integer>q1=new LinkedList<>();
for(int i=0;i<k;i++){
    s.push(q.peek());
    q.remove();
}
while(!s.isEmpty()){
    q.add(s.peek());
    s.pop();
}
for(int i=0;i<q.size()-k;i++){
    q.add(q.peek());
    q.remove();
}
}
    
    public static void print(Queue<Integer>q){
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }System.out.println();
    }
    public static void main(String[] args) {
       
    //    int Q = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}
    q.add(10); 
    q.add(20); 
    q.add(30); 
    q.add(40); 
    q.add(50); 
    q.add(60); 
    q.add(70); 
    q.add(80); 
    q.add(90); 
    q.add(100); 

        int k=5;
        print(q);
        reverse(k);
          print(q);

    }
}