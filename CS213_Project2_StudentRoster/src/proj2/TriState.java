/**
 * 
 */
package proj2;

/**
 * @author Stephen Danso, Sri Vishnu Jayakumar
 *
 */
import java.text.DecimalFormat;

public class TriState extends NonResident {
    private static final String NY = "NY";
    private static final String CT = "CT";
    private int triStateFullTuition = 29737;
    private int triStatePartTuition = 966 * getCreditHour();
    private String triState;


    public TriState(String name, Major major, int TOTAL_CREDIT_HOURS, String triState){
        super(name, major, TOTAL_CREDIT_HOURS);
        this.triState = triState;
    }


    @Override
    public void tuitionDue() {        
        if(this.triState == null){
            ;
        }
        else if ((this.getCreditHour() < creditMinFull)
        		&& (this.triState.equals(NY))) {
            this.setTuitionDue(((triStatePartTuition + uniFeePart)));
            this.set_calculated(true);
        }
        else if ((this.getCreditHour() < creditMinFull)
        		&& (this.triState.equals(CT))) {
            this.setTuitionDue(((triStatePartTuition + uniFeePart)));
            this.set_calculated(true);
        }
        else if (((!(this.getCreditHour() > maxCredNoAddFee))) 
        		&& (this.triState.equals(NY))) {
            this.setTuitionDue((((triStateFullTuition + uniFee) - 4000)));
            this.set_calculated(true);
        }
        else if (((!(this.getCreditHour() > maxCredNoAddFee)))
        		&& (this.triState.equals(CT))) {
            this.setTuitionDue((((triStateFullTuition + uniFee) - 5000)));
            this.set_calculated(true);
        }
        else {
        	if (this.triState.equals(NY)) {
                this.setTuitionDue(((((triStateFullTuition +
                        ((this.getCreditHour() - maxCredNoAddFee) * 966))
                        + uniFee) - 4000)));
                this.set_calculated(true);
        	}
        	else if (this.triState.equals(CT)) {
                this.setTuitionDue(((((triStateFullTuition +
                        ((this.getCreditHour() - maxCredNoAddFee) * 966))
                        + uniFee) - 5000)));
                this.set_calculated(true);
        	}
        }
    }


    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        
        if((this.triState.equals(NY)) && (this.getDatePayLast() == null)) {
        	return this.getProfile().getName() + 
        			":" + this.getProfile().getMajor() + ":" + this.getCreditHour() + " credit hours:"
        			+ "tuition due:" + decimalFormat.format(this.get_DueTuition()) + ":" + "total payment:" + 
        			decimalFormat.format(this.getLastPayment()) +
        			":" + "last payment date:" + " --/--/--" + ":" + "non-resident(tri-state)" + 
        			":" + "NY";
        }
        else if((this.triState.equals(CT)) && (this.getDatePayLast() == null)) {
        	return this.getProfile().getName() + 
        			":" + this.getProfile().getMajor() + ":" + this.getCreditHour() + " credit hours:"
        			+ "tuition due:" + decimalFormat.format(this.get_DueTuition()) + ":" + "total payment:" + 
        			decimalFormat.format(this.getLastPayment()) +
        			":" + "last payment date:" + " --/--/--" + 
        			":" + "non-resident(tri-state)" + 
        			":" + "CT";
        }
        else if((this.triState.equals(NY)) && (this.getDatePayLast() != null)) {
        	return this.getProfile().getName() + 
        			":" + this.getProfile().getMajor() + ":" + this.getCreditHour() + " credit hours:"
        			+ "tuition due:" + decimalFormat.format(this.get_DueTuition()) + ":" + "total payment:" + 
        			decimalFormat.format(this.getLastPayment()) +
        			":" + "last payment date: " + this.getDatePayLast().toString() + ":" + "non-resident(tri-state)" + 
        			":" + "NY";
        }
        else if((this.triState.equals(CT)) && (this.getDatePayLast() != null)) {
        	return this.getProfile().getName() + ":" + this.getProfile().getMajor() + 
        			":" + this.getCreditHour() + " credit hours:"
        			+ "tuition due:" + decimalFormat.format(this.get_DueTuition()) + 
        			":" + "total payment:" + 
        			decimalFormat.format(this.getLastPayment()) +
        			":" + "last payment date: " + this.getDatePayLast().toString() + 
        			":" + "non-resident(tri-state)" + 
        			":" + "CT";
        }
        return "";
    }
    
}
