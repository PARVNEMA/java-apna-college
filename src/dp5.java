import java.util.*;
public class dp5 {
    public static int lis(int arr[]){
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
          set.add(arr[i]);
        }
        int arr2[]=new int[set.size()];
        int i=0;
        for(int nums:set){
          arr2[i]=nums;
          i++;
        }
       Arrays.sort(arr2);
       return lcs(arr,arr2);}
      
       public static int lcs(int arr[],int arr2[]){
          int n=arr.length;
          int m=arr2.length;
      int dp[][]=new int[n+1][m+1];
          for(int i=1;i<n+1;i++){
              for(int j=1;j<m+1;j++){
                  if(arr[i-1]==arr2[j-1]){
                      dp[i][j]=dp[i-1][j-1]+1;
                  }
                  else{
                      int ans1=dp[i-1][j];
                      int ans2=dp[i][j-1];
      
                      dp[i][j]=Math.max(ans1,ans2);
                  }
              }
          }
          return dp[n][m];
       }
       public static int editdistance(String str1,String str2){
        int n=str1.length();
        int m=str2.length();

        int dp[][]=new int [n+1][m+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j]=j;
                    if(j==0){
                        dp[i][j]=i;
                    }
                }
            }    
        } //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }

            else{
                int add=dp[i][j-1]+1;
                int del=dp[i-1][j]+1;
                int rep=dp[i-1][j-1]+1;

                dp[i][j]=Math.min(add,Math.min(del,rep));
            }
            }
        }
return dp[n][m];
       }
       public static int stringconv(String str1,String str2){
        int n=str1.length();
        int m=str2.length();

        int dp[][]=new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;

                }
                else{
                   int ans1=dp[i-1][j];
                int ans2=dp[i][j-1];
            dp[i][j]=Math.max(ans1,ans2);               }
            }
        }
        int del= n-dp[n][m];
        int add=m-dp[n][m];
        return del+add;
       }
         public static void main(String[] args) {
        String str1="abcdefg";
        String str2="aceg";
      //  System.out.println(editdistance(str1, str2));
      System.out.println(stringconv(str1, str2));
        
      }  
}
