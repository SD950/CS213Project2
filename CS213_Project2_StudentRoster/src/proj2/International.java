/**
 * 
 */
package proj2;

/**
 * @author Stephen Danso, Sri Vishnu Jayakumar
 *
 */
import java.text.DecimalFormat;

public class International extends NonResident {
    private static final int addFee = 2650;
    private static final int internationalTuition = 29737;

    private boolean studyingAbroad;


    public International(String name, Major major, int creditHourTotal, boolean studyingAbroad) {
        super(name, major, creditHourTotal);
        this.studyingAbroad = studyingAbroad;
    }

    public boolean getAbroadStatus() {
        return this.studyingAbroad;
    }

    public void setAbroadStatus(boolean studyingAbroad) {
        this.studyingAbroad = studyingAbroad;
    }


    @Override
    public void tuitionDue() {
        if ((this.getCreditHour() >= creditMinFull) &&
                (this.getCreditHour() <= maxCredNoAddFee)
                && (this.getAbroadStatus() == false)) {
            this.setTuitionDue((internationalTuition 
            		+ uniFee + addFee));
            this.set_calculated(true);
        } else if ((this.getCreditHour() >= creditMinFull)
                && (this.getCreditHour() > maxCredNoAddFee)
                && (this.getAbroadStatus() == false)) {
            this.setTuitionDue((internationalTuition + uniFee + addFee
                    + ((this.getCreditHour() - maxCredNoAddFee) * 966)));
            this.set_calculated(true);
        } else if ((this.getCreditHour() >= creditMinFull)
                && (this.getAbroadStatus() == true)) {
            this.setTuitionDue((uniFee + addFee));
            this.set_calculated(true);
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        
        if ((this.getAbroadStatus() == true) && 
        		(this.getDatePayLast() != null)) {
            return this.getProfile().getName() + ":" + 
        		this.getProfile().getMajor() + ":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:" + 
                    df.format(this.getLastPayment()) +
                    ":" + "last payment date: " + this.getDatePayLast().toString() + ":" + "non-resident" + ":" +
                    "international" + ":" + "study abroad";
        } else if ((this.getAbroadStatus() == false) && (this.getDatePayLast() != null)) {
            return this.getProfile().getName() +
            		":" + this.getProfile().getMajor() + ":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:" + 
                    df.format(this.getLastPayment()) +
                    ":" + "last payment date: " + this.getDatePayLast().toString() + ":" + "non-resident" + ":" +
                    "international";
        } else if ((this.getAbroadStatus() == true) && (this.getDatePayLast() == null)) {
            return this.getProfile().getName() + 
            		":" + this.getProfile().getMajor() + ":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:" + 
                    df.format(this.getLastPayment()) +
                    ":" + "last payment date:" + " --/--/--" + ":" + "non-resident" + ":" +
                    "international" + ":" + "study abroad";
        } else if ((this.getAbroadStatus() == false) && (this.getDatePayLast() == null)) {
            return this.getProfile().getName() +
            		":" + this.getProfile().getMajor() + ":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:" + 
                    df.format(this.getLastPayment()) +
                    ":" + "last payment date:" + " --/--/--" + ":" + "non-resident" + ":" +
                    "international";
        }
        return "international";
    }
}
