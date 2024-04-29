import { Component, Inject, OnInit } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import {AsyncPipe, DOCUMENT, NgIf} from '@angular/common';
import { Router } from '@angular/router';
import { UserService } from '../user.service'; // Remplacez par le chemin vers votre service

@Component({
  selector: 'app-auth-button',
  template: `
    <ng-container *ngIf="auth.isAuthenticated$ | async; else loggedOut">
      <button (click)="auth.logout({ logoutParams: { returnTo: document.location.origin } })">
        DECONNEXION
      </button>
    </ng-container>

    <ng-template #loggedOut>
      <button (click)="auth.loginWithRedirect()">CONNEXION</button>
    </ng-template>
  `,
  standalone: true,
  imports: [
    AsyncPipe,
    NgIf
  ],
  styleUrls: ['./connection.component.css'] // Ajout du lien vers le fichier CSS
})
export class AuthButtonComponent implements OnInit {
  constructor(@Inject(DOCUMENT) public document: Document, public auth: AuthService, private router: Router, private clientService: UserService) {}

  ngOnInit(): void {
    this.auth.user$.subscribe(user => {
      if (user) {
        this.clientService.getUserByEmail(user.email)
          .then(res => {
            if (res) {
           
            } else {
              this.router.navigate(['/form']); // Remplacez par le chemin vers votre formulaire
            }
          })
          .catch(err => {
            console.error('Error while checking client:', err);
          });
      }
    });
  }
}
