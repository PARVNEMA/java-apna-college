import java.util.*;
public class dp  {
    public static int fib(int n,int f[]){
        if(n==0||n==1){
return n;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n]=fib(n-1,f)+fib(n-2,f);
        return f[n];
    }
    public static int fibtabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int countways(int n,int ways[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n]!=-1){
            return ways[n];
        }
      ways[n]= countways(n-1,ways)+countways(n-2,ways);
return ways[n];
  } 
  public static int tabulation(int n){
    int dp[]=new int[n+1]
;
dp[0]=1;
for(int i=1;i<=n;i++){
    if(i==1){
        dp[i]=dp[i-1];

    }
else{
    dp[i]=dp[i-1]+dp[i-2];
}
}
return dp[n];
  }
    public static void main(String[] args) {
        int n=5;
        int ways[]=new int[n+1];
        for(int i=0;i<=n;i++){
            ways[i]=-1;
        }
      //  int f[]=new int[n+1];
    //  System.out.println(  fibtabulation(n));
   // System.out.println(countways(n,ways));
   System.out.println(tabulation(n));
    }
}
