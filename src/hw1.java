public class hw1{
    public static int majority(int nums[]){
        return majorityrec(nums,0,nums.length-1);
    }
    public static int majorityrec(int nums[],int si,int ei){
        if(si==ei){
            return nums[si];
        }

        int mid=si+(ei-si)/2;
        int left=majorityrec(nums, si, mid);
        int right=majorityrec(nums, mid+1, ei);

        if(left==right){
            return left;
        }
        int leftcount=countinrange(nums,left,si,ei);
        int rightcount=countinrange(nums,right,si,ei);

        return leftcount>rightcount?left:right;
    //   return Math.max(leftcount,rightcount);

    }
    public static int countinrange(int nums[],int num,int si,int ei){
        int count=0;
       for(int i=si;i<=ei;i++){
        if(nums[i]==num){
            count++;
        }
       }
       return count;


    }
    public static void main(String[] args) {
        int nums[]={3,2,3,4,6};
        System.out.println(majority(nums));
    }
    }
