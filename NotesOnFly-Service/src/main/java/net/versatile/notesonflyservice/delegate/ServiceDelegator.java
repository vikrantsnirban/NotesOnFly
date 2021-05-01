package net.versatile.notesonflyservice.delegate;

import net.versatile.notesonflyservice.bo.config.Configurations;
import net.versatile.notesonflyservice.definitions.NoteBookService;
import net.versatile.notesonflyservice.definitions.NoteService;
import net.versatile.notesonflyservice.definitions.UserService;
import net.versatile.notesonflyservice.providers.filesystem.NoteBookServiceImpl;
import net.versatile.notesonflyservice.providers.filesystem.NoteServiceImpl;
import net.versatile.notesonflyservice.providers.filesystem.UserServiceImpl;

public final class ServiceDelegator {
	public static UserService getUserService(){
		if(Configurations.provider.equals("filesystem"))
				return new UserServiceImpl();
		return null;
	}
	
	public static NoteBookService getNoteBookService(){
		if(Configurations.provider.equals("filesystem"))
				return new NoteBookServiceImpl();
		return null;
	}
	
	public static NoteService getNoteService(){
		if(Configurations.provider.equals("filesystem"))
				return new NoteServiceImpl();
		return null;
	}
}
