import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {
	String studentName; 
	String studentGrade; 
	String courseOne,courseTwo,courseThree,courseFour;
	static int studentCounter = 0;

	
	// Initialize objects and properties 
	public Student(String sName, String sGrade, 
			String course1, String course2,
			String course3, String course4) {
		studentName = sName;
		studentGrade = sGrade;
		courseOne = course1;
		courseTwo = course2;
		courseThree = course3;
		courseFour = course4;
		studentCounter++;

	}
	
	public Student(String course1, String course2, String course3, String course4) {
		studentName = "NA";
		studentGrade = "NA";
		courseOne = course1;
		courseTwo = course2;
		courseThree = course3;
		courseFour = course4;
		studentCounter++;

	}
	
	// Display student info 
	public void studentInfo() {
		System.out.println("Name: "+studentName+
				          "\nGrade: "+studentGrade+
				          "\nCourse 1: "+courseOne+
				          "\nCourse 2: "+courseTwo+
				          "\nCourse 3: "+courseThree+
				          "\nCourse 4: "+courseFour
				          );
	}
	
	public static String enterName() {
		Scanner enterName; 
		String name = null;
	    boolean checkName = true;
	    
	    while (checkName) {

	    	enterName = new Scanner(System.in);
	    	System.out.println("Enter name:");
	    	name = enterName.nextLine();
		
	    	try {
	    		if (name.equals("")) {
	    			throw new AssertionError("Empty entry");

	    		} else {
	    		    checkName = false;

	    		}
			
	    	} catch (AssertionError e) {
	    		System.out.println("Incorrect value.");
    		    checkName = true;

	    	}
	    }
		 System.out.println("\nName added.");
		return name;
	}
	
	public static String enterGrade() {
		Scanner enterGrade;
		String grade = null;
		
		try {
			enterGrade = new Scanner(System.in);
			System.out.println("Enter grade:");
			grade = enterGrade.nextLine();
		
			if (grade.equals("")) {
				throw new AssertionError("Empty entry.");
			}
		} catch (AssertionError e) {
			System.out.println("Incorrect value.");
		}
		 System.out.println("\nGrade added.");
		return grade;
	}
	
	public static List<String> enterCourses() {
		List<String> courses = new ArrayList<String>();
		String course = null; 
		
		System.out.println("\n(Note: Ensure course is an available course and correct code)");
		for (int i=0; i < 4; i++) {
		boolean checkCourse = true;

		 while (checkCourse) {
			try {
				Scanner enterCourses = new Scanner(System.in);
				System.out.println("Enter course #" + (i+1) + ":");
				course = enterCourses.nextLine();
				
			for (String courseName : Classroom.coursesGrade11) {
				if (courseName.equals(course)) {
					checkCourse = false;
					courses.add(course);
				}
			  }
			} catch (AssertionError e) {
				System.out.println("Incorrect course option.");
			}
		 }
	}
		System.out.println("\nCourses added.");

		return courses;
	}
		
}
