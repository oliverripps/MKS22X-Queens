public class Driver{
  public static void main(String[] args){
    QueenBoard b = new QueenBoard(8);
    b.addQueen(0,0);
    System.out.println(b.toString());
    b.addQueen(1,2);
    System.out.println(b.toString());
    b.removeQueen(0,0);
    System.out.println(b.toString());
    b.removeQueen(1,2);
    System.out.println(b.toString());
    b.solve();



  }




}
