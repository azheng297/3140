import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Scanner;

public class daysCalc {
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

    public static String returnYear(String date, LocalDate today) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        LocalDate selectDate = LocalDate.parse(date+"/"+today.getYear(), formatter);

        if(selectDate.getMonthValue()>=today.getMonthValue()&&
        selectDate.getDayOfMonth()>=today.getDayOfMonth()){
            return date+"/"+today.getYear();
        }else{
            return date+"/"+(today.getYear()+1);
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
            if (input.equals("Y") || input.equals("y")) {
                System.out.println("Enter start date (MM/DD/YYYY): ");
                String first = keyboard.nextLine();
                if (isValidDate(first)) {

                } else if (isValidShortDate(first)) {
                    first = returnYear(first, today);
                } else {
                    System.out.println("Error.");
                    continue;
                }
                System.out.println("Enter end date (MM/DD/YYYY): ");
                String sec = keyboard.nextLine();
                if (isValidDate(sec)) {

                } else if (isValidShortDate(sec)) {
                    sec = returnYear(sec, today);
                } else {
                    System.out.println("Error.");
                    continue;
                }

                LocalDate date1 = LocalDate.parse(first, formatter), date2 = LocalDate.parse(sec, formatter);

                long daysBetween = ChronoUnit.DAYS.between(date1, date2);
                System.out.println("There are " + daysBetween + " days between " + date1 + " and " + date2);
            } else if (input.equals("N") || input.equals("n")) {
                System.out.println("Quiz, Final or Lab?(Q/F/L): ");
                input = keyboard.nextLine();
                if (input.equals("Q") || input.equals("q")) {
                    System.out.println("Enter Quiz Number(1/2/3/4/5): ");
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
                    System.out.println("Enter Lab Number(1/2/3/4): ");
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
                } else if (input.equals("F") || input.equals("f")) {
                    long daysBetween = ChronoUnit.DAYS.between(today, finalExam);
                    System.out.println("The final exam is " + daysBetween + " days from today.");
                } else {
                    System.out.println("Error.");
                }
            } else if (input.equals("Q") || input.equals("q")) {
                break;
            } else {
                System.out.println("Error.");
            }
        }
        keyboard.close();
    }
}