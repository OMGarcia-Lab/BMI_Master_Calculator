import java.util.Scanner;
import java.util.Date;
import java.util.regex.Pattern;

public class BMI_Master_Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("My CSC 215 BMI Calculator Projects:");
        System.out.println("    1. BMI, English \n    2. BMI, Metric");

        System.out.println(); // To add a gap in between lines //

        System.out.println("[USER MANUAL] Enter an exclamation mark ! to end.");
        System.out.println("Please enter the version you want to try:");
        String userVersion = in.nextLine();
        String normalizedVersion = userVersion.toLowerCase().trim();
        normalizedVersion = normalizedVersion.replaceAll("\\s+", "");

        if (Pattern.compile("en.*sh").matcher(normalizedVersion).find()) {
            System.out.println(); // To add a gap in between lines //

            // TITLE //
            Scanner input = new Scanner(System.in);
            System.out.println("-".repeat(100));
            System.out.printf("%s %n", "-- Welcome to: ");
            System.out.println("--            Body Mass Index (BMI) Calculator, CSC 215, English Version!");
            System.out.println("--                                                            By: Oscar Garcia");
            System.out.println("-".repeat(100));

            System.out.println();

            // Personal Info Section //
            System.out.print("Please enter your full name: ");
            String name = input.nextLine();
            System.out.print("Please enter height in feet and inches for " + name + ": ");
            double heightFeet = input.nextDouble();
            double heightInches = input.nextDouble();
            double height = (heightFeet * 12) + heightInches;
            System.out.print("Please enter your weight in pounds for " + name + ": ");
            double weight = input.nextDouble();


            System.out.println();

            // Summary Section //
            System.out.println("-- SUMMARY REPORT for " + name);
            Date now = new Date();
            System.out.println("-- Date and Time: " + now);
            double BMI = weight / (height * height) * 703;
            System.out.println("-- BMI: " + Math.round(BMI * 100) / 100.0 + " (or " + Math.round(BMI) + " if rounded)");
            if (BMI < 18.5) {
                String messageStatus = "Underweight";
                System.out.println("-- Weight Status: " + messageStatus);
            } else if (BMI > 18.5 && BMI < 24.9) {
                String messageStatus = "Healthy Weight";
                System.out.println("-- Weight Status: " + messageStatus);
            } else if (BMI > 24.9 && BMI < 29.9) {
                String messageStatus = "Overweight";
                System.out.println("-- Weight Status: " + messageStatus);
            } else if (BMI >= 30) {
                String messageStatus = "Obese";
                System.out.println("-- Weight Status: " + messageStatus);
            } else {
                System.out.println("-- Something went wrong. \n -- Please run the program again!");
            }

            System.out.println();

            // Chart Range Section //
            System.out.printf("Please Enter a LOW weight in pounds for " + name + ": ");
            double low = input.nextDouble();
            System.out.printf("Please Enter a HIGH weight in pounds for " + name + ": ");
            double high = input.nextDouble();

            System.out.println();

            // Chart Section //
            System.out.println("-".repeat(45));
            System.out.printf("| %-9s | %-7s | %-20s |%n", "WEIGHT", "BMI", "WEIGHT STATUS");
            System.out.println("-".repeat(44));

            boolean isFirstLine = true;
            for (double weights = low; weights <= high; weights += 5.5) {
                double newBMI = weights / (height * height) * 703;
                double newBMIRound = Math.round(newBMI * 100) / 100.0;
                String messageStatus;
                if (newBMI < 18.5) {
                    messageStatus = "Underweight    ";
                } else if (newBMI > 18.5 && newBMI < 24.9) {
                    messageStatus = "Healthy Weight ";
                } else if (newBMI > 24.9 && newBMI < 29.9) {
                    messageStatus = "Overweight     ";
                } else if (newBMI >= 30) {
                    messageStatus = "Obese         ";
                } else {
                    System.out.println("-- Something went wrong. \n -- Please run the program again!");
                    break;
                }

                if (isFirstLine) {
                    String highlightLOW = String.format("\u001B[30;43m(LOW)\033[0m");
                    System.out.printf("| %-9s | %-7s | %-20s | %n", weights, newBMIRound, messageStatus + highlightLOW);
                    // \033[31;1;43mHello\033[0m, \033[32;1;45mworld!\033[0m
                    isFirstLine = false;
                } else if (weights + 5.5 > high) {
                    String highlighHIGH = String.format("\u001B[30;43m(HIGH)\033[0m");
                    System.out.printf("| %-9s | %-7s | %-20s | %n", weights, newBMIRound, messageStatus + highlighHIGH);
                } else {
                    System.out.printf("| %-9s | %-7s | %-20s | %n", weights, newBMIRound, messageStatus);
                }

            }
            System.out.println("-".repeat(45));

            System.out.println();

            // Goodbye Text //
            System.out.println("The Mashouf Wellness Center is at 755 Font Blvd.");
            System.out.println();
            System.out.println("-".repeat(100));
            System.out.println("-- Thank you for using my program, " + name + "! \n-- Smell ya Later!!!");
            System.out.println("-".repeat(100));
        } else if (Pattern.compile("me.*ic").matcher(normalizedVersion).find()) {
            Scanner input = new Scanner(System.in);

            System.out.println(); // To add a gap in between text //!

            System.out.println("-".repeat(100));
            System.out.printf("%s %n", "-- Welcome to: ");
            System.out.println("--            Body Mass Index (BMI) Calculator, CSC 215, Metric Version!");
            System.out.println("--                                                            By: Oscar Garcia");
            System.out.println("-".repeat(100));

            System.out.println();

            // Personal Info Section //
            System.out.print("Please enter your full name: ");
            String name = input.nextLine();
            System.out.print("Please enter height in centimeter for " + name + ": ");
            double heightCentimeneters = input.nextDouble();
            double height = heightCentimeneters / 100;
            System.out.print("Please enter your weight in kilograms for " + name + ": ");
            double weight = input.nextDouble();


            System.out.println();

            // Summary Section //
            System.out.println("-- SUMMARY REPORT for " + name);
            Date now = new Date();
            System.out.println("-- Date and Time: " + now);
            double BMI = weight / (height * height);
            System.out.println("-- BMI: " + Math.round(BMI * 100) / 100.0 + " (or " + Math.round(BMI) + " if rounded)");
            if (BMI < 18.5) {
                String messageStatus = "Underweight";
                System.out.println("-- Weight Status: " + messageStatus);
            } else if (BMI > 18.5 && BMI < 24.9) {
                String messageStatus = "Healthy Weight";
                System.out.println("-- Weight Status: " + messageStatus);
            } else if (BMI > 24.9 && BMI < 29.9) {
                String messageStatus = "Overweight";
                System.out.println("-- Weight Status: " + messageStatus);
            } else if (BMI >= 30) {
                String messageStatus = "Obese";
                System.out.println("-- Weight Status: " + messageStatus);
            } else {
                System.out.println("-- Something went wrong. \n -- Please run the program again!");
            }

            System.out.println();

            // Chart Range Section //
            System.out.printf("Please Enter a LOW weight in kilograms for " + name + ": ");
            double low = input.nextDouble();
            System.out.printf("Please Enter a HIGH weight in kilograms for " + name + ": ");
            double high = input.nextDouble();

            System.out.println();

            // Chart Section //
            System.out.println("-".repeat(45));
            System.out.printf("| %-9s | %-7s | %-20s |%n", "WEIGHT", "BMI", "WEIGHT STATUS");
            System.out.println("-".repeat(44));

            boolean isFirstLine = true;
            for (double weights = low; weights <= high; weights += 2.5) {
                double newBMI = weights / (height * height);
                double newBMIRound = Math.round(newBMI * 100.0) / 100.0;
                String messageStatus;
                if (newBMI < 18.5) {
                    messageStatus = "Underweight    ";
                } else if (newBMI > 18.5 && newBMI < 24.9) {
                    messageStatus = "Healthy Weight ";
                } else if (newBMI > 24.9 && newBMI < 29.9) {
                    messageStatus = "Overweight    ";
                } else if (newBMI >= 30) {
                    messageStatus = "Obese         ";
                } else {
                    System.out.println("-- Something went wrong. \n-- Please run the program again!");
                    break;
                }

                if (isFirstLine) {
                    String highlightLOW = String.format("\u001B[30;43m(LOW)\033[0m");
                    System.out.printf("| %-9s | %-7s | %-20s | %n", weights, newBMIRound, messageStatus + highlightLOW);
                    // \033[31;1;43mHello\033[0m, \033[32;1;45mworld!\033[0m
                    isFirstLine = false;
                } else if (weights + 2.5 > high) {
                    String highlighHIGH = String.format("\u001B[30;43m(HIGH)\033[0m");
                    System.out.printf("| %-9s | %-7s | %-20s | %n", weights, newBMIRound, messageStatus + highlighHIGH);
                } else {
                    System.out.printf("| %-9s | %-7s | %-20s | %n", weights, newBMIRound, messageStatus);
                }

            }
            System.out.println("-".repeat(45));

            System.out.println();

            // Goodbye Text //
            System.out.println("The Mashouf Wellness Center is at 755 Font Blvd.");
            System.out.println();
            System.out.println("-".repeat(100));
            System.out.println("-- Thank you for using my program, " + name + "! \n-- Pip pip, Cheerio!!!");
            System.out.println("-".repeat(100));
        } else if (userVersion.equals("!")) {
            System.out.println("Exiting Code...");
            return;
        } else {
            System.out.println("Invalid Input! Please try again.");
        }
    }
}
