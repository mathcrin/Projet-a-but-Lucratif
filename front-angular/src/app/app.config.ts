import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideAuth0 } from '@auth0/auth0-angular';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideAuth0({
      domain: 'dev-agy5tyj2bm0mtnps.us.auth0.com',
      clientId: 'H7wxODr5UcxAAh6hB9wXZQ6HxiqnULlK',
      authorizationParams: {
        redirect_uri: window.location.origin
      }
    }),
    provideRouter(routes) // Ajout du fournisseur de routage
  ]
};

