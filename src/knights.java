public class knights {
    public static void nknights(char board[][],int rows){
        if(rows==board.length){
            printboard(board);
            return;
        }

        for(int j=0;j<board.length;j++){
          
          if(issafe(board,rows,j)){  board[rows][j]='k';

            nknights(board, rows+1);
            board[rows][j]='.'; }
        }
    }
    public static boolean issafe(char board[][],int row,int col){
//next row 

for(int i=row-1, j=col-1;i>=0&&j>=0;i--,j--){
    if(board[i-2][j-1]=='k'){
        return false;
    }
}

for(int i=row-1, j=col-1;i>=0&&j>=0;i--,j--){
    if(board[i-1][j-2]=='k'){
        return false;
    }
    }
    return true;
}
    public static void printboard(char board[][]){
        System.out.println("-------chess board-------");
for(int i=0;i<board.length;i++){
    for(int j=0;j<board.length;j++){
        System.out.print(board[i][j]+" ");
    }System.out.println();
}
    }
    public static void main(String[] args) {
        int n=3;
        char chessboard[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessboard[i][j]='.';
            }
        }
        nknights(chessboard, 0);
    }
}
