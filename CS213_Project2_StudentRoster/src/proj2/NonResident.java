/**
 * 
 */
package proj2;

/**
 * @author Stephen Danso, Sri Vishnu Jayakumar
 *
 */
import java.text.DecimalFormat;


public class NonResident extends Student {
    private static final int fullNonResidentTution = 29737;
    private int partNonResidentTuition = 966 * getCreditHour();


    public NonResident(String name, Major major, int creditHourTotal) {
    	
        super(name, major, creditHourTotal);
    }

    @Override
    public void tuitionDue() {
        if (this.getCreditHour() < creditMinFull) {
            this.setTuitionDue((partNonResidentTuition 
            		+ UNIVERSITY_FEE_PART_TIME));
            this.set_calculated(true);
        } else if ((!(this.getCreditHour() > maxCredNoAddFee))) {
            this.setTuitionDue((fullNonResidentTution
            		+ uniFee));
            this.set_calculated(true);
        } else {
            this.setTuitionDue((fullNonResidentTution +
                    ((this.getCreditHour() 
                    		- maxCredNoAddFee) * 966)
                    + uniFee));
            this.set_calculated(true);
        }
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        
        if (this.getDatePayLast() == null) {
            return this.getProfile().getName() + ":" + this.getProfile().getMajor() + 
            		":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + 
                    ":" + "total payment:" + 
                    df.format(this.getLastPayment()) +
            		":" + "last payment date:" + " --/--/--" + ":" + "non-resident";
        } else {
            return this.getProfile().getName() + ":" + this.getProfile().getMajor() + 
            		":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + 
                    ":" + "total payment:" + 
                    df.format(this.getLastPayment()) +
                    ":" + "last payment date: " + this.getDatePayLast().toString() + 
                    ":" + "non-resident";
        }
    }
}
