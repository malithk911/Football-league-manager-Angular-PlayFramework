/*
 * Name : Malith Kulathilake
 * IIT number : 2018412
 * UOW number : w1761910
 *
 * I confirm that I understand what plagiarism /
    collusion / contract cheating is and have read and
    understood the section on Assessment Offences in the
    Essential Information for Students. The work that I
    have submitted is entirely my own. Any work from
    other authors is duly referenced and acknowledged.
 */

package entities;

import java.io.Serializable;

// date class
public class Date implements Serializable {
    protected int day; // specified day
    protected int month; // specified month
    protected int year; // specified year

    // default constructor
    public Date() {
    }

    /**
     * @param day day
     * @param month month
     * @param year year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * @param year year
     */
    public Date(int year){
        this.year = year;
    }

    // getter for day
    public int getDay() {
        return day;
    }

    // setter for day
    public void setDay(int day) {
        this.day = day;
    }

    // getter for month
    public int getMonth() {
        return month;
    }

    // setter for month
    public void setMonth(int month) {
        this.month = month;
    }

    // getter for year
    public int getYear() {
        return year;
    }

    // setter for year
    public void setYear(int year) {
        this.year = year;
    }

    // toString() method for Date class
    /**
     *
     * @return attributes of object as string
     */
    public String toString() {
        return "DateAndTime {" +
                "day = " + getDay() +
                ", month = " + getMonth() +
                ", year = " + getYear() +
                '}';
    }

    // equals() method compares properties of objects
    /**
     *
     * @param obj object to be compared
     * @return boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Date date = (Date) obj;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }
}


