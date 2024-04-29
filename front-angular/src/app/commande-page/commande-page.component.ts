import {Component, Injectable, OnInit} from '@angular/core';
import axios from 'axios';
import {AuthButtonComponent} from "../connection/connection.component";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";

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

  constructor() { }

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

  ngOnInit(): void {
    this.getToken();

    axios.get('http://localhost:8080/commandes/articles', {
      headers: {
        Authorization: `Bearer ${this.token}`
      }
    })
      .then((response) => {
        this.articles = response.data;
        console.log(this.articles);
      })
      .catch((error) => {
        console.error("Une erreur s'est produite lors de la récupération des articles avec le backend", error);
      });
  }

  addPanier(item: any) {
    this.panier.push(item);
    this.updateTotal();
    console.log(this.panier);
  }

  removePanier(item: any) {
    this.panier = this.panier.filter((element) => element !== item);
    this.updateTotal();
    console.log(this.panier);
  }

  updateTotal() {
    this.total = 0;
    this.panier.forEach((item) => {
      this.total += item.prix;
    });
    return this.total;
  }

  getidClient() {
    axios.get('http://localhost:8082/clients/client/create', {
      headers: {
        Authorization: `Bearer ${this.token}`
      }
    })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.error("Une erreur s'est produite lors de la récupération de l'identifiant du client", error);
      });
  }

  validerPanier() {
    let idarticles = this.panier.map((item) => item.id);
    axios.post('http://localhost:8082/commandes/commandes/create', {
      id_client: 1,
      date_commande: new Date(),
      id_restaurant: 1,
      status: 'EnCours',
      details: this.detailsCommande,
      article: idarticles,
    }, {
      headers: {
        Authorization: `Bearer ${this.token}`
      }
    })
      .then((response) => {
        console.log(response);
        this.panier = [];
        this.total = 0;
      })
      .catch((error) => {
        console.error("Une erreur s'est produite lors de la validation du panier", error);
      });
  }
}
