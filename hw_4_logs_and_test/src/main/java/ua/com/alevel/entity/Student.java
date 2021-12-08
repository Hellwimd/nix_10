package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.MyArrayList;

public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private MyArrayList<Course> courseList;

    public String getFirstName() {
    }
}
