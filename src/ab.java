import java.util.*;
public class ab {
    public static void printspiral(int mat[][]){
        int sr=0;
        int sc=0;
        int er=mat.length-1;
        int ec=mat[0].length-1;

        while(sr<=er&&sc<=ec){
//top
for(int i=sc;i<=ec;i++){
    System.out.print(mat[sr][i]+" ");
}
//right
for(int i=sr+1;i<=er;i++){
    System.out.print(mat[i][ec]+" ");
}
//bottom
for(int i=ec-1;i>=sc;i--){
    
    System.out.print(mat[er][i]+" ");
    
}
if(sr==er){
    break;
}
//left
for(int i=er-1;i>=sr+1;i--){
    
    System.out.print(mat[i][sc]+ " ");
    
}
if(sc==ec){
    break;
}
sc++;sr++;er--;ec--;
        }
    }
    public static void main(String[] args) {
        int n=4;
        int mat[][]=new int[n][n];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.println("enter elements for"+i+","+j);
                mat[i][j]=sc.nextInt();
            }
        }
        printspiral(mat);
    }
}
