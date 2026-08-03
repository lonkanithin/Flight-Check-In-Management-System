import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;

public class ConsoleBoardingPassQR {
    public static void generateBoardingPassQR(String passengerName, String flightNo, String seat, String destination) {
        try {
            // Boarding pass details
            String qrText = "BOARDING PASS\n" +
                            "Passenger: " + passengerName + "\n" +
                            "Flight: " + flightNo + "\n" +
                            "Seat: " + seat + "\n" +
                            "Destination: " + destination;

            // Create QR Code
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrText, BarcodeFormat.QR_CODE, 30, 30);

            // Print QR in console (ASCII Art)
            for (int y = 0; y < bitMatrix.getHeight(); y++) {
                for (int x = 0; x < bitMatrix.getWidth(); x++) {
                    System.out.print(bitMatrix.get(x, y) ? "██" : "  ");
                }
                System.out.println();
            }

            System.out.println("\n✅ Scan this QR code with your mobile scanner to view boarding pass details.");

        } catch (WriterException e) {
            System.out.println("❌ Error generating QR: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example passenger
        generateBoardingPassQR("John Doe", "AI202", "12B", "Mumbai");
    }
}