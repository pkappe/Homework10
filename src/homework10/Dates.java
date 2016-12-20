package homework10;

import java.util.ArrayList;

/**
 * This Class is used to manipulate data from a list passed into the class. To
 * add dates, use the addDate(month, day, year) method. The dates that are
 * stored in this class can be used for multiple methods stored.
 *
 * @author Phil Kappe
 */
class Dates
{

    private static ArrayList<ArrayList<Integer>> dates;

    /**
     * Constructor to initialize the dates ArrayList in this class.
     */
    public Dates()
    {
        dates = new ArrayList<>();
    }

    /**
     * Adds a date to the ArrayList in this class.
     *
     * @param month The month of the date
     * @param day The day of the date
     * @param year The year of the date
     */
    public void addDate(int month, int day, int year)
    {
        ArrayList<Integer> currentDate = new ArrayList<>();

        currentDate.add(month);
        currentDate.add(day);
        currentDate.add(year);

        dates.add(currentDate);
    }

    /**
     * An ArrayList of the current dates stored in this class.
     *
     * @return The ArrayList of dates
     */
    public ArrayList<ArrayList<Integer>> getDates()
    {
        ArrayList<ArrayList<Integer>> tempDates = new ArrayList<>();

        for (int i = 0; i < dates.size(); i++)
        {
            tempDates.add(dates.get(i));
        }
        return tempDates;
    }

    /**
     * Prints out the dates stored in this Class to the console.
     */
    public void printDates()
    {
        for (int i = 0; i < dates.size(); i++)
        {
            System.out.println(dates.get(i));
        }
    }

