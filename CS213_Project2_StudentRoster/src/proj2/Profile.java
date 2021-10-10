/**
 * 
 */
package proj2;

/**
 * @author Stephen Danso, Sri Vishnu Jayakumar
 *
 */
import java.text.DecimalFormat;


public class Profile {
    private String name;
    private Major major; 


    public Profile(String name, Major major) {
        this.name = name; this.major = major;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMajor(Major major) {
        this.major = major;
    }
    
    public Major getMajor() {
        return this.major;
    }


    @Override
    public boolean equals(Object obj) {
        Profile profile = Profile.class.cast(obj);
        if (this.name.equals(profile.name) && this.major.equals(profile.major)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.name + ":" + this.major;
    }

}
