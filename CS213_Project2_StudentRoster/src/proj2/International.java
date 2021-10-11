package proj2;

import java.text.DecimalFormat;

/**
 * Class that extends NonResident class and includes specific data and
 * operations to students from overseas
 * 
 * @author Stephen Danso, Sri Vishnu Jayakumar
 */
public class International extends NonResident {
	private static final int addFee = 2650;
	private static final int internationalTuition = 29737;

	private boolean studyingAbroad;

	/**
	 * Constructor used to create International instance using name, major,
	 * creditHours, and if the student is studying abroad or not
	 * 
	 * @param name            Student name
	 * @param major           Student major
	 * @param creditHourTotal Students creditHours
	 * @param studyingAbroad  boolean value for studying abroad or not
	 */
	public International(String name, Major major, int creditHourTotal, boolean studyingAbroad) {
		super(name, major, creditHourTotal);
		this.studyingAbroad = studyingAbroad;
	}

	/**
	 * Helper method to return study aboard status
	 * 
	 * @return boolean studying abroad status true or false
	 */
	public boolean getAbroadStatus() {
		return this.studyingAbroad;
	}

	/**
	 * Helper method to set study abroad status
	 * 
	 * @param studyingAbroad boolean that depicts the state of studying abroad
	 */
	public void setAbroadStatus(boolean studyingAbroad) {
		this.studyingAbroad = studyingAbroad;
	}

	/**
	 * Overriden method to determine the amount of tuition due
	 */
	@Override
	public void tuitionDue() {
		if ((this.getCreditHour() >= creditMinFull) && (this.getCreditHour() <= maxCredNoAddFee)
				&& (this.getAbroadStatus() == false)) {
			this.setTuitionDue((internationalTuition + uniFee + addFee));
			this.set_calculated(true);
		} else if ((this.getCreditHour() >= creditMinFull) && (this.getCreditHour() > maxCredNoAddFee)
				&& (this.getAbroadStatus() == false)) {
			this.setTuitionDue(
					(internationalTuition + uniFee + addFee + ((this.getCreditHour() - maxCredNoAddFee) * 966)));
			this.set_calculated(true);
		} else if ((this.getCreditHour() >= creditMinFull) && (this.getAbroadStatus() == true)) {
			this.setTuitionDue((uniFee + addFee));
			this.set_calculated(true);
		}
	}

	/**
	 * Overriden method that returns the string representation of a international
	 * student instance
	 * 
	 * @return String representation of international instance
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");

		df.setGroupingUsed(true);
		df.setGroupingSize(3);

		if ((this.getAbroadStatus() == true) && (this.getDatePayLast() != null)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date: " + this.getDatePayLast().toString()
					+ ":" + "non-resident" + ":" + "international" + ":" + "study abroad";
		} else if ((this.getAbroadStatus() == false) && (this.getDatePayLast() != null)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date: " + this.getDatePayLast().toString()
					+ ":" + "non-resident" + ":" + "international";
		} else if ((this.getAbroadStatus() == true) && (this.getDatePayLast() == null)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date:" + " --/--/--" + ":" + "non-resident"
					+ ":" + "international" + ":" + "study abroad";
		} else if ((this.getAbroadStatus() == false) && (this.getDatePayLast() == null)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date:" + " --/--/--" + ":" + "non-resident"
					+ ":" + "international";
		}
		return "international";
	}
}
