import { Component, Inject, OnInit } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import {AsyncPipe, DOCUMENT, NgIf} from '@angular/common';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-auth-button',
  template: `
    <ng-container *ngIf="auth.isAuthenticated$ | async; else loggedOut">
      <button (click)="logout()">DECONNEXION</button>
    </ng-container>

    <ng-template #loggedOut>
      <button (click)="login()">CONNEXION</button>
    </ng-template>
  `,
  standalone: true,
  imports: [
    AsyncPipe,
    NgIf
  ],
  styleUrls: ['./connection.component.css']
})
export class AuthButtonComponent implements OnInit {
  constructor(@Inject(DOCUMENT) public document: Document, public auth: AuthService, private router: Router, private clientService: UserService) {}

  ngOnInit(): void {}

  login(): void {
    this.auth.loginWithRedirect();
  }

  logout(): void {
    this.auth.logout({ logoutParams: { returnTo: document.location.origin } });
    this.auth.user$.subscribe(user => {
      if (user) {
        this.clientService.getUserByEmail(user.email)
          .then(res => {
            if (res) {
              this.router.navigate(['/']); // Replace with the path to your home page
            } else {
              this.router.navigate(['/form']); // Replace with the path to your form
            }
          })
          .catch(err => {
            console.error('Error while checking client:', err);
          });
      }
    });
  }
}
