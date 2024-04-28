import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";
import {AuthButtonComponent} from "../connection/connection.component";

@Component({
  selector: 'app-nav-bar',
  standalone: true,
    imports: [
        RouterLink,
        AuthButtonComponent
    ],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {

}
