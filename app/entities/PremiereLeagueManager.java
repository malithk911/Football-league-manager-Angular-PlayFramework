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
import utils.FileLoadUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

// premiere league manager class that implements LeagueManager interface
public class PremiereLeagueManager implements LeagueManager, Serializable {
    protected int leagueYear; // league start date

    // default constructor
    public PremiereLeagueManager() {

    }

    /**
     * @param leagueYear league start date
     */
    public PremiereLeagueManager(int leagueYear) {
        this.leagueYear = leagueYear;
    }

    /**
     * Method to add a football club to league
     * @param sportsClub FootballClub object
     */
    @Override
    public void add(SportsClub sportsClub) throws IOException, ClassNotFoundException {

        FileLoadUtil.loadMatchesFromFile();
        FileLoadUtil.loadFromFile();

        boolean exists = false;
        for(FootballClub item : LEAGUE_CLUBS){
            if(item.getClubName().equals(sportsClub.getClubName())){
                exists = true;
                System.out.println("\n⚠ Club already exists in league ⚠");
            }
        }

        // check if sportsClub is an instance of FootballClub
        if(sportsClub instanceof SportsClub && !exists){
            LEAGUE_CLUBS.add((FootballClub) sportsClub); // Explicit type casting
            System.out.println("\n\uD83D\uDD14 Club added to league \uD83D\uDD14");
            System.out.println(LEAGUE_CLUBS);
        }
        utils.FileWriteUtil.saveMatchesToFile();
        utils.FileWriteUtil.saveToFile(); // save league details to file
    }

