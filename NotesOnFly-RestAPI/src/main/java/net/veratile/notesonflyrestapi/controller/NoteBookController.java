package net.veratile.notesonflyrestapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.versatile.notesonflyservice.bo.NoteBook;
import net.versatile.notesonflyservice.delegate.ServiceDelegator;

@RestController
public class NoteBookController {
	@RequestMapping("/notebook/list")
	public String listNoteBooks(@RequestParam(value = "userName", defaultValue = "") String userName) {
		if(userName.equals(""))
			return ServiceDelegator.getNoteBookService().listNoteBooks().toString().replaceAll(",","<br/>");
		else 
			return ServiceDelegator.getNoteBookService().listNoteBooksForUser(userName).toString().replaceAll(",","<br/>");
	}
	
	@RequestMapping("/notebook/add")
	public void addNote(@RequestParam(value = "userName") String userName, @RequestParam(value = "noteBookName") String noteBookName) {
		NoteBook notebook = new NoteBook();
		notebook.setNoteBookName(noteBookName);
		notebook.setUserName(userName);
		ServiceDelegator.getNoteBookService().addNoteBook(notebook);
	}
	
	@RequestMapping("/notebook/delete")
	public void listUsers(@RequestParam(value = "userName") String userName, @RequestParam(value = "noteBookName") String noteBookName) {
		NoteBook notebook = new NoteBook();
		notebook.setNoteBookName(noteBookName);
		notebook.setUserName(userName);
		ServiceDelegator.getNoteBookService().deleteNoteBook(notebook);
	}
}
