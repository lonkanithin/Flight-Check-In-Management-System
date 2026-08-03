import java.util.*;

public class AirlineSeats{

    public static void main(String[] args) {
        startAirlineSystem();
    }

    public static void startAirlineSystem() {
        Scanner sc = new Scanner(System.in);

        char[][] seats = new char[6][9]; 
        for (int i = 0; i < seats.length; i++) {
            Arrays.fill(seats[i], 'O'); 
        }
	
            clearScreen();
            displaySeats(seats);

            System.out.print("Enter seat to book (e.g. B3) or 'exit' to quit: ");
            String input = sc.nextLine().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("\n  Thank you for using the Airline Booking System!");
		
            }

            bookSeat(seats, input);
        	clearScreen();
            displaySeats(seats);

        sc.close();
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


    public static void bookSeat(char[][] seats, String seatCode) {
        if (seatCode.length() < 2) {
            System.out.println(" Invalid seat code!");
            return;
        }

        char rowChar = seatCode.charAt(0);
        int colNum = Character.getNumericValue(seatCode.charAt(1));

        int row = rowChar - 'A';
        int col = colNum - 1;

        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            System.out.println(" Invalid seat!");
            return;
        }

        if (seats[row][col] == 'O') {
            seats[row][col] = 'X';
            System.out.println("Seat " + seatCode + " successfully booked!");
        } else {
            System.out.println("Seat " + seatCode + " is already taken!");
        }
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
