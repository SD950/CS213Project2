/**
 * 
 */
package proj2;

/**
 * @author Stephen Danso, Sri Vishnu Jayakumar
 *
 */
import java.util.StringTokenizer;
import java.util.Calendar;


/**
 * Class that represent release date of the album
 * @author Sri Vishnu Jayakumar, Stephen Danso
 *
 */
public class Date {
    private int year;
    private int month;
    private int day;

    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int THE_EIGHTYS = 1980;
    //months
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    /**
     * Used to create a Date Object with variables taken by a string parameter in a certain format.
     * @param date takes a String in mm/dd/yyyy format.
     */
    public Date(String date) {
        String monthString;             //string of month tokenized 
        String dayString;               //string of day tokenized 
        String yearString;              //string of year tokenized 
        final String InvalidParameter = "-1";  //set value to -1 if any part missing

        StringTokenizer tokenDate = new StringTokenizer(date,"/");

        monthString = tokenDate.hasMoreTokens() ? tokenDate.nextToken() : InvalidParameter;
        dayString = tokenDate.hasMoreTokens() ? tokenDate.nextToken() : InvalidParameter;
        yearString = tokenDate.hasMoreTokens() ? tokenDate.nextToken() : InvalidParameter;

        if(tokenDate.hasMoreTokens()){      //set inavlid if too many fields
            month = Integer.parseInt(InvalidParameter);
            day = Integer.parseInt(InvalidParameter);
            year = Integer.parseInt(InvalidParameter);
        }
        else {
            month = Integer.parseInt(monthString);
            day = Integer.parseInt(dayString);
            year = Integer.parseInt(yearString);
        }
    }
    /**
     * Create Date object with today's date
     */
    public Date() {     //create object with today's date
    	
        Calendar currDate = Calendar.getInstance();
        year = currDate.get(Calendar.YEAR);
        month = currDate.get(Calendar.MONTH) + 1;
        day = currDate.get(Calendar.DATE);
    }

    /**
     * helper method to get the year 
     * @return int of the year
     */
    public int getYear(){
        return year;
    }

    /**
     * helper method to get the month
     * @return an int of the month
     */
    public int getMonth(){
        return month;
    }

    /**
     * helper method to get the day
     * @return int of the day
     */
    public int getDay(){
        return day;
    }

    /**
     * Method to see if a date is valid date to be used
     * Date with the year less than 1980 or a date beyond today is invalid.
     * @return boolean true if it is a valid date false if not
     */
    public boolean isValid() {
    	
        boolean validDate = false;
        Date current = new Date();       //current date value
        int currentYear = current.getYear();
        int currentMonth = current.getMonth();
        int currentDay = current.getDay();
        int dayFirst = 1;               //first day of the month
        int dayLast = 0;                //last day of the month

        if(year < THE_EIGHTYS || year > currentYear){
            return validDate;
        }
        else if(year == currentYear){
                if(month > currentMonth){
                    return validDate;
                }
                else if(day > currentDay){
                    return validDate;
                }
        }
        dayLast = numDaysMonth(year,month);

        if(day >= dayFirst && day <= dayLast)   //false when outside specified range for month
            validDate = true;
        return validDate;
    }

    /**
     * Helper method to find out number of days month with leap years
     * @param checked if leap year.
     * @param month check to return correct number of days.
     * @return int of number of days in a certain month.
     */
    public int numDaysMonth(int year, int month){
    	
        boolean leapYear;
        int dayLast;

        if(year % QUADRENNIAL == 0){        //find if a leap year
            if(year % CENTENNIAL == 0){
                if(year % QUATERCENTENNIAL == 0) {
                    leapYear = true;
                }
                else{
                    leapYear = false;
                }
            }
            else{
                leapYear = true;
            }
        }
        else{
            leapYear = false;
        }

        if(month == JANUARY || month == MARCH ||
                month == MAY || month == JULY ||  //Check if 31 days
                month == AUGUST || month == OCTOBER|| month == DECEMBER)
        {
            dayLast = 31;
        }else if (month == APRIL || month == JUNE ||
                    month == SEPTEMBER || month == NOVEMBER)   //Check if 30 days
        {
            dayLast = 30;
        }
        else if (month == FEBRUARY)  //Check if 29 days
        {
            if (leapYear) {
                dayLast = 29;
            } else {
                dayLast = 28;
            }
        }
        else{
            dayLast = -1;
        }
        return dayLast;
    }

