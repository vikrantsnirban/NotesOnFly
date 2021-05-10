package net.versatile.notesonflyservice.providers.db.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.versatile.notesonflyservice.bo.NoteBook;
import net.versatile.notesonflyservice.definitions.NoteBookService;

public class NoteBookServiceImpl implements NoteBookService {

	public void addNoteBook(NoteBook notebook) {
		String sqlQuery = "INSERT INTO NOTEBOOK VALUES (\""+  notebook.getUserName() 
		+"\", \"" + notebook.getNoteBookName()
		+ "\")";
		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			statement.execute(sqlQuery);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	

	}

	public void deleteNoteBook(NoteBook notebook) {
		
		String sqlQuery = "DELETE FROM NOTEBOOK WHERE USERNAME = " + "\"" + notebook.getUserName() + "\" and NOTEBOOKNAME = \"" + notebook.getNoteBookName()+ "\"";
		System.out.println(sqlQuery);


		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
		
	}

	public List<NoteBook> listNoteBooks() {

		List<NoteBook> noteBooks = new ArrayList<NoteBook>();
		
		String sqlQuery = "SELECT * FROM NOTEBOOK";
		
		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet usersFromDB = statement.executeQuery(sqlQuery);
			while(usersFromDB.next()){
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(usersFromDB.getString("USERNAME"));
				noteBook.setNoteBookName(usersFromDB.getString("NOTEBOOKNAME"));
				noteBooks.add(noteBook);
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return noteBooks;
	
	}

	public List<NoteBook> listNoteBooksForUser(String userName) {

		List<NoteBook> noteBooks = new ArrayList<NoteBook>();
		
		String sqlQuery = "SELECT * FROM NOTEBOOK WHERE USERNAME = " + "\"" + userName + "\"";
		
		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet usersFromDB = statement.executeQuery(sqlQuery);
			while(usersFromDB.next()){
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(usersFromDB.getString("USERNAME"));
				noteBook.setNoteBookName(usersFromDB.getString("NOTEBOOKNAME"));
				noteBooks.add(noteBook);
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return noteBooks;
	
	
		
	}

}
