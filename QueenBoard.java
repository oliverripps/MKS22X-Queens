public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    int[][] b = new int[size][size];
    board=b;
    for(int i=0;i<board.length;i++){
      for(int l=0;l<board[r].length;l++){
        board[i][l]==0;
      }
    }
  }
  private boolean addQueen(int r, int c)}{
    if(board[r][c]==0){
      board[r,c]=-1;
      for(int i=1;i<board.length;i++){
        board[r+i][c]+=1;
      }
      for(int i=1;i<board[r].length;i++){
        board[r][c+i]+=1;
      }
      for(int i=1;i<board[r].length;i++){
        board[r+i][c+i]+=1;
      }
    return true;
  }
    else{
      return false;
    }
  private boolean removeQueen(int r, int c){
    return true;
  }
  public String toString(){
    String str="";
    for(int i=0;i<board.length;i++){
      for(int l=0;l<board[r].length;l++){
        board[i][l]==0;
      }
    }
  }
  public boolean solve(){}
  public int countSolutions(){}









}
