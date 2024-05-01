import java.util.*;

public class dp7 {
   public static int countbst(int n){
    int dp[]=new int[n+1];
    dp[0]=1;
    dp[1]=1;

    for(int i=2;i<n+1;i++){
        for(int j=0;j<i;j++){
            dp[i]+=dp[j]*dp[i-j-1];
        }
    }
    return dp[n];
   } 

   public static int mcm(int arr[],int i,int j){
    if(i==j){
        return 0;
    }
    int ans=Integer.MAX_VALUE;
    for(int k=i;k<=j-1;k++){
        int cost1=mcm(arr, i, k);
 
        int cost2=mcm(arr, k+1, j);
        int cost3=arr[i-1]*arr[k]*arr[j];

        int finalcost=cost1+cost2+cost3;

        ans=Math.min(ans,finalcost);
    }
    return ans;
   }
   public static int mcmmem(int arr[],int i,int j,int dp[][]){
    if(i==j){
        return 0;
    }
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    int ans=Integer.MAX_VALUE;
    for(int k=i;k<=j-1;k++){
        int cost1=mcmmem(arr, i, k,dp);
        int cost2=mcmmem(arr, k+1, j, dp);
        int cost3=arr[i-1]*arr[k]*arr[j];
        
        ans=Math.min(ans,cost1+cost2+cost3);
        
    }
    return dp[i][j]=ans;
   }
   public static int mcmtab(int arr[]){
    int n=arr.length;
    int dp[][]=new int[n][n];

    for(int i=0;i<n;i++){
        dp[i][i]=0;
    }

    //bottom up
    for(int len=2;len<=n-1;len++){
        for(int i=1;i<=n-len;i++){
      int j=i+len-1;
      dp[i][j]=Integer.MAX_VALUE;
      for(int k=i;k<=j-1;k++){
        int cost1=dp[i][k];
        int cost2=dp[k+1][j];
        int cost3=arr[i-1]*arr[k]*arr[j];

        dp[i][j]=Math.min(dp[i][j],cost1+cost2+cost3);
      }
        }
    }
    return dp[1][n-1];
   }
   public static boolean minpart(int arr[]){
    int n=arr.length;int sum=0;
    for(int i=0;i<arr.length;i++){
        sum+=arr[i];
    }int w=sum/2;
    int dp[][]=new int[n+1][w+1];

    //bottom up
    for(int i=1;i<n+1;i++){
        for(int j=1;j<w+1;j++){
            if(arr[i-1]<=j){
                //valid
                //include &exclude
                dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][w]);
            }
            else{
                dp[i][j]=dp[i-1][j];
            }
        }
    }
    int sum1=dp[n][w];
    int sum2=sum-sum1;
   // return Math.abs(sum1-sum2);
   if(sum1==sum2){
    return true;   }return false;
   }
   public static int minjumps(int nums[]){
    int n=nums.length;
    int dp[]=new int[n+1];
    Arrays.fill(dp,-1);
    dp[n-1]=0;
    for(int i=n-2;i>=0;i--){
        int steps=nums[i];int ans=Integer.MAX_VALUE;
        for(int j=i+1;j<=steps+i&&j<n;j++){
if(dp[j]!=-1){
    ans=Math.min(ans,dp[j]+1);
}
        }
        if(ans!=Integer.MAX_VALUE){
            dp[i]=ans;
        }
    }
    return dp[0];

   }
   
   public static void main(String[] args) {
    int arr[]={2,3,1,1,4};
  //  int n=arr.length;
//  System.out.println(minpart(arr));
//System.out.println(minjumps(arr));
System.out.println(countbst(3));
   }
}
