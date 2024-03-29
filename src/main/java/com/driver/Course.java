package com.driver;
import java.util.LinkedList;
import java.util.Queue;

public class Course {
    private String courseCode;
    private int availableSeats;
    private Queue<Student> waitingList;

    public Course(String courseCode, int maxSeats) {
        this.courseCode = courseCode;
        this.availableSeats = maxSeats;
        this.waitingList = new LinkedList<>();
    }

    public String getCourseCode() {
    	//your code goes here
        return courseCode;
    }

    public synchronized boolean registerStudent(Student student) {
    	//your code goes here
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        } else {
            waitingList.offer(student);
            return false;
        }
    }

    public synchronized void processWaitingList() {
    	//your code goes here
        while (!waitingList.isEmpty() && availableSeats > 0) {
            Student student = waitingList.poll();
            if (student != null) {
                availableSeats--;
                student.notifyRegistered(this);
            }
        }
    }

    public synchronized int getAvailableSeats() {
    	//your code goes here
        return availableSeats;
    }
}
