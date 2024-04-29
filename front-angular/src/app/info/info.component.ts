import { Component } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import {AsyncPipe, NgIf} from "@angular/common";

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [
    AsyncPipe,
    NgIf
  ],
  template: `
    <ul *ngIf="auth.user$ | async as user">
      <li>{{ user.email }}</li>
    </ul>`
})
export class UserProfileComponent {
  constructor(public auth: AuthService) {}
}
