import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

class Exam {
    private final String examName;
    private final Integer mark;
    private final String formattedDate;

    Exam (String n, LocalDate d, Integer m){
        examName = n;
        mark = m;
        formattedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(d);
    }

    public String printExam(){
        return "Exam: " + examName + " - Sustained on " + formattedDate + " with a mark of: " + mark;
    }

    public Integer getMark(){
        return mark;
    }
}

class Residence {
    private final String cityName;
    private final String streetName;
    private final String provinceName;
    private final Integer capValue;

    Residence (String street, Integer cap, String city, String province){
        cityName = city;
        streetName = street;
        provinceName = province;
        capValue = cap;
    }

    public String printResidence(){
        return "Residence: " + streetName + " - " + capValue + " " + cityName + " (" + provinceName + ")";
    }
}

class PersonalData{
    private final String name;
    private final String surname;
    private final Integer yearOfBirth;
    private final Residence residence;
    private final ArrayList<Exam> exams;
    private final Integer idNumber;

    PersonalData (String n, String s, Integer yob, Residence r, Integer i, ArrayList<Exam> e){
        name = n;
        surname = s;
        yearOfBirth = yob;
        residence = r;
        exams = e;
        idNumber = i;
    }

    public String printPersonalData(){
        StringBuilder data = new StringBuilder("Name: " + name + "\n");
        data.append("Surname: ").append(surname).append("\n");
        data.append("ID: ").append(idNumber).append("\n");
        data.append("Year of birth: ").append(yearOfBirth).append("\n");
        data.append(residence.printResidence()).append("\n");
        for (Exam e : exams){
            data.append(e.printExam()).append("\n");
        }
        return data.toString();
    }

    public ArrayList<Exam> getExams(){
        return exams;
    }
}