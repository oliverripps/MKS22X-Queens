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

  private boolean addQueen(int r, int c){
    if(board[r][c]==0){
      board[r][c]=-1;
      for(int i=0;i<size;i++){
        if(x+1+i<size){
          board[x+1+i][y]+=1;
        }
      for(int i=c+1;i<size;i++){
        board[r][i]+=1;
        if(cross<size-1){
          cross+=1;
          board[cross][i]+=1;
        }
        }
      /*for(int i = 0; r - i >= 0 && c + i <size; i++){ //
        board[r-i][c+i] += 1;
      }*/
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
      /*for(int i = 0; r - i >= 0 && c + i <size; i++){ //
        board[r-i][c+i] -= 1;
      }*/
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
    if(!check()){
      throw new IllegalStateException();
    }
    return(solveR(0));
  }

  public int countSolutions(){
    if(!check()){
      throw new IllegalStateException();
    }
    return (countSolutionsH(0));

  }

  private boolean check(){
    for(int i=0;i<size;i++){
      for(int l=0;l<size;l++){
        if(board[i][l]!=0){
          return false;
        }
      }
    }
    return true;
  }
  public int countSolutionsH(int col){
    int c=0;
    if(col>=size){
      return 1;
    }
    for(int i=0;i<size;i++){
      if(addQueen(i,col)){
        c+=countSolutionsH(col+1);
        removeQueen(i,col);
      }
    }
    clear();
    return c;
    }



  public void clear(){
    int[][] b = new int[size][size];
    board=b;
  }
}
