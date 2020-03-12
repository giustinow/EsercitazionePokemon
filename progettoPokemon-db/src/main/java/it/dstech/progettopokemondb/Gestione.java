package it.dstech.progettopokemondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Gestione {

	private String username;
	private String password;
	private String url;
	private Connection connessione;
	private Statement statement;

	public Gestione() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.username = "root";
		this.password = "pavillion";
		this.url = "jdbc:mysql://localhost:3306/pokemon?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		this.connessione = DriverManager.getConnection(url, username, password);
		this.statement = connessione.createStatement();
	}

	public void insertPokemon(Pokemon pokemon) throws SQLException {
		String queryInserimentoPokemon = "INSERT INTO `pokemon`.`pokemon` (`nome`, `hp`, `atk`, `def`, `res`, `evoluzione`) VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement prepareStatement = connessione.prepareStatement(queryInserimentoPokemon);
		prepareStatement.setString(1, pokemon.getNome());
		prepareStatement.setInt(2, pokemon.getHp());
		prepareStatement.setInt(3, pokemon.getAttacco());
		prepareStatement.setInt(4, pokemon.getDifesa());
		prepareStatement.setInt(5, pokemon.getVelocita());
		prepareStatement.setString(6, pokemon.getEvoluzione());
		prepareStatement.execute();
	}

	public void deletePokemon(int id) throws SQLException {
		String queryEliminaPokemon = "DELETE FROM `pokemon`.`pokemon` WHERE id = ?;";
		PreparedStatement prepareStatement = connessione.prepareStatement(queryEliminaPokemon);
		prepareStatement.setInt(1, id);
		prepareStatement.execute();
	}

	public void updatePokemonName(int id, String pokemonName) throws SQLException {
		String queryModificaPokemon = "UPDATE `pokemon`.`pokemon` SET pokemon.nome = ? WHERE id = ?;";
		PreparedStatement prepareStatement = connessione.prepareStatement(queryModificaPokemon);
		prepareStatement.setString(1, pokemonName);
		prepareStatement.setInt(2, id);
		prepareStatement.execute();
	}

	public void retrivePokemon() throws SQLException {
		int contatore = 1;
		ResultSet risultatoQuery = statement.executeQuery("select * from `pokemon`.`pokemon`");
		System.out.println(" ID "+ " " + "  Nome  " + " " + " HP"  + "" + " ATK " + "" + "DEF " + "" + "RES " + "" + "Evoluzione");
		System.out.println("------------------------------------------");
		while (risultatoQuery.next()) {
			String nome = risultatoQuery.getString("Nome");
			int hp = risultatoQuery.getInt("hp");
			int atk = risultatoQuery.getInt("ATK");
			int def = risultatoQuery.getInt("DEF");
			int res = risultatoQuery.getInt("RES");
			String evoluzione = risultatoQuery.getString("evoluzione");
			System.out.println("[ " + contatore + " ] " +  nome + " " + hp + " " + atk + " " + def + " " + res + " " + evoluzione);
			contatore++;
		}
	}

	public void sortByAttack(boolean x) throws SQLException {
		if (x) {
			ResultSet risultatoQuery = statement.executeQuery("select * from `pokemon`.`pokemon` order by atk asc");
			System.out.println("Nome  " + "  " + " HP"  + "" + " ATK " + "" + "DEF " + "" + "RES " + "" + "Evoluzione");
			System.out.println("------------------------------------------");
			while (risultatoQuery.next()) {
				String nome = risultatoQuery.getString("Nome");
				int hp = risultatoQuery.getInt("hp");
				int atk = risultatoQuery.getInt("ATK");
				int def = risultatoQuery.getInt("DEF");
				int res = risultatoQuery.getInt("RES");
				String evoluzione = risultatoQuery.getString("evoluzione");
				System.out.println(nome + " " + hp + " " + atk + " " + def + " " + res + " " + evoluzione);
			}
			return;
		} else {
			ResultSet risultatoQuery = statement.executeQuery("select * from `pokemon`.`pokemon` order by atk desc");
			System.out.println("Nome  " + "  " + " HP"  + "" + " ATK " + "" + "DEF " + "" + "RES " + "" + "Evoluzione");
			System.out.println("------------------------------------------");
			while (risultatoQuery.next()) {
				String nome = risultatoQuery.getString("Nome");
				int hp = risultatoQuery.getInt("hp");
				int atk = risultatoQuery.getInt("ATK");
				int def = risultatoQuery.getInt("DEF");
				int res = risultatoQuery.getInt("RES");
				String evoluzione = risultatoQuery.getString("evoluzione");
				System.out.println(nome + " " + hp + " " + atk + " " + def + " " + res + " " + evoluzione);
			}
			return;
		}

	}

	public void sortByDefense(boolean x) throws SQLException {
		if (x) {
			ResultSet risultatoQuery = statement.executeQuery("select * from `pokemon`.`pokemon` order by def asc");
			System.out.println("Nome  " + "  " + " HP"  + "" + " ATK " + "" + "DEF " + "" + "RES " + "" + "Evoluzione");
			System.out.println("------------------------------------------");
			while (risultatoQuery.next()) {
				String nome = risultatoQuery.getString("Nome");
				int hp = risultatoQuery.getInt("hp");
				int atk = risultatoQuery.getInt("ATK");
				int def = risultatoQuery.getInt("DEF");
				int res = risultatoQuery.getInt("RES");
				String evoluzione = risultatoQuery.getString("evoluzione");
				System.out.println(nome + " " + hp + " " + atk + " " + def + " " + res + " " + evoluzione);
			}
			return;
		} else {
			ResultSet risultatoQuery = statement.executeQuery("select * from `pokemon`.`pokemon` order by def desc");
			System.out.println("Nome  " + "  " + " HP"  + "" + " ATK " + "" + "DEF " + "" + "RES " + "" + "Evoluzione");
			System.out.println("------------------------------------------");
			while (risultatoQuery.next()) {
				String nome = risultatoQuery.getString("Nome");
				int hp = risultatoQuery.getInt("hp");
				int atk = risultatoQuery.getInt("ATK");
				int def = risultatoQuery.getInt("DEF");
				int res = risultatoQuery.getInt("RES");
				String evoluzione = risultatoQuery.getString("evoluzione");
				System.out.println(nome + " " + hp + " " + atk + " " + def + " " + res + " " + evoluzione);
			}
			return;
		}

	}

	public void sortByResistance(boolean x) throws SQLException {
		if (x) {
			ResultSet risultatoQuery = statement.executeQuery("select * from `pokemon`.`pokemon` order by res asc");
			System.out.println("Nome  " + "  " + " HP"  + "" + " ATK " + "" + "DEF " + "" + "RES " + "" + "Evoluzione");
			System.out.println("------------------------------------------");
			while (risultatoQuery.next()) {
				String nome = risultatoQuery.getString("Nome");
				int hp = risultatoQuery.getInt("hp");
				int atk = risultatoQuery.getInt("ATK");
				int def = risultatoQuery.getInt("DEF");
				int res = risultatoQuery.getInt("RES");
				String evoluzione = risultatoQuery.getString("evoluzione");
				System.out.println(nome + " " + hp + " " + atk + " " + def + " " + res + " " + evoluzione);
			}
			return;
		} else {
			ResultSet risultatoQuery = statement.executeQuery("select * from `pokemon`.`pokemon` order by res desc");
			System.out.println("Nome  " + "  " + " HP"  + "" + " ATK " + "" + "DEF " + "" + "RES " + "" + "Evoluzione");
			System.out.println("------------------------------------------");
			while (risultatoQuery.next()) {
				String nome = risultatoQuery.getString("Nome");
				int hp = risultatoQuery.getInt("hp");
				int atk = risultatoQuery.getInt("ATK");
				int def = risultatoQuery.getInt("DEF");
				int res = risultatoQuery.getInt("RES");
				String evoluzione = risultatoQuery.getString("evoluzione");
				System.out.println(nome + " " + hp + " " + atk + " " + def + " " + res + " " + evoluzione);
			}
			return;
		}

	}


}
