import java.util.Scanner;

public class MonthlyTemperatures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays to hold month names and temps
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        double[] monthTemps = new double[12];

        // Collect temperatures for each month
        System.out.println("Please enter the average temperature for each month:");
        for (int i = 0; i < monthNames.length; i++) {
            System.out.print(monthNames[i] + ": ");
            monthTemps[i] = scanner.nextDouble();
        }

        // Select month or year stats
        System.out.println("\nWhat month would you like to see the temperature for?");
        System.out.println("Or type 'year' to see all months and yearly stats.");
        String userChoice = scanner.next();

        if (userChoice.equalsIgnoreCase("year")) {
            double sumTemps = 0;
            double maxTemp = monthTemps[0];
            double minTemp = monthTemps[0];
            String maxMonth = monthNames[0];
            String minMonth = monthNames[0];

            System.out.println("\nTemperatures for the year:");
            for (int i = 0; i < monthNames.length; i++) {
                System.out.println(monthNames[i] + ": " + monthTemps[i]);
                sumTemps += monthTemps[i];

                if (monthTemps[i] > maxTemp) {
                    maxTemp = monthTemps[i];
                    maxMonth = monthNames[i];
                }
                if (monthTemps[i] < minTemp) {
                    minTemp = monthTemps[i];
                    minMonth = monthNames[i];
                }
            }

            double avgYear = sumTemps / monthNames.length;
            System.out.println("\nYearly Average Temperature: " + avgYear);
            System.out.println("Highest Average: " + maxTemp + " (" + maxMonth + ") - That's pretty darn hot!");
            System.out.println("Lowest Average: " + minTemp + " (" + minMonth + ") - Brrr, that's chilly!");
        } else {
            boolean matchFound = false;
            for (int i = 0; i < monthNames.length; i++) {
                if (userChoice.equalsIgnoreCase(monthNames[i])) {
                    System.out.println(monthNames[i] + ": " + monthTemps[i]);
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                System.out.println("That doesn't seem like a month, try something else.");
            }
        }

        scanner.close();
    }
}