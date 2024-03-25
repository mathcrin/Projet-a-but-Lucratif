package fr.uphf.PABLCommandeArticle.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="Commande")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "id_client")
	private Integer idClient;

	@Column(name = "date_commande")
	private Date dateCommande;

	@Column(name = "id_restaurant")
	private Integer idRestaurant;

	@Column(name = "statut")
	private String statut;

	@Column(name = "details")
	private String details;

	@Column(name = "articles")
	private String articles;

	// Constructeurs, getters et setters
}

@Entity
@Table(name="Article")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_article", nullable = false)
	private Integer id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "id_restaurant")
	private Integer idRestaurant;

	@Column(name = "prix")
	private double prix;

	@Column(name = "ingredients")
	private String ingredients;

	@Column(name = "id_categorie")
	private Integer idCategorie;

	// Constructeur avec tous les champs, sauf l'ID
	public Article(String nom, Integer idRestaurant, double prix, String ingredients, Integer idCategorie) {
		this.nom = nom;
		this.idRestaurant = idRestaurant;
		this.prix = prix;
		this.ingredients = ingredients;
		this.idCategorie = idCategorie;
	}
}