public class heap2 {
    public static void heapsort(int arr[]){
        //step 1
        int n=arr.length;
        for(int i=n/2;i>0;i--){
            heapify(arr,i,n);
        }
        //step 2
        for(int i=n-1;i>0;i--){
            //swap
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,0,i);
        }
    }
    public static void heapify(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxheap=i;

        if(left<size&&arr[left]>arr[maxheap]){
            maxheap=left;
        }
        if(right<size&&arr[right]>arr[maxheap]){
            maxheap=right;
        }

        if(maxheap!=i){
            int temp=arr[i];
            arr[i]=arr[maxheap];
            arr[maxheap]=temp;

            heapify(arr, maxheap, size);

        }
    }
    public static void main(String[] args) {
        int arr[]={2,2,4,5,3};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");

        }System.out.println();
    }
}
