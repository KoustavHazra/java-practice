package encapsulation.oops3.learnPackage;

public class Teacher {
    public int teachingClass;
    private int id;
    String teacherAge;  // default or package private
    protected int totalStudents;

    public static void main(String[] args) {
        Teacher obj = new Teacher();
        obj.id = 123; // private, so accessible within the class
    }
}
