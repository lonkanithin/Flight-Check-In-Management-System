import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import java.util.*;
class A{
	private String username;
	private String password;
	private long mobile;
	private String email;
	A(String username, String password, long mobile, String email){
		this.username=username;
		this.password=password;
		this.mobile=mobile;
		this.email=email;
	}
	void setUsername(String username){
		this.username=username;
	}
	void setPassword(String password){
		this.password=password;
	}
	void setMobile(long mobile){
		this.mobile=mobile;
	}
	void setEmail(String email){
		this.email=email;
	}
	String getUsername(){
		return username;
	}
	String getPassword(){
		return password;
	}
	long getMobile(){
		return mobile;
	}
	String getEmail(){
		return email;
	}
}
class B{
	static A obj;
	static Scanner sc =new Scanner(System.in);
	
	static void signup(){
		System.out.println("Enter Username:");
		String name=sc.next();
		System.out.println("Enter Password:");
		String pass=sc.next();
		System.out.println("Enter Mobile Number:");
		long phone =sc.nextLong();
		boolean b=true;
		while(b){
		
		if(String.valueOf(phone).length()!=10){
        		System.out.println("Mobile number must be 10 digits!");
			InvalidMobileMessage m=new InvalidMobileMessage();
			m.InvalidNumber();
			System.out.println("If you want to try Again enter yes else no");
			String n=sc.next();
			if(!n.equalsIgnoreCase("yes")){
				System.out.print("thank you");
				return;
			}else{
				System.out.println("Enter Mobile Number:");
				phone=sc.nextLong();
				if(String.valueOf(phone).length()==10){
					b=false;
					break;
				}
				else{
					b=true;
				}
				
			}
			
    		}
		else{
			b=false;
		}
		}
		System.out.println("Enter Email Id:");
		String mail=sc.next();
		boolean be=true;
		while(be){
		if (!mail.contains("@") || !mail.contains(".")) {
        		System.out.println("Invalid email format!");
			InvalidEmailMessage e=new InvalidEmailMessage();
			e.InvalidEmail();
			System.out.println("If you want to try Again enter YES else NO");
			String n=sc.next();
			if(!n.equalsIgnoreCase("yes")){
				System.out.print("thank you");
				return;
			}
			else{
				System.out.print("Enter email : ");
				mail=sc.next();
				if(mail.contains("@") && mail.contains(".")){
					be=false;
					break;
				}
				else{
					be=true;
				}
			}

    		}
		else{
			be=false;
		}
		}
		obj=new A(name, pass, phone, mail);
		StyledSignupAnimation up=new StyledSignupAnimation();
		up.log();
		loginmain();
	}

	static void loginmain() {
    		while (true) {
        		System.out.println("LOGIN CREDENTIALS:-");
        		System.out.println("-------------------");

        		System.out.println("Enter Username or Mobile Number:");
        		String name1 = sc.next();

        		if (name1.equals(obj.getUsername())) {
            			login(name1);
           			break;
        		} 
			else if (name1.matches("\\d+")) {
            			long input1 = Long.parseLong(name1);
            			login(input1);
            			break;
        		} 
			else {
            			InvalidUsernameMessage u = new InvalidUsernameMessage();
            			u.InvalidUsername();
            			System.out.println("If you want to try Again enter YES else NO");
				String n=sc.next();
				if(n.equalsIgnoreCase("yes")){
					loginmain();
				}
				else{
					System.out.print("thank you");
					break;
				}
        		}
    		}
	}


	static void login(String name1){
		if(name1.equals(obj.getUsername())){
			System.out.println("enter password");
			String pass1=sc.next();
			if(pass1.equals(obj.getPassword())){
				StyledLoginAnimation s=new StyledLoginAnimation();
				s.log();
				FlightCheckIn f2=new FlightCheckIn();
				f2.flight();
				
			}
			else{	
				InvalidPasswordMessage p=new InvalidPasswordMessage();
				p.InvalidPassword();
				System.out.println("If you want to try Again enter YES else NO");
				String n=sc.next();
				if(n.equalsIgnoreCase("yes")){
					forgetPassword();
				}
				else{
					System.out.print("thank you");
				}

			}
		}
		else{
			InvalidUsernameMessage u=new InvalidUsernameMessage();
			u.InvalidUsername();
			System.out.println("If you want to try Again enter YES else NO");
			String n=sc.next();
			if(n.equalsIgnoreCase("yes")){
				loginmain();
			}
			else{
				System.out.print("thank you");
			}

		}
	}
	
