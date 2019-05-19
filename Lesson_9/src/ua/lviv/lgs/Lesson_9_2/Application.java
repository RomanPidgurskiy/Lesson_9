package ua.lviv.lgs.Lesson_9_2;
import java.util.Scanner;

public class Application {
	
	public static void main(String[] args) throws MyException {
		
	
	
	int a=0;
	int b=0;
	Methods metod = new Methods(a,b);
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the first value");
	
	if (sc.hasNextInt()) { a=sc.nextInt();
	 } else {metod.checkInput();
		return;
	 }	
	if (sc.hasNextInt()) { b=sc.nextInt(); } 
	  else { metod.checkInput();
	}

	metod.check();
	metod.methods();
	
 }
}