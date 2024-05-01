import java.util.*;
public class bst {
  static class node{
    int data;
    node left;
  node right;

  node(int data){
    this.data=data;
  }
   } 

   public static node insert(node root,int val){
    if(root==null){
        root=new node(val);
        return root;
    }

    if(root.data>val){
        root.left=insert(root.left, val);
    }
    else{
        root.right=insert(root.right,val);
    }
    return root;
   }

   public static void inorder(node root){
    if(root==null){
        return ;
    }
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
   }
   public static boolean search(node root,int key){
    if(root==null){
        return false;
    }
    if(root.data==key){
        return true;
    }
    if(root.data>key){
        return search(root.left, key);
    }
    else{
        return search(root.right,key);
    }
   }
   public static node delete(node root,int val){
    if(root.data>val){
        root.left=delete(root.left, val);
    }
    else if(root.data<val){
        root.right=delete(root.right,val);
    }
    else{
        //val pe pahuch gay hai ab delete karna hai
        //case 1 leaf node
        if(root.left==null&&root.right==null){
            return null;
        }

        //case2 one or single child
        if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }

        //case 3 both children
        node is=findinordersuccesor(root.right);
        root.data=is.data;
        root.right=delete(root.right,is.data);
    }
    return root;
   }
   public static node findinordersuccesor(node root){
    while(root.left!=null){
        root=root.left;
    }
    return root;
   }
   public static void printinrange(node root,int k1,int k2){
    if(root==null){
        return ;
    }
    if(root.data>=k1 && root.data<=k2){
        printinrange(root.left, k1, k2);
        System.out.println(root.data);
        printinrange(root.right, k1, k2);

    }
    else if(root.data<k1){
        printinrange(root.left, k1, k2);
    }
    else{
        printinrange(root.right, k1, k2);
    }
   }
   public static void printnode2leaf(node root,ArrayList<Integer>path){
    if(root==null){
        return ;
    }
    path.add(root.data);
    if(root.left==null&&root.right==null){
        printpath(path);
    }
    printnode2leaf(root.left,path);
    printnode2leaf(root.right, path);
    path.remove(path.size()-1);

   }
   public static void printpath(ArrayList<Integer>path){
    for(int i=0;i<path.size();i++){
        System.out.print(path.get(i)+"->");
    }System.out.println("null");
   }

   public static boolean isvalidbst(node root,node min,node max){
    if(root==null){
        return true;
    }
    if(min!=null&&root.data<=min.data){
        return false;
    }
    else if(max!=null &&root.data>=max.data){
        return false;
    }

    return isvalidbst(root.left,min,root)&&isvalidbst(root.right,root,max);
   }
   public static void main(String[] args) {
    int val[]={8,5,3,1,4,6,10,11,14};
    node root=null;

for(int i=0;i<val.length;i++){
    root=insert(root, val[i]);
}
   
    inorder(root);
    System.out.println();

  //  printinrange(root, 5, 12);

   // if(search(root, 88)){
   //     System.out.println("found");
  ///  }
  //  else{
      //  System.out.println("not found");
   // }

 //  printnode2leaf(root, new ArrayList<>());
if(isvalidbst(root, null, null)){
    System.out.println("valid bst");
}
else{
    System.out.println("not valid bst");
}

   }
}
