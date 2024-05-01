public class nqueens {
      public static boolean issafe(char board[][],int rows,int column){
        //vertically upwards
        for(int i=rows-1;i>=0;i--){
            if(board[i][column]=='Q'){
                return false;
            }
        }
        //left
        for(int i=rows-1, j=column-1;i>=0 &&j>=0;i--,j--){
            if(board[i][j]=='Q'){
        return false;
            }

        }
        //right
        for(int i=rows-1,j=column+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
      }



    public static boolean nqueen(char board[][],int rows){
        if(rows==board.length){
           // printboard(board);
           
            count++;
            return true;
        }
        
        for(int j=0;j<board.length;j++){

            if(issafe(board, rows, j)){
            board[rows][j]='Q';
 
            //neechay wali row me baithana possible hai ki nahi;
           if(  nqueen(board, rows+1)){
            return true;
           }
           //else
             board[rows][j]='x';}

        }
       // printboard(board);
        System.out.println(count);
        return false;
    }
    static int count=0;
    public static void printboard(char board[][]){
        System.out.println("---------chess board--------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int n=4;
        char board[][]=new char[n][n];
for(int i=0;i<board.length;i++){
    for(int j=0;j<board[0].length;j++){
       board[i][j]='x';
    }
}
        
       if( nqueen(board, 0)){
        System.out.println("soln is possible");
     printboard(board);
       }
       // System.out.println(count);
    }
}
