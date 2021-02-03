package entities;
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

// imports

import java.io.Serializable;
import java.util.Objects;

// school football club class
public class SchoolFootballClub extends FootballClub implements Serializable {
    protected String schoolName; // name of school
    protected int schoolRanking; // rank of school club

    // default constructor
    public SchoolFootballClub() {}

    /**
     * @param schoolName name of school
     * @param schoolRanking ranking
     */
    public SchoolFootballClub(String schoolName, int schoolRanking) {
        this.schoolName = schoolName;
        this.schoolRanking = schoolRanking;
    }

    /**
     * @param numOfGoalsScored num of goals scored
     * @param numOfGoalsConceded num of goals conceded
     * @param numOfPoints num of points
     * @param numOfMatches num of matches
     * @param schoolName name of school
     * @param schoolRanking ranking
     */
    public SchoolFootballClub(int numOfGoalsScored, int numOfGoalsConceded, int numOfPoints, int numOfMatches,
                              String schoolName, int schoolRanking) {
        super(numOfGoalsScored, numOfGoalsConceded, numOfPoints, numOfMatches);
        this.schoolName = schoolName;
        this.schoolRanking = schoolRanking;
    }

    /**
     * @param clubName club name
     * @param clubLocation club location
     * @param numOfMembers num of members
     * @param numOfWins num of wins
     * @param numOfDraws num of draws
     * @param numOfDefeats num of defeats
     * @param numOfGoalsScored num of goals scored
     * @param numOfGoalsConceded num of goals conceded
     * @param numOfMatches num of matches
     * @param schoolName name of school
     * @param schoolRanking ranking
     */
    public SchoolFootballClub(String clubName, String clubLocation, int numOfMembers,
                              int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsScored,
                              int numOfGoalsConceded, int numOfMatches, String schoolName,
                              int schoolRanking) {
        super(clubName, clubLocation, numOfMembers, numOfWins, numOfDraws, numOfDefeats, numOfGoalsScored,
                numOfGoalsConceded, numOfMatches);
        this.schoolName = schoolName;
        this.schoolRanking = schoolRanking;
    }

    // getter for schoolName
    public String getSchoolName() {
        return schoolName;
    }

    // setter for schoolName
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    // getter for school ranking
    public int getSchoolRanking() {
        return schoolRanking;
    }

    // setter for school ranking
    public void setSchoolRanking(int schoolRanking) {
        this.schoolRanking = schoolRanking;
    }

    /**
     * toString() method for schoolFootballClub class
     * @return String
     */
    public String toString() {
        return "SchoolFootballClub {" +
                "schoolName = '" + getSchoolName() +
                ", schoolRanking = " + getSchoolRanking() +
                ", numOfGoals = " + getNumOfGoalsScored() +
                ", numOfPoints = " + getNumOfPoints() +
                ", numOfPlayedMatches = " + getNumOfMatches() +
                ", numOfMembers = " + getNumOfMembers() +
                ", numOfWins = " + getNumOfWins() +
                ", numOfDraws = " + getNumOfDraws() +
                ", numOfDefeats = " + getNumOfDefeats() +
                '}';
    }

    /**
     * equals() method compares properties of objects
     * @param o object o
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return schoolRanking == that.schoolRanking &&
                Objects.equals(schoolName, that.schoolName);
    }

    // hashCode() method
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName, schoolRanking);
    }

    // compareTo() method
    /**
     * @param obj school football club object
     * @return integer
     */
    public int compareTo(SchoolFootballClub obj) {
        // the following is the same as Integer.compare()
        return Integer.compare(this.schoolRanking, obj.schoolRanking);
    }
}

