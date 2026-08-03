public class StyledLoginAnimation {
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
            Thread.sleep(200); // delay between letters (100 ms)
	}
	catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // restore interrupt status
                System.out.println("Interrupted!");
                return;
            }

        }
        System.out.println(RESET); // Reset style

        // Footer border
        System.out.println(BOLD + CYAN + "==============================" + RESET);

	}
    public static void main(String[] args)  {
	StyledLoginAnimation s=new StyledLoginAnimation();
	s.log();
       
    }
}