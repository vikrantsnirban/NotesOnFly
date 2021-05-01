package net.versatile.notesonflyservice.bo;

public class Note {

	NoteBook noteBook;
	String noteName;
	String noteTitle;
	String noteContent;
	
	public NoteBook getNoteBook() {
		return noteBook;
	}
	public void setNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	
	@Override
	public String toString() {
		return "NoteBook: [" + noteBook + "]\t"
				+ "Note Name: " + noteName + "\t"
				+ "Note Title: " + noteTitle + "\t"
				+ "Note Content: " + noteContent ;
	}
}
