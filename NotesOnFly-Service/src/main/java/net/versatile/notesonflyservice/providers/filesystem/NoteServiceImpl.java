package net.versatile.notesonflyservice.providers.filesystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.versatile.notesonflyservice.bo.Note;
import net.versatile.notesonflyservice.bo.NoteBook;
import net.versatile.notesonflyservice.bo.config.Configurations;
import net.versatile.notesonflyservice.definitions.NoteService;

public class NoteServiceImpl implements NoteService{

	public void addNote(Note note) {
		try {
			File noteFile = new File(Configurations.appRoot + "notebooks/" + note.getNoteBook().getUserName() + "/" + note.getNoteBook().getNoteBookName() + "/" + note.getNoteName() );
			if (noteFile.createNewFile()) {
				System.out.println("Note File created: " + noteFile.getName());
			}
			FileWriter noteFileWriter = new FileWriter(noteFile);
			noteFileWriter.write(note.toString());
			noteFileWriter.close();
			System.out.println("Successfully wrote Note Data to file: " + noteFile.getName());
		} catch (IOException e) {
			System.out.println("An error occurred while Note file creation");
			e.printStackTrace();
		}
		
	}

	public void updateNote(Note note) {
		try {
			File noteFile = new File(Configurations.appRoot + "notebooks/" + note.getNoteBook().getUserName() + "/" + note.getNoteBook().getNoteBookName() + "/" + note.getNoteName() );
			if (noteFile.exists()) {
				System.out.println("User File Exists: " + noteFile.getName());
			}
			FileWriter noteFileWriter = new FileWriter(noteFile);
			noteFileWriter.write(note.toString());
			noteFileWriter.close();
			System.out.println("Successfully updated Note Data to file: " + noteFile.getName());
		} catch (IOException e) {
			System.out.println("An error occurred while Note file update");
			e.printStackTrace();
		}
		
	}


	public void deleteNote(Note note) {
		File noteFile = new File(Configurations.appRoot + "notebooks/" + note.getNoteBook().getUserName() + "/" + note.getNoteBook().getNoteBookName() + "/" + note.getNoteName() );
	    if (noteFile.delete()) { 
	      System.out.println("Deleted Note file: " + noteFile.getName());
	    } else {
	      System.out.println("Failed to delete Note file: " + noteFile.getName());
	    } 
	}

	public List<Note> listAllNotes() {
		File userNoteBookFolder = new File(Configurations.appRoot + "notebooks/");// + userName);// + "/" + note.getNoteBook().getNoteBookName() + "/" + note.getNoteName() );
		List<Note> notes = new ArrayList<Note>();
		for(File noteBookFolder: userNoteBookFolder.listFiles()){
			if(noteBookFolder.isDirectory()){
				notes.addAll(listNotesForUser(noteBookFolder.getName()));
			}
		}
		return notes;
	}

	public List<Note> listNotesForUserNoteBook(String userName, String noteBookName) {
		File userNoteBookFolder = new File(Configurations.appRoot + "notebooks/" + userName + "/" + noteBookName + "/");// + note.getNoteName() );
		List<Note> notes = new ArrayList<Note>();
		for(File noteFile: userNoteBookFolder.listFiles()){
			Note note = new Note();
			note.setNoteName(noteFile.getName());
			NoteBook noteBook = new NoteBook();
			noteBook.setUserName(userName);
			noteBook.setNoteBookName(noteBookName);
			note.setNoteBook(noteBook);
			notes.add(note);
		}
		return notes;
	}

	public List<Note> listNotesForUser(String userName) {
		File userNoteBookFolder = new File(Configurations.appRoot + "notebooks/" + userName);// + "/" + note.getNoteBook().getNoteBookName() + "/" + note.getNoteName() );
		List<Note> notes = new ArrayList<Note>();
		for(File noteBookFolder: userNoteBookFolder.listFiles()){
			if(noteBookFolder.isDirectory()){
				notes.addAll(listNotesForUserNoteBook(userName, noteBookFolder.getName()));
			}
		}
		return notes;
	}

}
