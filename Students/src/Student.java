import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {

    private String name;
    private String group;
    private int[] academicPerformance;
    private double averageGrade;
    private boolean isBestStudent;

    public Student(String name, String group, int[] academicPerformance) {
        this.name = name;
        this.group = group;
        this.academicPerformance = academicPerformance;
        this.averageGrade = calculateAverageGrade(academicPerformance);
        this.isBestStudent = isBest(academicPerformance);
    }

    private double calculateAverageGrade(int[] academicPerformance) {
        double sum = 0;

        if(academicPerformance.length == 0) {
            return 0;
        } else {
            for(double grade : academicPerformance) {
                sum += grade;
            }
        }

        if (sum == 0) {
            return 0;
        } else {
            return sum / academicPerformance.length;
        }
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

    public String getGroup() {
        return group;
    }

    public int[] getAcademicPerformance() {
        return academicPerformance;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public boolean getBestStudent() {
        return isBestStudent;
    }

    @Override
    public String toString() {
        return "Student:" + "\t" +
                "name: " + name.toUpperCase() +
                ", group: '" + group + '\'' +
                ", academicPerformance " + Arrays.toString(academicPerformance) +
                ", averageGrade: " + averageGrade;
    }


}
