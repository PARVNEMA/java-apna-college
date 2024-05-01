class p{
    public static void bubblesort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void selectionsort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int maxpos=i;
            for(int j=i+1;j<n;j++){
                if(arr[maxpos]<arr[j]){
                    maxpos=j;
                }
                
            }
            //swap
            int temp=arr[i];
            arr[i]=arr[maxpos];
            arr[maxpos]=temp;
        }
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();
    }
    public static void countsort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(arr[i],largest);
        }
        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }int j=0;
        for(int i=count.length-1;i>=0;i--){
while(count[i]>0){
    arr[j]=i;
    j++;
    count[i]--;
}
        }
    }
public static void main(String[] args) {
    int arr[]={3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
   // bubblesort(arr);
  // selectionsort(arr);
  countsort(arr);
    printarr(arr);
}
}