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
	    for(int i=1;c+i<size;i++){
        board[r][c+i]+=1;
        if(r+i<size){
          board[r+i][c+i]+=1;
        }
  		  if (r-i>=0){
          board[r-i][c+i]+=1;
  		}
    }
      return true;
	  }
    return false;
  }


  private boolean removeQueen(int r, int c){
    if (board[r][c]==-1){
      board[r][c]=0;
	    for(int i=1;c+i<size;i++){
        board[r][c+i]-=1;
        if(r+i<size){
          board[r+i][c+i]-=1;
        }
  		  if (r-i>=0){
          board[r-i][c+i]-=1;
  		}
    }
      return true;
	  }
    return false;
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
    int c=countSolutionsH(0);
    clear();
    return c;

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
    return c;
    }



  public void clear(){
    int[][] b = new int[size][size];
    board=b;
  }
}
