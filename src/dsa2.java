import java.util.*;
public class dsa2{
   static class node{
      int val;
      node left;
      node right;

      public node(int data){
         this.val=data;
         this.left=null;
       this.right=null;
      }
   }
   public static void sumbst(node root1,node root2,int x){

      ArrayList<Integer>arr1=new ArrayList<>();
      getinorder(root1,arr1);

      ArrayList<Integer>arr2=new ArrayList<>();
      getinorder(root2,arr2);

      for(int i=0;i<arr1.size();i++){
         for(int j=0;j<arr2.size();j++){
            if(arr1.get(i)+arr2.get(j)==x){
            System.out.println(arr1.get(i))
            ;System.out.println(arr2.get(j));
            }
         }
      }

   }
   public static void getinorder(node root,ArrayList<Integer>arr){
      if(root==null){
         return ;
      }
      getinorder(root.left, arr);
      arr.add(root.val);
      getinorder(root.right, arr);
   }
   public static void main(String[] args) {
      node root1=new node(2);
      root1.left=new node(1);
      root1.right=new node(4);

      node root2=new node(9);
      root2.left=new node(3);
      root2.right=new node(12);

      sumbst(root1, root2, 11);
   }
}