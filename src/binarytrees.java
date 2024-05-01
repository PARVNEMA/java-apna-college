import java.util.*;
public class binarytrees{
    static class node{
        int data;
        node left;
        node right;
        public node(int d){
            this.data=d;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean univalued(node root){
        if(root==null){
  return true;
        }
        boolean left1=univalued(root.left);
        boolean right1=univalued(root.right);
        if( root.left!=null&&root.data!=root.left.data||root.right!=null&&root.data!=root.right.data){
            return false;
        }
        return left1&right1;
    }
    public static void inorder(node root){
        if(root==null){
            return ;
        }
        System.out.println(root.data);
        inorder(root.left);
        inorder(root.right);

    }
    public static void invert(node root){
        if(root==null){
            return ;
        }
        node temp=root.left;
        root.left=root.right;
        root.right=temp;

        invert(root.left);
        invert(root.right);

        
    }
    public static node deleteleaf(node root,int x){
if(root==null){
    return null;
}
    root.left=   deleteleaf(root.left , x);
    root.right=    deleteleaf(root.right,x);
        if(root.data==x&&root.left==null&&root.right==null){
            return null;
        }
        return root;
        }
    
    
    public static void main(String args[]){
        node tree=new node(1);
        tree.left=new node(2);
        tree.left.left=new node(3);
        tree.left.right=new node(4);
        tree.right=new node(5);
        tree.right.left=new node(6);
        tree.right.right=new node(7);

        inorder(tree);
     deleteleaf(tree, 4);
        inorder(tree);

    }
}