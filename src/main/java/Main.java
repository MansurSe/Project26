import comparator.StudentComparator;
import comparator.UniversityComparator;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

import comparator.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import model.Student;
import model.University;
import util.ComparatorUtil;


public class Main {
    public static void main(String[] args) throws IOException {

        List<University> universities = ReadFromExcel.readFromFileUniversity("universityInfo.xls");

        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);


        List<Student> students = ReadFromExcel.readFromFileStudent("universityInfo.xls");
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);

    }
}