	static void login(long name1){
		if(name1==obj.getMobile()){
			System.out.println("enter password");
			String pass1=sc.next();
			if(pass1.equals(obj.getPassword())){
				StyledLoginAnimation s=new StyledLoginAnimation();
				s.log();
				FlightCheckIn f1=new FlightCheckIn();
				f1.flight();
				
			}
			else{
				InvalidPasswordMessage p=new InvalidPasswordMessage();
				p.InvalidPassword();
				System.out.println("If you want to try Again enter YES else NO");
				String n=sc.next();
				if(n.equalsIgnoreCase("yes")){
					forgetPassword();
				}
				else{
					System.out.print("thank you");
				}

			}
		}
		else{
			InvalidUsernameMessage u=new InvalidUsernameMessage();
			u.InvalidUsername();
			System.out.println("If you want to try Again enter YES else NO");
			String n=sc.next();
			if(n.equalsIgnoreCase("yes")){
				loginmain();
			}
			else{
				System.out.print("thank you");
			}

		}
	}
	static void forget(long mobile){
		if(mobile==obj.getMobile()){
			int otp = generate();
			System.out.println(otp);
			System.out.println("enter otp");
			int userotp=sc.nextInt();
			if(otp==userotp){
				System.out.println("enter new password");
				String npass = sc.next();
				obj.setPassword(npass);
				StyledPasswordChangeAnimation c=new StyledPasswordChangeAnimation();
				c.PasswordChange();
				loginmain();
			}
			else{
				InvalidOtpMessage o=new InvalidOtpMessage();
				o.InvalidOtp();
				System.out.println("If you want to try Again enter YES else NO");
				String n=sc.next();
				if(n.equalsIgnoreCase("yes")){
					forgetPassword();
				}
				else{
					System.out.print("thank you");
				}

			}
		}
		else{
			InvalidMobileMessage m=new InvalidMobileMessage();
			m.InvalidNumber();
			System.out.println("If you want to try Again enter YES else NO");
			String n=sc.next();
			if(n.equalsIgnoreCase("yes")){
				forgetPassword();
			}
			else{
				System.out.print("thank you");
			}
	}
	}
	static void forget(String email){
		if(email.equals(obj.getEmail())){
			int otp = generate();
			System.out.println(otp);
			System.out.println("enter otp");
			int userotp=sc.nextInt();
			if(otp==userotp){
				System.out.println("enter new password");
				String npass = sc.next();
				obj.setPassword(npass);
				StyledPasswordChangeAnimation c=new StyledPasswordChangeAnimation();
				c.PasswordChange();
				loginmain();
			}
			else{
				InvalidOtpMessage o=new InvalidOtpMessage();
				o.InvalidOtp();
				System.out.println("If you want to try Again enter YES else NO");
				String n=sc.next();
				if(n.equalsIgnoreCase("yes")){
					forgetPassword();
				}
				else{
					System.out.print("thank you");
				}
	
			}
		}
		else{
			InvalidEmailMessage e=new InvalidEmailMessage();
			e.InvalidEmail();
			System.out.println("If you want to try Again enter YES else NO");
			String n=sc.next();
			if(n.equalsIgnoreCase("yes")){
				forgetPassword();
			}
			else{
				System.out.print("thank you");
			}	
		}
	}

	static void forgetPassword() {
		while(true){
    		System.out.println("Enter mobile or email:");
    		String input = sc.next();

    		if (input.equals(obj.getEmail())) {
       			 forget(input);
				break;
    		} 
		else if(input.matches("\\d+")){
            			long input1 = Long.parseLong(input);
            			forget(input1);
				break;
        	} 
		else{
			
            		System.out.println("Invalid input! Please enter a valid email or mobile number.");
			System.out.println("If you want to try Again enter YES else NO");
			String n=sc.next();
			if(n.equalsIgnoreCase("yes")){
				forgetPassword();
				break;
			}
			else{
				System.out.print("thank you");
				break;
			}
        
        	}
		}
    		
	}
	
	static int generate(){
		System.out.println("you otp");
		int otp=1000+(int)(Math.random()*8467);
		return otp;
	}
	
}


//  Abstraction
abstract class Passenger {
    private String name;
    private int age;
    private String passportNo;
    private String seatNo;

    public Passenger(String name, int age, String passportNo, String seatNo) {
        this.name = name;
        this.age = age;
        this.passportNo = passportNo;
        this.seatNo = seatNo;
    }

    //  Encapsulation
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPassportNo() { return passportNo; }
    public String getSeatNo() { return seatNo; }

    //  Polymorphism (Overridden)
    public abstract String getBenefits();

