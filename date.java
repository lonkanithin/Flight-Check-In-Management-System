import java.time.LocalDate;
import java.util.Scanner;
public class date 
{
	public void SelectDate()
	{
	        Scanner sc = new Scanner(System.in);
        	System.out.print("Enter travel date (YYYY-MM-DD): ");
        	String dateInput = sc.nextLine();
        	LocalDate travelDate = LocalDate.parse(dateInput);
        	System.out.println("Flight booked for: " + travelDate);
        	System.out.println("Day: " + travelDate.getDayOfMonth());
        	System.out.println("Month: " + travelDate.getMonth());
        	System.out.println("Year: " + travelDate.getYear());
        	sc.close();
	}
public static void main(String[] args)
{
	date obj=new date();
	obj.SelectDate();
}
}