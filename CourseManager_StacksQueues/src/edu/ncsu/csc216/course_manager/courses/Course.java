package edu.ncsu.csc216.course_manager.courses;

import java.util.ArrayList;

import edu.ncsu.csc216.course_manager.users.Student;
import edu.ncsu.csc216.course_manager.users.User;
import edu.ncsu.csc216.course_manager.utils.LinkedQueue;
import edu.ncsu.csc216.course_manager.utils.Queue;

/**
 * Course contains a list of enrolled students and a waitlist.
 * @author SarahHeckman and Manaka Green and Jerry Zhang
 */
public class Course implements Enrollable {
	
	/** A queue for students who want to enroll into a specific class. */
	//added <User> to fix warnings
	private LinkedQueue<User> waitlist;
	//Chose queue because the first waitlisted student should be the first one to
	//enroll into the class aka leave the waitlist.
	//Chose linkedList version of the queue since runtime is shorter for linked list
	//with queues
	
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
		waitlist = new LinkedQueue<User>();
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
	 * Returns a Queue so that we can check the contents of the waitlist.
	 * @return waitlist
	 */
	public Queue<User> getWaitlist() {
		return waitlist;
	}
	
	/**
	 * Enroll the user in the course if there is room, and the waitlist up to 5 students
	 * if there is no room in the course.
	 * @param user user to enroll
	 * @return true if user is enrolled into the class or enrolled into the waitlist
	 */
	public boolean enroll(User user) {
		//waitlist counter to keep track of how many students are in the waitlist
		int waitListCounter = 0;
		//max number of student allowed in course's waitlist
		int waitListCapacity = 5;
		//First check if student is already enrolled
		if (!enrolledStudents.contains(user)) {
			//If there is space to enroll, add the student to the course's list of students
			if(canEnroll(user)) {
				enrolledStudents.add(user);
				return true;
			}
			else {
				//If there is no space to enroll, add the student to the course's waitlist
				while (waitListCounter < waitListCapacity) {
					waitlist.enqueue(user);
					waitListCounter++;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Drops the student from the course or from the waitlist.
	 * @param user student to drop
	 * @return true if the student is dropped from the class or dropped from the waitlist
	 */
	public boolean drop(User user) {
		//make temp queue
		//if they're not already enrolled, then check waitlist
		LinkedQueue<User> temp = new LinkedQueue<User>();
		User student = null;
		boolean foundUser = false;
		if (!enrolledStudents.contains(user)) {
			while(!waitlist.isEmpty()) {
				//dequeued student is returned from dequeued method
				student = waitlist.dequeue();
				if (student.equals(user)) {
					foundUser = true;
					temp.enqueue(student);
					//create boolean flag
					//return true;
				}
				temp.enqueue(student);
				//
			}
			waitlist = temp;
		}
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