    public void generateBoardingPass(String flightNo, String destination, String source ,LocalDate date1) {
	Scanner sc=new Scanner(System.in);
        String boardingInfo = "BOARDING PASS\n" +
                "Passenger: " + name + "\n" +
                "Age: " + age + "\n" +
                "Passport: " + passportNo + "\n" +
                "Flight: " + flightNo + "\n" +
                "Seat: " + seatNo + "\n" +
		"Source: " + source + "\n" +
                "Destination: " + destination + "\n" +
		"Date: " + date1 + "\n" +
                "Benefits: " + getBenefits();

        System.out.println("\n==================== BOARDING PASS ====================");
        System.out.println(boardingInfo);
        System.out.println("=======================================================");

        
        generateQR(boardingInfo);
	System.out.println("To Cancel Your Flight Ticket, please enter cancel or press any other key to Exit");
	String can=sc.next();
	//Random r=new Random();
	PaymentDemo r=new PaymentDemo();
	if(can.equals("cancel")){
		AirlineSeats.cancel(flightNo,seatNo);
		System.out.println("Your flight ticket has been cancelled successfully. A refund of Rs "+r.money()+" will be processed within 3-5 business days.");

	}
	System.out.println("would you like to book another flight?(yes/no)");
        String option=sc.next();
	if(option.equals("yes")){
		FlightCheckIn f2=new FlightCheckIn();
		f2.flight();
		return;
	}
	else{
		System.out.println("Thank you");
	}
    }

  
    private void generateQR(String text) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 25, 25);

            for (int y = 0; y < bitMatrix.getHeight(); y++) {
                for (int x = 0; x < bitMatrix.getWidth(); x++) {
                    System.out.print(bitMatrix.get(x, y) ? "██" : "  ");
                }
                System.out.println();
            }
            System.out.println("\n Scan this QR code with your phone to view boarding pass details.");
        } catch (WriterException e) {
            System.out.println(" Error generating QR: " + e.getMessage());
        }
    }
}


class EconomyPassenger extends Passenger {
    public EconomyPassenger(String n, int a, String p, String s) {
        super(n, a, p, s);
    }
    @Override
    public String getBenefits() {
	
        return "1 Meal, 20kg Baggage";
    }
}

class BusinessPassenger extends Passenger {
    public BusinessPassenger(String n, int a, String p, String s) {
        super(n, a, p, s);
    }
    @Override
    public String getBenefits() {
        return "2 Meals, 35kg Baggage, Lounge Access";
    }
}

class FirstClassPassenger extends Passenger {
    public FirstClassPassenger(String n, int a, String p, String s) {
        super(n, a, p, s);
    }
    @Override
    public String getBenefits() {
        return "Luxury Meals, 50kg Baggage, Lounge + Priority Boarding";
    }
}

class FlightCheckIn {
	static void flight(){
	Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Flight Check-In System ");
	System.out.println("PASSENGER DETAILS:-");
	System.out.println("-------------------");

        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Passport Number: ");
        String passport = sc.nextLine();
	
	date obj=new date();
	LocalDate date1=obj.SelectDate();;

	FlightSelection fs = new FlightSelection();
        fs.chooseFlight();

        String flightNo = fs.getFlightNo();

        String source = fs.getSource();

        String destination = fs.getDestination();

        System.out.println("\nChoose Class: ");
        System.out.println("1. Economy");
        System.out.println("2. Business");
        System.out.println("3. First Class");
        int choice = sc.nextInt();

	System.out.println("\nSelect your seat for this flight:");
	String seat = AirlineSeats.selectSeat(fs.getFlightNo());


	if(seat == null) {
    		System.out.println("Booking cancelled.");
    		return;
	}	

	PaymentDemo ob=new PaymentDemo();
	if(1==ob.Submethod()){
        Passenger passenger;
        switch (choice) {
            case 1:
                passenger = new EconomyPassenger(name, age, passport, seat);
                break;
            case 2:
                passenger = new BusinessPassenger(name, age, passport, seat);
                break;
            case 3:
                passenger = new FirstClassPassenger(name, age, passport, seat);
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Economy.");
                passenger = new EconomyPassenger(name, age, passport, seat);
        }

        passenger.generateBoardingPass(flightNo, destination, source, date1);
	}
	else{
		System.out.println("Payment failed -your booking has not been confirmed");
		return; 
	}
	}
	
}

class FlightSelection {
    private String flightNo;
    private String source;
    private String destination;

