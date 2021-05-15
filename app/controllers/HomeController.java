package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.FootballClub;
import entities.Match;
import entities.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.mvc.*;
import utils.ApplicationUtil;
import utils.FileLoadUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    protected static final Logger logger = LoggerFactory.getLogger("controller");

    /**
     * @return arraylist of league clubs as json object
     * @throws IOException exception
     * @throws ClassNotFoundException exception
     */
    public Result listClubs() throws IOException, ClassNotFoundException {
        FileLoadUtil.loadFromFile(); // load league details to file
        ArrayList<FootballClub> result = Menu.premiereLeagueManager.LEAGUE_CLUBS; // assign league clubs arraylist to result arraylist
/* ------------------------------------------------------------------------------------------------------------------ */
        result.sort(Comparator.comparingInt(FootballClub::getGoalDifference)); // sort clubs according to goal difference
        result.sort(Comparator.comparingInt(FootballClub::getNumOfPoints)); // sort clubs according to points
        Collections.reverse(result);
/* ------------------------------------------------------------------------------------------------------------------ */
        logger.debug("In LeagueManagerController.listClubs(), result is: {}", result.toString());
        ObjectMapper mapper = new ObjectMapper(); // create ObjectMapper object
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class); // map result array list to json object
        return ok(ApplicationUtil.createResponse(jsonData, true)); // send json object as response to frontend api request
    }

    /**
     * @return arraylist of league matches as json object
     * @throws IOException exception
     * @throws ClassNotFoundException exception
     */
    public Result listMatches() throws IOException, ClassNotFoundException {
        FileLoadUtil.loadMatchesFromFile();
        Menu.premiereLeagueManager.setLeagueYear(Menu.premiereLeagueManager.LEAGUE_MATCHES.get(0).getDate().getYear());
        ArrayList<Match> result = Menu.premiereLeagueManager.LEAGUE_MATCHES; // assign matches array list to result arraylist
        logger.debug("In LeagueManagerController.listClubs(), result is: {}", result.toString());
        ObjectMapper mapper = new ObjectMapper(); // create ObjectMapper object
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class); // map result array list to json object
        return ok(ApplicationUtil.createResponse(jsonData, true)); // send json object as response to frontend api request
    }

    /**
     * @return arraylist of league matches as json object
     * @throws IOException exception
     * @throws ClassNotFoundException exception
     */
    public Result sortMatchList() throws IOException, ClassNotFoundException {
        FileLoadUtil.loadMatchesFromFile();
        Menu.premiereLeagueManager.setLeagueYear(Menu.premiereLeagueManager.LEAGUE_MATCHES.get(0).getDate().getYear());
        ArrayList<Match> result = Menu.premiereLeagueManager.LEAGUE_MATCHES; // assign matches array list to result arraylist
        Match.sortMatches(result); // sort results array list
        logger.debug("In LeagueManagerController.listClubs(), result is: {}", result.toString());
        ObjectMapper mapper = new ObjectMapper(); // create ObjectMapper object
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class); // map result array list to json object
        return ok(ApplicationUtil.createResponse(jsonData, true)); // send json object as response to frontend api request
    }

    /**
     * @return random match
     * @throws IOException exception
     * @throws ClassNotFoundException exception
     */
    public Result produceRandomMatch() throws IOException, ClassNotFoundException {
        FileLoadUtil.loadFromFile();
        Menu.premiereLeagueManager.setLeagueYear(Menu.premiereLeagueManager.LEAGUE_MATCHES.get(0).getDate().getYear());
        Match result = Menu.premiereLeagueManager.generateRandomMatch(); // assign generated random match to result match object
        logger.debug("In LeagueManagerController.listClubs(), result is: {}", result.toString());
        ObjectMapper mapper = new ObjectMapper(); // create ObjectMapper object
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class); // map result array list to json object
        return ok(ApplicationUtil.createResponse(jsonData, true)); // send json object as response to frontend api request
    }

    /**
     * @return arraylist of league clubs as json object
     * @throws IOException exception
     * @throws ClassNotFoundException exception
     */
    public Result goalsSortedClubs() throws IOException, ClassNotFoundException {
        FileLoadUtil.loadFromFile();
        ArrayList<FootballClub> result = Menu.premiereLeagueManager.LEAGUE_CLUBS; // assign league clubs array list to result arraylist
        FootballClub.compareGoals(result); // sort result array list
        logger.debug("In LeagueManagerController.listClubs(), result is: {}", result.toString());
        ObjectMapper mapper = new ObjectMapper(); // create ObjectMapper object
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class); // map result array list to json object
        return ok(ApplicationUtil.createResponse(jsonData, true)); // send json object as response to frontend api request
    }

    /**
     * @return arraylist of league clubs as json object
     * @throws IOException exception
     * @throws ClassNotFoundException exception
     */
    public Result winsSortedClubs() throws IOException, ClassNotFoundException {
        FileLoadUtil.loadFromFile();
        ArrayList<FootballClub> result = Menu.premiereLeagueManager.LEAGUE_CLUBS; // assign league clubs array list to result arraylist
        FootballClub.compareWins(result); // sort result array list
        logger.debug("In LeagueManagerController.listClubs(), result is: {}", result.toString());
        ObjectMapper mapper = new ObjectMapper(); // create ObjectMapper object
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class); // map result array list to json object
        return ok(ApplicationUtil.createResponse(jsonData, true)); // send json object as response to frontend api request
    }
}
