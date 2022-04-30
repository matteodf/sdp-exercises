package student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

class JSONExam {
    private final String examName;
    private final Integer mark;
    private final String formattedDate;

    public JSONExam(String n, LocalDate d, Integer m){
        examName = n;
        mark = m;
        formattedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(d);
    }
}

class JSONResidence {
    private final String cityName;
    private final String streetName;
    private final String provinceName;
    private final Integer capValue;

    public JSONResidence(String street, Integer cap, String city, String province){
        cityName = city;
        streetName = street;
        provinceName = province;
        capValue = cap;
    }
}

public class JSONStudent{
    private final String name;
    private final String surname;
    private final Integer yearOfBirth;
    private final JSONResidence residence;
    private final ArrayList<JSONExam> exams;
    private final Integer idNumber;

    public JSONStudent(String n, String s, Integer yob, JSONResidence r, Integer i, ArrayList<JSONExam> e){
        name = n;
        surname = s;
        yearOfBirth = yob;
        residence = r;
        exams = e;
        idNumber = i;
    }
}