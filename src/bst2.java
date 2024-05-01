import java.util.*;
public class bst2 {
    static class node{
        int data;
          node left;
        node right;

       public  node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
         }
    }
    static class info{
        boolean isbst;
        int size;
        int max;
        int min;

        public info(boolean isbst,int size,int min,int max){
            this.isbst=isbst;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }

    public static int maxbst=0;
    public static info largestbst(node root){
        if(root == null){
            return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        info leftinfo=largestbst(root.left);
        info rightinfo=largestbst(root.right);
   int size=leftinfo.size+rightinfo.size+1;

   int min=Math.min(root.data,Math.min(leftinfo.min,rightinfo.min));
   int max=Math.max(root.data,Math.max(leftinfo.max,rightinfo.max));

   if(root.data<=leftinfo.max ||root.data>=rightinfo.min){
    return new info(false,size,min,max);
   }

   if(leftinfo.isbst&&rightinfo.isbst){
    maxbst=Math.max(maxbst,size);

    return new info(true, size, min, max);
   }
   return new info(false, size, min, max);
    }
    public static void preorder(node root){
        if(root==null){return;}

        System.out.print(root.data+" ");

        preorder(root.left);
        
        preorder(root.right);
    } 
    public static void getinorder(node root,ArrayList<Integer>inorder){
        if(root==null){
            return ;
        }
        getinorder(root.left, inorder);
        inorder.add(root.data);
        getinorder(root.right, inorder);
    }
  public static node createbst(ArrayList<Integer>inorder,int st,int ei){
            if(st>ei){
                return null;
            }
            int mid=(st+ei)/2;
            node root=new node(inorder.get(mid));
            root.left=createbst(inorder,st,mid-1);
            root.right=createbst(inorder,mid+1,ei);
            return root; 

        }
        public static node balancedbst(node root){
            ArrayList<Integer>inorder=new ArrayList<>();
            getinorder(root, inorder);

            root=createbst(inorder, 0, inorder.size()-1);
            return root;
        }
        public static node mergebst(node root1,node root2){
            ArrayList<Integer>arr1=new ArrayList<>();
            getinorder(root1, arr1);

            ArrayList<Integer>arr2=new ArrayList<>();
            getinorder(root2, arr2);
            

            ArrayList<Integer>finalarr=new ArrayList<>();
int i=0; int j=0;
            while(i<=arr1.size()&&j<=arr2.size()){
                if(arr1.get(i)<arr2.get(j)){
                    finalarr.add(arr1.get(i));
                    i++;
                }
                else{
                    finalarr.add(arr2.get(j));
                    j++;
                }
            }

            while(i<arr1.size()){
                finalarr.add(arr1.get(i));
                i++;
            }
            while(j<arr2.size()){
                finalarr.add(arr2.get(j));
                j++;
            }

         return    createbst(finalarr, 0, finalarr.size()-1);

        }


        public static void main(String[] args) {
           node root1=new node(2);
           root1.left=new node(1);
           root1.right=new node(4);

           node root2=new node(9);
           root2.left=new node(3);
           root2.right=new node(12);

           node root=mergebst(root1, root2);
           preorder(root);
        }

}
