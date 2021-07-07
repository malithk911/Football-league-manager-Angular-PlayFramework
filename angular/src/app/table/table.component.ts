import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FootballClub} from "../Interfaces/FootballClub_interface";
import {Observable} from "rxjs";
import {ResponseInterface} from "../Interfaces/Response_interface";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})

export class TableComponent implements OnInit {
  leagueTableData: ResponseInterface;
  myTable: FootballClub[]; // array of type footballClub

  constructor(private httpClient: HttpClient) {

    // subscribe object received from backend
    this.getUsers().subscribe(list => {
      this.leagueTableData = list;
      this.myTable = this.leagueTableData.response; // assign footballClub array to myTable
    });
  }

  ngOnInit(): void {
  }

  // subscribe object received from backend
  getSortedByGoals(){
    this.sortByGoals().subscribe(goalsSorted => {
      this.leagueTableData = goalsSorted;
      this.myTable = this.leagueTableData.response;
    })
  }

  // subscribe object received from backend
  getSortedByPoints(){
    this.getUsers().subscribe(pointsSorted => {
      this.leagueTableData = pointsSorted;
      this.myTable = this.leagueTableData.response;
    });
  }

  // subscribe object received from backend
  getSortedByWins(){
    this.sortByWins().subscribe(winsSorted => {
      this.leagueTableData = winsSorted;
      this.myTable = this.leagueTableData.response;
    });
  }

  // get list of clubs from backend through http request
  getUsers(): Observable<ResponseInterface> {
    return this.httpClient.get<ResponseInterface>('/table');
  }

  // get list of clubs from backend through http request
  sortByGoals(): Observable<ResponseInterface> {
    return this.httpClient.get<ResponseInterface>('/sortByGoals');
  }

  // get list of clubs from backend through http request
  sortByWins(): Observable<ResponseInterface> {
    return this.httpClient.get<ResponseInterface>('/sortByWins');
  }
}


