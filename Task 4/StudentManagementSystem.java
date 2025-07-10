import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> studentList;
    private final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        studentList = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(Student student) {
        studentList.add(student);
        saveToFile();
    }

    public boolean removeStudent(String rollNumber) {
        for (Student s : studentList) {
            if (s.getRollNumber().equalsIgnoreCase(rollNumber)) {
                studentList.remove(s);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(String rollNumber) {
        for (Student s : studentList) {
            if (s.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return s;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : studentList) {
                System.out.println("----------------------------");
                System.out.println(s);
            }
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(studentList);
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentList = (List<Student>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading from file.");
        }
    }
}
