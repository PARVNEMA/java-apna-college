import java.beans.PropertyDescriptor;
import java.util.ArrayList;
public class bt {
    static class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int height(node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);

        return Math.max(lh,rh)+1
;    }
public static int diameter2(node root){
    if(root ==null){
        return 0;
    }
    int ld=diameter2(root.left);
    int lh=height(root.left);
    int rd=diameter2(root.right);
    int rh=height(root.right);

    int selfd=lh+rh+1;

    return Math.max(selfd,Math.max(ld,rd));

}
static class info{
    int diam;
    int ht;

    public info(int diam,int ht){
        this.diam=diam;
        this.ht=ht;
    }
}
    public static info diameter(node root){
        if(root==null){
            return new info(0,0);
        }
        info leftinfo=diameter( root.left);
        info rightinfo=diameter(root.right);
        int diam=Math.max(Math.max(leftinfo.diam,rightinfo.diam),leftinfo.ht+rightinfo.ht+1);
        int ht=Math.max(leftinfo.ht,rightinfo.ht)+1;

        return new info(diam,ht);
    
}
public static boolean isidentical(node node,node subroot){
    if(node==null&&subroot==null){
        return true;
    }
   else if(node==null||subroot==null||node.data!=subroot.data){
        return false;
    }
    if(!isidentical( node.left,subroot.left)){
        return false;
    }
    if(!isidentical(node.right,subroot.right)){
        return false;
    }
    return true;
}
public static boolean issubtree(node root,node subroot){
    if(root==null){
        return false;
    }
    if(root.data==subroot.data){
        if(isidentical(root,subroot)){
            return true;
        }
    }
    return issubtree(root.left,subroot)||issubtree(root.right,subroot);
}
public static void klevel(node root,int level,int k){
    if(root==null){
        return;    }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        klevel( root.left,level+1,k);
        klevel( root.right,level+1,k);

}
public static boolean getpath(node root,int n,ArrayList<node>path){
    if(root==null){
        return false;
    }
    path.add(root);

    if(root.data==n){
        return true;
    }
    boolean foundleft=getpath(root.left, n, path);
    boolean foundright=getpath(root.right, n, path);

    if(foundleft||foundright){
        return true;
    }

    path.remove(path.size()-1);
    return false;

}
public static node lca(node root,int n1,int n2){
    ArrayList<node>path1=new ArrayList<>();
    ArrayList<node>path2=new ArrayList<>();

    getpath(root,n1,path1);
    getpath(root,n2,path2);

    //lastcommon ancestor
    int i=0;
    for(;i<path1.size()&&i<path2.size();i++){
        if(path1.get(i)!=path2.get(i)){
            break;
        }
    }
    node lca=path1.get(i-1);
    return lca;

}
public static node lca2(node root,int n1,int n2){
    if(root==null){
        return null;
    }
    if(root.data==n1||root.data==n2){
        return root;
    }

    node leftlca=lca2(root.left,n1,n2);
    node rightlca=lca2(root.right,n1,n2);

    if(leftlca==null){
        return rightlca;

    }
    if(rightlca==null){
        return leftlca;
    }
    return root;
}
public static int kancestor(node root,int n,int k){

    if(root==null){
        return -1;
    }
    if(root.data==n){
        return 0;
    }
    int leftdis=kancestor(root.left, n, k);
    int rightdis=kancestor(root.right, n, k);

    if(leftdis==-1&&rightdis==-1){
        return -1;
    }
    int max=Math.max(leftdis,rightdis);
    if(max+1==n){
        System.out.println(root.data);
    }
    return max+1;
}
public static int transform(node root){
    if(root==null){
return 0;
    }
    int leftchild=transform(root.left);
    int rightchild=transform(root.right);
int newleft=root.left==null?0:root.left.data;
int newright=root.right==null?0:root.right.data;
    int data=root.data;
    root.data=newleft+leftchild+newright+rightchild;
    return data;
}
public static void preorder(node root){
    if(root==null){
        return ;
    }
    System.out.println(root.data);
    preorder(root.left);
    preorder(root.right);

}

public static void main(String[] args) {
    node root=new node(1);
    root.left=new node(2);
    root.left.left=new node(4);  
    root.left.right=new node(5);
    root.right=new node(3);
    root.right.left=new node(6);
    root.right.right=new node(7);

   //System.out.println(diameter(root).diam);
    node subnode=new node(2);
    subnode.left=new node(4);
    subnode.right=new node(5);

   // System.out.println(isidentical(root, subnode));
//int k=3;
//klevel(root, 1, k);
//int n1=4;
//int n2=5;
//System.out.println(lca2(root, n1, n2).data);
//int n=5;
//int k=2;
//System.out.println(kancestor(root, n, k));
transform(root);
preorder(root);
}
}
