package tests.inheritTestNg;

public class Digit {

  public static void main(String[] args) {
    String str = "5 of 6 is my Date of birth bla bla 098652435178";
    long sum = 0;
    String[] chr = str.split("\\s");


    for (int i = 0; i < chr.length; i++) {
      try {
        long p = Long.parseLong(chr[i]);
        System.out.println("I am number " + chr[i]);
        sum = sum + p;

      } catch (NumberFormatException n) {
        System.out.println("I am string " + chr[i]);
      }
    }
    System.out.println(sum);

  }

}
