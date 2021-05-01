package net.versatile.notesonflyservice.definitions;

import java.util.List;

import net.versatile.notesonflyservice.bo.Note;

public interface NoteService {
	void addNote(Note note);
	void updateNote(Note note);
	void deleteNote(Note note);
	List<Note> listAllNotes();
	List<Note> listNotesForUserNoteBook(String userName, String noteBookName);
	List<Note> listNotesForUser(String userName);
}
