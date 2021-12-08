package ua.com.alevel;

import ua.com.alevel.classes.DateFormatter;
import ua.com.alevel.classes.UniqueNamePicker;
import ua.com.alevel.services.FileService;

import java.util.List;

public class Main {
    private static final String BASE_FILE_INPUT_PATH = "module_2/src/main/resources/data/input/";
    private static final String BASE_FILE_OUTPUT_PATH = "module_2/src/main/resources/data/output/";

    public static void main(String[] args) {
//        ---Task 1
//        String format = "2020/04/05";
//        String format = "05/04/2020";
//        String format = "04-05-2020";

        String date = FileService.readFile(BASE_FILE_INPUT_PATH + "DateInput.txt");
        System.out.println(date);
        FileService.writeFile(dates.soString(), BASE_FILE_OUTPUT_PATH,);
        List<String> dates = DateFormatter.getInstance(date).getDates();
        System.out.println(dates);

//        //Task2
//        String name = UniqueNamePicker.getInstance(FileService.readFile(BASE_FILE_INPUT_PATH + "NameInput.txt")).getName();
//        System.out.println(name);
//    }
}
