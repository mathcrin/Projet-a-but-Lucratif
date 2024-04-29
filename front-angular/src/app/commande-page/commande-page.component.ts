import {Component, Injectable, OnInit} from '@angular/core';
import axios from 'axios';
import {AuthButtonComponent} from "../connection/connection.component";

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
    AuthButtonComponent
  ],
})

@Injectable({
  providedIn: 'root'
})

export class CommandePageComponent implements OnInit {
  articles: any[] = [];
  token: string = '';

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

    axios.get('/commandes/articles', { // Utilisation du proxy
      headers: {
        Authorization: `Bearer ${this.token}`
      }
    })
      .then((response) => {
        this.articles = response.data;
        console.log(this.articles);
      })
      .catch((error) => {
        console.error("Une erreure s'est produite lors de la récupération des articles avec le backend", error);
      });
  }
}
