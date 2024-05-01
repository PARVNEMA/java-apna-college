import java.util.*;
public class basic{
    static class pair implements Comparable<pair>{
        int val;
        int ind;

        public pair(int val,int ind){
this.val=val;
this.ind=ind;
        }
@override
        public int compareTo(pair p){
return p.val-this.val;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=new int[arr.length-k+1];

        PriorityQueue<pair>pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new pair(arr[i],i));
        }
        res[0]=pq.peek().val;

        for(int i=k;i<arr.length;i++){
            while(pq.size()>0&&pq.peek().ind<=(i-k)){
                pq.remove();
            }
            pq.add(new pair(arr[i],i));
            res[i-k+1]=pq.peek().val;
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]);
        }System.out.println();

    }
}