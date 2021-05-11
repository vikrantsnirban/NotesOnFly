package net.veratile.notesonflyrestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.versatile.notesonflyservice.bo.Note;
import net.versatile.notesonflyservice.bo.NoteBook;
import net.versatile.notesonflyservice.delegate.ServiceDelegator;

@RestController
public class NoteController {
	@RequestMapping("/note/list")
	public String listNotes(@RequestParam(value = "userName", defaultValue = "") String userName,
			@RequestParam(value = "noteBookName", defaultValue = "") String noteBookName) {

		if (!userName.equals("")) {
			if (!noteBookName.equals("")) {
				return formatNotesForHTML(ServiceDelegator.getNoteService().listNotesForUserNoteBook(userName, noteBookName));
			}

			return formatNotesForHTML(ServiceDelegator.getNoteService().listNotesForUser(userName));
		}
		return formatNotesForHTML(ServiceDelegator.getNoteService().listAllNotes());
		
	}
	
	@RequestMapping("/note/add")
	public void addNote(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "noteBookName") String noteBookName, @RequestParam(value = "noteName") String noteName, @RequestParam(value = "noteTitle") String noteTitle, @RequestParam(value = "noteContent") String noteContent) {
		NoteBook noteBook = new NoteBook();
		noteBook.setUserName(userName);
		noteBook.setNoteBookName(noteBookName);
		Note note = new Note();
		note.setNoteBook(noteBook);
		note.setNoteName(noteName);
		note.setNoteTitle(noteTitle);
		note.setNoteContent(noteContent);
		ServiceDelegator.getNoteService().addNote(note);
	}
	
	@RequestMapping("/note/update")
	public void updateNote(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "noteBookName") String noteBookName, @RequestParam(value = "noteName") String noteName, @RequestParam(value = "noteTitle") String noteTitle, @RequestParam(value = "noteContent") String noteContent) {
		NoteBook noteBook = new NoteBook();
		noteBook.setUserName(userName);
		noteBook.setNoteBookName(noteBookName);
		Note note = new Note();
		note.setNoteBook(noteBook);
		note.setNoteName(noteName);
		note.setNoteTitle(noteTitle);
		note.setNoteContent(noteContent);
		ServiceDelegator.getNoteService().updateNote(note);
	}
	
	@RequestMapping("/note/delete")
	public void deleteNote(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "noteBookName") String noteBookName, @RequestParam(value = "noteName") String noteName){
		NoteBook noteBook = new NoteBook();
		noteBook.setUserName(userName);
		noteBook.setNoteBookName(noteBookName);
		Note note = new Note();
		note.setNoteBook(noteBook);
		note.setNoteName(noteName);
		ServiceDelegator.getNoteService().deleteNote(note);
	}
	
	private String formatNotesForHTML(List<Note> notes){
		StringBuilder notesToDisplay = new StringBuilder();
		for(Note note: notes){
			notesToDisplay.append("<h1>" + note.getNoteTitle() + "</h1>");
			notesToDisplay.append("<i>" + note.getNoteBook().getUserName() + " : " +  note.getNoteBook().getNoteBookName() + "</i>");
			notesToDisplay.append("<p>" + note.getNoteContent() + "</p>");
			notesToDisplay.append("<hr/>");
			
		}
		return notesToDisplay.toString();
	}
}
