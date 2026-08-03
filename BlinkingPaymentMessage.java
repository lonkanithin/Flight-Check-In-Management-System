public class BlinkingPaymentMessage {
    final String RESET = "\u001B[0m";
    final String BOLD = "\u001B[1m";
    final String GREEN = "\u001B[32m";
    final String BLINK = "\u001B[5m"; // ANSI blink code
    final String CYAN = "\u001B[36m";

    public void pay() {
        System.out.println(BOLD + CYAN + "=====================================" + RESET);

        String message = "  PAYMENT SUCCESSFUL! ";

        // Blink the message for a few seconds
        for (int i = 0; i < 6; i++) { // blinks 3 times
            try {
                System.out.print("\r" + BOLD + BLINK + GREEN + message + RESET);
                Thread.sleep(500);
                System.out.print("\r" + " ".repeat(message.length())); // clear
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // restore interrupt status
                System.out.println("Interrupted!");
                return;
            }
        }

        // Final steady message
        System.out.println("\r" + BOLD + GREEN + message + RESET);

        System.out.println(BOLD + CYAN + "=====================================" + RESET);
    }

    public static void main(String[] args) {
        BlinkingPaymentMessage b = new BlinkingPaymentMessage();
        b.pay();
    }
}
