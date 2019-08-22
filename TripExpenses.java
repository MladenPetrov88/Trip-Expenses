import java.util.Scanner;

public class TripExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int daysOfTrip = Integer.parseInt(scan.nextLine());
        double moneyLeft = 0.0;
        for (int i = 0; i < daysOfTrip; i++) {
            double dayLimit = 60 + moneyLeft;
            moneyLeft = 0;
            String input = scan.nextLine();
            int products = 0;
            while (!"Day over".equals(input)) {
                double price = Double.parseDouble(input);
                if (dayLimit - price >= 0) {
                    dayLimit -= price;
                    products++;
                } else {
                    input = scan.nextLine();
                    continue;
                }
                if (dayLimit == 0) {
                    break;
                }
                input = scan.nextLine();
            }
            if ("Day over".equals(input)) {
                moneyLeft = Math.abs(moneyLeft - dayLimit);
                System.out.println(String.format("Money left from today: %.2f. You've bought %d products.", moneyLeft, products));
            } else {
                System.out.println(String.format("Daily limit exceeded! You've bought %d products.", products));
            }
        }
    }
}
