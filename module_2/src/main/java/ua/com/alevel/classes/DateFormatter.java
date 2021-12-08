package ua.com.alevel.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatter {
    private static final String YYYY_MM_DD = "\\d{4}/\\d{2}/\\d{2}";
    private static final String DD_MM_YYYY = "\\d{2}/\\d{2}/\\d{4}";
    private static final String MM_DD_YYYY = "\\d{2}-\\d{2}-\\d{4}";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static String fileContent;
    private static DateFormatter dateFormatter;

    private DateFormatter(String fileContent) {
        DateFormatter.fileContent = fileContent;
    }

    public static DateFormatter getInstance(String fileContent) {
        if (dateFormatter == null)
            dateFormatter = new DateFormatter(fileContent);
        return dateFormatter;
    }

    public List<String> getDates() {
        List<String> result = new ArrayList<>();
        for (String date : parseDates()){
            String reformattedDate = match(date);
            if (reformattedDate != null){
                result.add(reformattedDate);
            }
        }
        return result;
    }

    private String match(String date){
        if (Pattern.matches(YYYY_MM_DD, date)) {
            System.out.println("YYYY_MM_DD - " + date);
            return new SimpleDateFormat(DATE_PATTERN).format(new Date(date)).replace("-", "");
        } else if (Pattern.matches(DD_MM_YYYY, date)) {
            System.out.println("DD_MM_YYYY - " + date);
            return convertToAppliedFormat("dd/MM/yyyy", date).replace("-", "");
        } else if (Pattern.matches(MM_DD_YYYY, date)) {
            System.out.println("MM_DD_YYYY - " + date);
            return convertToAppliedFormat("MM-dd-yyyy", date).replace("-", "");
        }

        return null;
    }

    private List<String> parseDates(){
        List<String> dates = new ArrayList<>();
        List<Pattern> patterns = Arrays.asList(
                Pattern.compile(YYYY_MM_DD),
                Pattern.compile(DD_MM_YYYY),
                Pattern.compile(MM_DD_YYYY)
        );

        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(fileContent);
            while (matcher.find()) {
                String foundedDate = fileContent.substring(matcher.start(), matcher.end());
                if (!dates.contains(foundedDate)) {
                    dates.add(foundedDate);
                }
            }
        }
        System.out.println("dates = " + dates);
        return dates;
    }

    private String convertToAppliedFormat(String format, String date) {
        String formattedDate = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            Date parsedDate = simpleDateFormat.parse(date);
            simpleDateFormat.applyPattern(DATE_PATTERN);
            formattedDate = simpleDateFormat.format(parsedDate);
        } catch (ParseException exception) {
            System.out.println(exception.getMessage());
        }
        return formattedDate;
    }
}
