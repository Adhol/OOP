import java.util.Scanner;

public class Grades {

    public static final int NUMBER_OF_GRADES = 5;

    public static int[] fillArrayOfGrades() {

        Scanner in = new Scanner(System.in);

        int[] grades = new int[NUMBER_OF_GRADES];
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Enter " + (i + 1) + " grade from 1 to 5\n");

            grades[i] = in.nextInt();

            if (grades[i] > 5 | grades[i] < 1) {
                System.out.println("Wrong grade, try again");
                --i;
            }
        }
        return grades;
    }
}
