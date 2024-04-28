import { Component, Inject } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import {AsyncPipe, DOCUMENT, NgIf,CommonModule} from '@angular/common';

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
  styleUrls: ['./connection.component.css'], // Ajout du lien vers le fichier CSS
  imports: [
    AsyncPipe,
    NgIf
  ],
  standalone: true
})
export class AuthButtonComponent {
  constructor(@Inject(DOCUMENT) public document: Document, public auth: AuthService) {
    this.auth.isAuthenticated$.subscribe(value => {
      console.log('Is authenticated:', value);
    });
  }
}
