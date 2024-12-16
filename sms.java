import java.util.*;

class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("ID: " + id + " || Name: " + name + " || Age: " + age);
    }
}

class StudentManagementSystem {
    List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(int id, String name, int age) {
        students.add(new Student(id, name, age));
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : students) {
            student.display();
        }
    }

    public void deleteStudent(int id) {
        for (Student student : students) {
            if (student.id == id) {
                students.remove(student);
                System.out.println("Student with ID " + id + " has been removed.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}

class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("=========================");
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student age: ");
                    int age = sc.nextInt();
                    sms.addStudent(id, name, age);
                    System.out.println("=========================");
                    break;
                case 2:
                    System.out.println("=========================");
                    sms.displayAllStudents();
                    System.out.println("=========================");
                    break;
                case 3:
                    System.out.println("=========================");
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();
                    sms.deleteStudent(deleteId);
                    System.out.println("=========================");
                    break;
                case 4:
                    System.out.println("=========================");
                    System.out.println("Exiting...");
                    System.out.println("=========================");
                    sc.close();
                    return;
                default:
                    System.out.println("=========================");
                    System.out.println("Invalid choice. Try again.");
                    System.out.println("=========================");
            }
        }
    }
}