    /**
     * Iterates through all the dates stored in this class to find which dates
     * occurred on 2016.
     *
     * @return The amount of dates falling on 2016
     */
    public int twoThousandSixteenDates()
    {
        int count = 0;
        for (int i = 0; i < dates.size(); i++)
        {
            if (dates.get(i).get(2) == 16)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Iterates through all the dates stored in this class to find which dates
     * occurred BEFORE 2016.
     *
     * @return The amount of dates before 2016.
     */
    public int beforeTwoThousandSixteen()
    {
        int count = 0;
        for (int i = 0; i < dates.size(); i++)
        {
            if (dates.get(i).get(2) < 16)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Iterates through all the dates stored in this class to find which dates
     * occurred AFTER 2016
     *
     * @return
     */
    public int afterTwoThousandSixteen()
    {
        int count = 0;
        for (int i = 0; i < dates.size(); i++)
        {
            if (dates.get(i).get(2) > 16)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Finds which dates in the ArrayList, for this class, are not valid. After
     * invalid dates are found, they are removed from the list. After the date
     * is removed from the ArrayList, 1 is added to a value to find the total
     * percentage of dates that was removed from the ArrayList.
     * <p>
     *
     * DAYS IN EACH MONTH <br>
     * 1. January 31 <br>
     * 2. February 28*<br>
     * 3. March 31<br>
     * 4. April 30<br>
     * 5. May 31<br>
     * 6. June 30<br>
     * 7. July 31<br>
     * 8. August 31<br>
     * 9. Sept 30<br>
     * 10. October 31<br>
     * 11. November 30<br>
     * 12. December 31<br>
     *
     * @return The percentage of dates that were invalid.
     */
    public double validDates()
    {
        ArrayList<Integer> date = new ArrayList<>();
        double invalidCount = 0;
        double datesSize = dates.size();
        for (int i = 0; i < dates.size(); i++)
        {
            date = dates.get(i);
            if (date.get(0) != null)
            {
                switch (date.get(0))
                {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (!(date.get(1) <= 31))
                        {
                            dates.remove(i);
                            invalidCount++;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (!(date.get(1) <= 30))
                        {
                            dates.remove(i);
                            invalidCount++;
                        }
                        break;
                    case 2:
                        if (isLeapYear(date.get(0)))
                        {
                            if (!(date.get(1) <= 29))
                            {
                                dates.remove(i);
                                invalidCount++;
                            }

                        }
                        else
                        {
                            if (!(date.get(1) <= 28))
                            {
                                dates.remove(i);
                                invalidCount++;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        return (invalidCount / datesSize) * 100;
    }

    /**
     * Check if the year passed in is a leap year. Leap years occur every 4
     * years. This method checks from 2016 (the most recent leap year) to 1970
     * to see if the year passed in falls on one of those years.
     *
     * @param year The year to check
     * @return True if the year passed in is a leap year.
     */
    public boolean isLeapYear(int year)
    {
        for (int i = 2016; i > 1970; i = i - 4)
        {
            if (year == i)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Reverses the order of the dates ArrayList passed in.
     *
     * @param startArray The ArrayList to reverse.
     * @return An ArrayList that is in reversed order from startArray.
     */
    public ArrayList<ArrayList<Integer>> reverseDates(
            ArrayList<ArrayList<Integer>> startArray)
    {
        ArrayList<ArrayList<Integer>> rDates
                = new ArrayList<>();

        for (int i = startArray.size() - 1; i > 0; i--)
        {
            rDates.add(startArray.get(i));
        }

        return rDates;
    }

    /**
     * Iterates through the dates ArrayList in this class to determine the month
     * that has the most dates, regardless of year.
     *
     * @return The month with the most dates
     */
    public String monthCount()
    {
        // Add the count of each month to an Array
        int[] monthCounts = new int[12];
        for (int i = 0; i < dates.size(); i++)
        {
            int monthIndex = (dates.get(i).get(0) - 1);
            monthCounts[monthIndex] += 1;
        }

        // Find which count is the highest in the month count Array
        int winningMonthCount = 0;
        for (int month : monthCounts)
        {
            if (month > winningMonthCount)
            {
                winningMonthCount = month;
            }
        }

        // Find the index of the highest winning month
        int winningMonthIndex = 0;
        for (int i = 0; i < monthCounts.length; i++)
        {
            if (monthCounts[i] == winningMonthCount)
            {
                winningMonthIndex = i;
            }
        }

        // Return the month based on the highest winning index
        switch (winningMonthIndex)
        {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";

        }
        return "";
    }

    /**
     * Counts the number of dates that occur on the first day of the month.
     *
     * @return The number of dates that occurred on the first day of the month.
     */
    public int firstDayOfMonthCount()
    {
        int dateCount = 0;
        for (int i = 0; i < dates.size(); i++)
        {
            if (dates.get(i).get(1) == 1)
            {
                dateCount++;
            }

        }
        return dateCount;
    }

    /**
     * Checks which dates in the list pass in, occur on the last day of the
     * month
     *
     * @return An array of the dates which occur on the last month of the year
     */
    public ArrayList<ArrayList<Integer>> lastDayOfMonthDates()
    {
        ArrayList<ArrayList<Integer>> theDates = new ArrayList<>();

        for (int i = 0; i < dates.size(); i++)
        {
            if (dates.get(0) != null)
            {
                switch (dates.get(i).get(0))
                {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (dates.get(i).get(1) == 31)
                        {
                            theDates.add(dates.get(i));
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (dates.get(i).get(1) == 30)
                        {
                            theDates.add(dates.get(i));
                        }
                        break;
                    case 2:
                        if (isLeapYear(dates.get(i).get(0)))
                        {
                            if (dates.get(i).get(1) == 29)
                            {
                                theDates.add(dates.get(i));
                            }

                        }
                        else
                        {
                            if (dates.get(i).get(1) == 28)
                            {
                                theDates.add(dates.get(i));
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        return theDates;
    }

    // Variables used in merge sorting methods.
    private ArrayList<ArrayList<Integer>> startArray;
    private ArrayList<ArrayList<Integer>> tempMergArr;

    /**
     * Used to sort an array list of dates in the format: MM/DD/YY<br>
     * Dates are first sorted by day, then month, then year.
     *
     * @param startArray The ArrayList to sort
     * @return Sorted ArrayList of dates in ascending order.
     */
    public void sort(ArrayList<ArrayList<Integer>> inputArr)
    {
        startArray = inputArr;
        tempMergArr = new ArrayList<>();

        int monthIndex = 0;
        int dayIndex = 1;
        int yearIndex = 2;

        int length = startArray.size();
        doMergeSort(0, length - 1, dayIndex);
        doMergeSort(0, length - 1, monthIndex);
        doMergeSort(0, length - 1, yearIndex);
    }

    /**
     * Recursive method to find the indices of the two halves before merge sort.
     *
     * @param lowerIndex The index to start the sorting process
     * @param higherIndex The index to end the sorting process
     * @param datePosition Which portion of the date to sort by. Date format
     * must be MM/DD/YY. EXAMPLE: Index 1 would sort the days in the list.
     */
    private void doMergeSort(int lowerIndex, int higherIndex, int datePosition)
    {
        if (lowerIndex < higherIndex)
        {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle, datePosition);
            doMergeSort(middle + 1, higherIndex, datePosition);
            mergeParts(lowerIndex, middle, higherIndex, datePosition);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex,
            int datePosition)
    {

        for (int i = lowerIndex; i <= higherIndex; i++)
        {
            tempMergArr.add(i, startArray.get(i));
        }

        int i = lowerIndex; // First index of the first array
        int j = middle + 1; // First index of the second array
        int k = lowerIndex; // First index of the merged array

        // Move the smaller element in each array to the start of the merged
        // array
        while (i <= middle && j <= higherIndex)
        {
            if (tempMergArr.get(i).get(datePosition)
                    <= tempMergArr.get(j).get(datePosition))
            {
                startArray.set(k, tempMergArr.get(i));
                i++;
            }
            else
            {
                startArray.set(k, tempMergArr.get(j));
                j++;
            }
            k++;
        }

        // Merge the two arrays together
        while (i <= middle)
        {
            startArray.set(k, tempMergArr.get(i));
            k++;
            i++;
        }

    }

    /**
     * Checks an array to see if the dates passed in occurred more than once.
     *
     * @param array The array to evaluate
     * @return An array of the dates which occurred more than once
     */
    public ArrayList<ArrayList<Integer>> datesMoreThanOnce(
            ArrayList<ArrayList<Integer>> array)
    {
        ArrayList<ArrayList<Integer>> tempList = new ArrayList<>();

        // Sort the array to help find dates that occur more than once
        sort(array);

        for (int i = 0; i < array.size() - 1; i = i + 2)
        {
            if (array.get(i).equals(array.get(i + 1)))
            {
                if (!tempList.contains(array.get(i)))
                {
                    tempList.add(array.get(i));
                }
            }
        }
        return tempList;
    }

}
