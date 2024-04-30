import { Routes } from '@angular/router';
import { CommandePageComponent } from './commande-page/commande-page.component';
import {AcceuilComponent} from "./acceuil/acceuil.component";
import {FormComponent} from "./formulaire/formulaire.component";
import {AboutPageComponent} from "./about-page/about-page.component";
import {MenuPageComponent} from "./menu-page/menu-page.component";
import {RestaurantPageComponent} from "./restaurant-page/restaurant-page.component";

export const routes: Routes = [
  { path: '', component: AcceuilComponent },
  { path: 'commander', component: CommandePageComponent },
  { path: 'about', component: AboutPageComponent},
  { path: 'menu', component: MenuPageComponent},
  { path: 'restaurant', component: RestaurantPageComponent},
  { path: 'form', component: FormComponent },
];