    public void chooseFlight() {
        Scanner sc = new Scanner(System.in);

        String[][] flights = {
            {"101", "Delhi", "Mumbai"},
            {"202", "Hyderabad", "Chennai"},
            {"303", "Bangalore", "Kolkata"},
            {"404", "Pune", "Goa"}
        };

        System.out.println("\nAvailable Flights:");
	System.out.println("--------------------");
        for (int i = 0; i < flights.length; i++) {
            System.out.println((i + 1) + ". " + flights[i][0] + " - " + flights[i][1] + " -> " + flights[i][2]);
        }

        System.out.println("\nChoose your flight (1-4): ");
	System.out.println("--------------------------");
        int choice = sc.nextInt();
        sc.nextLine(); 

        if (choice < 1 || choice > flights.length) {
            System.out.println("Invalid choice! Please try again.");
            chooseFlight(); 
            return;
        }

        // Assign chosen flight details
        this.flightNo = flights[choice - 1][0];
        this.source = flights[choice - 1][1];
        this.destination = flights[choice - 1][2];
    }

    // Getters
    public String getFlightNo() {
        return flightNo;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}

class AirlineSeats {
    
    private static char[][] flight101Seats = new char[6][9];
    private static char[][] flight202Seats = new char[6][9];
    private static char[][] flight303Seats = new char[6][9];
    private static char[][] flight404Seats = new char[6][9];

    static {
        for (int i = 0; i < 6; i++) {
            Arrays.fill(flight101Seats[i], 'O');
            Arrays.fill(flight202Seats[i], 'O');
            Arrays.fill(flight303Seats[i], 'O');
            Arrays.fill(flight404Seats[i], 'O');
        }
    }

    
    private static char[][] getSeats(String flightNo) {
        switch (flightNo) {
            case "101": return flight101Seats;
            case "202": return flight202Seats;
            case "303": return flight303Seats;
            case "404": return flight404Seats;
            default: return flight101Seats;
        }
    }

    public static String selectSeat(String flightNo) {
        Scanner sc = new Scanner(System.in);
        char[][] seats = getSeats(flightNo);

        while (true) {
            clearScreen();
            displaySeats(seats);

            System.out.print("Enter seat to book (e.g., B3) or 'exit' to cancel: ");
            String input = sc.nextLine().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("Booking cancelled.");
                return null;
            }

            boolean booked = bookSeat(seats, input);
            if (booked) {
                System.out.println("Seat " + input + " selected successfully!");
                displaySeats(seats);
                return input;
            }

            System.out.println("Press Enter to continue...");
            sc.nextLine();
        }
    }

	
   public static String cancel(String flightNo, String seat) {
        Scanner sc = new Scanner(System.in);
        char[][] seats = getSeats(flightNo);

        while (true) {
                        String input = seat;

            if (input.equals("EXIT")) {
                System.out.println("Booking cancelled.");
                return null;
            }

            boolean cancel = cancelSeat(seats, input);
            if (cancel) {
                displaySeats(seats);
		System.out.println("Seat " + input + " cancelled successfully!");
                return input;
            }

            System.out.println("Press Enter to continue...");
            sc.nextLine();
        }
    }

    public static void displaySeats(char[][] seats) {
        System.out.println("============ AIRLINE SEAT MAP ============");
        System.out.print("     ");
        for (int i = 1; i <= 3; i++) System.out.print(" " + i + " ");
        System.out.print("       ");
        for (int i = 4; i <= 9; i++) System.out.print(" " + i + " ");
        System.out.println();

        char rowLetter = 'A';
        for (int i = 0; i < seats.length; i++) {
            System.out.print(" " + rowLetter++ + " | ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(" " + seats[i][j] + " ");
                if (j == 2) System.out.print("   |   ");
            }
            System.out.println();
        }
        System.out.println("==========================================");
        System.out.println("Legend: O = Open Seat | X = Booked Seat\n");
    }

    public static boolean bookSeat(char[][] seats, String seatCode) {
        if (seatCode.length() < 2) {
            System.out.println("Invalid seat code!");
            return false;
        }

        char rowChar = seatCode.charAt(0);
        int colNum;
        try {
            colNum = Integer.parseInt(seatCode.substring(1));
        } catch (NumberFormatException e) {
            System.out.println("Invalid seat number!");
            return false;
        }

        int row = rowChar - 'A';
        int col = colNum - 1;

        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            System.out.println("Invalid seat!");
            return false;
        }

