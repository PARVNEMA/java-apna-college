import java .util.*;
public class disjointsetds {
    static int n=7;
    static int par[]=new int[n];
    static int rank[]=new int[n];

    public static void init(){
for(int i=0;i<n;i++){
    par[i]=i;
}
    }
    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return find(par[x]);
    }
    public static void union(int a,int b){
        int para=find(a);
        int parb=find(b);

        if(rank[para]==rank[parb]){
            par[parb]=para;
            rank[para]++;
        }
        else if(rank[para]<rank[parb]){
            par[para]=parb;
        }
        else{
            par[parb]=para;
        }
    }
    public static void main(String args[]){
        init();
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println((find(3)));
        System.out.println(find(4));
        union(1, 5);
    }
}
