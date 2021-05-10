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
		
		System.out.println("sqlQuery:\n" + sqlQuery);
		System.out.println("Record(s) Added: " + DBManager.executeSQL(sqlQuery));
	}

	public void deleteNoteBook(NoteBook notebook) {
		
		String sqlQuery = "DELETE FROM NOTEBOOK WHERE USERNAME = " + "\"" + notebook.getUserName() + "\" and NOTEBOOKNAME = \"" + notebook.getNoteBookName()+ "\"";
		System.out.println("sqlQuery:\n" + sqlQuery);
		System.out.println("Record(s) Deleted: " + DBManager.executeSQL(sqlQuery));

	}

	public List<NoteBook> listNoteBooks() {

		List<NoteBook> noteBooks = new ArrayList<NoteBook>();
		
		String sqlQuery = "SELECT * FROM NOTEBOOK";
		System.out.println("sqlQuery:\n" + sqlQuery);
		
		try {
			ResultSet noteBookResultSet = DBManager.fetchResults(sqlQuery);
			while(noteBookResultSet.next()){
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(noteBookResultSet.getString("USERNAME"));
				noteBook.setNoteBookName(noteBookResultSet.getString("NOTEBOOKNAME"));
				noteBooks.add(noteBook);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return noteBooks;
	
	}

	public List<NoteBook> listNoteBooksForUser(String userName) {

		List<NoteBook> noteBooks = new ArrayList<NoteBook>();
		
		String sqlQuery = "SELECT * FROM NOTEBOOK WHERE USERNAME = " + "\"" + userName + "\"";
		System.out.println("sqlQuery:\n" + sqlQuery);
		
		try {
			ResultSet noteBookResultSet = DBManager.fetchResults(sqlQuery);
			while(noteBookResultSet.next()){
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(noteBookResultSet.getString("USERNAME"));
				noteBook.setNoteBookName(noteBookResultSet.getString("NOTEBOOKNAME"));
				noteBooks.add(noteBook);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return noteBooks;
	}

}
