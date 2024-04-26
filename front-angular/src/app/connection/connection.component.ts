import { Component, Inject } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import {AsyncPipe, DOCUMENT, NgIf} from '@angular/common';

@Component({
  selector: 'app-auth-button',
  template: `
    <ng-container *ngIf="auth.isAuthenticated$ | async; else loggedOut">
      <button (click)="auth.logout({ logoutParams: { returnTo: document.location.pathname. } })">
        Log out
      </button>
    </ng-container>

    <ng-template #loggedOut>
      <button (click)="auth.loginWithRedirect()">Log in</button>
    </ng-template>
  `,
  imports: [
    NgIf,
    AsyncPipe
  ],
  standalone: true
})
export class AuthButtonComponent {
  constructor(@Inject(DOCUMENT) public document: Document, public auth: AuthService) {}
}
