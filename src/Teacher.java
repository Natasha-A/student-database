import java.io.IOException;
import java.util.Scanner;

class Teacher { 
	private static boolean correctLogin = false; 
	String userName = "teacher"; 
	String passwordName = "password";
	String name = null;
	String subject = null;
	
	public Teacher(String teacherName, String subjectName) {
		name = teacherName;
		subject = subjectName;
	}
	
	public static boolean getLogin() {
		return correctLogin;
	}
	
	public void isCorrectLogin() {
		Scanner enterTeacherLogin = new Scanner(System.in);
		Scanner enterTeacherPassword = new Scanner(System.in);
		String loginInput = null;
		String passwordInput = null;
		boolean checkLogin = true;

		while (checkLogin) {
			try {
				System.out.println("Enter login: ");
				loginInput = enterTeacherLogin.nextLine();
				System.out.println("Enter password: ");
				passwordInput = enterTeacherPassword.nextLine();
			
			} catch (Exception e) {
				System.out.println("1: Error in entering login, try again.");
		} 
			if (loginInput.equals(userName) && passwordInput.equals(passwordName)) {
				checkLogin = false;
				this.correctLogin = true; // sets current classroom object associated w/ teacher as true
			} else {
				System.out.println("Incorrect username or password, try again.");
			}
		}
	}
		
	    // save changes at this point or at end? choose to save all ...
	 public void addAssessment() throws ClassNotFoundException { // gets added to entire assessments 
	    	// database, then read into as assesmentsForClass() based on class type 
	    	System.out.println("\n------ Add Assessment ------");
	    	try {
				String date = Date_Format.enterDate();
				String course = this.subject;
				String teacher = this.name;
				String type = Assessment.addType();
				String description = Assessment.addDescription();
				
				Assessment assessment = new Assessment(date, course, teacher,
						type, description);
				Classroom.assessmentsObjects.add(assessment);

			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
}
