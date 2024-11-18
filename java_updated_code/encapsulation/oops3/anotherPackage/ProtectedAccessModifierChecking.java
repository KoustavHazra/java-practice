package encapsulation.oops3.anotherPackage;

import encapsulation.oops3.learnPackage.Teacher;

public class ProtectedAccessModifierChecking extends Teacher {
    public static void main(String[] args) {
        ProtectedAccessModifierChecking obj = new ProtectedAccessModifierChecking();
        obj.totalStudents = 20; // protected prop is accessible here
    }

}
