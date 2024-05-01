import java.util.*;
import java.util.Queue;
public class practice {
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
    public static void levelorder(node root){
        if(root==null){
            return;
        }
            Queue<node>q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                node currnode=q.remove();

                if(currnode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }

                 }
                 else{
                    System.out.print(currnode.data+" ");
                    if(currnode.left!=null){
                        q.add(currnode.left);}
                        if(currnode.right!=null){
                       q.add(currnode.right);
                        }
                    
                 }
            }
    }
    static class binarytree{
        static int idx=-1;
        public static node buildtree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            node newnode=new node(nodes[idx]);
            newnode.left=buildtree(nodes);
            newnode.right=buildtree(nodes);
            return newnode;
        }
    }

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1,};
        binarytree tree=new binarytree();
        node root=tree.buildtree(nodes);
        System.out.println(root.data);

        levelorder(root);
    }
}
