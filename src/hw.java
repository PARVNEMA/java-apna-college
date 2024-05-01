public class hw{
    public static void print(int mat[][]){
        int n=mat.length;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
  System.out.println("elements of"+i+","+j+" ="+mat[i][j]);
            }
        }System.out.println();
    }
    
    public static void main(String args[]){
     //   int n=3;
       // int mat[][]=new int[2][3];
   int  mat[][]= { {2,3,7}, {5,6,7} };


int transpose[][]=new int[3][2];
            for(int i=0;i<2;i++){
                for(int j=0;j<3;j++){
                    
                        transpose[i][j]=mat[j][i];
                    
                    
                }
            }
            print(mat);
            print(transpose);
    }
}