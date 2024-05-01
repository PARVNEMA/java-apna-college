public class sudoko{
	// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
 
    public static boolean issafe(int sud[][],int row,int col,int digit){
for(int i=0;i<=8;i++){
   if( sud[i][col]==digit){
    return false;
   }
}
for(int j=0;j<=8;j++){
    if(sud[row][j]==digit){
return false;
    }
}
int sr=(row/3)*3;

int sc=(col/3)*3;
for(int i=sr;i<sr+3;i++){
    for(int j=sc;j<sc+3;j++){
        if(sud[i][j]==digit){
            return false;
        }
    }
}
return true;
    }
    public static boolean sudokosolver(int sud[][],int row,int col){
        if(row==9&&col==0){
            return true;
        }

        int nextrow=row;int nextcol=col+1;
        if(col+1==9){
            nextrow=row+1;
            nextcol=0;
        }
        if(sud[row][col]!=0){
            sudokosolver(sud, nextrow, nextcol);
        }
        for(int digit=1;digit<=9;digit++){
            if(issafe(sud,row,col,digit)){
         sud[row][col]=digit;
         if(sudokosolver(sud, nextrow, nextcol)){
            return true;
         }
         sud[row][col]=0;
   }
        }
        return false;
  }
  public static void printsudoko(int grid[][]){
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            System.out.println(grid[i][j]+" ");
        }System.out.println();
    }
  }
  public static void main(String[] args) {
    int grid[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
    { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
    { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
    { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
    { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
    { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
    { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
    { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
    { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };


   if(sudokosolver(grid,0,0)){
        printsudoko(grid);
    }
    else{
        System.out.println("soln doesnt exist");
    }
  }
}

    

}