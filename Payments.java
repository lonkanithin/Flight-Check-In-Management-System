import java.util.Scanner;
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
	        		System.out.println("Processing Credit Card Payment of Rs" + amount 			+ " for " + cardHolder);
	        		return true; 
			}
		public double getCashback(double amount)
		{
			double cashback = (int)(Math.random() * 91) + 10; 
	        		System.out.println("Congratulations! You got Rs" + cashback + " 						cashback on Credit card .");
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
{	
	int Userpin(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Pin");
		int Upin=sc.nextInt();
		return Upin;
	}
	public int Submethod() 
	{
        	Scanner sc = new Scanner(System.in);
		Random Ran=new Random();
        	System.out.println("Flight Ticket: Rs"+Ran.random2());
        	double amount = Ran.random2();
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
                	System.out.print("Enter Card Number: ");
                	String cardNum = sc.nextLine();
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

            		case 2:
                    	System.out.print("Enter UPI ID: ");
                    	String upiId = sc.nextLine();
			if(pin==Userpin()){
                    		payment = new UPIPayment(upiId);
				v=1;
			}
			else{
				System.out.println("Invalid Pin");
			}
                    	break;
    		
                	case 3:
                    	System.out.print("Enter PhonePe ID: ");
                    	String phonePeId = sc.nextLine();
			if(pin==Userpin()){
                    		payment = new PhonePePayment(phonePeId);
				v=1;
			}
			else{
				System.out.println("Invalid Pin");
			}
                    	break;
    	
            		case 4:
                    	System.out.print("Enter Paytm Number: ");
                    	String paytmNum = sc.nextLine();
			if(pin==Userpin()){
                    		payment = new PaytmPayment(paytmNum);
				v=1;
			}
			else{
				System.out.println("Invalid Pin");
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
		return v;
            }
            sc.close();
	return 0;
	}
  }

public class Payments{
	
	public static void main(String[] args)
	{
		PaymentDemo ob=new PaymentDemo();
		
		System.out.println(ob.Submethod());
	}
}