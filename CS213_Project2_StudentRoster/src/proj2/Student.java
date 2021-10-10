/**
 * 
 */
package proj2;

/**
 * @author Stephen Danso, Sri Vishnu Jayakumar
 *
 */
import java.text.DecimalFormat;


public class Student {
    private double tuitionDue;
    private Profile profile;     
    private int creditHourTotal;
  
    public static final int uniFee = 3268;

    public static final double uniFeePart= 0.80 * uniFee;
    public static final int creditMinFull = 12;
    public static final int maxCredNoAddFee = 16;

    private Date lastPaymentDate = null;
    private boolean wasCalculated = false;

    private double lastPayment = 0.00;


    public Student(String name, Major major, int creditHourTotal) {
        this.creditHourTotal = creditHourTotal;
        this.profile = new Profile(name, major);
    }
    public boolean wasCalculated() {
        return this.wasCalculated;
    }
    public Profile getProfile() {
        return this.profile;
    }
    public double getLastPayment() {
        return this.lastPayment;
    }

    public double get_DueTuition() {
        return this.tuitionDue;
    }
    public void set_calculated(boolean wasCalculated) {
        this.wasCalculated = wasCalculated;
    }
    public Date getDatePayLast() {
        return this.lastPaymentDate;
    }
    public void setTotalCreditHours(int partTimeHours) {
        this.creditHourTotal = partTimeHours;
    }
    
    public void tuitionDue() {

    }

    public void setLastPayment(double payment) {
        this.lastPayment += payment;
    }
    public int getCreditHour() {
        return this.creditHourTotal;
    }
    public void setTuitionDue(double tuitionDue) {
        this.tuitionDue = tuitionDue;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);


        if (this.getDatePayLast() == null) {
            return this.profile.getName() + ":" + this.profile.getMajor() +
            		":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + 
                    ":" + "total payment:" +
                    df.format(this.getLastPayment()) + ":" + "last payment date:" + " --/--/--";
        } else {
            return this.profile.getName() + ":" + this.profile.getMajor() + 
            		":" + this.getCreditHour() + " credit hours:"
                    + "tuition due:" + df.format(this.get_DueTuition()) + 
                    ":" + "total payment:" +
                    df.format(this.getLastPayment()) + ":" + "last payment date: "
                    + this.getDatePayLast().toString();
        }
    }


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
