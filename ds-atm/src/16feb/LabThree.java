import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LabThree {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String name = input.nextLine();
    System.out.print("Enter your age: ");
    String age = input.nextLine();
    System.out.print("Enter your gernder: ");
    String gender = input.nextLine();
    System.out.print("Enter your occupation: ");
    String occupation = input.nextLine();
    System.out.print("Enter your address: ");
    String address = input.nextLine();

    try {
      FileWriter file = new FileWriter("user.txt");
      file.write("Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nOccupation: " + occupation + "\nAddress: " + address);
      file.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    input.close();
  }
}
