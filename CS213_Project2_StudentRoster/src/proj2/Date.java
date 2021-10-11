/**
 * 
 */
package proj2;

/**
 * @author Stephen Danso, Sri Vishnu Jayakumar
 *
 */
import java.util.Calendar;


public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    private static final int QUADRENNIAL = 4;
    private static final int CENTENNIAL = 100;
    private static final int QUATERCENTENNIAL = 400;
    private static final int MAXYEAR = 2021;
    
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;
    

    /**
     * helper method to get the year 
     * @return int of the year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * helper method to get the month
     * @return an int of the month
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * helper method to get the day
     * @return int of the day
     */
    public int getDay() {
        return this.day;
    }



    /**
     * Used to create a Date Object with variables taken by a string parameter in a certain format.
     * @param date takes a String in mm/dd/yyyy format.
     */
    public Date(String date) {
        String[] correctDate = date.split("/");
        this.year = Integer.parseInt(correctDate[2]);
        this.month = Integer.parseInt(correctDate[0]);
        this.day = Integer.parseInt(correctDate[1]);
    }

    /**
     * Create Date object with today's date
     */
    public Date() {
        Calendar calendar = Calendar.getInstance();
        Date today = Date.this;
        today.year = calendar.get(Calendar.YEAR);
        today.month = calendar.get(Calendar.MONTH) + 1;
        today.day = calendar.get(Calendar.DATE);
    }

    /**
    Checks if a date in leap year is valid.
    @param date input date
    @return true if leap year.
    */
    public boolean leapYearDateValid(Date date) {
        if ((date.month == FEBRUARY) && (date.day > 29
                || date.day < 1)) {
            return false;
        } else if ((date.month == APRIL || date.month == JUNE 
        		|| date.month == SEPTEMBER
                || date.month == NOVEMBER) &&
                (date.day > 30 || date.day < 1)) {
            return false;
        } else if ((date.month == JANUARY || date.month == MARCH 
        		|| date.month == MAY
                || date.month == JULY || date.month == AUGUST
                || date.month == OCTOBER || date.month == DECEMBER)
                && (date.day > 31 || date.day < 1)) {
            return false;
        }
        return true;
    }

    /**
    Check if a date in non leap year is valid
    @param date input date
    @return true non leap year.
    */
    public boolean nonLeapYear(Date date) {
        if ((date.month == FEBRUARY) && (date.day > 28
                || date.day < 1)) {
            return false;
        } else if ((date.month == APRIL || date.month == JUNE || date.month == SEPTEMBER
                || date.month == NOVEMBER) && (date.day > 30
                || date.day < 1)) {
            return false;
        } else if ((date.month == JANUARY || date.month == MARCH || date.month == MAY
                || date.month == JULY || date.month == AUGUST
                || date.month == OCTOBER || date.month == DECEMBER)
                && (date.day > 31 || date.day < 1)) {
            return false;
        }
        return true;
    }

    /**
     * Method to see if a date is valid date to be used
     * Date with the year less than 2021 or a date beyond today is invalid.
     * @return boolean true if it is a valid date false if not
     */
    public boolean isValid(Date date) {
        boolean leapYear = false;
        Date today = new Date();
        if (date.month > 12 || date.month <= 0 
        		|| date.year <= 0 || date.day <= 0) {
            return false;
        }
        if (date.year > today.year) {
            return false;
        } else if ((date.year == today.year) 
        		&& (date.month > today.month)) {
            return false;
        } else if ((date.year == today.year) && 
        		(date.month == today.month) 
        		&& (date.day > today.day)) {
            return false;
        }
        if (date.year < MAXYEAR) {
            return false;
        }
        if (date.year % QUADRENNIAL == 
        		0 && date.year % CENTENNIAL != 0) {
            leapYear = true;
        } else if ((date.year % QUADRENNIAL == 0) && 
        		(date.year % CENTENNIAL != 0)
                && (date.year % QUATERCENTENNIAL == 0)) {
            leapYear = true;
        }
        if (leapYear) {
            return leapYearDateValid(date);
        } else {
            return nonLeapYear(date);
        }
    }


    /**
     * Compare dates
     * @param date date to be compared
     * @return 1 if left bigger, -1 if right bigger
     */
    @Override
    public int compareTo(Date date) {
        if (this.year != date.year) {
            return this.year > date.year ? 1 
            		: this.year < date.year ? -1 : 0;
        } else {
            if (this.month != date.month) {
                return this.month > date.month ? 1 
                		: this.month < date.month ? -1 : 0;
            } else {
                return this.day > date.day ? 1 
                		: this.day < date.day ? -1 : 0;
            }
        }
    }

    /**
     * Method for date in mm/dd/yyyy format.
     * @return string in the right format.
     */
    @Override
    public String toString() {
        return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
    }
        
        
        public static void main(String[] args){
            
            Boolean result;
            //testing isValid() method
            System.out.println("Testing isValid()...\n");
            

            System.out.println("Testing case #1...");
            Date dateCase1 = new Date("14/11/2017"); //invalid test date because month is too large
            System.out.println("Enter date with month outside valid range: " + dateCase1);
            result = dateCase1.isValid(dateCase1);
            if(result){
                System.out.println("PASS.");
            }
            else{
                System.out.println("FAIL.");
            }
            System.out.println("Testing case #2...");//lower than 1980 so fail
            Date dateCase2 = new Date("4/9/1965");
            System.out.println("Enter date inside valid range: " + dateCase2);
            result = dateCase2.isValid(dateCase2);
            if(result){
                System.out.println("PASS.");
            }
            else{
                System.out.println("FAIL.");
            }

            System.out.println("Testing case #3...");
            Date dateCase3 = new Date("0/45/2014"); //invalid test date because month is too small
            System.out.println("Enter date with day outside valid range (month too small): " + dateCase3);
            result = dateCase3.isValid(dateCase3);
            if(result){
                System.out.println("PASS.");
            }
            else{
                System.out.println("FAIL.");
            }

            System.out.println("Testing case #4...");
            Date dateCase4 = new Date("3/56/2015"); //invalid test date because day is too large
            System.out.println("Enter date with day outside valid range: " + dateCase4);
            result = dateCase4.isValid(dateCase4);
            if(result){
                System.out.println("PASS.");
            }
            else{
                System.out.println("FAIL.");
            }



            System.out.println("Testing case #5...");
            Date dateCase5 = new Date("2/29/2020"); //valid test date because leap year
            System.out.println("Insert leap date on leap year: " + dateCase5);
            result = dateCase5.isValid(dateCase5);
            if(result){
                System.out.println("PASS.");
            }
            else{
                System.out.println("FAIL.");
            }

            System.out.println("Testing case #6...");
            Date dateCase6 = new Date("2/29/2021"); //invalid test date because not a leap year
            System.out.println("Insert leap date on non-leap year: " + dateCase6);
            result = dateCase6.isValid(dateCase6);
            if(result){
                System.out.println("PASS.");
            }
            else{
                System.out.println("FAIL.");
            }
            System.out.println("Testing case #7...");
            Date dateCase7 = new Date("5/0/2014"); //invalid test date because because day is too small
            System.out.println("Enter date with day outside valid range (day too small): " + dateCase7);
            result = dateCase7.isValid(dateCase7);
            if(result){
                System.out.println("PASS.");
            }
            else{
                System.out.println("FAIL.");
            }
            System.out.println("Testing case #8...");
            Date dateCase8 = new Date("04/31/2021"); //invalid test date because too old
            System.out.println("Enter date in April outside range: " + dateCase8);
            result = dateCase8.isValid(dateCase8);
            if(result){
                System.out.println("PASS.");
            }
            else{
                System.out.println("FAIL.");
            }


            System.out.println("Testing case #9...");
            Date currDate = new Date();
            System.out.println("Insert current date: " + currDate); //test todays's date
            result = currDate.isValid(currDate);
            if(result){
                System.out.println("PASS.");
            }
            else{
                System.out.println("FAIL.");
            }
            System.out.println("Testing case #10...");
            Date dateCase10 = new Date("3/7/2027"); //invalid test date because because future date
            System.out.println("Enter date in future: " + dateCase10);
            result = dateCase10.isValid(dateCase10);
            if(result){
                System.out.println("PASS.");
            }
            else{
                System.out.println("FAIL.");
            }

        }     
           
    }
