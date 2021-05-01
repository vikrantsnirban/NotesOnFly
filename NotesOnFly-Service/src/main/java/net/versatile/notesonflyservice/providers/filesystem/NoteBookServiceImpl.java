package net.versatile.notesonflyservice.providers.filesystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.versatile.notesonflyservice.bo.NoteBook;
import net.versatile.notesonflyservice.bo.User;
import net.versatile.notesonflyservice.bo.config.Configurations;
import net.versatile.notesonflyservice.definitions.NoteBookService;

public class NoteBookServiceImpl implements NoteBookService {

	public void addNoteBook(NoteBook notebook) {
		File noteBookFolder = new File(
				Configurations.appRoot +  "notebooks/"+ notebook.getUserName() + "/" + notebook.getNoteBookName());
		noteBookFolder.mkdirs();
		System.out.println("NoteBook Folder created: " + noteBookFolder.getName());

	}

	public void deleteNoteBook(NoteBook notebook) {
		File noteBookFolder = new File(
				Configurations.appRoot +  "notebooks/"+ notebook.getUserName() + "/" + notebook.getNoteBookName());
		noteBookFolder.delete();
		System.out.println("NoteBook Folder created: " + noteBookFolder.getName());

	}

	public List<NoteBook> listNoteBooks() {
		File noteBookFolder = new File(Configurations.appRoot +  "notebooks/");
		List<NoteBook> noteBooks = new ArrayList<NoteBook>();
		for(File userFolder: noteBookFolder.listFiles()){
			if(userFolder.isDirectory()){
				noteBooks.addAll(listNoteBooksForUser(userFolder.getName()));
			}
		}
		return noteBooks;
	}

	public List<NoteBook> listNoteBooksForUser(String userName) {
		File noteBookFolder = new File(Configurations.appRoot +  "notebooks/" + userName + "/");
		List<NoteBook> noteBooks = new ArrayList<NoteBook>();
		for(File noteBookFile: noteBookFolder.listFiles()){
			NoteBook noteBook = new NoteBook();
			noteBook.setNoteBookName(noteBookFile.getName());
			noteBook.setUserName(userName);
			noteBooks.add(noteBook);
		}
		return noteBooks;
	}

}
