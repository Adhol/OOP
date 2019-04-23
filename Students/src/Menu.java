import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.exit;

public class Menu {

    static Scanner in = new Scanner(System.in);

    private List<Student> listOfStudents = new ArrayList<>();


    public void showMenu() {
        setItem();
        System.out.println("Please select menu item:");
        while (true) {
            try {
                int item = in.nextInt();
                switch (item) {
                    case 1:
                        System.out.println("You selected: " + item);
                        showListOfStudents();
                        setItem();
                        break;
                    case 2:
                        System.out.println("You selected: " + item);
                        showListOfBestStudents();
                        setItem();
                        break;
                    case 3:
                        System.out.println("You selected: " + item);
                        addStudent();
                        setItem();
                        break;
                    case 4:
                        System.out.println("You selected: " + item);
                        removeStudent();
                        setItem();
                        break;
                    case 5:
                        System.out.println("You selected: " + item);
                        saveStudentsToFile();
                        exit(0);
                        break;
                    default:
                        System.out.println("You selected wrong item, try again");
                        setItem();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Not correct item, try again");
                setItem();
            }
        }
    }

    public void setItem() {
        System.out.println("\tMain Menu\n1 - Show All Students\n2 - Show Best Students\n3 - Add student\n" +
                "4 - Remove student\n5 - Exit program");
    }

    public void showListOfStudents() {
        if (listOfStudents.isEmpty()) {
            loadStudentsFromFile();
        }
        SortStudentsByAverageGrade();

        for (Student student : listOfStudents) {
            System.out.println(student);
        }
    }

    private void showListOfBestStudents() {
        if (listOfStudents.isEmpty()) {
            loadStudentsFromFile();
        }

        SortStudentsByAverageGrade();

        for (Student student : listOfStudents) {
            if (student.getBestStudent()) {
                System.out.println(student);
            }
        }

    }

    public void addStudent() {
        try {
            in.nextLine();
            System.out.println("Enter name of student:");
            String studentName = in.nextLine();
            System.out.println("Enter group of student");
            String studentGroup = in.nextLine();
            System.out.println("Enter student grades");
            int[] academicPerformance = Grades.fillArrayOfGrades();
            System.out.println("You added student");
            Student student = new Student(studentName, studentGroup, academicPerformance);
            listOfStudents.add(student);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Wrong data, try again");
        }
    }



    private void SortStudentsByAverageGrade() {
        listOfStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student, Student other) {
                if (student.getAverageGrade() == other.getAverageGrade()) {
                    return student.getName().compareTo(other.getName());
                } else if (student.getAverageGrade() > other.getAverageGrade()){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    public void removeStudent() {
        if (listOfStudents.isEmpty()) {
            loadStudentsFromFile();
        }
        if (listOfStudents.size() == 0) {
            System.out.println("List of students is empty");
        } else {
            System.out.println("number of students: " + listOfStudents.size());
            for (int i = 0; i < listOfStudents.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, listOfStudents.get(i));
            }
            System.out.println("Which student do you want to remove from the list?:");
            int id = in.nextInt();
            if (id >= 1 && id <= listOfStudents.size()) {
                listOfStudents.remove(id - 1);
                saveStudentsToFile();
            } else {
                System.out.println("student not found");
            }
        }

    }

    public void saveStudentsToFile() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            writer.writeObject(listOfStudents);
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }

    public void loadStudentsFromFile() {
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("students.dat"))) {
            listOfStudents = ((ArrayList<Student>) reader.readObject());
        } catch (IOException e) {
            System.out.println("file not found");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

