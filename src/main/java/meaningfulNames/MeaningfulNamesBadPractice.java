package meaningfulNames;

import java.util.HashMap;
import java.util.Map;

public class MeaningfulNamesBadPractice {

    static class Handler {

        private final String pg;
        private final Map<String, Double> txHist;

        public Handler(String pg) {
            this.pg = pg;
            this.txHist = new HashMap<>();
        }

        public void process(String cName, double amt) {
            System.out.println("Pmt process $" + amt + " for customer " + cName + " via " + pg);
            txHist.put(cName, txHist.getOrDefault(cName, 0.0) + amt);
        }

        public void refund(String cName, double amt) {
            System.out.println("Refund $" + amt + " for customer " + cName);
            double cBal = txHist.getOrDefault(cName, 0.0);
            if (cBal >= amt) {
                txHist.put(cName, cBal - amt);
            } else {
                System.out.println("Insufficient balance to refund.");
            }
        }

        public void generateReceipt(String cName) {
            double total = txHist.getOrDefault(cName, 0.0);
            System.out.println("Generating receipt for customer " + cName + " for total $" + total);
        }

        public static void main(String[] args) {
            Handler ph = new Handler("Stripe");
            ph.process("Alice", 100.0);
            ph.process("Bob", 150.0);
            ph.refund("Alice", 50.0);
            ph.generateReceipt("Alice");
            ph.generateReceipt("Bob");
        }
    }

}
