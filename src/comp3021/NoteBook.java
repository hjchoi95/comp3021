package base;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<Folder> folders;
	public NoteBook() {
		folders = new ArrayList<Folder>();
	}
	
	public boolean createTextNote(String folderName, String title) {
		TextNote note = new TextNote(title);
		return insertNote(folderName, note);
	}
	
	public boolean createImageNote(String folderName, String title) {
		ImageNote note = new ImageNote(title);
		return insertNote(folderName, note);
	}
	
	
	public ArrayList<Folder> getFolders() {
		return folders;
	}
	
	public boolean insertNote(String folderName, Note note) {
		Folder targetFolder = null;//new Folder(folderName);
		
		//STEP 1
		boolean folderExists=false;
		for (int i=0; i<folders.size(); ++i) {
			if (folders.get(i).equals(targetFolder)) {
				targetFolder = folders.get(i);
				folderExists=true;
				break;
			}
		}
		if (!folderExists) {
			targetFolder = new Folder(folderName);
			folders.add(targetFolder);
		}
		
		// STEP 2
		for (int i=0; i<targetFolder.getNotes().size(); ++i) {
			if (targetFolder.getNotes().get(i).equals(note)) {
				System.out.println("Creating note "+note.getTitle() + " under folder "+ folderName + " failed");
				return false;
			}
		}
		
		// STEP 3
		targetFolder.addNote(note);
		return true;
	}
}