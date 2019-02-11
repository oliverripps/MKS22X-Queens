public class QueenBoard{
  private int[][] board;
  private int size;
  public QueenBoard(int s){
    int[][] b = new int[s][s];
    board=b;
    size=s;
    for(int i=0;i<s;i++){
      for(int l=0;l<s;l++){
        board[i][l]=0;
      }
    }
  }

  private boolean addQueen(int r, int c){//make private
    if(r>size-1 || c>size-1){
      return false;
    }
    if(board[r][c]==0){
      board[r][c]=-1;
      int cross = r;
      for(int i=1;i<size-r;i++){
        board[r+i][c]+=1;
      }
      for(int i=c+1;i<size;i++){
        board[r][i]+=1;
        if(cross<size-1){
          cross+=1;
          board[cross][i]+=1;
        }
        }
    return true;
  }
    else{
      return false;
    }
  }

  private boolean removeQueen(int r, int c){
    if(r>size-1 || c>size-1){
      return false;
    }
    if(board[r][c]==-1){
      board[r][c]=0;
      int cross = r;
      for(int i=1;i<size-r;i++){
        board[r+i][c]-=1;
      }
      for(int i=c+1;i<size;i++){
        board[r][i]-=1;
        if(cross<size-1){
          cross+=1;
          board[cross][i]-=1;
        }
      }
    return true;
  }
    else{
      return false;
    }
  }


  public String toString(){
    String str="";
    for(int i=0;i<board.length;i++){
      for(int l=0;l<board[0].length;l++){
        if(board[i][l]==-1){
          str+="Q";
        }
        if(board[i][l]!=-1){
          str+=board[i][l];
        }
        if(l<board[0].length-1){
          str+=" ";
        }
        if(l>=board[0].length-1){
          str+="\n";
        }

      }
    }
    return str;
  }

  private boolean solveR(int col){
    if(col>=size){
          return true;
        }
    else{
      for(int i=0;i<size;i++){
        if(addQueen(i,col)){
          if(solveR(col+1)){
            return true;
        }
          removeQueen(i,col);
      }
    }
      return false;
  }
}

  public boolean solve(){
    return(solveR(0));
  }
  /*public int countSolutions(){

  }*/
  private void clear(){
    int[][] b = new int[size][size];
    board=b;
  }
}
