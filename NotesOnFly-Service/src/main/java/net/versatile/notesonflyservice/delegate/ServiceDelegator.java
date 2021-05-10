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
		
		if(Configurations.provider.equals("db"))
			return new net.versatile.notesonflyservice.providers.db.mysql.UserServiceImpl();
		return null;
	}
	
	public static NoteBookService getNoteBookService(){
		if(Configurations.provider.equals("filesystem"))
				return new NoteBookServiceImpl();
		if(Configurations.provider.equals("db"))
			return new net.versatile.notesonflyservice.providers.db.mysql.NoteBookServiceImpl();
		return null;
	}
	
	public static NoteService getNoteService(){
		if(Configurations.provider.equals("filesystem"))
				return new NoteServiceImpl();
		if(Configurations.provider.equals("db"))
			return new net.versatile.notesonflyservice.providers.db.mysql.NoteServiceImpl();
		return null;
	}
}
