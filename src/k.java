import java.util.Stack;
public class k{
    public static int maxWater(int[] height){
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
        while ((!stack.isEmpty())
        && (height[stack.peek()] < height[i])) {
        int pop_height = height[stack.peek()];
        stack.pop();
        if (stack.isEmpty())
        break;
        int distance = i - stack.peek() - 1;
        int min_height
        = Math.min(height[stack.peek()],
        height[i])
        - pop_height;
        ans += distance * min_height;
        }
        stack.push(i);
        }
        return ans;
        }
        public static void main(String[] args){
        int arr[] = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 6,};
       // namannema0704@gmail.com
       System.out.println(maxWater(arr));
        }
    }
