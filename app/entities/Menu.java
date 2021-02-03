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
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static PremiereLeagueManager premiereLeagueManager = new PremiereLeagueManager();
    protected static int plYear;
    protected static int count;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        obtainLeagueYear();
        runMenu();
    }

    /**
     * Console Menu
     */
    public static void runMenu() throws IOException, ClassNotFoundException {

//        FootballClub fc = new SchoolFootballClub();

        boolean exit = false;
        while(!exit){
            try{
System.out.println("\n—————————————————————————————————— PREMIERE LEAGUE ——————————————————————————————————");
                System.out.println("\n-- Choose an option -- \n");
                System.out.println("⬤ Press 1 to add league club.");
                System.out.println("⬤ Press 2 delete league club.");
                System.out.println("⬤ Press 3 view statistics of league club.");
                System.out.println("⬤ Press 4 to display premiere league table.");
                System.out.println("⬤ Press 5 to add played match to league.");
                System.out.println("⬤ Press 6 to save to file.");
                System.out.println("⬤ Press 7 to load from file.");
                System.out.println("⬤ Press 8 to open GUI.");
                System.out.println("⬤ Press 9 to quit.");

                Scanner keyboardInput = new Scanner (System.in);
                int choice = keyboardInput.nextInt();

                switch(choice){
                    case 1: // get club details

System.out.println("\n—————————————————————————————————— Add a club to league ——————————————————————————————————");

                        System.out.println("\n⯁ Enter club name : ");
                        keyboardInput.nextLine();
                        String clubName = keyboardInput.nextLine().toLowerCase(); // convert club name to lower case

                        if(!clubName.isEmpty()){
                            System.out.println("⯁ Enter club country : ");
                            String clubCountry = keyboardInput.nextLine().toLowerCase();

                            if(!clubCountry.isEmpty()){
                                FootballClub newFootballClub = new FootballClub(clubName, clubCountry, 0,
                        0, 0, 0, 0, 0, 0);

                                Menu.premiereLeagueManager.add(newFootballClub); // add a football club to league

                            } else {
                                System.out.println("\n⚠ Error: Must enter club country! ⚠");
                                exit = true;
                                runMenu();
                            }
                        } else {
                            System.out.println("\n⚠ Error: Must enter club name! ⚠");
                            exit = true;
                            runMenu();
                        }

                        break;
                    case 2:

System.out.println("\n—————————————————————————————————— Delete a club from league ——————————————————————————————————");
                        System.out.println("\n⯁ Enter club name to delete : ");
                        keyboardInput.nextLine();
                        String deleteClubName = keyboardInput.nextLine().toLowerCase(); // convert club name to lower case

                        Menu.premiereLeagueManager.delete(deleteClubName); // delete a football club from league

                        break;
                    case 3:

System.out.println("\n—————————————————————————————————— View club statistics ——————————————————————————————————");
                        System.out.println("\n⯁ Enter club name to view statistics : ");
                        keyboardInput.nextLine();
                        String viewClubStats = keyboardInput.nextLine().toLowerCase(); // convert club name to lower case

                        Menu.premiereLeagueManager.displayStats(viewClubStats); // view stats of a club

                        break;
                    case 4:

                        Menu.premiereLeagueManager.displayTable(); // display premiere league table

                        break;
                    case 5:

System.out.println("\n—————————————————————————————————— Add a played match ——————————————————————————————————");
                        System.out.println("\n---- Premiere League " + Menu.premiereLeagueManager.getLeagueYear() + " ----");

                        Date dateOfMatch = new Date(); // create a date object
                        System.out.println("\n⯁ Enter date of match (DD.MM.YYYY) : ");
                        String userInputDate = keyboardInput.next();

                        // split date string into day, month and year
                        String [] arr = userInputDate.split("\\.", 3);

                        // convert split values to integer
                        if((Integer.parseInt(arr[0]) > 0 && Integer.parseInt(arr[0]) <= 31) &&
                                (Integer.parseInt(arr[1]) > 0 && Integer.parseInt(arr[1]) <= 12) &&
                                (Integer.parseInt(arr[2]) == Menu.premiereLeagueManager.getLeagueYear())){
                            dateOfMatch.setDay(Integer.parseInt(arr[0]));
                            dateOfMatch.setMonth(Integer.parseInt(arr[1]));
                            dateOfMatch.setYear(Integer.parseInt(arr[2]));
                        } else {
                            System.out.println("\n⚠ Error: invalid date. Enter a valid date ⚠");
                            break;
                        }
                        System.out.println(dateOfMatch.toString());

                        System.out.println("\n⯁ Enter home club name : ");
                        keyboardInput.nextLine();
                        String homeClubName = keyboardInput.nextLine().toLowerCase();

                        System.out.println("⯁ Enter visiting club name : ");
                        String visitingClubName = keyboardInput.nextLine().toLowerCase();

                        System.out.println("⯁ Enter home club score : ");
                        int homeClubScore = keyboardInput.nextInt();

                        System.out.println("⯁ Enter visiting club score : ");
                        int visitingClubScore = keyboardInput.nextInt();

                        if((homeClubScore < 50 && homeClubScore >= 0) && (visitingClubScore < 50 && visitingClubScore >= 0)){
                            // create match object
                            Match match = new Match(dateOfMatch, homeClubName, visitingClubName, homeClubScore,
                                    visitingClubScore);
                            // call addPlayedMatch() method and pass in match as parameter
                            Menu.premiereLeagueManager.addPlayedMatch(match);
                        } else {
                            System.out.println("\n⚠ Error: Invalid score! ⚠");
                            exit = true;
                            runMenu();
                        }

                        break;
                    case 6:
                        utils.FileWriteUtil.saveMatchesToFile(); // save matches to file
                        utils.FileWriteUtil.saveToFile(); // save league details to file

                        break;
                    case 7:
                        utils.FileLoadUtil.loadMatchesFromFile(); // load matches from file
                        utils.FileLoadUtil.loadFromFile(); // load league details from file

                        break;
                    case 8:

                        if(count == 0){
                            callSbt(); // invoke local server
                            count += 1;
                        } else {
                            runGui();
                        }

                        break;
                    case 9:

                        exit = true;
                        System.out.println("\n\uD83D\uDD14 Program exiting....");
                        System.exit(0); // exit program
                        break;
                }
            }
            catch (Exception e){
                System.out.println("\n⚠ Error! Enter valid input! ⚠");
            }
        }
    }

    /**
     * Obtain league year from user
     */
    public static void obtainLeagueYear(){
        try {
            String userInput;
            Scanner keyboardInput = new Scanner(System.in);
            System.out.println("\n——————————————————————————————————————— WELCOME! ———————————————————————————————————————");
            System.out.println("\n\n⬤ Enter 'a' to continue previous league manager\n⬤ Enter 'b' to start new league manager");
            System.out.println("\n⯁ Enter option : ");
            userInput = keyboardInput.next().toLowerCase();

            if(userInput.equals("b")){
                // create file objects with pathname of save files
                File f = new File("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PremiereLeague.txt");
                File f2 = new File("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PlayedMatchDetails.txt");

                // delete existing save files
                f.delete();
                f2.delete();

                System.out.println("\n⯁ Enter Premiere League Year :");
                plYear = keyboardInput.nextInt(); // get league year input
                Menu.premiereLeagueManager.setLeagueYear(plYear); // set league year
                System.out.println("\nLeague year: " + Menu.premiereLeagueManager.getLeagueYear());

                new File("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PremiereLeague.txt");
                new File("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PlayedMatchDetails.txt");
            }
        } catch (Exception e){
            System.out.println("\n⚠ Error : Enter a valid year! ⚠\n");

            new File("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PremiereLeague.txt");
            new File("C:\\Users\\Malith\\IdeaProjects\\l5-cw-playframework\\app\\utils\\PlayedMatchDetails.txt");
            obtainLeagueYear();
        }
    }

    public static void callSbt(){
        try{
            Process runtime = Runtime.getRuntime().exec("cmd /c start sbt run"); // execution method to start local server

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runGui() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String url = "http://localhost:4200/";
        runtime.exec("rund1132 url.dll, FileProtocolHandler" + url);
    }
}


