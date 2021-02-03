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
import java.util.ArrayList;
import java.util.Objects;

/**
 * Match class that holds information regarding a specific match in the league
 */
public class Match implements Serializable {
    protected Date date;
    protected String homeClubName;
    protected String visitingClubName;
    protected int homeClubScore;
    protected int visitingClubScore;

    // default constructor
    public Match() {
    }

    /**
     *
     * @param date date of the match
     * @param homeClubName name of home club
     * @param visitingClubName name of visiting club
     * @param homeClubScore score of home club
     * @param visitingClubScore score of visiting club
     */
    public Match(Date date, String homeClubName, String visitingClubName, int homeClubScore, int visitingClubScore) {
        this.date = date;
        this.homeClubName = homeClubName;
        this.visitingClubName = visitingClubName;
        this.homeClubScore = homeClubScore;
        this.visitingClubScore = visitingClubScore;
    }

    // getter for homeClub name
    public String getHomeClubName() {
        return homeClubName;
    }

    // setter for homeClub name
    public void setHomeClubName(String homeClubName) {
        this.homeClubName = homeClubName;
    }

    // getter for visitingClub name
    public String getVisitingClubName() {
        return visitingClubName;
    }

    // setter for visitingClub name
    public void setVisitingClubName(String visitingClubName) {
        this.visitingClubName = visitingClubName;
    }

    // getter for homeClubScore
    public int getHomeClubScore() {
        return homeClubScore;
    }

    // setter for homeClubScore
    public int setHomeClubScore() {
        return this.homeClubScore = getVisitingClubScore();
    }

    // getter for visitingClubScore
    public int getVisitingClubScore() {
        return visitingClubScore;
    }

    // setter for visitingClubScore
    public int setVisitingClubScore() {
        return this.visitingClubScore = getHomeClubScore();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * toString() method of Match class
     * @return attributes of object as string
     */
    @Override
    public String toString() {
        return "Match{" +
                "date = " + getDate() +
                ", homeClubName = " + getHomeClubName() +
                ", visitingClubName = " + getVisitingClubName() +
                ", homeClubScore = " + getHomeClubScore() +
                ", visitingClubScore = " + getVisitingClubScore() +
                '}';
    }

    // equals() method compares properties of objects
    /**
     *
     * @param obj object to compare with
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Match match = (Match) obj;
        return date == match.date &&
                homeClubScore == match.homeClubScore &&
                visitingClubScore == match.visitingClubScore &&
                Objects.equals(homeClubName, match.homeClubName) &&
                Objects.equals(visitingClubName, match.visitingClubName);
    }

    public int hashCode() {
        return Objects.hash(date, homeClubName, visitingClubName, homeClubScore, visitingClubScore);
    }

    public static void sortMatches(ArrayList<Match> matchesList){
        boolean sorted = false;
        Match temp;

        while (!sorted){
            sorted = true;
            for(int i = 0; i < matchesList.size()-1; i++){
                if(matchesList.get(i).getDate().getYear() > matchesList.get(i+1).getDate().getYear()){
                    temp = matchesList.get(i);
                    matchesList.set(i, matchesList.get(i+1));
                    matchesList.set(i+1, temp);
                    sorted = false;
                } else if (matchesList.get(i).getDate().getYear() == matchesList.get(i+1).getDate().getYear()){
                    if(matchesList.get(i).getDate().getMonth() > matchesList.get(i+1).getDate().getMonth()){
                        temp = matchesList.get(i);
                        matchesList.set(i, matchesList.get(i+1));
                        matchesList.set(i+1, temp);
                        sorted = false;
                    } else if(matchesList.get(i).getDate().getMonth() == matchesList.get(i+1).getDate().getMonth()){
                        if(matchesList.get(i).getDate().getDay() > matchesList.get(i+1).getDate().getDay()){
                            temp = matchesList.get(i);
                            matchesList.set(i, matchesList.get(i+1));
                            matchesList.set(i+1, temp);
                            sorted = false;
                        }
                    }
                }
            }
        }
    }


//    public static void sortMatches(){
//        boolean sorted = false;
//        Match temp;
//
//        while (!sorted){
//            sorted = true;
//            for(int i = 0; i < LeagueManager.LEAGUE_MATCHES.size()-1; i++){
//                if(LeagueManager.LEAGUE_MATCHES.get(i).getDate().getYear() > LeagueManager.LEAGUE_MATCHES.get(i+1).getDate().getYear()){
//                    temp = LeagueManager.LEAGUE_MATCHES.get(i);
//                    LeagueManager.LEAGUE_MATCHES.set(i, LeagueManager.LEAGUE_MATCHES.get(i+1));
//                    LeagueManager.LEAGUE_MATCHES.set(i+1, temp);
//                    sorted = false;
//                } else if (LeagueManager.LEAGUE_MATCHES.get(i).getDate().getYear() == LeagueManager.LEAGUE_MATCHES.get(i+1).getDate().getYear()){
//                    if(LeagueManager.LEAGUE_MATCHES.get(i).getDate().getMonth() > LeagueManager.LEAGUE_MATCHES.get(i+1).getDate().getMonth()){
//                        temp = LeagueManager.LEAGUE_MATCHES.get(i);
//                        LeagueManager.LEAGUE_MATCHES.set(i, LeagueManager.LEAGUE_MATCHES.get(i+1));
//                        LeagueManager.LEAGUE_MATCHES.set(i+1, temp);
//                        sorted = false;
//                    } else if(LeagueManager.LEAGUE_MATCHES.get(i).getDate().getMonth() == LeagueManager.LEAGUE_MATCHES.get(i+1).getDate().getMonth()){
//                        if(LeagueManager.LEAGUE_MATCHES.get(i).getDate().getDay() > LeagueManager.LEAGUE_MATCHES.get(i+1).getDate().getDay()){
//                            temp = LeagueManager.LEAGUE_MATCHES.get(i);
//                            LeagueManager.LEAGUE_MATCHES.set(i, LeagueManager.LEAGUE_MATCHES.get(i+1));
//                            LeagueManager.LEAGUE_MATCHES.set(i+1, temp);
//                            sorted = false;
//                        }
//                    }
//                }
//            }
//        }
//    }
}
