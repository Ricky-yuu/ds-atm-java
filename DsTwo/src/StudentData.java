import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentData {
  public static void main(String[] args) {
    String filename = "studentList.txt";
    Student st1 = new Student("A", "TP0001", "Networking", new String[]{"APU2", "APU3", "APU3"});
    Student st2 = new Student("B", "TP0002", "Networking", new String[]{"APU2", "APU3", "APU3"});
    ArrayList<Object> list = new ArrayList<Object>();
    list.add(st1);
    list.add(st2);

    FileOutputStream fileStream = null;
    ObjectOutputStream outputStream = null;
    try {
      fileStream = new FileOutputStream(filename);
      outputStream = new ObjectOutputStream(fileStream);
      outputStream.writeObject(list);
      outputStream.close();
      System.out.println("Object is saved");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
