import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;



public class Assessment  {
	// all assessments for all classes
    static LocalDateTime today = LocalDateTime.now();
    static LocalDateTime nextWeek = today.plusDays(7);
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E MMM dd yyyy");
    static String formattedDateNextWeek = nextWeek.format(myFormatObj);
	public String date;
	public String course;
	public String teacher;
	public String type;
	public String description = "NA";
	
	// Overloading constructors can be used by programmer when hard coding values 
	public Assessment(String dateVal, String courseVal, String teacherVal, 
					   String typeVal, String descripVal) {
			date = dateVal;
			course = courseVal;
			teacher = teacherVal;
			type = typeVal;
			description = descripVal;
	}
	
	// Overloading constructors 
	public Assessment(String courseVal, String teacherVal, String typeVal, String descripVal) {
		date = formattedDateNextWeek; 
		course = courseVal;
		teacher = teacherVal;
		type = typeVal; 
		description = descripVal;
	}
	
	public Assessment(String courseVal, String teacherVal, String typeVal) {
		date = formattedDateNextWeek; 
		course = courseVal;
		teacher = teacherVal;
		type = typeVal;
		description = "NA";
	}
		
	
	public static String addType() {
		String type = null;
		boolean checkType = true;
		while (checkType) {
			try {
			 Scanner enterType = new Scanner(System.in); 
				System.out.println("\nEnter type of assessment (Q = Quiz, T = Test):");
				String typeInput = enterType.nextLine();	
				
				if (typeInput.equals("T")) {
					type = "Test";
					checkType = false;

				} else if (typeInput.equals("Q")) {
					type = "Quiz";
					checkType = false;

				} else {
					System.out.println("Invalid entry. Enter 'Q' or 'T'");
				}
				
			} catch (NullPointerException e) {
				System.out.println("Entry unrecognized.");
			}	
		}
		return type;
	}
	
	public static String addDescription() {
		boolean checkDescrip = true;
		String description = null; 
		
		while (checkDescrip) {
			try {
				Scanner setDescrip = new Scanner(System.in);
				System.out.println("Specify description for assessment? Enter(Y/N)");
				String addDescrip = setDescrip.nextLine();
			
				if (addDescrip.equals("Y")) {
					Scanner enterDescrip = new Scanner(System.in);
					System.out.println("Enter a brief description of the assessment:");
					String typeDescrip = enterDescrip.nextLine();
					
					description = typeDescrip;
					checkDescrip = false;
									
				} else if (addDescrip.equals("N")) { 
					checkDescrip = false;
					description = "NA";

				} else {
					System.out.println("Incorrect entry. Enter 'Y' or 'N'.");
					checkDescrip = true;
				}
			} catch (NullPointerException e) {
				System.out.println("Entry unrecognized.");
			}
		}
		return description;
	}
	
	public static void viewUpcomingAssessments(Classroom classroom)  {
		int listLength = classroom.assessmentsForClassList.size();
		// converts dates from assessments as string list values 
		List<String> datesListAsString = new ArrayList<String>();
		for (int index = 0; index < listLength; index++) {
			datesListAsString.add(classroom.assessmentsForClassList.get(index).date);
		}
		
		System.out.println(datesListAsString);
		List<List<String>> slicedDatesList = new ArrayList<List<String>>(); 
		
		for (int indexDate = 0; indexDate < datesListAsString.size(); indexDate++) {
			String line = datesListAsString.get(indexDate);
			List<String> slicedLine = Arrays.asList(line.split(" ")); // split line by spaces 
			slicedDatesList.add(slicedLine);
		}
		
		int year = 0;
		int month = 0;
		int day = 0;
		int hour = 0;
		int min = 0;
		List<LocalDateTime> dateTimeList = new ArrayList<LocalDateTime>();
		
		for (int k = 0; k < slicedDatesList.size(); k++) {
			for (int j=0; j < slicedDatesList.get(k).size(); j++) {
				year = today.getYear();
				// input month in string format i.e June, July, etc.
				month = Date_Format
						.convertToNumericalMonth(slicedDatesList.get(k).get(1));
				day = Integer.parseInt(slicedDatesList.get(k).get(2));
			}
			dateTimeList.add(LocalDateTime.of(year, month, day, hour, min));
		}	
		Collections.sort(dateTimeList);
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E MMM dd yyyy");

		System.out.println("------ Upcoming Assessments in " +
		classroom.teacher.subject + " for " + today.getMonth() + " ------");

		for(LocalDateTime dateTime: dateTimeList) {
			// ensure that displayed upcoming assessments are dates ahead of 'today' date 
		    String formattedDetailDate = dateTime.format(dateFormatter);
		    String totalInfo = null;

		    for (int index = 0; index < listLength; index++) {
		    	Assessment assessment = classroom.assessmentsForClassList.get(index);
		    	if (formattedDetailDate.equals
		    			(assessment.date)) {
		    		totalInfo = formattedDetailDate + ", " +
		    						   assessment.course + ", " +
		    						   assessment.teacher + ", " +
		    						   assessment.type + ": " +
		    						   assessment.description;
		    	}	
		    }
		    
		    if (today.getDayOfMonth() < dateTime.getDayOfMonth()) {
		    	System.out.println(totalInfo);
		    }
		}	
	}
}

