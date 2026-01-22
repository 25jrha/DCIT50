public class TeacherStudentAssignment {
    public static void main(String[] args) {

        Course course1 = new Course("Raiton", "Chidori");

        Course[] Ninjutsu = {course1};

        Student student = new Student("Jhon Rio Alcoser", 20, "Male", "2509090909");
        Teacher teacher = new Teacher("Kakashi Sensei", 26, "Male", "ANBU", Ninjutsu);

        student.displayStudent();

        teacher.displayTeacher();

        course1.displayCourse();
    }
}

class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}

class Student extends Person {
    private String studentId;

    public Student(String name, int age, String gender, String studentId) {
        super(name, age, gender);
        this.studentId = studentId;
    }

    public void displayStudent() {
        System.out.println("--- Student Information ---");
        displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println();
    }
}

class Course {
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public void displayCourse() {
        System.out.println(courseCode + " - " + courseName);
    }
}

class Teacher extends Person {
    String department;
    Course[] courses;

    public Teacher(String name, int age, String gender, String department, Course[] courses) {
        super(name, age, gender);
        this.department = department;
        this.courses = courses;
    }

    public void displayTeacher() {
        System.out.println("--- Teacher Information ---");
        super.displayInfo();
        System.out.println("Department: " + this.department);
        System.out.println("Courses Handled:");
        for (Course c : courses) {
            c.displayCourse();
        }
        System.out.println();
    }


}
