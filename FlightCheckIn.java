import java.util.Scanner;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;

// 🔹 Abstraction
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

    // 🔹 Encapsulation
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPassportNo() { return passportNo; }
    public String getSeatNo() { return seatNo; }

    // 🔹 Polymorphism (Overridden)
    public abstract String getBenefits();

    public void generateBoardingPass(String flightNo, String destination) {
        String boardingInfo = "BOARDING PASS\n" +
                "Passenger: " + name + "\n" +
                "Age: " + age + "\n" +
                "Passport: " + passportNo + "\n" +
                "Flight: " + flightNo + "\n" +
                "Seat: " + seatNo + "\n" +
                "Destination: " + destination + "\n" +
                "Benefits: " + getBenefits();

        System.out.println("\n==================== BOARDING PASS ====================");
        System.out.println(boardingInfo);
        System.out.println("=======================================================");

        // Generate QR code in console
        generateQR(boardingInfo);
    }

    // 🔹 QR Code (Console Based)
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
            System.out.println("\n✅ Scan this QR code with your phone to view boarding pass details.");
        } catch (WriterException e) {
            System.out.println("❌ Error generating QR: " + e.getMessage());
        }
    }
}

// 🔹 Inheritance
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

// 🔹 Main Flight Check-In System
public class FlightCheckIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("✈ Welcome to Flight Check-In System ✈");
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Passport Number: ");
        String passport = sc.nextLine();

        System.out.print("Enter Flight Number: ");
        String flightNo = sc.nextLine();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter Seat Number: ");
        String seat = sc.nextLine();

        System.out.println("\nChoose Class: ");
        System.out.println("1. Economy");
        System.out.println("2. Business");
        System.out.println("3. First Class");
        int choice = sc.nextInt();

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

        passenger.generateBoardingPass(flightNo, destination);
    }
}