package com.driver;

public class Student implements Runnable {
    private String name;
    private Course[] courses;

    public Student(String name, Course... courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
    	//your code goes here
        return name;
    }

    @Override
    public void run() {
    	//your code goes here
        for (Course course : courses) {
            if (course.registerStudent(this)) {
                System.out.println(name + " registered for " + course.getCourseCode());
            } else {
                System.out.println(name + " placed on waiting list for " + course.getCourseCode());
            }
        }
    }
    public synchronized void notifyRegistered(Course course) {
        System.out.println(name + " registered from waiting list for " + course.getCourseCode());
    }
}
