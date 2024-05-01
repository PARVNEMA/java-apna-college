import java.util.ArrayList;

public class naman1 {
    
  public static void sub(int arr[],int i,ArrayList<Integer>al, ArrayList<ArrayList<Integer>>ar){
    if(i==arr.length){
    if(al.size()>0){
       ar.add(al);
    }
    return;
    }
    sub(arr, i+1, al,ar);
    al.add(arr[i]);
    sub(arr, i+1, al,ar);
    al.remove(al.size()-1);
    return;
}
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        ArrayList<ArrayList<Integer>>al=new ArrayList<>();
        sub(arr, 0, new ArrayList<>(),al);
        
 for(ArrayList a:al){
    int sum=0;
    for(int i=0;i<a.size();i++){
    sum +=a.get(i);
    }
    
 }
    }

 }