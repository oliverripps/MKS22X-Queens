public class QueenBoard{
  private int[][] board;
  private int size;
  public QueenBoard(int s){ 
    int[][] b = new int[s][s];
    board=b;//intitializing instance variables
    size=s;
  }

  private boolean addQueen(int r, int c){
    if(board[r][c]==0){//if it is currently not in a queens path
      board[r][c]=-1;//set it as a queen
	    for(int i=1;c+i<size;i++){//for the rest of the columns
        board[r][c+i]+=1;//add that it is in the path horizontally
        if(r+i<size){//while it is not too low on the board
          board[r+i][c+i]+=1;//add the diagonal down
        }
  		  if (r-i>=0){//while not too high
          board[r-i][c+i]+=1;//add diagonal up
  		}
    }
      return true;
	  }
    return false;
  }


  private boolean removeQueen(int r, int c){//same as add queen but -1 opposed to +1
    if (board[r][c]==-1){//if currently a queen
      board[r][c]=0;//make not a queen
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
      for(int l=0;l<board[0].length;l++){//for each piece
        if(board[i][l]==-1){//if queen
          str+="Q";
        }
        if(board[i][l]!=-1){//if not queen
          str+="_";
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

  private boolean solveR(int col){//following seudocode
    if(col>=size){//if gone through every column
          return true;
        }
    else{
      for(int i=0;i<size;i++){//for every row
        if(addQueen(i,col)){// if can add queen
          if(solveR(col+1)){//if can add at next row
            return true;
        }
          removeQueen(i,col);//if not, remove the last one
      }
    }
      return false;
  }
}

  public boolean solve(){
    if(!check()){//if board is clear
      throw new IllegalStateException();
    }
    return(solveR(0));//call helper
  }

  public int countSolutions(){
    if(!check()){//if board is clear
      throw new IllegalStateException();
    }
    int c=countSolutionsH(0);//call helper to get amount of solutions
    clear();//clear the board
    return c;//return amount of solutions

  }

  private boolean check(){
    for(int i=0;i<size;i++){
      for(int l=0;l<size;l++){//check each piece
        if(board[i][l]!=0){//if not empty, false
          return false;
        }
      }
    }
    return true;
  }
  public int countSolutionsH(int col){//following seudocode
    int c=0;//create counter
    if(col>=size){//if at end, return 1
      return 1;
    }
    for(int i=0;i<size;i++){//for each row
      if(addQueen(i,col)){//if you can add a queen
        c+=countSolutionsH(col+1);//if solution, add to counter
        removeQueen(i,col);//backtrack to find next solution
      }
    }
    return c;//return amount of solutions counted by counter
    }



  public void clear(){//clear board by instantiating new board
    int[][] b = new int[size][size];
    board=b;
  }
}
