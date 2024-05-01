import java.util.*;
public class segt {
    static int tree[];
    public static void init(int n){
        tree=new int[4*n];
    }
    public static void buildst(int i,int si,int sj,int arr[]){
        if(si==sj){
            tree[i]=arr[si];
            return ;
        }
        int mid=(si+sj)/2;
        buildst(2*i+1, si, mid, arr);
        buildst(2*i+2, mid+1, sj, arr);
        tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
    }
    public static int getmax(int arr[],int qi,int qj){
        int n=arr.length;
        return getmaxutil(0, 0, n-1, qi, qj);
    }
    public static int getmaxutil(int i,int si,int sj,int qi,int qj){
        if(si>qj||sj<qi){
            return Integer.MIN_VALUE;
        }
        else if(si>=qi&&sj>=qj){
            return tree[i];
        }
        else{
            int mid=(si+sj)/2;
            int leftans=getmaxutil(2*i+1, si, mid, qi, qj);
            int rightans=getmaxutil(2*i+2, mid+1, sj, qi, qj);
        
            return Math.max(leftans,rightans);
        }
    }
    public static void update(int arr[],int idx,int newval){
        arr[idx]=newval;
        int n=arr.length;
 updateutil(0, 0, n-1, idx, newval);
    }
    public static void updateutil(int i,int si,int sj,int idx,int newval){
        if(idx<si||idx>sj){
            return ;
        }
        tree[i]=Math.max(tree[i],newval);
if(si!=sj){
    int mid=(si+sj)/2;
updateutil(2*i+1, si, mid, idx, newval);
updateutil(2*i+2, mid+1, sj, idx, newval);
}
    }
    public static void main(String[] args) {
        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
        init(n);
      buildst(0, 0, n-1, arr);
        int max=getmax(arr, 2, 5);
        System.out.println(max);
        update(arr, 2, 20);
        System.out.println(getmax(arr, 2, 5));
    }
}
