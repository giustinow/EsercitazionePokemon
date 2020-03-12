package it.dstech.progettopokemondb;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		Gestione gestione = new Gestione();
		while (true) {
			menu();
			int scelta = input.nextInt();
			input.nextLine();
			switch (scelta) {
			case 1: {
				gestione.insertPokemon(nuovoPokemon(input));
				break;
			}
			case 2:{
				gestione.updatePokemonName(scegliId(input, gestione), nomeNuovo(input));
				break;
			}
			case 3:{
				gestione.deletePokemon(scegliId(input, gestione));
				break;
			}
			case 4:{
				gestione.retrivePokemon();
				break;
			}
			case 5:{
				gestione.sortByAttack(true);
				break;
			}
			case 6:{
				gestione.sortByAttack(false);
				break;
			}
			case 7:{
				gestione.sortByDefense(true);
				break;
			}
			case 8:{
				gestione.sortByDefense(false);
				break;	
			}
			case 9:{
				gestione.sortByResistance(true);
				break;
			}
			case 10:{
				gestione.sortByResistance(false);
				break;
			}
			case 11:{
				
			}
			default:{
				input.close();
				System.exit(0);
			}
			}
		}
	}
	public static int scegliId (Scanner input, Gestione gestione) throws SQLException {
		gestione.retrivePokemon();
		System.out.println("Scegli l'ID del pokemon");
		return input.nextInt();	
	}
	public static String nomeNuovo(Scanner input) {
		System.out.println("Inserisci il nome del nuovo Pokemon");
		return input.nextLine();
	}
	public static Pokemon nuovoPokemon(Scanner input) {
		System.out.println("Inserisci il NOME del tuo Pokemon");
		String nome = input.nextLine();
		System.out.println("Inserisci l'HP del pokemon");
		int hp = input.nextInt();
		System.out.println("Inserisci il livello di ATTACCO del Pokemon");
		int attacco = input.nextInt();
		input.nextLine();
		System.out.println("Inserisci il livello di DIFESA del Pokemon");
		int difesa = input.nextInt();
		input.nextLine();
		System.out.println("Inserisci il livello di VELOCITA del Pokemon");
		int velocita = input.nextInt();
		input.nextLine();
		System.out.println("Inserisci lo stadio di evoluzione del Pokemon");
		String evoluzione = input.nextLine();
		return new Pokemon(nome, hp, attacco, difesa, velocita, evoluzione);
	}

	public static void menu() {
		System.out.println("Scegli cosa fare");
		System.out.println("************************************************************************");
		System.out.println("1. Inserisci un nuovo Pokemon da mettere al centro Pokemon");
		System.out.println("2. Modfica il Pokemon");
		System.out.println("3. Rimuovi il Pokemon dal centro Pokemon");
		System.out.println("4. Stampa la lista di tutti i Pokemon");
		System.out.println("5. Stampa la lista in ordine CRESCENTE per ATTACCO dei Pokemon");
		System.out.println("6. Stampa la lista in ordine DECRESCENTE per ATTACCO dei Pokemon");
		System.out.println("7. Stampa la lista in ordine CRESCENTE per DIFESA dei Pokemon");
		System.out.println("8. Stampa la lista in ordine DECRESCENTE per DIFESA dei Pokemon");
		System.out.println("9. Stampa la lista in ordine CRESCENTE per RESISTENZA dei Pokemon");
		System.out.println("10. Stampa la lista in ordine DECRESCENTE per RESISTENZA dei Pokemon");
		System.out.println("11. ESCI");
		System.out.println("************************************************************************");

	}


}
