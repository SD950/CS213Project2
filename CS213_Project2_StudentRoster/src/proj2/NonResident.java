package proj2;

import java.text.DecimalFormat;

/**
 * Class that extends Student class and includes specific data and operations to
 * non-resident students
 * 
 * @author Stephen Danso, Sri Vishnu Jayakumar
 */
public class NonResident extends Student {
	private int partNonResidentTuition = 966 * getCreditHour();

	/**
	 * Constructor used to create NonResident object using name, major, and credit
	 * hours
	 * 
	 * @param name            Student name
	 * @param major           Student major
	 * @param creditHourTotal Student credit hours
	 */
	public NonResident(String name, Major major, int creditHourTotal) {

		super(name, major, creditHourTotal);
	}

	/**
	 * Overriden method used to calculate the amount of tuition due
	 */
	@Override
	public void tuitionDue() {
		if (this.getCreditHour() < creditMinFull) {
			this.setTuitionDue((partNonResidentTuition + uniFeePart));
			this.set_calculated(true);
		} else if ((!(this.getCreditHour() > maxCredNoAddFee))) {
			this.setTuitionDue((29737 + uniFee));
			this.set_calculated(true);
		} else {
			this.setTuitionDue((29737 + ((this.getCreditHour() - maxCredNoAddFee) * 966) + uniFee));
			this.set_calculated(true);
		}
	}

	/**
	 * Overriden toString() method to create a string representation of payment
	 * 
	 * @return String representation of payment string and credit hours
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);

		if (this.getDatePayLast() == null) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date:" + " --/--/--" + ":"
					+ "non-resident";
		} else {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:"
					+ df.format(this.getLastPayment()) + ":" + "last payment date: " + this.getDatePayLast().toString()
					+ ":" + "non-resident";
		}
	}
}
