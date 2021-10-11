package proj2;

import java.text.DecimalFormat;

/**
 * Class that extends NonResident class and includes specific data and
 * operations to non-resident students
 * 
 * @author Stephen Danso, Sri Vishnu Jayakumar
 */
public class TriState extends NonResident {
	private static final String NY = "NY";
	private static final String CT = "CT";
	private int triStateFullTuition = 29737;
	private int triStatePartTuition = 966 * getCreditHour();
	private String triState;

	/**
	 * Constructor used to create a TriState instance using name, major,
	 * creditHours, and state
	 * 
	 * @param name            Student name
	 * @param major           Student major
	 * @param creditHourTotal Student creditHOurs
	 * @param triState        Tristate State
	 */
	public TriState(String name, Major major, int creditHourTotal, String triState) {
		super(name, major, creditHourTotal);
		this.triState = triState;
	}

	/**
	 * Overriden method used to calculate the amount of tuition due
	 */
	@Override
	public void tuitionDue() {
		if (this.triState == null) {
			;
		} else if ((this.getCreditHour() < creditMinFull) && (this.triState.equals(NY))) {
			this.setTuitionDue(((triStatePartTuition + uniFeePart)));
			this.set_calculated(true);
		} else if ((this.getCreditHour() < creditMinFull) && (this.triState.equals(CT))) {
			this.setTuitionDue(((triStatePartTuition + uniFeePart)));
			this.set_calculated(true);
		} else if (((!(this.getCreditHour() > maxCredNoAddFee))) && (this.triState.equals(NY))) {
			this.setTuitionDue((((triStateFullTuition + uniFee) - 4000)));
			this.set_calculated(true);
		} else if (((!(this.getCreditHour() > maxCredNoAddFee))) && (this.triState.equals(CT))) {
			this.setTuitionDue((((triStateFullTuition + uniFee) - 5000)));
			this.set_calculated(true);
		} else {
			if (this.triState.equals(NY)) {
				this.setTuitionDue(
						((((triStateFullTuition + ((this.getCreditHour() - maxCredNoAddFee) * 966)) + uniFee) - 4000)));
				this.set_calculated(true);
			} else if (this.triState.equals(CT)) {
				this.setTuitionDue(
						((((triStateFullTuition + ((this.getCreditHour() - maxCredNoAddFee) * 966)) + uniFee) - 5000)));
				this.set_calculated(true);
			}
		}
	}

	/**
	 * Overriden toString method used to create a string representation of Tristate
	 * instance
	 * 
	 * @return String string representation of tristate instance
	 */
	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		decimalFormat.setGroupingUsed(true);
		decimalFormat.setGroupingSize(3);

		if ((this.triState.equals(NY)) && (this.getDatePayLast() == null)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + decimalFormat.format(this.get_DueTuition()) + ":"
					+ "total payment:" + decimalFormat.format(this.getLastPayment()) + ":" + "last payment date:"
					+ " --/--/--" + ":" + "non-resident(tri-state)" + ":" + "NY";
		} else if ((this.triState.equals(CT)) && (this.getDatePayLast() == null)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + decimalFormat.format(this.get_DueTuition()) + ":"
					+ "total payment:" + decimalFormat.format(this.getLastPayment()) + ":" + "last payment date:"
					+ " --/--/--" + ":" + "non-resident(tri-state)" + ":" + "CT";
		} else if ((this.triState.equals(NY)) && (this.getDatePayLast() != null)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + decimalFormat.format(this.get_DueTuition()) + ":"
					+ "total payment:" + decimalFormat.format(this.getLastPayment()) + ":" + "last payment date: "
					+ this.getDatePayLast().toString() + ":" + "non-resident(tri-state)" + ":" + "NY";
		} else if ((this.triState.equals(CT)) && (this.getDatePayLast() != null)) {
			return this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHour()
					+ " credit hours:" + "tuition due:" + decimalFormat.format(this.get_DueTuition()) + ":"
					+ "total payment:" + decimalFormat.format(this.getLastPayment()) + ":" + "last payment date: "
					+ this.getDatePayLast().toString() + ":" + "non-resident(tri-state)" + ":" + "CT";
		}
		return "";
	}

}