        if (seats[row][col] == 'O') {
            seats[row][col] = 'X';
            return true;
        } else {
            System.out.println("Seat " + seatCode + " is already taken!");
            return false;
        }
    }

   public static boolean cancelSeat(char[][] seats, String seatCode) {
        if (seatCode.length() < 2) {
            System.out.println("Invalid seat code!");
            return false;
        }

        char rowChar = seatCode.charAt(0);
        int colNum;
        try {
            colNum = Integer.parseInt(seatCode.substring(1));
        } catch (NumberFormatException e) {
            System.out.println("Invalid seat number!");
            return false;
        }

        int row = rowChar - 'A';
        int col = colNum - 1;

        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            System.out.println("Invalid seat!");
            return false;
        }

        if (seats[row][col] == 'X') {
            seats[row][col] = 'O';
            return true;
        }
	return true;
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


interface Paymentsclass
{
	boolean pay(double amount);
	double getCashback(double amount);
}


class CreditCardPayment implements Paymentsclass {

		
		private String cardNumber, cardHolder;
		public CreditCardPayment(String cardNumber, String cardHolder)
			{
	        		this.cardNumber = cardNumber;
	        		this.cardHolder = cardHolder;
	    		}
		public boolean pay(double amount) 
			{
	        		System.out.println("Processing Credit Card Payment of Rs" + amount + " for " + cardHolder);
	        		return true; 
			}
		public double getCashback(double amount)
		{
			double cashback = (int)(Math.random() * 91) + 10; 
	        		System.out.println("Congratulations! You got Rs" + cashback + " cashback on Credit card .");
	        		return cashback;

		}

		

	}


class UPIPayment implements Paymentsclass
{
    	private String upiId;
    	public UPIPayment(String upiId)
		{
        		this.upiId = upiId;
    		}
    	public boolean pay(double amount) 
		{
        		System.out.println("Processing UPI Payment of Rs" + amount + " via " + upiId);
        		return true;
		}
	public double getCashback(double amount)
	 	{
        		double cashback = (int)(Math.random() * 91) + 10; 
        		System.out.println("Congratulations! You got Rs" + cashback + " cashback on Credit card .");
        		return cashback;
		}
}


class PhonePePayment implements Paymentsclass
{
    	private String phonePeId;
    	public PhonePePayment(String phonePeId) 
		{
        		this.phonePeId = phonePeId;
    		}
    	public boolean pay(double amount)
		 {
        		System.out.println("Processing PhonePe Payment of Rs" + amount + " via " + phonePeId);
        		return true;
    		}
	public double getCashback(double amount)
	 {
        	double cashback = (int)(Math.random() * 91) + 10;
        	System.out.println("Congratulations! You got Rs" + cashback + " cashback on PhonePe .");
        	return cashback;
	}
}


class PaytmPayment implements Paymentsclass
{
    	private String paytmNumber;
    	public PaytmPayment(String paytmNumber)
		 {
        		this.paytmNumber = paytmNumber;
    		}
    	public boolean pay(double amount)
		 {
        		System.out.println("Processing Paytm Payment of Rs" + amount + " linked to " + paytmNumber);
        		return true;
    		}
	public double getCashback(double amount)
	 {
        	double cashback = (int)(Math.random() * 91) + 10; 
        	System.out.println("Congratulations! You got Rs" + cashback + " cashback on Paytm .");
        	return cashback;
	}
}
class Random{
	static Random Ran=new Random();
	double c=(int)(Math.random()*92+10)*1000;
	double a=c;
	Double random2(){
		return this.a;
	}

}

