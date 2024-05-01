import java.util.*;
public class dp6{
    public static int catalan(int n){
        if(n==0||n==1){
            return 1;
        }int ans=0;
        for(int i=0;i<=n-1;i++){
  ans+=catalan(i)*catalan(n-i-1);

        }
        return ans;
    }
    public static int catalanm(int n,int dp[]){
        if(n==0||n==1){
            return 1;
        }int ans=0;
        if(dp[n]!=-1){
            return dp[n];
        }
        else{
            for(int i=2;i<=n+1;i++){
ans+=catalanm(i,dp)*catalanm(n-i-1,dp);
            }
        }
        return ans;
    }
    public static int cattab(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        //System.out.println(catalanm(n+1,dp));
        System.out.println(cattab(n));
    }
}