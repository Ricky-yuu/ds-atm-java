import java.util.Scanner;

public class LabOne {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number: ");
    String number = input.nextLine();
    if (number.matches("-?\\d+")) {
      int num = Integer.parseInt(number);
      if (num > 0) {
        System.out.println("Positive");
      } else if (num < 0) {
        System.out.println("Negative");
      } else {
        System.out.println("Zero");
      }
      if (num % 2 == 0) {
        System.out.println("Even");
      } else {
        System.out.println("Odd");
      }
    } else {
      System.out.println("Invalid input. Please do not enter a alphabetic character or empty input.");
    }

    input.close();
  }
}