class PaymentDemo 
{	static Random Ran=new Random();
	double m=Ran.random2();
	double me=m;
	int Userpin(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Pin");
		int Upin=sc.nextInt();
		return Upin;
	}
	double money(){
		return this.me;
	}
	public int Submethod() 
	{
        	Scanner sc = new Scanner(System.in);
		
        	System.out.println("Flight Ticket: Rs"+money());
        	double amount = money();
        	System.out.println("Choose Payment Method:");
        	System.out.println("1. Credit Card");
        	System.out.println("2. UPI (GPay)");
        	System.out.println("3. PhonePe");
        	System.out.println("4. Paytm");
		Paymentsclass payment = null;
        	int choice = sc.nextInt();
        	sc.nextLine(); 
		int pin=1234;
		int v=0;
        	switch (choice) 
		{
            		case 1:
			while(true){
                	System.out.println("Enter Card Number: ");
                	String cardNum = sc.nextLine();
			if(cardNum.length()<16 || cardNum.length()>16){
				System.out.println("Invalid card number");
			}
			else{
			System.out.print("Enter Card Holder Name: ");
                	String cardHolder = sc.nextLine();
			if(pin==Userpin()){
                		payment = new CreditCardPayment(cardNum, cardHolder);
				v=1;
			}
			else{
				System.out.println("Invalid Pin");
			}
				break;
			}
			}
                	break;

            		case 2:
			while(true){
                    	System.out.println("Enter UPI ID: ");
                    	String upiId = sc.nextLine();
			if(!upiId.contains("@")){
				System.out.println("Invalid UPI ID");
			}
			else{
			if(pin==Userpin()){
                    		payment = new UPIPayment(upiId);
				v=1;
			}
			else{
				System.out.println("Invalid Pin");
			}
			break;
			}
			}
                    	break;
    		
                	case 3:
			while(true){
                    	System.out.println("Enter PhonePe ID: ");
                    	String phonePeId = sc.nextLine();
			if(!phonePeId.contains("@")){
				System.out.println("Invalid UPI ID");
			}
			else{
			if(pin==Userpin()){
                    		payment = new PhonePePayment(phonePeId);
				v=1;
			}
			else{
				System.out.println("Invalid Pin");
			}
			break;
			}
			}
                    	break;
    	
            		case 4:
			while(true){
                    	System.out.println("Enter Paytm Number: ");
                    	String paytmNum = sc.nextLine();
			if(!paytmNum.matches("^[6-9]\\d{9}$")){
				System.out.println("Invalid paytm number");		
			}
			else{
			if(pin==Userpin()){
                    		payment = new PaytmPayment(paytmNum);
				v=1;
			}
			else{
				System.out.println("Invalid Pin");
			}
			break;
			}
			}
                    	break;

    		        default:
                    	System.out.println("Invalid Payment mode selection! Exiting...");
                    	System.exit(0);
            	}

            if (payment != null && payment.pay(amount)) 
    		{
                double cashback = payment.getCashback(amount);
                System.out.println(" Final Cashback credited Successfully : Rs" + cashback);
		BlinkingPaymentMessage b = new BlinkingPaymentMessage();
        	b.pay();
		return v;
            }
            sc.close();
	return 0;
	}
  }
class BlinkingPaymentMessage {
    final String RESET = "\u001B[0m";
    final String BOLD = "\u001B[1m";
    final String GREEN = "\u001B[32m";
    final String BLINK = "\u001B[5m"; 
    final String CYAN = "\u001B[36m";

    public void pay() {
        System.out.println(BOLD + CYAN + "=====================================" + RESET);

        String message = "  PAYMENT SUCCESSFUL! ";

        
        for (int i = 0; i < 6; i++) { 
            try {
                System.out.print("\r" + BOLD + BLINK + GREEN + message + RESET);
                Thread.sleep(500);
                System.out.print("\r" + " ".repeat(message.length())); 
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Interrupted!");
                return;
            }
        }

       
        System.out.println("\r" + BOLD + GREEN + message + RESET);

        System.out.println(BOLD + CYAN + "=====================================" + RESET);
    }
}

class StyledLoginAnimation {
	final String RESET = "\u001B[0m";
        final String BOLD = "\u001B[1m";
        final String GREEN = "\u001B[32m";
        final String CYAN = "\u001B[36m";
	
	void log(){
   
        System.out.println(BOLD + CYAN + "==============================" + RESET);

        // Animated message
        String message = "  LOGIN SUCCESSFUL!";
        System.out.print(BOLD + GREEN);
        for (char ch : message.toCharArray()) {
	try {
            System.out.print(ch);
            Thread.sleep(200); 
	}
	catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Interrupted!");
                return;
            }

        }
        System.out.println(RESET); 

        // Footer border
        System.out.println(BOLD + CYAN + "==============================" + RESET);

	}
   
}

class StyledSignupAnimation {
	final String RESET = "\u001B[0m";
        final String BOLD = "\u001B[1m";
        final String GREEN = "\u001B[32m";
        final String CYAN = "\u001B[36m";
	
	void log(){
   
        System.out.println(BOLD + CYAN + "==============================" + RESET);

        // Animated message
        String message = "  REGISTRATION SUCCESSFUL!";
        System.out.print(BOLD + GREEN);
        for (char ch : message.toCharArray()) {
	try {
            System.out.print(ch);
            Thread.sleep(200); 
	}
	catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Interrupted!");
                return;
            }

        }
        System.out.println(RESET); // Reset style

        // Footer border
        System.out.println(BOLD + CYAN + "==============================" + RESET);

	}

}

class InvalidPasswordMessage {
    final String RESET = "\u001B[0m";
    final String BOLD = "\u001B[1m";
    final String RED = "\u001B[31m";
    final String BLINK = "\u001B[5m"; 
    final String CYAN = "\u001B[36m";

