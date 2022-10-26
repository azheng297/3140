import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class daysCalc{
    public static void main(String[] args) throws IOException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter start date (MM/DD/YYYY): ");
        String first = input.readLine();
        System.out.println("Enter end date (MM/DD/YYYY): ");
        String sec = input.readLine();

        LocalDate date1 = LocalDate.parse(first, formatter), date2 = LocalDate.parse(sec, formatter);

        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("There are "+daysBetween+" days between "+date1+" and "+date2);
    }
}