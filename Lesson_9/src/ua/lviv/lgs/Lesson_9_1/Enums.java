package ua.lviv.lgs.Lesson_9_1;

import java.util.Scanner;

/** 
 * The {@code String} class represents string
 * @author R.Pidgurskiy
 * @since JDK 1.8.0_201
 * @version 1.0
 */

public class Enums {
	
	public enum Seasons {
		WINTER, SPRING, SUMMER, AUTUMN;
	}

	public enum Monthes {
		
		JANUARY(31, Seasons.WINTER), 
		FEBRUATY(28, Seasons.WINTER),
		DECEMBER(30,Seasons.WINTER),
		MARCH(31,Seasons.SPRING), 
		APRIL(30,Seasons.SPRING), 
		MAY(31,Seasons.SPRING),
		JUNE(30,Seasons.SUMMER), 
		JULY(31,Seasons.SUMMER),
		AUGUST(31,Seasons.SUMMER),
		SEPTEMBER(30,Seasons.AUTUMN),
		OCTOBER(31,Seasons.AUTUMN),
		NOVEMBER(30,Seasons.AUTUMN);
		
		
		int days;
		Seasons season;
		
		Monthes(int days, Seasons season){
			this.days=days;
			this.season=season;
		}
		
		public int getDays() {
			return days;
		}

		public Seasons getSeason() {
			return season;
		}
	}
	
	static void menu(){
		System.out.println("\n Select a menu item!");
		System.out.println("1 - Check if there is such a month");
		System.out.println("2 - Output all months with the same period of the year");
		System.out.println("3 - Output all months with the same number of days");
		System.out.println("4 - Display all months with fewer days");
		System.out.println("5 - Display all the months that have more days");
		System.out.println("6 - Display the next season");
		System.out.println("7 - Display the previous year of the screen");
		System.out.println("8 - Display all the months that have a couple of days");
		System.out.println("9 - Display all the months that have an odd number of days on the screen");
		System.out.println("0 - Display the screen or the console entered, the month has a couple of days");
		
	}
	
	/** Input month*/
	
	public static String  Input() throws WrongInputConsoleParametersException{
		Monthes[] monthesArr = Monthes.values();
		System.out.println("  Enter the month:");
		Scanner scq = new Scanner(System.in);
		String mont = scq.next().toUpperCase();
		boolean flag = true;
		for (Monthes m : monthesArr) {
			  if (m.name().equals(mont)) {flag = false;}
	        	}
			if (flag==true) { String message = "Error entering month";
			  throw new WrongInputConsoleParametersException(message);
			}
		 
	  return (mont);
	}


	public static void main(String[] args) throws WrongInputConsoleParametersException  {
		Monthes[] monthesArr = Monthes.values();
		Seasons [] seasonArr = Seasons.values();
		Scanner scase = new Scanner(System.in);
		
		while(true) {
			menu ();
			switch(scase.next())  {
			
		/** Bring out the month */
			case "1": {
				String mont = Input();
				 System.out.println("So there is such a month - " + mont); 
			  break;
			}
			
		/** Output all months with the same period of the year */
			case "2": {
				String mont = Input();
				String StrSeson = null ;
				for (Monthes m : monthesArr) {
				  if (m.name().equals(mont)) {  StrSeson = m.season.toString();}	
				 }
			   for (Monthes m : monthesArr) {
				 if (m.season.toString() ==  StrSeson) { System.out.println(m.name()); }  
			    }  
			break;
		  }
			
			/**Output all months with the same number of days */
			case "3": {
				String mont = Input();
				int StrDay = 0 ;
				for (Monthes m : monthesArr) {
				  if (m.name().equals(mont)) {  StrDay = m.getDays();}	
				 }
				 for (Monthes m : monthesArr) {
					 if (m.getDays() ==  StrDay) { System.out.println(m.name()); }  
				    }  
			break;
		  }
			/** Display all months with fewer days */
			
			case "4": {		
				int days = Monthes.JANUARY.days;
				 for (Monthes  m : monthesArr) {
					if (m.days<days) {days=m.days;}
				  }		
				 for (Monthes  m : monthesArr)
				    if (m.days==days) {System.out.println(m.name()+" - Number of days "+ days);} 
			break;
		  }
			
		/**Display all the months that have more days */	 
          case "5": {
				int days = Monthes.JANUARY.days;
				 for (Monthes  m : monthesArr) {
					if (m.days>days) days=m.days;
				  }		
				 for (Monthes  m : monthesArr)
				    if (m.days==days) System.out.println(m.name()+" - Number of days "+ days); 
			break;
		  }	
          
          /**Display the next season  */
          case "6": {
        	  String mont = Input();
        	  int ordinal = 0;
				for (Monthes m : monthesArr) { 
				  if (m.name().equals(mont)) { 
					  ordinal = 1+m.season.ordinal(); 
					  if (ordinal == 4 ) {ordinal = 0;}
					    System.out.println ("Next season "+seasonArr[ordinal]);
					}	
				 }
			break;
		  }	
          
          
          /**Display the previous year of the screen */
          case "7": {
        	  String mont = Input();
        	  int ordinal = 0;
				for (Monthes m : monthesArr) { 
				  if (m.name().equals(mont)) { 
					  ordinal = m.season.ordinal()-1; 
					  if (ordinal == -1 ) {ordinal = 3;}
					 System.out.println ("The previous one season "+seasonArr[ordinal]);
					}	
				 }
			break;
		  }
          
          /** Display all the months that have a couple of days */
          case "8": {
        	  System.out.println ("All the months that have a couple of days");
				 for (Monthes  m : monthesArr) {
					 if (m.days%2==0) {  System.out.println(m.name()+" - "+m.days);}
				  }		
				  
			break;
		  }	
          
          
         /**Display all the months that have an odd number of days on the screen*/
          case "9": {
        	  System.out.println ("All the months that have not even a number of days");
				 for (Monthes  m : monthesArr) {
					 if (m.days%2==1) {  System.out.println(m.name()+" - "+m.days);}
				  }		
				  
			break;
		  }	
          
          case "0": {
        	  String mont = Input();
        	  for (Monthes m : monthesArr) {
				  if (m.name().equals(mont)) { 
					  if (m.days%2==0) {  
						  System.out.println(m.name()+" - "+m.days+" Even");} 
					  else {System.out.println(m.name()+" - "+m.days+" Odd number");}
				  }	
				 }
				  
			break;
		  }	
			
			}
			
		}


	}

}
