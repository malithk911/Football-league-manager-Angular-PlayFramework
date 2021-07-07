import { NgModule } from '@angular/core';
import { MatGridListModule } from "@angular/material/grid-list";
import { MatListModule } from "@angular/material/list";
import { MatButtonModule } from "@angular/material/button";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";

const  materialComponents = [
  MatGridListModule,
  MatListModule,
  MatButtonModule,
  MatFormFieldModule,
  MatInputModule
]

@NgModule({
  imports: [materialComponents],
  exports: [materialComponents]
})
export class MaterialModule { }
