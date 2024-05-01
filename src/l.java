import java.util.*;

public class l {
    public static void ss(int mat[][],int key){
        int col=0;int row=mat.length-1;

        while(col<mat[0].length&&row>=0){
            if(mat[row][col]==key){
                System.out.println(row+"'"+"col");
            }
            else if(key<mat[row][col]){
                row--;
            }
            else{
                col++;
            }
        }
    }
   public static void main(String[] args) {
    int n=3;
    Scanner sc=new Scanner(System.in);
    int mat[][]=new int[n][n];
for(int i=0;i<mat.length;i++){
    for(int j=0;j<mat[0].length;j++){
        System.out.print("enter elements for"+i+","+j);
        mat[i][j]=sc.nextInt();
    }
}
int k=5;
ss(mat, k);
   }
}
