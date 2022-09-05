import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;


public class User_MainProgram {

	public static void main(String[] args) throws IOException {
		
	String studentsFile = "/Users/natasha.ahammed/eclipse-workspace/"
			+ "Summative_BrainstormClasses/src/students.csv";
	
	String assessmentsFile = "/Users/natasha.ahammed/eclipse-workspace/"
			+ "Summative_BrainstormClasses/src/assessments.csv";
				
	Classroom.readFiles(studentsFile, assessmentsFile);
	
	
	//Classroom.studentsObjects.get(0).studentInfo();
	//System.out.println(Classroom.studentsObjects.size());
	//System.out.println(Classroom.studentsObjects);
		
	// as soon as user enters, create class!!
	Classroom classroom_Math = new Classroom();
	Classroom classroom_Physics = new Classroom();
	Classroom classroom_English = new Classroom();
	
	classroom_Math.teacher = new Teacher("Teacher_Math", "MCR3U0");
	classroom_Physics.teacher = new Teacher("Teacher_Physics", "SPH3U0");
	classroom_English.teacher = new Teacher("Teacher_English", "ENG3U0");
	//System.out.println(Classroom.assessmentsList);
	//System.out.println(Classroom.assessmentsObjects.get(0).date);
	
	//classroom_Math.addAssessment();
	classroom_Math.addStudentsToClass();
	classroom_Physics.addStudentsToClass();
	
	//classroom_Math.displayAssessmentsForClass();

	classroom_Math.viewMonthlySchedule();
	//classroom_Math.displayOptimalAssessmentDates();
	
	//classroom_Math.addAssessment();
	classroom_Math.displayAssessmentsForClass();

	
	}

}