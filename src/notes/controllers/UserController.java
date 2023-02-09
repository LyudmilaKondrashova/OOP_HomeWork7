package notes.controllers;

import notes.model.Note;
import notes.model.Repository;

import java.util.ArrayList;

public class UserController {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) {
        repository.createNote(note);
    }

    public Note readNote(int idNote) throws Exception {
        ArrayList<Note> notes = repository.getAllNotes();
            for (Note note : notes) {
                if (note.getId() == idNote) {
                    return note;
                }
            }
        throw new Exception("Note not found");
    }

    public ArrayList<Note> readList() {
        ArrayList<Note> notes = repository.getAllNotes();
        return notes;
    }

    public void deleteNote(int idNote) throws Exception {
        inputIdValidation(idNote);
        repository.deleteNote(idNote);
    }

    public void updateNote(int idNote, Note newNote) throws Exception {
        inputIdValidation(idNote);
        newNote.setId(idNote);
        repository.updateNote(newNote);
    }

    public void inputIdValidation (int inputId) throws Exception {
        ArrayList<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId() == inputId)
                return;
        }
        throw new Exception("Note not found - no such ID here");
    }
}
