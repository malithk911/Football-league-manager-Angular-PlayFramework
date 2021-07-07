import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Match_response_interface} from "../Interfaces/Match_response_interface";
import {Match} from "../Interfaces/Match_interface";
import {Random_match_response} from "../Interfaces/Random_match_response";
import {Date_interface} from "../Interfaces/Date_interface";

@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})

export class MatchComponent implements OnInit {
  matchData: Match_response_interface;
  matchList: Match[];
  searchList: Match[];
  randMatchData: Random_match_response;
  randomMatch : Match;
  searchListExist: boolean = false;

  constructor(private httpClient: HttpClient) {

    // subscribe object received from backend
    this.getMatches().subscribe(list => {
      this.matchData = list;
      this.matchList = this.matchData.response;
    });
  }

  ngOnInit(): void {
  }

  // subscribe object received from backend
  getLeagueMatchesSorted(){
    this.searchListExist = false;
    this.getSortedMatches().subscribe(matchList => {
      this.matchData = matchList;
      this.matchList = this.matchData.response;
    });
  }

  // subscribe object received from backend
  displayRandomMatch(){
    this.getRandomMatch().subscribe(randMatch =>{
      this.randMatchData = randMatch;
      this.randomMatch = this.randMatchData.response;

      // display random match details in alert box
      alert("RANDOM MATCH\n\n" + "Date : " + this.randomMatch.date.day + "." + this.randomMatch.date.month + "." +
        this.randomMatch.date.year + "\n\nHome Club : " + this.randomMatch.homeClubName + "\nHome Club score : " +
        this.randomMatch.homeClubScore + "\n\nVisiting Club : " + this.randomMatch.visitingClubName +
        "\nVisiting Club score : " + this.randomMatch.visitingClubScore);
    });
  }

  onSubmit(matchItem){
    let splitDate = matchItem.matchDate.split(".", 3); // split date text
    // convert split text to date object
    let dateObj: Date_interface = {day:parseInt(splitDate[0]), month: parseInt(splitDate[1]), year: parseInt(splitDate[2])};
    let enteredDate = dateObj.day + "." + dateObj.month + "." + dateObj.year;
    let iterateDate;

    this.searchList = [];

    for(let i = 0; i < this.matchList.length; i++){
      iterateDate = this.matchList[i].date.day + "." + this.matchList[i].date.month + "." + this.matchList[i].date.year

      if(iterateDate == enteredDate){
        const pushVariable = this.searchList.push(this.matchList[i]); // if entered date == iterate date then add match object to search list
      }
    }
    this.searchListExist = true; // boolean = true
  }
  /*-------------------------------------------------------------------------------------------------------------------*/

  // get match list from backend through http request
  getMatches(): Observable<Match_response_interface> {
    return this.httpClient.get<Match_response_interface>('/matches');
  }

  // get match list from backend through http request
  getSortedMatches(): Observable<Match_response_interface> {
    return this.httpClient.get<Match_response_interface>('/sortMatches');
  }

  // get match list from backend through http request
  getRandomMatch(): Observable<Random_match_response> {
    return this.httpClient.get<Random_match_response>('/randomMatch');
  }
}

