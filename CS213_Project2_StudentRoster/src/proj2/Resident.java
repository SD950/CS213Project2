package proj2;

import java.text.DecimalFormat;

/**
 * Class that extends Student class and includes specific data and operations to
 * resident students
 * 
 * @author Stephen Danso, Sri Vishnu Jayakumar
 */
public class Resident extends Student {

	private int partTuitionResident = 404 * getCreditHour();
	private static final int fullTimeTuitionResident = 12536;
	private double aidAmount = 0;
	private boolean aidRecieved = false;

	/**
	 * Constructor used to create a Resident object using name, major, and credit
	 * hours
	 * 
	 * @param name            Student name
	 * @param major           Student major
	 * @param creditHourTotal Student credit hours
	 */
	public Resident(String name, Major major, int creditHourTotal) {
		super(name, major, creditHourTotal);
	}

	/**
	 * Overriden method used to calculate the tuition amount due
	 */
	@Override
	public void tuitionDue() {
		if (this.getCreditHour() < creditMinFull) {
			this.setTuitionDue((partTuitionResident + uniFeePart));
			this.set_calculated(true);
		} else if ((!(this.getCreditHour() > maxCredNoAddFee))) {
			this.setTuitionDue((fullTimeTuitionResident + uniFee));
			this.set_calculated(true);
		} else {
			this.setTuitionDue((fullTimeTuitionResident + ((this.getCreditHour() - maxCredNoAddFee) * 404) + uniFee));
			this.set_calculated(true);
		}
	}

	/**
	 * Helper method used to set the amount of financial aid using a boolean
	 * parameter
	 * 
	 * @param financialAid boolean value that represents if financial aid was
	 *                     awarded
	 */
	public void setAid(boolean financialAid) {
		this.aidRecieved = financialAid;
	}

	/**
	 * Helper method used to set the aid amount using a double parameter
	 * 
	 * @param financialAid double value that represents financial aid award amount
	 */
	public void setAidAmount(double financialAid) {
		this.aidAmount = financialAid;
	}

	/**
	 * Method that returns the amount of financial aid received
	 * 
	 * @return boolean aid received
	 */
	public boolean financialAid() {
		return this.aidRecieved;
	}

	/**
	 * Method to set financial aid amount for resident
	 * 
	 * @param financialAid double value that represents financial aid reward amount
	 */
	public void setAidAmountResident(double financialAid) {
		this.setTuitionDue((this.get_DueTuition() - financialAid));
	}

	/**
	 * Overriden toString() method to create a string representation of payment
	 * 
	 * @return String representation of payment string and financial aid
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);

		if ((this.getDatePayLast() == null) && (aidRecieved == false)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date:" + " --/--/--" + ":" + "resident";
		} else if (this.getDatePayLast() != null && (aidRecieved == false)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date: " + this.getDatePayLast().toString()
					+ ":" + "resident";
		} else if (this.getDatePayLast() == null && (aidRecieved == true)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date:" + " --/--/--" + ":" + "resident"
					+ ":" + "financial aid $" + df.format(this.aidAmount);
		} else if (this.getDatePayLast() != null && (aidRecieved == true)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date: " + this.getDatePayLast().toString()
					+ ":" + "resident" + ":" + "financial aid $" + df.format(this.aidAmount);
		}
		return "";
	}

}
