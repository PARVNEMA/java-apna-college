import java.util.*;
public class al{
    public static int target(ArrayList<Integer>al,int key){
        int count=0;
        int maxcount=Integer.MIN_VALUE;
        int target=0;
        for(int i=0;i<al.size()-1;i++){
if(al.get(i)==key){
if(al.get(i+1)==target){
count++;
maxcount=Math.max(count,maxcount);
}
else{
    target=al.get(i+1);
}
}
        }
        return target;
    }
    public static void main(String[] args) {
        ArrayList<Integer>al=new ArrayList<>();
        al.add(2);
        al.add(2);
        al.add(2);
        al.add(2);
        al.add(2);
        al.add(3);
        
        

        int key=1;
        System.out.println(target(al, key));
    }
}