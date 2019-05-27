import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {

    private String name;
    private String group;
    private int[] academicPerformance;

    public Student(String name, String group, int[] academicPerformance) {
        this.name = name;
        this.group = group;
        this.academicPerformance = academicPerformance;
    }

    private double calculateAverageGrade(int[] academicPerformance) {
        double sum = 0;
        for (double grade : academicPerformance) {
            sum += grade;
        }
        return sum / academicPerformance.length;
    }

    private boolean isBest(int[] academicPerformance) {
        for (int grade : academicPerformance) {
            if (grade < 4) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return calculateAverageGrade(academicPerformance);
    }

    public boolean getBestStudent() {
        return isBest(academicPerformance);
    }

    @Override
    public String toString() {
        return "Student - " +
                "name: " + name.toUpperCase() +
                ", group: '" + group + '\'' +
                ", academicPerformance " + Arrays.toString(academicPerformance) +
                ", averageGrade: " + calculateAverageGrade(academicPerformance);
    }


}
