package bank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankStatementAnalyser {

    public static void main(String[] args) {
        String fileName = "Jan2023.txt"; // Change this to the actual file name

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;
            List<Double> depositAmounts = new ArrayList<>();
            List<Double> withdrawalAmounts = new ArrayList<>();
            double maxDeposit = 0;
            double shoppingExpenses = 0;
            double maxWithdrawalAmount = 0;
            String maxWithdrawalDate = "";

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the header line
                }
                String[] parts = line.split(",");
                double deposit = Double.parseDouble(parts[3]);
                double withdrawal = Double.parseDouble(parts[2]);

                if (deposit > 0) {
                    depositAmounts.add(deposit);
                    if (deposit > maxDeposit) {
                        maxDeposit = deposit;
                    }
                }

                if (withdrawal > 0) {
                    withdrawalAmounts.add(withdrawal);
                    if (parts[1].equalsIgnoreCase("Shopping")) {
                        shoppingExpenses += withdrawal;
                    }
                    if (withdrawal > maxWithdrawalAmount) {
                        maxWithdrawalAmount = withdrawal;
                        maxWithdrawalDate = parts[0];
                    }
                }
            }

            double sumOfDeposits = depositAmounts.stream().mapToDouble(Double::doubleValue).sum();
            System.out.println("Sum of all deposits = " + sumOfDeposits);
            System.out.println("Max deposit amount = " + maxDeposit);
            System.out.println("Shopping expenses = " + shoppingExpenses);
            System.out.println("Date on which max amount withdrawn = " + maxWithdrawalDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
