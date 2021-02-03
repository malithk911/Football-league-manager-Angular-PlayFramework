package utils;

import entities.FootballClub;
import entities.Match;
import entities.Menu;
import java.io.*;
import java.util.ArrayList;

public class FileLoadUtil {
    /**
     * load objects to data structure from file
     */
    @SuppressWarnings("Unchecked")
    public static void loadFromFile() {
        try{
            /*
             * Loading league details from saved file onto program data structure
             */
            ArrayList<FootballClub> tempList1; // temporary arraylist
            FileInputStream inputStream1 = new FileInputStream("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PremiereLeague.txt");
            ObjectInputStream objectInputStream1 = new ObjectInputStream(inputStream1);

            tempList1 = (ArrayList<FootballClub>) objectInputStream1.readObject(); // type casting

            Menu.premiereLeagueManager.LEAGUE_CLUBS.clear(); // clear league clubs arraylist
            Menu.premiereLeagueManager.LEAGUE_CLUBS.addAll(tempList1); // add loaded object to data structure
            System.out.println("\n\uD83D\uDD14 League details loaded from file \uD83D\uDD14\n");

            System.out.println(Menu.premiereLeagueManager.LEAGUE_CLUBS);
            objectInputStream1.close(); // close object input stream
            inputStream1.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("\n⚠ Error : File not found ⚠");
        }
        catch(EOFException e){
            System.out.println("\n⚠ Error : End of stream reached unexpectedly ⚠");
        }
        catch(Exception e){
            System.out.println("\n⚠ Error while loading file ⚠");
        }
    }

    /**
     * load objects to data structure from file
     * @throws IOException IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    @SuppressWarnings("Unchecked")
    public static void loadMatchesFromFile() throws IOException, ClassNotFoundException {
        try{
            /*
             * Loading played match details from saved file onto program data structure
             */
            ArrayList<Match> tempList2; // temporary arraylist
            FileInputStream inputStream2 = new FileInputStream("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PlayedMatchDetails.txt");
            ObjectInputStream objectInputStream2 = new ObjectInputStream(inputStream2);

            tempList2 = (ArrayList<Match>) objectInputStream2.readObject(); // type casting

            Menu.premiereLeagueManager.LEAGUE_MATCHES.clear(); // clear league matches arraylist
            Menu.premiereLeagueManager.LEAGUE_MATCHES.addAll(tempList2); // add loaded object to data structure
            System.out.println("\n\uD83D\uDD14 Match details loaded from file \uD83D\uDD14\n");
            Menu.premiereLeagueManager.setLeagueYear(Menu.premiereLeagueManager.LEAGUE_MATCHES.get(0).getDate().getYear());

            System.out.println(Menu.premiereLeagueManager.LEAGUE_MATCHES);
            objectInputStream2.close(); // close object input stream
            inputStream2.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("\n⚠ Error : File not found ⚠");
        }
        catch(EOFException e){
            System.out.println("\n⚠ Error : End of stream reached unexpectedly ⚠");
        }
        catch(Exception e){
            System.out.println("\n⚠ Error while loading file ⚠");
        }
    }
}

