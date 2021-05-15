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
import java.io.IOException;
import java.util.ArrayList;

public interface LeagueManager {
    // Array lists to hold all the clubs
    static final ArrayList<FootballClub> LEAGUE_CLUBS = new ArrayList<>();
    static final ArrayList<SportsClub> SCHOOL_CLUBS = new ArrayList<>();
    static final ArrayList<SportsClub> UNI_CLUBS = new ArrayList<>();

    // Array list to hold all the details of each match played in the league
    static final ArrayList<Match> LEAGUE_MATCHES = new ArrayList<>();

    // abstract methods which are implemented in premiereLeagueManager class
    void add(SportsClub sportsClub) throws IOException, ClassNotFoundException; // method to add a sports club
    void delete(String sportsClubName) throws IOException, ClassNotFoundException; // method to delete a sports club
    void displayStats(String sportsClubName); // display club statistics
    void displayTable() throws IOException, ClassNotFoundException; // display premiere league table
    void addPlayedMatch(Match match) throws IOException; // add a played match
}


