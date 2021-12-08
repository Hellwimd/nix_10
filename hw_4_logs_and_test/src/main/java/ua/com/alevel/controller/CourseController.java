//package ua.com.alevel.controller;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class CourseController {
//
//    private static final CourseService courseservice = new CourseServiceImpl();
//
//    public void run() {
//        BufferedReader bfread = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Select your function");
//        String position;
//        try{
//            runNavigation();
//            while ((position = bfread.readLine()) !=null)){
//                crud (position, bfread);
//                position = bfread.readLine();
//                if (position.equals(0)){
//                    return;
//                }
//                crud (position, bfread);
//            }
//        } catch (IOException e) {
//            System.out.println("problem =" + e.getMessage());
//        }
//    }
//
//    private void runNavigation(){
//        System.out.println();
//        System.out.println("If you want to create course, please enter 1");
//        System.out.println("If you want to findById course, please enter 2");
//        System.out.println("If you want to update course, please enter 3");
//        System.out.println("If you want to delete course, please enter 4");
//        System.out.println("If you want to delete studentInList, please enter 5");
//        System.out.println("If you want to findAll course, please enter 6");
//        System.out.println("If you want to deleteAll course, please enter 7");
//        System.out.println("If you want to exit, please enter 0");
//        System.out.println();
//    }
//
//    private void crud (String position, BufferedReader bfread){
//        switch (position) {
//            case "1":
//                createCourse();
//                break;
//            case "2":
//                findCourseByID();
//                break;
//            case "3":
//                updateCourse();
//                break;
//            case "4":
//                deleteCourse();
//                break;
//            case "5":
//                deleteStudentImList();
//                break;
//            case "6":
//                findAllCourses();
//                break;
//            case "7":
//                deleteAllCourses();
//                break;
//        }
//        runNavigation();
//        }
//
//        private void createCourse(BufferedReader bfread){
//            System.out.println("Please, enter name of your course");
//            String courseName = bfread.readLine();
//
//            System.out.println("");
//            Course course = new Course();
//            course.setNameCourse(courseName);
//}
//}