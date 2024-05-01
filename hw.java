import java.util.*;
public class hw{

    static class node{
        int data;
        node left;
        node right;

        public node(int data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
     static int min;
    public static int target(node root,int k){
   min=Integer.MAX_VALUE;
   abs(root,k);
return min;
    }
    public static void abs(node root,int k){
        if(root==null){
            return;
        }
        min=Math.min(Math.abs(root.data-k),min);
        if(k<=root.data){
            abs(root.left,k);
        }
        else {
            abs(root.right,k);
        }
        
    }
    public static void main(String[] args) {
        node root=new node(8);
         root.left=new node(5);
         root.left.left=new node (3);
         root.left.right=new node(6);
         
         root.right=new node(15);
         root.right.right=new node(18);

        System.out.println( target(root, 5));
    }
}