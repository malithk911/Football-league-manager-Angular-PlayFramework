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
import java.util.ArrayList;
import java.util.Objects;

// football club class
public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {
    protected int numOfGoalsScored; // number of goals for club
    protected int numOfGoalsConceded;
    protected int numOfPoints; // number of points scored by club
    protected int numOfMatches; // number of matches played by club
    protected int goalDifference; // num of goals scored - num of goals conceded
    protected Match match; // holds data about a match

    // default constructor
    public FootballClub() {}

    /**
     *
     * @param numOfGoalsScored num of goals scored
     * @param numOfGoalsConceded num of goals conceded
     * @param numOfPoints num of points
     * @param numOfMatches num of matches played
     */
    public FootballClub(int numOfGoalsScored, int numOfGoalsConceded, int numOfPoints, int numOfMatches) {
        this.numOfGoalsScored = numOfGoalsScored;
        this.numOfGoalsConceded = numOfGoalsConceded;
        this.numOfPoints = numOfPoints;
        this.numOfMatches = numOfMatches;
    }

    /**
     *
     * @param clubName club name
     * @param clubLocation club location
     * @param numOfMembers num of members
     * @param numOfWins num of wins
     * @param numOfDraws num of draws
     * @param numOfDefeats num of defeats
     * @param numOfGoalsScored num of goals scored
     * @param numOfGoalsConceded num of goals conceded
     * @param numOfMatches num of matches played
     */
    public FootballClub(String clubName, String clubLocation, int numOfMembers, int numOfWins,
                        int numOfDraws, int numOfDefeats, int numOfGoalsScored, int numOfGoalsConceded,
                        int numOfMatches) {
        super(clubName, clubLocation, numOfMembers, numOfWins, numOfDraws, numOfDefeats);
        this.numOfGoalsScored = numOfGoalsScored;
        this.numOfGoalsConceded = numOfGoalsConceded;
        this.numOfPoints = setNumOfPoints();
        this.numOfMatches = numOfMatches;
        this.goalDifference = setGoalDifference();
    }

    /**
     *
     * @return number of goals scored as integer value
     */
    // getter for numOfGoals
    public int getNumOfGoalsScored() {
        return numOfGoalsScored;
    }

    /**
     *
     * @param numOfGoalsScored integer - number of goals scored
     */
    // setter for numOfGoals
    public void setNumOfGoalsScored(int numOfGoalsScored) {
        this.numOfGoalsScored = numOfGoalsScored;
    }

    /**
     *
     * @return number of goals conceded as integer value
     */
    public int getNumOfGoalsConceded() {
        return numOfGoalsConceded;
    }

    /**
     *
     * @param numOfGoalsConceded integer value
     */
    public void setNumOfGoalsConceded(int numOfGoalsConceded) {
        this.numOfGoalsConceded = numOfGoalsConceded;
    }

    /**
     *
     * @return integer num of points
     */
    // getter for numOfPoints
    public int getNumOfPoints() {
        return numOfPoints;
    }

    /**
     *
     */
    // setter for numOfPoints
    public int setNumOfPoints() {
        return this.numOfPoints = (getNumOfWins() * 3 + getNumOfDraws());
    }

    /**
     *
     * @return integer
     */
    // getter for numOfMatches
    public int getNumOfMatches() {
        return numOfMatches;
    }

    /**
     *
     * @param numOfMatches num of matches played
     */
    // setter for numOfMatches
    public void setNumOfMatches(int numOfMatches) {
        this.numOfMatches = numOfMatches;
    }

    /**
     * @return goal difference
     */
    public int getGoalDifference() {
        return this.goalDifference = (getNumOfGoalsScored() - getNumOfGoalsConceded());
    }

    /**
     * @return calculated goal difference
     */
    public int setGoalDifference() {
        return this.goalDifference = (getNumOfGoalsScored() - getNumOfGoalsConceded());
    }

    /**
     *
     * @return Match
     */
    public Match getMatch() {
        return match;
    }

    /**
     *
     * @param match Match object
     */
    public void setMatch(Match match) {
        this.match = match;
    }

    /**
     *
     * @return attributes of object as string
     */
    // toString() method for FootballClub class
    @Override
    public String toString() {
        return "FootballClub {" + "clubName = " + getClubName() +
                ", clubLocation = " + getClubCountry() +
                ", numOfMembers = " + getNumOfMembers() +
                ", numOfGoals = " + getNumOfGoalsScored() +
                ", numOfPoints = " + getNumOfPoints() +
                ", numOfPlayedMatches = " + getNumOfMatches() +
                ", numOfWins = " + getNumOfWins() +
                ", numOfDraws = " + getNumOfDraws() +
                ", numOfDefeats = " + getNumOfDefeats() +
                '}';
    }

    /**
     *
     * @param obj Object to be compared
     * @return boolean
     */
    // equals() method compares properties of objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        if (!super.equals(obj)) return false;
        FootballClub that = (FootballClub) obj;
        return numOfGoalsScored == that.numOfGoalsScored &&
                numOfPoints == that.numOfPoints &&
                numOfMatches == that.numOfMatches;
    }

    /**
     *
     * @return hashcode of object which is an integer value
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numOfGoalsScored, numOfPoints, numOfMatches);
    }

    /**
     *
     * @param obj FootballClub object
     * @return integer
     */
    // compareTo() method
    @Override
    public int compareTo(FootballClub obj) {
        if(this.numOfPoints == obj.getNumOfPoints()){
            int compareGoalDifference = obj.getGoalDifference();
            return compareGoalDifference-this.goalDifference;
        } else {
            int comparePoints = obj.getNumOfPoints();
            return comparePoints-this.numOfPoints;
        }
    }

    /**
     * sort according to number of goals scored
     */
    public static void compareGoals(ArrayList<FootballClub> footballClub) {
        boolean sorted = false;
        FootballClub temp;

        while(!sorted){
            sorted = true;
            for(int i = 0; i < footballClub.size() - 1; i++){
                if(footballClub.get(i).getNumOfGoalsScored() < footballClub.get(i+1).getNumOfGoalsScored()){
                    temp = footballClub.get(i);
                    footballClub.set(i, footballClub.get(i+1));
                    footballClub.set(i+1, temp);
                    sorted = false;
                }
            }
        }
    }

    /**
     * sort according to number of wins
     */
    public static void compareWins(ArrayList<FootballClub> footballClub) {
        boolean sorted = false;
        FootballClub temp;

        while(!sorted){
            sorted = true;
            for(int i = 0; i < footballClub.size() - 1; i++){
                if(footballClub.get(i).getNumOfWins() < footballClub.get(i+1).getNumOfWins()){
                    temp = footballClub.get(i);
                    footballClub.set(i, footballClub.get(i+1));
                    footballClub.set(i+1, temp);
                    sorted = false;
                }
            }
        }
    }
}
