/**
 * 
 */
package proj2;

/**
 * @author Stephen Danso, Sri Vishnu Jayakumar
 *
 */
import java.text.DecimalFormat;

public class Resident extends Student {
	
    private int partTuitionResident = 404*getCreditHour();
    private static final int fullTimeTuitionResident = 12536;
    private double aidAmount = 0; private boolean aidRecieved = false;


    public Resident(String name, Major major, int creditHourTotal) {
        super(name, major, creditHourTotal);
    }

    @Override
    public void tuitionDue() {
        if (this.getCreditHour() < creditMinFull) {
            this.setTuitionDue((partTuitionResident
            		+ uniFeePart));
            this.set_calculated(true);
        } else if ((!(this.getCreditHour() > maxCredNoAddFee))) {
            this.setTuitionDue((fullTimeTuitionResident 
            		+ uniFee));
            this.set_calculated(true);
        } else {
            this.setTuitionDue((fullTimeTuitionResident +
                    ((this.getCreditHour() - maxCredNoAddFee) * 404)
                    + uniFee));
            this.set_calculated(true);
        }
    }
    public void setAid(boolean financialAid) {
        this.aidRecieved = financialAid;
    }

    public void setAidAmount(double financialAid){
        this.aidAmount = financialAid;
    }
    public boolean financialAid() {
        return this.aidRecieved;
    }

    public void setAidAmountResident(double financialAid) {
        this.setTuitionDue((this.get_DueTuition() - financialAid));
    }





    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        
        if ((this.getDatePayLast() == null) && (aidRecieved == false)) {
            return this.getProfile().getName() + ":" + this.getProfile().getMajor() +
            		":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + 
                    ":" + "total payment:" + 
                    df.format(this.getLastPayment()) +
                    ":" + "last payment date:" + " --/--/--" + ":" + "resident";
        } 
        else if (this.getDatePayLast() != null && (aidRecieved == false)) {
            return this.getProfile().getName() + ":" + this.getProfile().getMajor() + 
            		":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:" + 
                    df.format(this.getLastPayment()) +
                    ":" + "last payment date: " + this.getDatePayLast().toString() + ":" + "resident";
        }
        else if (this.getDatePayLast() == null && (aidRecieved == true)) {
            return this.getProfile().getName() + ":" + this.getProfile().getMajor() + 
            		":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) +
                    ":" + "total payment:" + 
                    df.format(this.getLastPayment()) +
                    ":" + "last payment date:" + " --/--/--" + ":" + "resident" +
                    ":" + "financial aid $" + df.format(this.aidAmount);
        } 
        else if (this.getDatePayLast() != null && (aidRecieved == true)) {
            return this.getProfile().getName() + ":" + this.getProfile().getMajor() + 
            		":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + ":" + "total payment:" + 
                    df.format(this.getLastPayment()) +
                    ":" + "last payment date: " + this.getDatePayLast().toString() + ":" + "resident" + 
                    ":" + "financial aid $" + df.format(this.aidAmount);
        }
        return "";
    }

}
