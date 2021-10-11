package proj2;

import java.text.DecimalFormat;

/**
 * Class that defines the common data items and operations for all student
 * instances
 * 
 * @author Stephen Danso, Sri Vishnu Jayakumar
 */
public class Student {
	private double tuitionDue;
	private Profile profile;
	private int creditHourTotal;

	public static final int uniFee = 3268;

	public static final double uniFeePart = 0.80 * uniFee;
	public static final int creditMinFull = 12;
	public static final int maxCredNoAddFee = 16;

	private Date lastPaymentDate = null;
	private boolean calculated = false;

	private double lastPayment = 0.00;

	/**
	 * Constructor used to create student object using name, major, and creditHours
	 * 
	 * @param name            name of student
	 * @param major           student's major
	 * @param creditHourTotal number of creditHours total
	 */

	public Student(String name, Major major, int creditHourTotal) {
		this.creditHourTotal = creditHourTotal;
		this.profile = new Profile(name, major);
	}

	/**
	 * Helper method used to determine if calculation was performed
	 * 
	 * @return boolean default value false
	 */

	public boolean calculated() {
		return this.calculated;
	}

	/**
	 * Helper method used to get Profile
	 * 
	 * @return Profile profile object
	 */

	public Profile getProfile() {
		return this.profile;
	}

	/**
	 * Helper method to get last payment
	 * 
	 * @return double last payment
	 */

	public double getLastPayment() {
		return this.lastPayment;
	}

	/**
	 * Helper method used to get tuition due
	 * 
	 * @return double tuition amount due
	 */

	public double get_DueTuition() {
		return this.tuitionDue;
	}

	/**
	 * Helper method used to set calculated value
	 * 
	 * @param calculated boolean value that depicts whether value is calculated
	 */

	public void set_calculated(boolean calculated) {
		this.calculated = calculated;
	}

	/**
	 * Method used to get the date of the last payment
	 * 
	 * @return Date date object of last payment
	 */

	public Date getDatePayLast() {
		return this.lastPaymentDate;
	}

	/**
	 * Method used to set the total credit hours
	 * 
	 * @param partTimeHours integer that represents the number of hours for part
	 *                      time
	 */

	public void setTotalCreditHours(int partTimeHours) {
		this.creditHourTotal = partTimeHours;
	}

	/**
	 * Do nothing method to be overriden
	 */

	public void tuitionDue() {

	}

	/**
	 * Helper method used to set the last payment
	 * 
	 * @param payment floating point amount to be added to lastPayment
	 */

	public void setLastPayment(double payment) {
		this.lastPayment += payment;
	}

	/**
	 * Helper method used to get the total credit hours
	 * 
	 * @return int number of credit hours total
	 */

	public int getCreditHour() {
		return this.creditHourTotal;
	}

	/**
	 * Helper method used to set the tuition amount due
	 * 
	 * @param tuitionDue floating point value that represents the amount due
	 */

	public void setTuitionDue(double tuitionDue) {
		this.tuitionDue = tuitionDue;
	}

	/**
	 * Helper method used to set the last payment date
	 * 
	 * @param lastPaymentDate -date object that represents last payment date
	 */

	public void setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}

	/**
	 * Overriden toString() method that returns string representation of student
	 * object
	 * 
	 * @return String string representation of student
	 */

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);

		if (this.getDatePayLast() == null) {
			return this.profile.getName() + ":" + this.profile.getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date:" + " --/--/--";
		} else {
			return this.profile.getName() + ":" + this.profile.getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date: " + this.getDatePayLast().toString();
		}
	}

	/**
	 * Overriden equals() method that returns a boolean value if two profiles are
	 * the same
	 * 
	 * @param obj object that is to be compared
	 */
	@Override
	public boolean equals(Object obj) {
		Student profile = Student.class.cast(obj);
		if (this.profile.equals(profile.profile)) {
			return true;
		} else {
			return false;
		}
	}

}