    public void InvalidPassword() {
        System.out.println(BOLD + CYAN + "=====================================" + RESET);

        String message = "  Invalid Password! ";

        
        for (int i = 0; i < 3; i++) { 
            try {
                System.out.print("\r" + BOLD + BLINK + RED + message + RESET);
                Thread.sleep(500);
                System.out.print("\r" + " ".repeat(message.length())); 
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Interrupted!");
                return;
            }
        }

       
        System.out.println("\r" + BOLD + RED + message + RESET);

        System.out.println(BOLD + CYAN + "=====================================" + RESET);
    }
}

class InvalidUsernameMessage {
    final String RESET = "\u001B[0m";
    final String BOLD = "\u001B[1m";
    final String RED = "\u001B[31m";
    final String BLINK = "\u001B[5m"; 
    final String CYAN = "\u001B[36m";

    public void InvalidUsername() {
        System.out.println(BOLD + CYAN + "=====================================" + RESET);

        String message = "  Invalid User! ";

        
        for (int i = 0; i < 3; i++) { 
            try {
                System.out.print("\r" + BOLD + BLINK + RED + message + RESET);
                Thread.sleep(500);
                System.out.print("\r" + " ".repeat(message.length())); 
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Interrupted!");
                return;
            }
        }

       
        System.out.println("\r" + BOLD + RED + message + RESET);

        System.out.println(BOLD + CYAN + "=====================================" + RESET);
    }
}

class InvalidMobileMessage {
    final String RESET = "\u001B[0m";
    final String BOLD = "\u001B[1m";
    final String RED = "\u001B[31m";
    final String BLINK = "\u001B[5m"; 
    final String CYAN = "\u001B[36m";

    public void InvalidNumber() {
        System.out.println(BOLD + CYAN + "=====================================" + RESET);

        String message = "  Invalid Mobile Number! ";

        
        for (int i = 0; i < 3; i++) { 
            try {
                System.out.print("\r" + BOLD + BLINK + RED + message + RESET);
                Thread.sleep(500);
                System.out.print("\r" + " ".repeat(message.length())); 
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Interrupted!");
                return;
            }
        }

       
        System.out.println("\r" + BOLD + RED + message + RESET);

        System.out.println(BOLD + CYAN + "=====================================" + RESET);
    }
}

class InvalidOtpMessage {
    final String RESET = "\u001B[0m";
    final String BOLD = "\u001B[1m";
    final String RED = "\u001B[31m";
    final String BLINK = "\u001B[5m"; 
    final String CYAN = "\u001B[36m";

    public void InvalidOtp() {
        System.out.println(BOLD + CYAN + "=====================================" + RESET);

        String message = "  Invalid Otp! ";

        
        for (int i = 0; i < 3; i++) { 
            try {
                System.out.print("\r" + BOLD + BLINK + RED + message + RESET);
                Thread.sleep(500);
                System.out.print("\r" + " ".repeat(message.length())); 
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Interrupted!");
                return;
            }
        }

       
        System.out.println("\r" + BOLD + RED + message + RESET);

        System.out.println(BOLD + CYAN + "=====================================" + RESET);
    }
}

class InvalidEmailMessage {
    final String RESET = "\u001B[0m";
    final String BOLD = "\u001B[1m";
    final String RED = "\u001B[31m";
    final String BLINK = "\u001B[5m"; 
    final String CYAN = "\u001B[36m";

    public void InvalidEmail() {
        System.out.println(BOLD + CYAN + "=====================================" + RESET);

        String message = "  Invalid Email Id! ";

        
        for (int i = 0; i < 3; i++) { 
            try {
                System.out.print("\r" + BOLD + BLINK + RED + message + RESET);
                Thread.sleep(500);
                System.out.print("\r" + " ".repeat(message.length())); 
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Interrupted!");
                return;
            }
        }

       
        System.out.println("\r" + BOLD + RED + message + RESET);

        System.out.println(BOLD + CYAN + "=====================================" + RESET);
    }
}
class InvalidDate {
    final String RESET = "\u001B[0m";
    final String BOLD = "\u001B[1m";
    final String RED = "\u001B[31m";
    final String BLINK = "\u001B[5m"; 
    final String CYAN = "\u001B[36m";

