package proj2;

import java.text.DecimalFormat;

/**
 * Class that defines the profile of a student which includes name and major
 * 
 * @author Stephen Danso, Sri Vishnu Jayakumar
 */
public class Profile {
	private String name;
	private Major major;

	/**
	 * Constructor used to create Profile object using the name and major as
	 * parameters
	 * 
	 * @param name  student's name
	 * @param major student's major
	 */
	public Profile(String name, Major major) {
		this.name = name;
		this.major = major;
	}

	/**
	 * Helper method to get the name of student
	 * 
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Helper method to set the name
	 * 
	 * @param name student name string
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Helper method to set the major
	 * 
	 * @param major student major Major object
	 */
	public void setMajor(Major major) {
		this.major = major;
	}

	/**
	 * Helper method used to get student's major
	 * 
	 * @return Major enum
	 */
	public Major getMajor() {
		return this.major;
	}

	/**
	 * Overriden equals() method to check the equality of two profiles using
	 * students name and major
	 * 
	 * @param obj object to be compared in equals method
	 * @return boolean true or false depending on whether the profiles are the same
	 */
	@Override
	public boolean equals(Object obj) {
		Profile profile = Profile.class.cast(obj);
		if (this.name.equals(profile.name) && this.major.equals(profile.major)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Overriden toString() method that returns the string representation of name
	 * and major
	 * 
	 * @return String name and major
	 */
	@Override
	public String toString() {
		return this.name + ":" + this.major;
	}

}
