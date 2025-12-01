package org.example;

public class Student {

//    “Declare a private reference variable named course that can hold the address of a Course object.”
    // “Create a private variable named course that can hold a Course object (but does not create the object yet).”
    private Course course; // course type ka object

    // for constructor dependency injection
    public Student() {

    }
    public Student(Course course) {
        this.course = course;
        System.out.println("Constructor depenedency injection");
    }

    // for setter dependency injection
    public void setCourse(Course course) {
        this.course = course;
        System.out.println("Setter dependecy injection ");
    }

    // course was null, so null.enroll() caused error.
    public void study() {
        int start = course.enroll();
        System.out.println(start);
        if(start >= 1){
            System.out.println("Journey started....");
        } else{
            System.out.println("Payment Failed...");
        }
    }
}
