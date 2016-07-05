/**
 * 
 */
package edu.ncsu.csc216.course_manager.courses;

import java.util.ArrayList;

import edu.ncsu.csc216.course_manager.users.Student;
import edu.ncsu.csc216.course_manager.users.User;

/**
 * @author SarahHeckman
 *
 */
public class Course implements Enrollable {
	
	//TODO Add your data structure for the Course wait list here.
	//TODO Provide a reasoning for WHY you selected a Stack vs. Queue
	//and why you selected the ArrayList or LinkedList version of the 
	//Stack or Queue as a comment on the field.
	
	/** Course name */
	private String name;
	/** Course credit hours */
	private int credits;
	/** Course capacity */
	private int capacity;
	/** Students enrolled in the course */
	private ArrayList<User> enrolledStudents;
	/** Minimum credit hours for a course */
	public static final int MIN_HOURS = 1;
	/** Maximum credit hours for a course */
	public static final int MAX_HOURS = 4;
	
	/**
	 * Creates a Course with the given name and credit hours.
	 * @param name course name
	 * @param credits course credit hours
	 * @param capacity course capacity
	 */
	public Course(String name, int credits, int capacity) {
		super();
		enrolledStudents = new ArrayList<User>();
		setName(name);
		setCredits(credits);
		setCapacity(capacity);
	}

	/**
	 * Returns the course name.
	 * @return the course name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the course name to the given name.  An IllegalArgumentException is
	 * thrown if the name is null or an empty string.
	 * @param name the course name
	 */
	public void setName(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	/**
	 * Returns the course's credit hours.
	 * @return the course's credit hours
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets the course credit hours to the given value.  An IllegalArgumentException is
	 * thrown if the value is less than MIN_HOUR and greater than MAX_HOURS.
	 * @param credits the course's credit hours
	 */
	public void setCredits(int credits) {
		if (credits < MIN_HOURS || credits > MAX_HOURS) {
			throw new IllegalArgumentException();
		}
		this.credits = credits;
	}

	/**
	 * Returns the course's capacity.
	 * @return the course's capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the course's capacity to the given value.  An IllegalArgumentException is
	 * thrown if the value is less than 1 or if the new capacity is less than the 
	 * number of students currently enrolled in the course.
	 * @param capacity course's capacity
	 */
	public void setCapacity(int capacity) {
		if (capacity < 1  || capacity < enrolledStudents.size()) {
			throw new IllegalArgumentException();
		} 
		this.capacity = capacity;
	}

	/**
	 * Returns the enrolled students as an array.
	 * @return enrolled students
	 */
	public Student [] getEnrolledStudents() {
		Student [] s = new Student[enrolledStudents.size()];
		return enrolledStudents.toArray(s);
	}
	
	/**
	 * Returns true if there is capacity to add a user to the course and the 
	 * user is not already enrolled.
	 * @param user User to add to the course
	 * @return true if there is capacity
	 */
	public boolean canEnroll(User user) {
		if (enrolledStudents.size() < capacity) {
			if (user instanceof Student) {
				Student s = (Student) user;
				for (int i = 0; i < enrolledStudents.size(); i++) {
					if (enrolledStudents.get(i).equals(s)) {
						return false;
					}
				}
				return true;
			}
			return false;
		}
		return false;
	}
	
	/**
	 * Enroll the user in the course if there is room.
	 * @param user user to enroll
	 * @return true if user is enrolled.
	 */
	public boolean enroll(User user) {
		return canEnroll(user) && enrolledStudents.add(user);
	}
	
	/**
	 * Drops the student from the course.
	 * @param user student to drop
	 * @return true if the student is dropped
	 */
	public boolean drop(User user) {
		return enrolledStudents.remove(user);
	}

	/**
	 * Returns the hashCode for a course from the course's fields.
	 * @return the hashCode for the course
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Compares courses by their name.  
	 * @param obj object to check for equality of
	 * @return true if objects are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + "," + credits + "," + capacity;
	}

}
