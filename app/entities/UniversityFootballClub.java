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

// university football club class
public class UniversityFootballClub extends FootballClub implements Serializable {
    protected String uniName; // name of university
    protected int uniRanking; // rank of university club

    // default constructor
    public UniversityFootballClub() {}

    /**
     * @param uniName name of university
     * @param uniRanking ranking
     */
    public UniversityFootballClub(String uniName, int uniRanking) {
        this.uniName = uniName;
        this.uniRanking = uniRanking;
    }

    /**
     * @param numOfGoalsScored num of goals scored
     * @param numOfGoalsConceded num of goals conceded
     * @param numOfPoints num of points
     * @param numOfMatches num of matches
     * @param uniName name of university
     * @param uniRanking ranking
     */
    public UniversityFootballClub(int numOfGoalsScored, int numOfGoalsConceded, int numOfPoints, int numOfMatches,
                                  String uniName, int uniRanking) {
        super(numOfGoalsScored, numOfGoalsConceded, numOfPoints, numOfMatches);
        this.uniName = uniName;
        this.uniRanking = uniRanking;
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
     * @param uniName name of university
     * @param uniRanking ranking
     */
    public UniversityFootballClub(String clubName, String clubLocation, int numOfMembers,
                                  int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsScored,
                                  int numOfGoalsConceded, int numOfMatches, String uniName,
                                  int uniRanking) {
        super(clubName, clubLocation, numOfMembers, numOfWins, numOfDraws, numOfDefeats, numOfGoalsScored,
                numOfGoalsConceded, numOfMatches);
        this.uniName = uniName;
        this.uniRanking = uniRanking;
    }

    // getter for university name
    public String getUniName() {
        return uniName;
    }

    // setter for university name
    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    // getter for university ranking
    public int getUniRanking() {
        return uniRanking;
    }

    // setter for university ranking
    public void setUniRanking(int uniRanking) {
        this.uniRanking = uniRanking;
    }

    /**
     * toString() method for UniversityFootballClub class
     * @return attributes of object as string
     */
    public String toString() {
        return "UniversityFootballClub {" +
                "uniName = " + getUniName() +
                ", uniRanking = " + getUniRanking() +
                ", numOfGoals = " + getNumOfGoalsScored() +
                ", numOfPoints = " + getNumOfPoints() +
                ", numOfPlayedMatches = " + getNumOfMatches() +
                ", numOfMembers = " + getNumOfMembers() +
                ", numOfWins = " + getNumOfWins() +
                ", numOfDraws = " + getNumOfDraws() +
                ", numOfDefeats = " + getNumOfDefeats() +
                '}';
    }

    // equals() method compares properties of objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        UniversityFootballClub that = (UniversityFootballClub) obj;
        return uniRanking == that.uniRanking &&
                uniName.equals(that.uniName);
    }

    // hashCode() method
    public int hashCode() {
        return Objects.hash(super.hashCode(), uniName, uniRanking);
    }

    // compareTo() method
    public int compareTo(UniversityFootballClub obj) {
        return Integer.compare(this.uniRanking, obj.uniRanking);
    }
}
