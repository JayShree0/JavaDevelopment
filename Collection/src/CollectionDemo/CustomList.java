package CollectionDemo;

import java.util.ArrayList;
import java.util.List;

public class CustomList {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Shruti", "Bmrit");
        Student s2 = new Student(2, "Jay Shree", "DSA");
        Student s3 = new Student(3, "Muskan", "DevOps");

        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        System.out.println(studentList);
    }
}
