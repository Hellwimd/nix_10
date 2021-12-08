package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.MyArrayList;


public class Course {

    private String id;
    private String courseTitle;
    private int credit;
    private MyArrayList<Student> studentList;
}
