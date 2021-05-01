package net.versatile.notesonflyservice.definitions;

import java.util.List;

import net.versatile.notesonflyservice.bo.NoteBook;

public interface NoteBookService {
	void addNoteBook(NoteBook notebook);
	void deleteNoteBook(NoteBook notebook);
	List <NoteBook> listNoteBooks();
	List <NoteBook> listNoteBooksForUser(String userName);
}
