package net.versatile.notesonflyservice.bo;

public class NoteBook {
	String userName;
	String noteBookName = "Unnamed";
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNoteBookName() {
		return noteBookName;
	}
	public void setNoteBookName(String noteBookName) {
		this.noteBookName = noteBookName;
	}
	
	@Override
	public String toString() {
		return "Notebook Name: " + noteBookName + "\t"
			   + "UserName Name: " + userName;
	}
}
