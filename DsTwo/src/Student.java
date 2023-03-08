import java.io.Serializable;

public class Student implements Serializable {
  private String name;
  private String studentId;
  private String course;
  private String[] subjects;

  public Student(String name, String studentId, String course, String[] subjects) {
    this.name = name;
    this.studentId = studentId;
    this.course = course;
    this.subjects = subjects;
  }

  public String getName() {
    return name;
  }

  public String getStudentId() {
    return studentId;
  }

  public String getCourse() {
    return course;
  }

  public String[] getSubjects() {
    return subjects;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public void setSubjects(String[] subjects) {
    this.subjects = subjects;
  }

  @Override
  public String toString() {
    return "Student [course=" + course + ", name=" + name + ", studentId=" + studentId + ", subjects="
        + subjects + "]";
  }
}