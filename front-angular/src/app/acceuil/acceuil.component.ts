import { Component } from '@angular/core';
import {AuthButtonComponent} from "../connection/connection.component";

@Component({
  selector: 'app-acceuil',
  standalone: true,
    imports: [
        AuthButtonComponent
    ],
  templateUrl: './acceuil.component.html',
  styleUrl: './acceuil.component.css'
})
export class AcceuilComponent {

}
