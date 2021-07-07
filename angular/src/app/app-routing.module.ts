import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MenuComponent } from "./menu/menu.component";
import {TableComponent} from "./table/table.component";
import {MatchComponent} from "./match/match.component";

const routes: Routes = [
  {path: 'menu', component: MenuComponent},
  {path: 'table', component: TableComponent},
  {path: 'matches', component: MatchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
