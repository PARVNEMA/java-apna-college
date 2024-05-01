import java.util.*;
import java.util.Deque;
public class h{
public static void connectropes(int arr[]){
    Deque<Integer>d=new LinkedList<>();
    Arrays.sort(arr);
int cost=0;
    for(int i=0;i<arr.length;i++){
        d.addLast(arr[i]);
    }

    while(d.size()!=1){
        int s=d.removeFirst();
        int w=d.removeFirst();
        cost+=s+w;
    d.addFirst(s+w);

    }
    System.out.println(cost);
           
}
public static void main(String[] args) {
    int arr[]={1,2,3,4};
    connectropes(arr);
}
}