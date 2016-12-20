package homework10;

import java.util.ArrayList;
import java.util.Random;

/**
 * Write a Java class to organize 1000 dates using a 2D ArrayList.
 * <p>
 * • Each date is 3 integers, a month, a day, and then a 2-digit year.
 * <p>
 * Your class must have methods to: <br>
 * • ▬ Store all 1000 dates in a 2D ArrayList <br>
 * • ▬ Remove any invalid dates and output the percentage of dates that were
 * invalid <br>
 * • ▬ Count the number of dates in the year 2016 <br>
 * • ▬ Count the number of dates that occurred before the year 2016 <br>
 * • ▬ Count the number of dates that occurred after the year 2016 <br>
 * • ▬ Reverse the 1000 dates <br>
 * • ▬ Determine the month that has the most dates, regardless of the year <br>
 * • ▬ Count the number of dates that occur on the first day of the month <br>
 * • ▬ Determine the dates that occur on the last day of the month <br>
 * • Determine any dates that occurs more than once <br>
 * • ▬ Sort the 1000 dates in chronological order
 *
 * @author Phil Kappe
 */
public class Homework10
{

    public static void main(String[] args)
    {
        Dates date = new Dates();
        generateDates();

        ArrayList<ArrayList<Integer>> allDates = date.getDates();
        
        System.out.println("The Dates: " + date.getDates());
        System.out.println();
        
        System.out.printf("Percentage of invalid dates: %.2f",
                date.validDates());
        System.out.print("%");
        System.out.println();
        System.out.println();

        System.out.println("There are " + date.twoThousandSixteenDates()
                + " dates IN 2016.");
        System.out.println();

        System.out.println("There are " + date.beforeTwoThousandSixteen()
                + " dates BEFORE 2016.");
        System.out.println();

        System.out.println("There are " + date.afterTwoThousandSixteen()
                + " dates AFTER 2016.");
        System.out.println();

        System.out.println("The month with the most dates is: "
                + date.monthCount());
        System.out.println();

        System.out.println("There are " + date.firstDayOfMonthCount()
                + " dates that occur on the first day of the month.");
        System.out.println();

        System.out.println("The dates that occur on the last day of each month"
                + " are: " + date.lastDayOfMonthDates());
        System.out.println();

        date.sort(allDates);
        System.out.println("Sorted Dates: " + allDates);
        System.out.println();
        
        System.out.println("Dates that occur more than once: " + 
                date.datesMoreThanOnce(allDates));
    }

    /**
     * Randomly generate dates to populate the Dates Class<br>
     * FORMAT: mm/dd/yy
     */
    private static void generateDates()
    {
        Dates date = new Dates();
        Random rand = new Random();
        int totalDates = 1000;

        for (int i = 0; i < totalDates; i++)
        {
            date.addDate(rand.nextInt(12) + 1, rand.nextInt(31) + 1,
                    rand.nextInt(8) + 10);
        }
    }

}
