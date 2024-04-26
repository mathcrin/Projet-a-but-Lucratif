import { Routes } from '@angular/router';
import { CommandePageComponent } from './commande-page/commande-page.component';
import {AcceuilComponent} from "./acceuil/acceuil.component";

export const routes: Routes = [
  { path: '', component: AcceuilComponent },
  { path: 'commander', component: CommandePageComponent },
];