    public void InvalidDate1() {
        System.out.println(BOLD + CYAN + "=====================================" + RESET);

        String message = "  Invalid Date Format! ";

        
        for (int i = 0; i < 3; i++) { 
            try {
                System.out.print("\r" + BOLD + BLINK + RED + message + RESET);
                Thread.sleep(500);
                System.out.print("\r" + " ".repeat(message.length())); 
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Interrupted!");
                return;
            }
        }

       
        System.out.println("\r" + BOLD + RED + message + RESET);

        System.out.println(BOLD + CYAN + "=====================================" + RESET);
    }
}
class StyledPasswordChangeAnimation {
	final String RESET = "\u001B[0m";
        final String BOLD = "\u001B[1m";
        final String GREEN = "\u001B[32m";
        final String CYAN = "\u001B[36m";
	
	void PasswordChange(){
   
        System.out.println(BOLD + CYAN + "==============================" + RESET);

        String message = "  Password Updated SuccessFully! ";
        System.out.print(BOLD + GREEN);
        for (char ch : message.toCharArray()) {
	try {
            System.out.print(ch);
            Thread.sleep(200); 
	}
	catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Interrupted!");
                return;
            }

        }
        System.out.println(RESET); 

        // Footer border
        System.out.println(BOLD + CYAN + "==============================" + RESET);

	}

}




class date
{
    public LocalDate SelectDate()
    {
        Scanner sc = new Scanner(System.in);
        LocalDate travelDate = null;
        while (true) {
            System.out.print("Enter travel date (YYYY-MM-DD): ");
            String dateInput = sc.nextLine();

            try {
                travelDate = LocalDate.parse(dateInput);

                if (!travelDate.isBefore(LocalDate.now())) {
                    
                    break;
                } else {
                    System.out.println(CVWelcome.BROWNISH_ORANGE+"Enter present or Future date "+CVWelcome.RESET);
                }

            } catch (DateTimeParseException e) {
                InvalidDate d=new InvalidDate();
			d.InvalidDate1();
            }
        }

        return travelDate;
    }
}
public class CVWelcome {
    public static final String RESET = "\u001B[0m";
    public static final String GRAY = "\u001B[90m";
    public static final String BROWNISH_ORANGE = "\u001B[38;2;168;82;50m";
    public static final String PURPLE = "\u001B[35m";
	
    static void welcome(){
	System.out.println(BROWNISH_ORANGE +
                "          ##        ##    ########   ##         ######     ########     ##                ##     ########    \n" +
                "          ##   ##   ##   ##         ##        ##         ##        ##   ##  ##         ## ##   ##                \n" +
                "          ##   ##   ##   ##         ##        ##         ##        ##   ##    ##      ##  ##   ##            \n" +
                "          ##   ##   ##   ######     ##        ##         ##        ##   ##     ##   ##    ##   #####         \n" +
                "          ##   ##   ##   ##         ##        ##         ##        ##   ##        #       ##   ##               \n" +
                "          ##   ##   ##   ##         ##        ##         ##        ##   ##                ##   ##                \n" +
                "           ###    ###     ########   ########   ######     ########     ##                ##    #########    \n" +
                RESET);

        System.out.println(GRAY +
                "                                        ########    #######        \n" +
                "                                           ##     ##       ##      \n" +
                "                                           ##     ##       ##      \n" +
                "                                           ##     ##       ##      \n" +
                "                                           ##     ##       ##      \n" +
                "                                           ##     ##       ##      \n" +
                "                                           ##       #######        \n"
                + RESET);

        System.out.println(PURPLE +
                "  #######   ##              ##        #####          ##    ##########    ##           ##   ##           ##   ########    ########       \n" +
                " ##          ##            ##       ##     ##        ##    ##     ##     ##           ##   ## #         ##   ##         ##         \n" +
                " ##           ##          ##       ##       ##       ##    ##   ##       ##           ##   ##   ##      ##   ##         ##          \n" +
                " ##            ##        ##       ##         ##      ##    ##  ##        ##           ##   ##     ##    ##   ########   #########    \n" +
                " ##             ##      ##       ##  ######   ##     ##    ##    ##      ##           ##   ##       ##  ##   ##                  ##    \n" +
                " ##               ##  ##        ##            ##     ##    ##      ##    ##           ##   ##         # ##   ##                  ##      \n" +
                "  #######           ###         ##            ##     ##    ##        ##  #########    ##   ##           ##   ########    #########    \n"
                + RESET);

        System.out.println("\nPlease Signup to access your CV Airlines flight dashboard...");
	System.out.println();	
	System.out.println("SIGNUP CREDENTIALS:-");
	System.out.println("-------------------");
	B obj=new B();
	obj.signup();
	}
    public static void main(String[] args) {
 	CVWelcome w=new CVWelcome();
	w.welcome();
    }
}