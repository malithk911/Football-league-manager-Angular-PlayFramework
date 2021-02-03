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

// imports
import java.io.Serializable;
import java.util.Objects;

// sports club class
public class SportsClub implements Serializable {
    protected String clubName; // club name
    protected String clubCountry; // club location
    protected int numOfMembers; // number of members in club
    protected int numOfWins; // number of wins
    protected int numOfDraws; // number of draws
    protected int numOfDefeats; // number of defeats

    // default constructor
    public SportsClub(){}

    /**
     *
     * @param clubName club name
     * @param clubCountry location
     * @param numOfMembers num of members
     * @param numOfWins // num of wins
     * @param numOfDraws // num of draws
     * @param numOfDefeats // num of defeats
     */
    public SportsClub(String clubName, String clubCountry, int numOfMembers, int numOfWins,
                      int numOfDraws, int numOfDefeats) {
        this.clubName = clubName;
        this.clubCountry = clubCountry;
        this.numOfMembers = numOfMembers;
        this.numOfWins = numOfWins;
        this.numOfDraws = numOfDraws;
        this.numOfDefeats = numOfDefeats;
    }

    // getter for clubName
    public String getClubName() {
        return clubName;
    }

    // setter for clubName
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    // getter for clubLocation
    public String getClubCountry() {
        return clubCountry;
    }

    // setter for clubLocation
    public void setClubCountry(String clubCountry) {
        this.clubCountry = clubCountry;
    }

    // getter for numOfMembers
    public int getNumOfMembers() {
        return numOfMembers;
    }

    // setter for numOfMembers
    public void setNumOfMembers(int numOfMembers) {
        this.numOfMembers = numOfMembers;
    }

    // getter for numOfWins
    public int getNumOfWins() {
        return numOfWins;
    }

    // setter for numOfWins
    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    // getter for numOfDraws
    public int getNumOfDraws() {
        return numOfDraws;
    }

    // setter for numOfDraws
    public void setNumOfDraws(int numOfDraws) {
        this.numOfDraws = numOfDraws;
    }

    // getter for numOfDefeats
    public int getNumOfDefeats() {
        return numOfDefeats;
    }

    // setter for numOfDefeats
    public void setNumOfDefeats(int numOfDefeats) {
        this.numOfDefeats = numOfDefeats;
    }

    // toString() method for SportsClub class

    /**
     *
     * @return attributes of object as string
     */
    public String toString() {
        return "SportsClub {" +
                "clubName = " + getClubName() +
                ", clubLocation = " + getClubCountry() +
                ", numOfMembers = " + getNumOfMembers() +
                ", numOfWins = " + getNumOfWins() +
                ", numOfDraws = " + getNumOfDraws() +
                ", numOfDefeats = " + getNumOfDefeats() +
                '}';
    }

    // equals() method compares properties of objects
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        SportsClub that = (SportsClub) obj;
        /*
         * Double.compare() returns,
         * 0 if num1 == num2
         * 1 if num1 > num2
         * -1 if num1 < num2
         */
        return numOfMembers == that.numOfMembers &&
                numOfWins == that.numOfWins &&
                numOfDraws == that.numOfDraws &&
                numOfDefeats == that.numOfDefeats &&
                clubName.equals(that.clubName) &&
                clubCountry.equals(that.clubCountry);
    }

    // compareTo() methods

    /**
     *
     * @param obj object to compare to
     * @return integer
     */
    public int compareTo(SportsClub obj){
        if(this.numOfMembers == obj.numOfMembers &&
                this.numOfWins == obj.numOfWins &&
                this.numOfDraws == obj.numOfDraws &&
                this.numOfDefeats == obj.numOfDefeats){
            return 0;
        } else if (this.numOfMembers > obj.numOfMembers &&
                this.numOfWins > obj.numOfWins &&
                this.numOfDraws > obj.numOfDraws &&
                this.numOfDefeats > obj.numOfDefeats){
            return 1;
        } else {
            return -1;
        }
    }

    // hashCode() method
    public int hashCode() {
        return Objects.hash(clubName, clubCountry, numOfMembers,
                numOfWins, numOfDraws, numOfDefeats);
    }
}


