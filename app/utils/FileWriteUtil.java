package utils;

// imports
import entities.Menu;
import java.io.*;

public class FileWriteUtil {
    /**
     * method to save data structure containing objects to file using FileOutputStream
     * @throws IOException IOException
     */
    public static void saveToFile() throws IOException {
        try{
            /*
             * Create file object using FileOutputStream
             * Save league club details
             */
            FileOutputStream file1 = new FileOutputStream("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PremiereLeague.txt");
            ObjectOutput objectOutput1 = new ObjectOutputStream(file1); // create object objectOutput from objectOutputStream
            objectOutput1.writeObject(Menu.premiereLeagueManager.LEAGUE_CLUBS); // write object to file

            System.out.println("\n\uD83D\uDD14 League details saved to file \uD83D\uDD14");
            objectOutput1.close(); // close object output stream
            file1.close();

        } catch (FileNotFoundException Exception){
            new File("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PremiereLeague.txt");
            saveToFile();
        }
    }

    public static void saveMatchesToFile() throws IOException {
        try{
            /*
             * Create file object using FileOutputStream
             * Save played match details
             */
            FileOutputStream file2 = new FileOutputStream("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PlayedMatchDetails.txt");
            ObjectOutput objectOutput2 = new ObjectOutputStream(file2); // create object objectOutput from objectOutputStream
            objectOutput2.writeObject(Menu.premiereLeagueManager.LEAGUE_MATCHES); // write object to file

            System.out.println("\n\uD83D\uDD14 Played match details saved to file \uD83D\uDD14\n");
            System.out.println(Menu.premiereLeagueManager.LEAGUE_MATCHES);
            objectOutput2.close(); // close object output stream
            file2.close();
        } catch (FileNotFoundException Exception){
            new File("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PlayedMatchDetails.txt");
            saveMatchesToFile();
        }
    }
}

