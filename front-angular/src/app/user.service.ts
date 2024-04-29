import { Injectable } from '@angular/core';
import axios from 'axios'; // Import axios

@Injectable({
  providedIn: 'root'
})
export class UserService {
  // Remplacez par l'URL de votre API
  private clientUrl = 'http://localhost:8083/clients/client'; // URL pour les requêtes liées aux clients

  // Entrez votre token ici
  private token = "";
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

  async getUserByEmail(email: string | undefined) {
    this.getToken();
    console.log(email);
    try {
      const response = await axios.get(`http://localhost:8083/clients/client/existsByEmail?email=${email}`, {
        headers: {
          'Authorization': `Bearer ${this.token}`
        }
      });
      // Si l'utilisateur existe, retournez les données de l'utilisateur
      // Sinon, retournez null ou undefined
      return response.data ? response.data : null;
    } catch (err) {
      console.error('Error while checking client:', err);
    }
  }

  async createClient(client: any) {
    const response = await axios.post(`${this.clientUrl}/create`, client, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    });
    return response.data;
  }
}
