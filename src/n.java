public class n{
    public static void print(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]);
        }System.out.println();
    }
     public static void quicksort(int arr[],int si,int ei){
        if(si>=ei){
            return;

        }
   int pi=partition(arr,si,ei);
   quicksort(arr,si,pi-1);//left
   quicksort(arr,pi+1,ei);//right

     }
     public static int  partition(int arr[],int si,int ei){
       int pivot=arr[ei];
       int i=si-1;
       for(int j=si;j<ei;j++){
        if(arr[j]<=pivot){
            i++;
            //swap
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;

        } }
        //for positioning pivot;
        i++;
            //swap
            int temp=pivot;
            arr[ei]=arr[i];
            arr[i]=temp;
       return i;
     }
     public static void main(String args[]){
        int arr[]={1,5,9,8,7,0};
        quicksort(arr, 0, arr.length-1);
        print(arr);
     }
}