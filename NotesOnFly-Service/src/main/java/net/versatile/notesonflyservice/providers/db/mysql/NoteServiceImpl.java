package net.versatile.notesonflyservice.providers.db.mysql;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.versatile.notesonflyservice.bo.Note;
import net.versatile.notesonflyservice.bo.NoteBook;
import net.versatile.notesonflyservice.bo.config.Configurations;
import net.versatile.notesonflyservice.definitions.NoteService;

public class NoteServiceImpl implements NoteService{

	public void addNote(Note note) {
		String sqlQuery = "INSERT INTO NOTE VALUES (\""+ note.getNoteBook().getUserName()
		+"\", \"" + note.getNoteBook().getNoteBookName() 
		+ "\", \"" + note.getNoteName()
		+"\", \"" + note.getNoteTitle()
		+"\", \"" + note.getNoteContent() 
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

	public void updateNote(Note note) {
		String sqlQuery = "UPDATE NOTE SET "
							+ "USERNAME = " + "\"" + note.getNoteBook().getUserName()
							+ "\", NOTEBOOKNAME = " + "\"" + note.getNoteBook().getNoteBookName()
							+ "\", NOTENAME = " + "\"" + note.getNoteName()
							+ "\", NOTETITLE = " + "\"" + note.getNoteTitle() 
							+ "\", NOTECONTENT = " + "\"" + note.getNoteContent()
							+ "\" WHERE USERNAME = \"" + note.getNoteBook().getUserName() 
							+ "\" AND NOTEBOOKNAME = \"" + note.getNoteBook().getNoteBookName() + "\"";

		System.out.println(sqlQuery);
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


	public void deleteNote(Note note) {
		String sqlQuery = "DELETE FROM NOTE WHERE USERNAME = " + "\"" 
		+ note.getNoteBook().getUserName() + "\" AND NOTEBOOKNAME = \""
		+ note.getNoteBook().getNoteBookName() + "\" AND NOTENAME = \""
		+ note.getNoteName() + "\"";
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

	public List<Note> listAllNotes() {
		List<Note> notes = new ArrayList<Note>();
		
		String sqlQuery = "SELECT * FROM NOTE";
		
		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet usersFromDB = statement.executeQuery(sqlQuery);
			while(usersFromDB.next()){
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(usersFromDB.getString("USERNAME"));
				noteBook.setNoteBookName(usersFromDB.getString("NOTEBOOKNAME"));
				Note note = new Note();
				note.setNoteBook(noteBook);
				note.setNoteName(usersFromDB.getString("NOTENAME"));
				note.setNoteTitle(usersFromDB.getString("NOTETITLE"));
				note.setNoteContent(usersFromDB.getString("NOTECONTENT"));
				notes.add(note);

			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return notes;
	
		
	}

	public List<Note> listNotesForUserNoteBook(String userName, String noteBookName) {
		
		List<Note> notes = new ArrayList<Note>();
		
		String sqlQuery = "SELECT * FROM NOTE WHERE USERNAME = \"" 
		+ userName + "\" AND NOTEBOOKNAME = \"" + noteBookName + "\"";
		
		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet usersFromDB = statement.executeQuery(sqlQuery);
			while(usersFromDB.next()){
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(usersFromDB.getString("USERNAME"));
				noteBook.setNoteBookName(usersFromDB.getString("NOTEBOOKNAME"));
				Note note = new Note();
				note.setNoteBook(noteBook);
				note.setNoteName(usersFromDB.getString("NOTENAME"));
				note.setNoteTitle(usersFromDB.getString("NOTETITLE"));
				note.setNoteContent(usersFromDB.getString("NOTECONTENT"));
				notes.add(note);

			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return notes;
	
		
	}

	public List<Note> listNotesForUser(String userName) {
		List<Note> notes = new ArrayList<Note>();
		
		String sqlQuery = "SELECT * FROM NOTE WHERE USERNAME = \"" 
				+ userName  + "\"";
		
		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet usersFromDB = statement.executeQuery(sqlQuery);
			while(usersFromDB.next()){
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(usersFromDB.getString("USERNAME"));
				noteBook.setNoteBookName(usersFromDB.getString("NOTEBOOKNAME"));
				Note note = new Note();
				note.setNoteBook(noteBook);
				note.setNoteName(usersFromDB.getString("NOTENAME"));
				note.setNoteTitle(usersFromDB.getString("NOTETITLE"));
				note.setNoteContent(usersFromDB.getString("NOTECONTENT"));
				notes.add(note);

			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return notes;
	
		
	}

}
