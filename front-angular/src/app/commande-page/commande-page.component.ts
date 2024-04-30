import {Component, Injectable, OnInit} from '@angular/core';
import axios from 'axios';
import {AuthButtonComponent} from "../connection/connection.component";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AuthService} from "@auth0/auth0-angular";
import { UserService } from '../user.service'
import {Router} from "@angular/router";
import Cookies from 'js-cookie';
import {convertOutputFile} from "@angular-devkit/build-angular/src/tools/esbuild/utils";

interface Article {
  id: number;
  nom: string;
  id_Restaurant: number;
  ingredients: string;
  prix: number;
  categorie: string;
}

@Component({
  selector: 'app-commande-page',
  templateUrl: './commande-page.component.html',
  styleUrls: ['./commande-page.component.css'],
  standalone: true,
  imports: [
    AuthButtonComponent,
    CommonModule,
    FormsModule
  ],
})

@Injectable({
  providedIn: 'root'
})

export class CommandePageComponent implements OnInit {
  articles: any[] = [];
  token: string = '';
  panier: any[] = [];
  total = 0;
  detailsCommande: string = '';

  constructor(public auth: AuthService, private userService: UserService, private router: Router) { }

  async getToken(): Promise<void> {
    const url = 'https://dev-agy5tyj2bm0mtnps.us.auth0.com/oauth/token';
    const body = {
      client_id: 'SWpan2FZzWzIGu7eQo9jgLK9jHpepxIF',
      client_secret: 'AAsfsIMiwOQ3iaQTP81iqz3esD5vAu8COM9v500jM7kne468F9idB7ZIbIeK_1-y',
      audience: 'http://localhost:8080',
      grant_type: 'client_credentials'
    };

    try {
      const response = await axios.post(url, body);
      this.token = response.data.access_token;
    } catch (error) {
      console.error('Error while fetching token:', error);
    }
  }

  async ngOnInit() {
    await this.getToken();
    console.log(this.token);
    const savedPanier = Cookies.get('panier');

    axios.get('http://localhost:8080/commandes/articles', {
      headers: {
        Authorization: `Bearer ${this.token}`
      }
    })
      .then((response) => {
        this.articles = response.data;
        if (savedPanier) {
          const savedPanierArray = JSON.parse(savedPanier);
          this.panier = this.articles.filter((item) => {
            return savedPanierArray.includes(item.id);
          });
          this.updateTotal();
        }
        console.log(this.articles);
      })
      .catch((error) => {
        console.error("Une erreur s'est produite lors de la récupération des articles avec le backend", error);
      });
  }

  addPanier(item: any) {
    this.panier.push(item);
    this.updateTotal();
    this.refreshCookiePanier();
    console.log(this.panier);
  }

  removePanier(item: any) {
    const index = this.panier.findIndex((element) => element === item);
    if (index !== -1) {
      this.panier.splice(index, 1);
    }
    this.updateTotal();
    this.refreshCookiePanier();
    console.log(this.panier);
  }

  updateTotal() {
    this.total = 0;
    this.panier.forEach((item) => {
      this.total += item.prix;
    });
    return this.total;
  }

  validerPanier() {
    if(this.panier.length === 0) {
      window.alert('Vous devez remplir le panier avant de valider la commande');
      return;
    }
    if (!this.userService.currentUserId) {
      this.userService
      window.alert('Vous devez être connecté pour valider la commande');
      this.auth.loginWithRedirect()
      return;
    }
    let idarticles = this.panier.map((item) => item.id);
    console.log(idarticles);
    let now = new Date();
    let localDate = new Date(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours()+2, now.getMinutes(), now.getSeconds(), now.getMilliseconds());
    axios.post('http://localhost:8080/commandes/commandes/create', {
      idClient: this.userService.currentUserId,
      dateCommande: localDate,
      details: this.detailsCommande,
      idRestaurant: 1,
      status: 'EnCours',
      articles: idarticles,
    }, {
      headers: {
        Authorization: `Bearer ${this.token}`
      }
    })
      .then((response) => {
        console.log(response);
        this.panier = [];
        this.total = 0;
        this.refreshCookiePanier();
        window.alert('La commande a été passée avec succès, vous avez la journée pour venir la récupérer !');
        // Rediriger l'utilisateur vers la page d'accueil
        this.router.navigate(['/'])
      })
      .catch((error) => {
        console.error("Une erreur s'est produite lors de la validation du panier", error);
        window.alert('Une erreur s\'est produite lors de la validation du panier');
        console.log(this.userService.currentUserId);
      });
  }

  refreshCookiePanier() {
    let articles = this.panier.map((item) => item.id);
    Cookies.set('panier', JSON.stringify(articles));
  }

  //vérifie ques les articles dans le panier sont toujours dans la liste des articles et met à jour les artticles en conséquence
}
