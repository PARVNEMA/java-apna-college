import java.util.Stack;
public class data{
    public static void main(String[] args) {
        Stack<Integer>s=new Stack<>();
        int arr[]={6,8,0,1,3};
        int nxtgreater[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty()&&arr[s.peek()]<=arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nxtgreater[i]=  -1;          }
                else{
                    nxtgreater[i]=arr[s.peek()];
                }
                s.push(i);
        }
        for(int i=0;i<nxtgreater.length;i++){
            System.out.print(nxtgreater[i]+" ");
        }System.out.println();
    }
}