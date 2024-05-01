import java.util.*;
public class v{
   public static int trappingwater(int arr[]){
      int n=arr.length;
      int leftmax[]=new int[n];
      leftmax[0]=arr[0];
      for(int i=1;i<n;i++){
   leftmax[i]=Math.max(arr[i],leftmax[i-1]);
      }
      int rightmax[]=new int[n];
      rightmax[n-1]=arr[n-1];
      for(int i=n-2;i>=0;i--){
         rightmax[i]=Math.max(arr[i],rightmax[i+1]);
      }
int trapwater=0;
      for(int i=0;i<n;i++){
         int waterlvl=Math.min(leftmax[i],rightmax[i]);

         trapwater+=waterlvl-arr[i];
      }
return trapwater;
   }
   public static void prefixsum(int arr[]){
      int n=arr.length;
      int currsum=0;
      int maxsum=Integer.MIN_VALUE;
      int prefix[]=new int[n];
      prefix[0]=arr[0];

      for(int k=1;k<prefix.length;k++){
         prefix[k]+=prefix[k-1]+arr[k];
      }
      for(int i=0;i<n;i++){
         int start=i;
         for(int j=i;j<n;j++){
            int end=j;
         
            currsum=start==0?prefix[end]:prefix[end]+prefix[start-1];
  if(maxsum<currsum){
  maxsum=currsum;
  }
  } }
System.out.println(maxsum);
   }
      public static void main(String[] args) {
         int arr[]={1,-2,6,-1,3};
       //  System.out.println(trappingwater(arr));
         // prefixsum(arr);
         String str="abca";
    char ch[]= str.toCharArray();
    Arrays.sort(ch);
    for(char c:ch){
      System.out.println(c);
    }
      }      
       
}