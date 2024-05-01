import java.util.Stack;
public class trappingrainwater {
    public static int trappwater(int[] height){
        int n=height.length;
        Stack<Integer>left=new Stack<>();
        Stack<Integer>right=new Stack<>();

        left.push(height[0]);
        right.push(height[n-1]);

        //leftmax
        for(int i=0;i<n;i++){
        left.push(Math.max(height[i],left.peek()));
        
        }
        //rightmax
        for(int i=n-1;i>=0;i--){
            right.push(Math.max(height[i],right.peek()));
            
            }
            int tr=0;
            for(int i=0;i<n;i++){
                int waterlvl=Math.min(left.peek(),right.peek());
left.pop();right.pop();
                tr+=waterlvl-height[i];
            }
            return tr;
    }
    public static void main(String[] args) {
        int height[]= { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    ;
        System.out.println(trappwater(height));
    }
}
