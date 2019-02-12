public class Driver{
  public static void main(String[] args){
    QueenBoard b = new QueenBoard(9);
    /*b.addQueen(0,0);
    System.out.println(b.toString());
    b.addQueen(1,2);
    System.out.println(b.toString());
    b.removeQueen(0,0);
    System.out.println(b.toString());
    b.removeQueen(1,2);
    System.out.println(b.toString());
    b.addQueen(2,7);*/
    System.out.println(b.toString());
    b.solve();
    System.out.println(b.toString());
    b.clear();
    System.out.println(b.countSolutions());
    System.out.println(b.toString());



  }




}