    /**
     * Method for date in mm/dd/yyyy format.
     * @return string in the right format.
     */
    public String toString(){   //return date in mm/dd/yyyy
        return (month + "/" + day + "/" + year);
    }
    
	public int compareTo(Date date) {
		
		if(date instanceof Date) {
			return -1;
		}
		if(date.getYear() < year) {
			return 1;
		}else if(date.getYear() > year) {
			return -1;
		}else {
			//case if years are equal
			if(date.getMonth() < month) {
				return 1;
			}else if(date.getMonth() > month) {
				return -1;
			}else {
				//case if the months are equal
				if(date.getDay() < day) {
					return 1;
				}else if(date.getDay() > day) {
					return -1;
				}else {
					return 1;
				}
				
			}
			
		}
		
	}


    public static void main(String[] args){
        
        Boolean result;
        //testing isValid() method
        System.out.println("Testing isValid()...\n");
        

        System.out.println("Testing case #1...");
        Date dateCase1 = new Date("14/11/2017"); //invalid test date because month is too large
        System.out.println("Enter date with month outside valid range: " + dateCase1);
        result = dateCase1.isValid();
        if(result){
            System.out.println("PASS.");
        }
        else{
            System.out.println("FAIL.");
        }
        System.out.println("Testing case #2...");//lower than 1980 so fail
        Date dateCase2 = new Date("4/9/1965");
        System.out.println("Enter date inside valid range: " + dateCase2);
        result = dateCase2.isValid();
        if(result){
            System.out.println("PASS.");
        }
        else{
            System.out.println("FAIL.");
        }

        System.out.println("Testing case #3...");
        Date dateCase3 = new Date("0/45/2014"); //invalid test date because month is too small
        System.out.println("Enter date with day outside valid range (month too small): " + dateCase3);
        result = dateCase3.isValid();
        if(result){
            System.out.println("PASS.");
        }
        else{
            System.out.println("FAIL.");
        }

        System.out.println("Testing case #4...");
        Date dateCase4 = new Date("3/56/2015"); //invalid test date because day is too large
        System.out.println("Enter date with day outside valid range: " + dateCase4);
        result = dateCase4.isValid();
        if(result){
            System.out.println("PASS.");
        }
        else{
            System.out.println("FAIL.");
        }



        System.out.println("Testing case #5...");
        Date dateCase5 = new Date("2/29/2020"); //valid test date because leap year
        System.out.println("Insert leap date on leap year: " + dateCase5);
        result = dateCase5.isValid();
        if(result){
            System.out.println("PASS.");
        }
        else{
            System.out.println("FAIL.");
        }

        System.out.println("Testing case #6...");
        Date dateCase6 = new Date("2/29/2021"); //invalid test date because not a leap year
        System.out.println("Insert leap date on non-leap year: " + dateCase6);
        result = dateCase6.isValid();
        if(result){
            System.out.println("PASS.");
        }
        else{
            System.out.println("FAIL.");
        }
        System.out.println("Testing case #7...");
        Date dateCase7 = new Date("5/0/2014"); //invalid test date because because day is too small
        System.out.println("Enter date with day outside valid range (day too small): " + dateCase7);
        result = dateCase7.isValid();
        if(result){
            System.out.println("PASS.");
        }
        else{
            System.out.println("FAIL.");
        }
        System.out.println("Testing case #8...");
        Date dateCase8 = new Date("04/31/2021"); //invalid test date because too old
        System.out.println("Enter date in April outside range: " + dateCase8);
        result = dateCase8.isValid();
        if(result){
            System.out.println("PASS.");
        }
        else{
            System.out.println("FAIL.");
        }


        System.out.println("Testing case #9...");
        Date currDate = new Date();
        System.out.println("Insert current date: " + currDate); //test todays's date
        result = currDate.isValid();
        if(result){
            System.out.println("PASS.");
        }
        else{
            System.out.println("FAIL.");
        }
        System.out.println("Testing case #10...");
        Date dateCase10 = new Date("3/7/2027"); //invalid test date because because future date
        System.out.println("Enter date in future: " + dateCase10);
        result = dateCase10.isValid();
        if(result){
            System.out.println("PASS.");
        }
        else{
            System.out.println("FAIL.");
        }

    }
}
