package net.versatile.noteonflycli;

import net.versatile.notesonflyservice.bo.Note;
import net.versatile.notesonflyservice.bo.NoteBook;
import net.versatile.notesonflyservice.bo.User;
import net.versatile.notesonflyservice.definitions.NoteBookService;
import net.versatile.notesonflyservice.definitions.NoteService;
import net.versatile.notesonflyservice.definitions.UserService;
import net.versatile.notesonflyservice.delegate.ServiceDelegator;
import net.versatile.notesonflyservice.providers.filesystem.NoteBookServiceImpl;
import net.versatile.notesonflyservice.providers.filesystem.NoteServiceImpl;
import net.versatile.notesonflyservice.providers.filesystem.UserServiceImpl;

public class Main {
	public static void main(String[] args) {
		if (args[0].equals("user")){

			UserService userService = ServiceDelegator.getUserService();
			
			if( args[1].equals("create") || args[1].equals("update") || args[1].equals("delete")){
				if(args[2].equals("") ){
					System.err.println("User Name not provided.");
				}else{
					System.out.println("User Name: " + args[2]);
				}
				
				
				
				if(args[1].equals("delete")){
					System.out.println("Deleting User: " + args[2]);
					userService.deleteUser(args[2]);
					System.exit(0);
				}
				
				User user = new User();
				user.setUserName(args[2]);
				user.setFirstName(args.length >= 4 ? args[3] : "");
				user.setLastName(args.length >= 5 ? args[4] : "");
				user.setEmailAddress(args.length >= 6 ? args[5] : "NO-EMAIL");
				user.setAddress(args.length >= 7  ? args[6] : "NO-ADDRESS");
				
				System.out.println(user);
				if(args[1].equals("create")){
					System.out.println("Creating User: " + user.getUserName());
					userService.addUser(user);
				}
				
				if(args[1].equals("update")){
					System.out.println("Updating User: " + user.getUserName());
					userService.updateUser(user);
				}
				
				
			} else if (args[1].equals("list")){
				System.out.println(userService.listUsers().toString().replaceAll(",", "\n"));
			}else {
				System.err.println("Invalid User Option");
			} 
		} else if (args[0].equals("notebook")){
			NoteBookService noteBookService = ServiceDelegator.getNoteBookService();
			if(args[1].equals("create") || args[1].equals("delete")){
				if(args[2].equals("") ){
					System.err.println("User Name not provided.");
				}else{
					System.out.println("User Name: " + args[2]);
				}
				
				if(args[3].equals("") ){
					System.err.println("NoteBook Name not provided.");
				}else{
					System.out.println("NoteBook Name: " + args[3]);
				}
				
				NoteBook noteBook = new NoteBook();
				noteBook.setUserName(args[2]);
				noteBook.setNoteBookName(args[3]);
				
				
				
				if(args[1].equals("create")){
					noteBookService.addNoteBook(noteBook);
				}
				if(args[1].equals("delete")){
					noteBookService.deleteNoteBook(noteBook);
				}
				
			}else if (args[1].equals("list")){
				System.out.println(args.length);
				if(args.length != 3  ){
					System.out.println(noteBookService.listNoteBooks().toString().replaceAll(",", "\n"));
				}else{
					System.out.println(noteBookService.listNoteBooksForUser(args[2]).toString().replaceAll(",", "\n"));
				}
				
			}else {
				System.err.println("Invalid NoteBook Option");
			} 
			
		} else if (args[0].equals("note")){
			NoteService noteService = ServiceDelegator.getNoteService();
			
			if( args[1].equals("create") || args[1].equals("update") || args[1].equals("delete")){
				
				Note note = new Note();
				NoteBook noteBook = new  NoteBook();
				
				if(!args[2].equals("")){
					noteBook.setUserName(args[2]);
				}else{
					System.err.println("User Name not provided");
				}
				
				if(!args[3].equals("")){
					noteBook.setNoteBookName(args[3]);
				}else{
					System.err.println("Notebook Name not provided");
				}
				
				note.setNoteBook(noteBook);
				
				if(!args[4].equals("")){
					note.setNoteName(args[4]);
				}else{
					System.err.println("Note Name not provided");
				}
				
				
				
				
				System.out.println(note);
				if(args[1].equals("delete")){
					System.out.println("Deleting User: " + args[2]);
					noteService.deleteNote(note);
					System.exit(0);
				}
				
				if(!args[5].equals("")){
					note.setNoteTitle(args[5]);
				}else{
					System.err.println("Note Title not provided");
				}
				
				if(!args[6].equals("")){
					note.setNoteContent(args[6]);
				}else{
					System.err.println("Note Content not provided");
				}
				
				System.out.println(note);
				
				if(args[1].equals("create")){
					System.out.println("Creating Note: " + note.getNoteName());
					noteService.addNote(note);
				}
				
				if(args[1].equals("update")){
					System.out.println("Updating Note: " + note.getNoteName());
					noteService.updateNote(note);
				}
				
				
			} else if (args[1].equals("list")){
				if(args.length == 3){
					System.out.println(noteService.listNotesForUser(args[2]).toString().replaceAll(",", "\n"));
				}else if(args.length == 4){
					System.out.println(noteService.listNotesForUserNoteBook(args[2], args[3]).toString().replaceAll(",", "\n"));
				}else {
					System.out.println(noteService.listAllNotes().toString().replaceAll(",", "\n"));
				}
			}else {
				System.err.println("Invalid Note Option");
			} 
			
		} else {
			System.err.println("Invalid Option. Exiting...");
		} 
	}
}
