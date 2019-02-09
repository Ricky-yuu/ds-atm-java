import java.util.Scanner;

public class LabTwo {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int[] values = new int[6];
    int sum = 0;
    for (int i = 0; i < values.length; i++) {
      try{
        System.out.print("Enter a number: ");
        values[i] = input.nextInt();
        sum += values[i];
      } catch (Exception e) {
        System.out.println("Invalid input. Please do not enter a alphabetic character or empty input.");
        System.exit(0);
      }
    }

    System.out.println("Sum: " + sum);
    
    for (int i = 0; i < values.length; i++) {
      for (int j = i + 1; j < values.length; j++) {
        if (values[i] > values[j]) {
          int temp = values[i];
          values[i] = values[j];
          values[j] = temp;
        }
      }
    }

    System.out.println("Ascending order: ");
    for (int i = 0; i < values.length; i++) {
      System.out.print(values[i] + " ");
    }

    input.close();
  }
}
