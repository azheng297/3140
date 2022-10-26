import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class daysCalc {
    /*
     * Checks if the date is valid
     * i.e. 05/54/2021 is not valid
     */
    public static boolean isValidDate(String Date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/uuuu");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(Date.trim());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*
     * Checks if shortened dates are valid
     * i.e. 09/70 is not valid
     */
    public static boolean isValidShortDate(String Date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(Date.trim());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*
     * Shortened dates will have a set year depending on:
     * if date is already passed today's date
     * if it is passed this method takes today's year and adds it to the end of the
     * String date
     */
    public static String returnYear(String date, LocalDate today) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        LocalDate selectDate = LocalDate.parse(date + "/" + today.getYear(), formatter);

        if (selectDate.getMonthValue() >= today.getMonthValue() &&
                selectDate.getDayOfMonth() >= today.getDayOfMonth()) {
            return date + "/" + today.getYear();
        } else {
            return date + "/" + (today.getYear() + 1);
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        LocalDate today = LocalDate.now(),
                quiz1 = LocalDate.of(2022, 9, 14),
                quiz2 = LocalDate.of(2022, 9, 28),
                quiz3 = LocalDate.of(2022, 10, 26),
                quiz4 = LocalDate.of(2022, 11, 16),
                quiz5 = LocalDate.of(2022, 12, 7),
                lab1 = LocalDate.of(2022, 9, 28),
                lab2 = LocalDate.of(2022, 10, 26),
                lab3 = LocalDate.of(2022, 11, 23),
                lab4 = LocalDate.of(2022, 12, 7),
                finalExam = LocalDate.of(2022, 12, 19);
        Scanner keyboard = new Scanner(System.in);
        String input = "";

        while (input != "Q") {
            System.out.println("Do you want to enter a custom date? (Y/N) or (Q to quit)");
            input = keyboard.nextLine();
            if (input.equals("Y") || input.equals("y")) { // Checks if user answered yes
                System.out.println("Enter start date (MM/DD/YYYY): ");
                String first = keyboard.nextLine();
                if (isValidDate(first)) { // If statement determines if date is valid
                } else if (isValidShortDate(first)) {
                    first = returnYear(first, today);
                } else {
                    System.out.println("Error.");
                    continue;
                }
                System.out.println("Enter end date (MM/DD/YYYY): ");
                String sec = keyboard.nextLine();
                if (isValidDate(sec)) { // If statement determines if date is valid
                } else if (isValidShortDate(sec)) {
                    sec = returnYear(sec, today);
                } else {
                    System.out.println("Error.");
                    continue;
                }

                LocalDate date1 = LocalDate.parse(first, formatter), date2 = LocalDate.parse(sec, formatter);

                long daysBetween = ChronoUnit.DAYS.between(date1, date2);
                System.out.println("There are " + daysBetween + " days between " + date1 + " and " + date2);
            } else if (input.equals("N") || input.equals("n")) { // checks if user answered no
                System.out.println("Quiz, Final or Lab?(Q/F/L): ");
                input = keyboard.nextLine();
                if (input.equals("Q") || input.equals("q")) {
                    System.out.println("Enter Quiz Number(1/2/3/4/5): "); // prompts the user to select which quiz
                    input = keyboard.nextLine();
                    if (input.equals("1")) {
                        long daysBetween = ChronoUnit.DAYS.between(today, quiz1);
                        System.out.println("Quiz " + input + " is " + daysBetween + " days from today.");
                    } else if (input.equals("2")) {
                        long daysBetween = ChronoUnit.DAYS.between(today, quiz2);
                        System.out.println("Quiz " + input + " is " + daysBetween + " days from today.");
                    } else if (input.equals("3")) {
                        long daysBetween = ChronoUnit.DAYS.between(today, quiz3);
                        System.out.println("Quiz " + input + " is " + daysBetween + " days from today.");
                    } else if (input.equals("4")) {
                        long daysBetween = ChronoUnit.DAYS.between(today, quiz4);
                        System.out.println("Quiz " + input + " is " + daysBetween + " days from today.");
                    } else if (input.equals("5")) {
                        long daysBetween = ChronoUnit.DAYS.between(today, quiz5);
                        System.out.println("Quiz " + input + " is " + daysBetween + " days from today.");
                    } else {
                        System.out.println("Error.");
                    }
                } else if (input.equals("L") || input.equals("l")) {
                    System.out.println("Enter Lab Number(1/2/3/4): "); // prompts the user to select which lab
                    input = keyboard.nextLine();
                    if (input.equals("1")) {
                        long daysBetween = ChronoUnit.DAYS.between(today, lab1);
                        System.out.println("Lab " + input + " is due " + daysBetween + " days from today.");
                    } else if (input.equals("2")) {
                        long daysBetween = ChronoUnit.DAYS.between(today, lab2);
                        System.out.println("Lab " + input + " is due " + daysBetween + " days from today.");
                    } else if (input.equals("3")) {
                        long daysBetween = ChronoUnit.DAYS.between(today, lab3);
                        System.out.println("Lab " + input + " is due " + daysBetween + " days from today.");
                    } else if (input.equals("4")) {
                        long daysBetween = ChronoUnit.DAYS.between(today, lab4);
                        System.out.println("Lab " + input + " is due " + daysBetween + " days from today.");
                    } else {
                        System.out.println("Error.");
                    }
                } else if (input.equals("F") || input.equals("f")) { // This is reached if user wants to know final date
                    long daysBetween = ChronoUnit.DAYS.between(today, finalExam);
                    System.out.println("The final exam is " + daysBetween + " days from today.");
                } else {
                    System.out.println("Error.");
                }
            } else if (input.equals("Q") || input.equals("q")) { // User quits
                break;
            } else {
                System.out.println("Error.");
            }
        }
        keyboard.close();
    }
}