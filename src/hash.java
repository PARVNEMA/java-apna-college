import java.util.*;
public class hash{
  public static void main(String args[]){
    int arr1[]={7,3,9};
    int arr2[]={6,3,9,2,9,4};

    HashSet<Integer> s=new HashSet<>();

    for(int i=0;i<arr1.length;i++){
      s.add(arr1[i]);
    }
    for(int i=0;i<arr1.length;i++){
      s.add(arr2[i]);
    }
    System.out.println("union"+s.size());

    s.clear();
    for(int i=0;i<arr1.length;i++){
      s.add(arr1[i]);
    }
int count=0;
    for(int i=0;i<arr2.length;i++){
      if(s.contains(arr2[i])){
count++;
s.remove(arr2[i]);
      }
    }System.out.println("intersection"+count);
  }

}