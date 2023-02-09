package notes.model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private FileOperation fileOperation;

    private NoteContent noteContent = new NoteContent();

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    //Получение всех записок в виде списка
    @Override
    public ArrayList<Note> getAllNotes() {
        ArrayList<StringBuilder> items = fileOperation.readAllNotes();
        ArrayList<Note> notes = new ArrayList<>();
        for (StringBuilder item : items) {
            notes.add(noteContent.readContent(item));
        }
        return notes;
    }

    //Создание новой записки
    @Override
    public int createNote(Note newNote) {
        ArrayList<Note> notes = getAllNotes();
        int maxId = 0;
        for (Note item : notes) {
            int currentId = item.getId();
            if (maxId < currentId) {
                maxId = currentId;
            }
        }
        int idNote = maxId + 1;
        newNote.setId(idNote);
        notes.add(newNote);
        writeNotes(notes);
        return idNote;
    }

    @Override
    public void updateNote(Note note) {
        ArrayList<Note> notes = getAllNotes();
        Note updateNote = notes.stream().filter(i -> i.getId() == (note.getId())).findFirst().get();
        updateNote.setHeader(note.getHeader());
        updateNote.setText(note.getText());
        writeNotes(notes);
    }

    @Override
    public void deleteNote(int idNote) {
        ArrayList<Note> notes = getAllNotes();
        ArrayList<StringBuilder> lines = new ArrayList<>();
        for (Note note : notes) {
            if (note.getId() != idNote) {
                lines.add(noteContent.readContent(note));
            }
            fileOperation.saveAllNotes(lines);
        }
    }

    private void writeNotes(ArrayList<Note> notes) {
        ArrayList<StringBuilder> wrNotes = new ArrayList<>();
        for (Note note : notes) {
            wrNotes.add(noteContent.readContent(note));
        }
        fileOperation.saveAllNotes(wrNotes);
    }
}
