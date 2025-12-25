import java.util.Scanner;

public class MonthlyTemperatures {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

       
        double[] monthTemps = new double[12];

      //Collect temperatures using loop 
        System.out.println("Please enter the average temperature for each month:");
        for (int i = 0; i < monthNames.length; i++) {
            System.out.print(monthNames[i] + ": ");
            monthTemps[i] = scanner.nextDouble();
        }

     //ask  user what they want to see 
        System.out.println("\nEnter a month name to view its temperature,");
        System.out.println("or type 'year' to view all temperatures and yearly stats.");
        String userChoice = scanner.next();

      
        if (userChoice.equalsIgnoreCase("year")) {

        
            double sumTemps = monthTemps[0];
            double maxTemp = monthTemps[0];
            double minTemp = monthTemps[0];
            String maxMonth = monthNames[0];
            String minMonth = monthNames[0];

            System.out.println("\nTemperatures for the year:");

            // Loop through remaining months.
            for (int i = 1; i < monthNames.length; i++) {
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

            // Display results.
            System.out.println("\nYearly Average Temperature: " + avgYear);
            System.out.println("Highest Average: " + maxTemp + " (" + maxMonth + ")");
            System.out.println("Lowest Average: " + minTemp + " (" + minMonth + ")");

        } else {

            // Search for the month the user entered.
            boolean matchFound = false;

            for (int i = 0; i < monthNames.length; i++) {
                if (userChoice.equalsIgnoreCase(monthNames[i])) {
                    System.out.println(monthNames[i] + ": " + monthTemps[i]);
                    matchFound = true;
                    break; // Stop loop once match is found.
                }
            }

            // If no match was found, notify the user.
            if (!matchFound) {
                System.out.println("That doesn't seem like a valid month.");
            }
        }

        scanner.close(); // Good practice: close resources.
    }
}
