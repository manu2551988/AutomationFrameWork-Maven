package test_scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo11 {
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 //get current date time with Date()
		 Date date = new Date();
		 System.out.println(date.getMonth());
		 System.out.println(date.getYear());
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 System.out.println(date1);
	}

}