    /**
     * method to delete a football club from league
     * @param sportsClubName sports club name as string
     */
    @Override
    public void delete(String sportsClubName) throws IOException, ClassNotFoundException {

        FileLoadUtil.loadMatchesFromFile();
        FileLoadUtil.loadFromFile();

        boolean found = false;
        for(FootballClub item : LEAGUE_CLUBS){
            if(item.getClubName().equals(sportsClubName)){
                LEAGUE_CLUBS.remove(item);
                System.out.println("\n⚠ Deleted club : " + item);
                System.out.println("\n\uD83D\uDD14 Club deletion successful \uD83D\uDD14\n");
                System.out.println(LEAGUE_CLUBS);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("\n⚠ Error : Club not found ⚠");
        }
        utils.FileWriteUtil.saveToFile(); // save league details to file
    }

    /**
     * method to display statistics
     * @param sportsClubName sports club name as string
     */
    @Override
    public void displayStats(String sportsClubName) {
        boolean found = false;
        for(FootballClub item : LEAGUE_CLUBS){
            if(item.getClubName().equals(sportsClubName)){
                System.out.println("\n" + item.toString());
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("\n⚠ Error : Club not found ⚠");
        }
    }

    /**
     * method display premiere league table
     */
    @Override
    public void displayTable() throws IOException, ClassNotFoundException {
        FileLoadUtil.loadMatchesFromFile();
        FileLoadUtil.loadFromFile();

        LEAGUE_CLUBS.sort(Comparator.comparingInt(FootballClub::getGoalDifference)); // sort clubs according to goal difference
        LEAGUE_CLUBS.sort(Comparator.comparingInt(FootballClub::getNumOfPoints)); // sort clubs according to points
        Collections.reverse(LEAGUE_CLUBS);

        // table headers created using string formatting
        System.out.println("\n——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n", "ClubName", "Location", "G-Scored",
                "G-Conceded", "Points", "Matches", "Wins", "Draws", "Defeats");
        System.out.println("——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        System.out.println();

        // table data displayed using string formatting
        for (FootballClub leagueClub : LEAGUE_CLUBS) {
            System.out.printf("%-15s%-15s%-15d%-15d%-15d%-15d%-15d%-15d%-15d%n", leagueClub.getClubName(),
                    leagueClub.getClubCountry(), leagueClub.getNumOfGoalsScored(),
                    leagueClub.getNumOfGoalsConceded(), leagueClub.getNumOfPoints(),
                    leagueClub.getNumOfMatches(), leagueClub.getNumOfWins(),
                    leagueClub.getNumOfDraws(), leagueClub.getNumOfDefeats());
            System.out.println("——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        }
        System.out.println("\n");
    }

    /**
     * Adding a played match to league
     * @param match object
     */
    @Override
    public void addPlayedMatch(Match match) throws IOException {
        try{
            boolean exists = false;
            boolean homeClubExist = false;
            boolean visitingClubExist = false;

            utils.FileLoadUtil.loadMatchesFromFile();
            utils.FileLoadUtil.loadFromFile();

            // check if match exists in league by comparing list items with match object
            if (match instanceof Match){
                if(LEAGUE_MATCHES.size() >= 1){
                    for(Match item : LEAGUE_MATCHES){
                        if (item.toString().equals(match.toString())){
                            exists = true;
                            System.out.println("\n⚠ Error: Match already exists in league database ⚠");
                        }
                    }
                }
            }

            // check if clubs in the match exists in league by comparing home and visiting clubs with league clubs
            if (!exists) {
                for (FootballClub club : LEAGUE_CLUBS) {
                    if (club.getClubName().equals(match.getHomeClubName())) {
                        homeClubExist = true;
                    } else if (club.getClubName().equals(match.getVisitingClubName())) {
                        visitingClubExist = true;
                    }
                }
            }

            // if both clubs in exist in league, add match to league and update club statistics
            if (LEAGUE_CLUBS.size() >= 1 && homeClubExist && visitingClubExist){
                LEAGUE_MATCHES.add(match);
                System.out.println("\n\uD83D\uDD14 Match added to league \uD83D\uDD14");
                System.out.println(match);
                System.out.println(LEAGUE_MATCHES);

                // update club statistics of home club and visiting club
                for(FootballClub leagueClub : LEAGUE_CLUBS){
                    if (leagueClub.getClubName().equals(match.getHomeClubName())) {
                        leagueClub.numOfGoalsScored += match.getHomeClubScore();
                        leagueClub.numOfGoalsConceded += match.getVisitingClubScore();
                        leagueClub.numOfMatches += 1;
                        if (match.getHomeClubScore() > match.getVisitingClubScore()){
                            leagueClub.numOfWins += 1;
                            leagueClub.numOfPoints += 3;
                        } else if (match.getHomeClubScore() < match.getVisitingClubScore()){
                            leagueClub.numOfDefeats += 1;
                        } else {
                            leagueClub.numOfDraws += 1;
                            leagueClub.numOfPoints += 1;
                        }
                    } else if ((leagueClub.getClubName().equals(match.getVisitingClubName()))) {
                        leagueClub.numOfGoalsScored += match.getVisitingClubScore();
                        leagueClub.numOfGoalsConceded += match.getHomeClubScore();
                        leagueClub.numOfMatches += 1;
                        if (match.getVisitingClubScore() > match.getHomeClubScore()){
                            leagueClub.numOfWins += 1;
                            leagueClub.numOfPoints += 3;
                        } else if (match.getVisitingClubScore() < match.getHomeClubScore()){
                            leagueClub.numOfDefeats += 1;
                        } else {
                            leagueClub.numOfDraws += 1;
                            leagueClub.numOfPoints += 1;
                        }
                    }
                }
                utils.FileWriteUtil.saveMatchesToFile(); // save matches to file
                utils.FileWriteUtil.saveToFile(); // save league details to file

            } else if((!homeClubExist || !visitingClubExist) && !exists) {
                System.out.println("\n⚠ Error: One or Both clubs dont exist in league ⚠");
            } else if(LEAGUE_CLUBS.size() < 1) {
                System.out.println("\n⚠ Error: Not enough clubs to add played match ⚠");
            }
        } catch (Exception e) {
            System.out.println("\n⚠ Error: Unable to add played match ⚠");
        }
    }

/* ----------------------------------------------------------------------------------------------------------------- */

    /**
     * generate a random played match
     * @return match object with random generated attributes
     */
    public Match generateRandomMatch() throws IOException {
        Match match = null;

        try{
            Random random =  new Random();

            // create random date
            int randomDay = random.nextInt(31) + 1; // random day
            int randomMonth = random.nextInt(12) + 1; // random month
            int randomYear = Menu.premiereLeagueManager.getLeagueYear(); // get league year

            Date randomDate = new Date(randomDay, randomMonth, randomYear); // instantiate date object
            System.out.println("Random date : " + randomDate);

            // select random club existing in league
            FootballClub randomHomeTeam = LEAGUE_CLUBS.get(random.nextInt(LEAGUE_CLUBS.size()));

            // remove arraylist element, this element will be added back later when the addPlayedMatch() method is called
            LEAGUE_CLUBS.remove(randomHomeTeam);

            // select random club existing in league
            FootballClub randomVisitingTeam = LEAGUE_CLUBS.get(random.nextInt(LEAGUE_CLUBS.size()));

            // generate random scores
            int randomHomeScore = random.nextInt(50)+1;
            int randomVisitingScore = random.nextInt(50)+1;

            // return match object
            match = new Match(randomDate, randomHomeTeam.getClubName(), randomVisitingTeam.getClubName(),
                    randomHomeScore, randomVisitingScore);

            addPlayedMatch(match); // call addPlayedMatch() method

        } catch (Exception e){
            System.out.println("⚠ \nError : Couldn't generate match ⚠\n");
        }
        return match;
    }

/* ----------------------------------------------------------------------------------------------------------------- */

    /**
     * getter for leagueStartDate
     * @return Date
     */
    public int getLeagueYear() {
        return leagueYear;
    }

    /**
     * @param leagueYear set league year
     */
    public void setLeagueYear(int leagueYear) {
        this.leagueYear = leagueYear;
    }

    /**
     * toString() method for PremiereLeagueManager class
     * @return object attributes as string
     */
    @Override
    public String toString() {
        return "PremiereLeagueManager {" +
                "leagueStartDate = " + getLeagueYear() +
                "leagueClubs = " + LEAGUE_CLUBS +
                "leagueMatches = " + LEAGUE_MATCHES +
                '}';
    }

    /**
     * @param o object
     * @return leagueYear
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PremiereLeagueManager that = (PremiereLeagueManager) o;
        return leagueYear == that.leagueYear;
    }

    /**
     * @return hashcode values of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(leagueYear);
    }
}


