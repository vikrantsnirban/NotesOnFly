package net.versatile.notesonflyservice.providers.db.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.versatile.notesonflyservice.bo.Note;
import net.versatile.notesonflyservice.bo.NoteBook;
import net.versatile.notesonflyservice.definitions.NoteService;

public class NoteServiceImpl implements NoteService{

	public void addNote(Note note) {
		String sqlQuery = "INSERT INTO NOTE VALUES (\""+ note.getNoteBook().getUserName()
		+"\", \"" + note.getNoteBook().getNoteBookName() 
		+ "\", \"" + note.getNoteName()
		+"\", \"" + note.getNoteTitle()
		+"\", \"" + note.getNoteContent() 
		+ "\")";
		System.out.println("sqlQuery:\n" + sqlQuery);
		System.out.println("Record(s) Added: " + DBManager.executeSQL(sqlQuery));
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
		System.out.println("sqlQuery:\n" + sqlQuery);
		System.out.println("Record(s) Updated: " + DBManager.executeSQL(sqlQuery));
	}


	public void deleteNote(Note note) {
		String sqlQuery = "DELETE FROM NOTE WHERE USERNAME = " + "\"" 
		+ note.getNoteBook().getUserName() + "\" AND NOTEBOOKNAME = \""
		+ note.getNoteBook().getNoteBookName() + "\" AND NOTENAME = \""
		+ note.getNoteName() + "\"";
		System.out.println("sqlQuery:\n" + sqlQuery);
		System.out.println("Record(s) Deleted: " + DBManager.executeSQL(sqlQuery));
	}

	public List<Note> listAllNotes() {
		List<Note> notes = new ArrayList<Note>();
		
		String sqlQuery = "SELECT * FROM NOTE";
		System.out.println("sqlQuery:\n" + sqlQuery);
		
		try {
			ResultSet noteResultSet = DBManager.fetchResults(sqlQuery);
			while(noteResultSet.next()){
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(noteResultSet.getString("USERNAME"));
				noteBook.setNoteBookName(noteResultSet.getString("NOTEBOOKNAME"));
				Note note = new Note();
				note.setNoteBook(noteBook);
				note.setNoteName(noteResultSet.getString("NOTENAME"));
				note.setNoteTitle(noteResultSet.getString("NOTETITLE"));
				note.setNoteContent(noteResultSet.getString("NOTECONTENT"));
				notes.add(note);

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return notes;
	}

	public List<Note> listNotesForUserNoteBook(String userName, String noteBookName) {
		
		List<Note> notes = new ArrayList<Note>();
		
		String sqlQuery = "SELECT * FROM NOTE WHERE USERNAME = \"" 
		+ userName + "\" AND NOTEBOOKNAME = \"" + noteBookName + "\"";
		
		System.out.println("sqlQuery:\n" + sqlQuery);
		
		try {
			ResultSet noteResultSet = DBManager.fetchResults(sqlQuery);
			while(noteResultSet.next()){
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(noteResultSet.getString("USERNAME"));
				noteBook.setNoteBookName(noteResultSet.getString("NOTEBOOKNAME"));
				Note note = new Note();
				note.setNoteBook(noteBook);
				note.setNoteName(noteResultSet.getString("NOTENAME"));
				note.setNoteTitle(noteResultSet.getString("NOTETITLE"));
				note.setNoteContent(noteResultSet.getString("NOTECONTENT"));
				notes.add(note);

			}
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
		
		System.out.println("sqlQuery:\n" + sqlQuery);
		
		try {
			ResultSet noteResultSet = DBManager.fetchResults(sqlQuery);
			while(noteResultSet.next()){
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(noteResultSet.getString("USERNAME"));
				noteBook.setNoteBookName(noteResultSet.getString("NOTEBOOKNAME"));
				Note note = new Note();
				note.setNoteBook(noteBook);
				note.setNoteName(noteResultSet.getString("NOTENAME"));
				note.setNoteTitle(noteResultSet.getString("NOTETITLE"));
				note.setNoteContent(noteResultSet.getString("NOTECONTENT"));
				notes.add(note);

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return notes;
	}

}
