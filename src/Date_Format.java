import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

	
public class Date_Format {
	
	static LocalDateTime today = LocalDateTime.now();
    static LocalDateTime nextWeek = today.plusDays(7);
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E MMM dd yyyy");
    static String formattedDateNextWeek = nextWeek.format(myFormatObj);
    static Calendar cal = Calendar.getInstance();
    static int lastDateOfMonth = cal.getActualMaximum(Calendar.DATE);

	public static String enterDate() throws IOException {
		boolean checkDate = true;
		String date = null;
		List<String> validDates = new ArrayList<String>();
		
		while (checkDate) {
			Scanner setDate = new Scanner(System.in);
			System.out.println("\nSpecify date for assessment? Enter(Y/N)");
			String addDate = setDate.nextLine();
			LocalDateTime today = LocalDateTime.now();
			DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("dd");
		    DateTimeFormatter numDateFormat = DateTimeFormatter.ofPattern("e");
			
				if (addDate.equals("Y")) {
					
					String dateString = today.format(currentDate);
					int dateToday = Integer.parseInt(dateString);
				    
					for (int indexDate=1; indexDate <= (lastDateOfMonth-dateToday); indexDate++) {
						LocalDateTime nextDay = today.plusDays(indexDate);
					    String formattedDate = nextDay.format(numDateFormat); // display only date 
						int intFormattedDate = Integer.parseInt(formattedDate);
						
						if (1 < intFormattedDate && intFormattedDate < 7) {
						    DateTimeFormatter detailDateFormat = DateTimeFormatter.ofPattern("E MMM dd yyyy");
						    String formattedDetailDate = nextDay.format(detailDateFormat);
							validDates.add(formattedDetailDate);
						}
						
					 }		
					
					// Display valid dates (weekdays)
					System.out.println("\n------ Valid Dates for " + today.getMonth() + " -----");
				    for (int index=0; index < validDates.size(); index++) {
				    	System.out.println((index+1)+ ": "+ validDates.get(index));
				    }
				    
				    date = addDate(validDates);
				    System.out.println(date);
					checkDate = false;
					
					

				} else if (addDate.equals("N")) {
					date = formattedDateNextWeek; 
					System.out.println("Recorded date as one week from today: " + date);
					checkDate = false;

				} else {
					System.out.println("Incorrect entry. Enter 'Y' or 'N'.");
					checkDate = true;

				}
			}
			
			return date; // return null if not applicable 

		}
	
    
	public static String addDate(List<String> datesList) throws IOException {
		int lengthList = datesList.size();
		boolean checkInput = true; 
		String date = null;
		String dateIndex = null;
	
		while (checkInput) {
			try {
				Scanner enterDateIndex = new Scanner(System.in);
				System.out.println("\nSelect index # for assessment date:");
				dateIndex = enterDateIndex.nextLine();
				
				if (0 < Integer.parseInt(dateIndex) && 
						Integer.parseInt(dateIndex) <= (lengthList+1)) {
						date = datesList.get((Integer.parseInt(dateIndex)-1));

						checkInput = false;
					} else {
						System.out.println("Incorrect index.");
						checkInput = true;
					}
			} catch (NumberFormatException e) {
				System.out.println("Incorrect format.");
				checkInput = true;
			}
		}
		System.out.println("Assessment has been recorded.");
    	
		return date;	
	}
	
	public static int convertToNumericalMonth(String month) {
		int numMonth = 0;
		switch (month) {
			case "Jan.": 
				numMonth = 1;
				break;
			case "Feb.":
				numMonth = 2;
				break;
			case "Mar.":
				numMonth = 3;
				break;
			case "Apr.":
				numMonth = 4;
				break;
			case "May.":
				numMonth = 5;
				break;
			case "Jun.":
				numMonth = 6; 
				break;
			case "July.":
				numMonth = 7; 
				break;
			case "Aug.":
				numMonth = 8; 
				break;
			case "Sep.":
				numMonth = 9;
				break;
			case "Oct.":
				numMonth = 10;
				break;
			case "Nov.":
				numMonth = 11;
				break;
			case "Dec.":
				numMonth = 12;
				break;
		}
		return numMonth;
	}
	
	public static List<String> getMonthDates() {
		List<LocalDateTime> dateTimeList = new ArrayList<LocalDateTime>();
		List<String> dateFormattedList = new ArrayList<String>();
		DateTimeFormatter numDateFormat = DateTimeFormatter.ofPattern("e");

		for (int date=1; date <= lastDateOfMonth; date++) {
			int year = today.getYear();
			int month = today.getMonthValue();
		    int day = date;
		    
		    LocalDateTime dateTimeObject = LocalDateTime.of(year, month, day, 0, 0);
			String numDate = dateTimeObject.format(numDateFormat);
			Integer numDateAsInt = Integer.parseInt(numDate);
			
			if (1 < numDateAsInt && numDateAsInt < 7) {
				dateTimeList.add(LocalDateTime.of(year, month, day, 0, 0));
		    }
		}

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E MMM dd yyyy");
		
		for (LocalDateTime dateTime: dateTimeList) {
			String formattedDetailDate = dateTime.format(dateFormatter);
			dateFormattedList.add(formattedDetailDate);
		}
		//System.out.println(dateFormattedList);
		return dateFormattedList;
	}

}
