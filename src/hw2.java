public class hw2 {
    public static void bubblesort(int arr[]){
int n=arr.length;
int count=0;

for(int i=0;i<n-1;i++){
    for(int j=0;j<n-1-i;j++){
        if(arr[j]>arr[j+1]){
            int temp=arr[j];
            arr[j]=arr[j+1];
            arr[j+1]=temp;
            count++;
        }
        System.out.println("now the inversion count "+i+"="+count);
    }
}
    }
    public static void main(String[] args) {
        
        int arr[]={5,5,5};
        bubblesort(arr);
    }
}
