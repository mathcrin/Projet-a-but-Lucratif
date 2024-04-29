import { Component, OnInit } from '@angular/core';
import { UserService } from "../user.service";
import { AuthService } from '@auth0/auth0-angular';
import { Router } from '@angular/router';
import {FormsModule} from "@angular/forms"; // Import Router

@Component({
  selector: 'app-form',
  templateUrl: './formulaire.component.html',
  standalone: true,
  imports: [
    FormsModule
  ],
  styleUrls: ['./formulaire.component.css']
})
export class FormComponent implements OnInit {
  client = {
    nom: '',
    prenom: '',
    addresse: '',
    mail: '',
    telephone: ''
  };

  constructor(private clientService: UserService, public auth: AuthService, private router: Router) {} // Inject Router

  ngOnInit(): void {
    this.auth.user$.subscribe(user => {
      if (user && user.email) {
        this.client.mail = user.email;
      } else {
        this.client.mail = '';
      }
    });
  }

  onSubmit(): void {
    this.clientService.createClient(this.client)
      .then(res => {
        console.log('Client created:', res);
        this.client = {nom: '', prenom: '', addresse: '', mail: '', telephone: ''};
        this.router.navigate(['/']); // Redirect to home page
      })
      .catch(err => {
        console.error('Error while creating client:', err);
      });
  }
}
