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

  public boolean addQueen(int r, int c){//make private
    if(board[r][c]==0){
      board[r][c]=-1;
      for(int i=1;i<board.length-r;i++){
        board[r+i][c]+=1;
      }
      for(int i=1;i<board[r].length-c;i++){
        board[r][c+i]+=1;
      }
      for(int i=1;i<board[r].length-c;i++){
        board[r+i][c+i]+=1;
      }
    return true;
  }
    else{
      return false;
    }
  }

  public boolean removeQueen(int r, int c){
    if(board[r][c]==-1){
      board[r][c]=0;
      for(int i=1;i<board.length-r;i++){
        board[r+i][c]-=1;
      }
      for(int i=1;i<board[r].length-c;i++){
        board[r][c+i]-=1;
      }
      for(int i=1;i<board[r].length-c;i++){
        board[r+i][c+i]-=1;
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


  /*public boolean solve(int r, int c, int current, int goal){
    if(goal==current){
      return true;
    }
    if(addQueen(r,c)({
      add
      if(addQueen(r,c+1)){
        if(addQueen(r,c))
      }
    }*/
  private boolean solveR(int col){
    if(col>=size){
          return true;
        }
    System.out.println(toString());
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

  public boolean solve(){
    return(solveR(0));
  }
  /*public int countSolutions(){

  }*/
}
