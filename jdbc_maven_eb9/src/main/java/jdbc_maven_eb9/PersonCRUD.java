package jdbc_maven_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonCRUD {
	public Connection getConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb","root","root");

		return connection;
	}

	public void savePerson(Person person) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?)");
		preparedstatement.setInt(1, person.getId());
		preparedstatement.setString(2, person.getName());
		preparedstatement.setLong(3, person.getPhone());
		preparedstatement.executeUpdate();
		connection.close();
		System.out.println("Inserted");
	}

	public void updatePerson(Person person) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement("UPDATE PERSON SET NAME=? WHERE ID=?");
		preparedstatement.setString(1, person.getName());
		preparedstatement.setInt(2, person.getId());
		preparedstatement.execute();
		connection.close();
		System.out.println("UPDATED");
	}

	public void deletePerson(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
		preparedstatement.setInt(1, id);
		int count = preparedstatement.executeUpdate();
		if (count == 1) {
			System.out.println("DELETED");
		} else {
			System.out.println("NO SUCH ID FOUND");
		}
	}

	public void getAllPerson() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM PERSON");
		ResultSet resultset = preparedstatement.executeQuery();
		while (resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getLong(3));
			System.out.println("========================");
		}
		connection.close();
	}
}
