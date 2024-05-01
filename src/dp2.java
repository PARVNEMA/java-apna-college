import java.util.*;

public class dp2 {
    public static int knapsack(int val[],int wt[],int w,int n,int dp[][]){
        if(w==0||n==0){
            return 0;
        }
        if(dp[n][w]!=-1){
            return dp[n][w];
        }
        if(wt[n-1]<=w){
            //inc
            int ans1=val[n-1]+knapsack(val, wt, w-wt[n-1], n-1,dp);
            //exc
            int ans2=knapsack(val, wt, w, n-1,dp);

            dp[n][w]= Math.max(ans1,ans2);
            return dp[n][w];
        }
        else{
           dp[n][w]= knapsack(val, wt, w, n-1,dp);
  return dp[n][w];

        }
    }
    public static boolean targetsumsubset(int arr[],int sum){
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){

                int v=arr[i-1];

                if(v<=j &&dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }

                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        printdp(dp);
        return dp[n][sum];
    }
    public static void printdp(boolean[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int unboundedknapsack(int val[],int wt[],int w){
        int n=val.length;
        int dp[][]=new int[n+1][w+1];

        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<w+1;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
               if(wt[i-1]<=j){//valid
             dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
               }
               else{

                dp[i][j]=dp[i-1][j];
               }
            }
        }
        printun(dp);
        return dp[n][w];
    }
    public static void printun(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
       int arr[]={15,14,10,45,30};
       int wt[]={2,5,1,3,4};
       int w=7;
System.out.print(unboundedknapsack(arr, wt, w));
      // System.out.println(targetsumsubset(arr, sum));
    }
}
