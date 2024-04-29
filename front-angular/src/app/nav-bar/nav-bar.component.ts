import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";
import {AuthButtonComponent} from "../connection/connection.component";
import {UserProfileComponent} from "../info/info.component";

@Component({
  selector: 'app-nav-bar',
  standalone: true,
  imports: [
    RouterLink,
    AuthButtonComponent,
    UserProfileComponent
  ],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {

}
