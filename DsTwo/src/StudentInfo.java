import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentInfo {
  public static void main(String[] args) {
    String filename = "studentList.txt";
    List studentInfo = null;
    FileInputStream fileStream = null;
    ObjectInputStream inputStream = null;
    try {
      fileStream = new FileInputStream(filename);
      inputStream = new ObjectInputStream(fileStream);
      studentInfo = (ArrayList) inputStream.readObject();
      inputStream.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    // print out the size
    System.out.println("Student Details Size: " + studentInfo.size());
    System.out.println();
    
    Student stout;
    for (int i = 0; i < studentInfo.size(); i++) {
      stout = (Student) studentInfo.get(i);
      System.out.println("Student Name: " + stout.getName());
      System.out.println("Student ID: " + stout.getStudentId());
      System.out.println("Student Course: " + stout.getCourse());
      System.out.println("Student Subjects: " + stout.getSubjects()[0] + " | Student second subject is: " + stout.getSubjects()[1] + " | Student third subject is: " + stout.getSubjects()[2]);
      System.out.println("-------------------------------------------------------------------");
    }
  }
}
