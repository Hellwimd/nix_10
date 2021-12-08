package ua.com.alevel.classes;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueNamePicker {
    private static final String ALLOWED_SPLITTERS = "\\s+|,|;";
    private static String fileContent;
    private static UniqueNamePicker uniqueNamePicker;

    private UniqueNamePicker(String fileContent) {
        UniqueNamePicker.fileContent = fileContent;
    }

    public static UniqueNamePicker getInstance(String fileContent) {
        if (uniqueNamePicker == null)
            uniqueNamePicker = new UniqueNamePicker(fileContent);
        return uniqueNamePicker;
    }

    public String getName(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String name : fileContent.split(ALLOWED_SPLITTERS)) {
            if(name.trim().length() == 0 ) continue;
            map.compute(name, (key, value) -> (value != null) ? value + 1 : 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return "Unique names does not provided";
    }
}
