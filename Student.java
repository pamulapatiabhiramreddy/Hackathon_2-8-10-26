import java.util.Scanner;

 class Student {
    
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    
    public double calculateFee() {
        return courseCredits * 1500.0;
    }

        public boolean checkEligibility() {
        return marks >= 50;
    }

    
    public double calculateScholarship() {
        if (marks >= 85) {
            return 0.20 * calculateFee();
        } else if (marks >= 70 && marks <= 84) {
            return 0.10 * calculateFee();
        } else {
            return 0.0;
        }
    }

    
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    
    public void displayDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility: " + (checkEligibility() ? "Eligible" : "Not Eligible"));
        System.out.printf("Total Fee: ", calculateFee());
        System.out.printf("Scholarship: ", calculateScholarship());
        System.out.printf("Final Fee: ", calculateFinalFee());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String studentName = scanner.nextLine();
        String rollNumber = scanner.nextLine();
        double marks = scanner.nextDouble();
        scanner.nextLine(); 
        String courseName = scanner.nextLine();
        int courseCredits = scanner.nextInt();

        
        Student student = new Student(studentName, rollNumber, marks, courseName, courseCredits);

        
        if (student.checkEligibility()) {
            student.calculateFee();
            student.calculateScholarship();
            student.calculateFinalFee();
            student.displayDetails();
        } else {
            System.out.println("Student is not eligible for registration.");
        }

        scanner.close();
    }
}