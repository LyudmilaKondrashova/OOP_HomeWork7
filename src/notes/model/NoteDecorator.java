package notes.model;

import java.util.ArrayList;

public class NoteDecorator implements Repository, FileOperation{
    private Repository reposit;
    private FileOperation fileOp;
    private Logable log;

    public NoteDecorator(Repository reposit, FileOperation fileOp, Logable log) {
        this.reposit = reposit;
        this.fileOp = fileOp;
        this.log = log;
    }

    @Override
    public ArrayList<StringBuilder> readAllNotes() {
        log.SeeLog(String.format("LOG: Производится чтение всех записок из файла"));
        return fileOp.readAllNotes();
    }

    @Override
    public void saveAllNotes(ArrayList<StringBuilder> notes) {
        log.SeeLog(String.format("LOG: Производится запись всех записок в файл"));
        fileOp.saveAllNotes(notes);
    }

    @Override
    public ArrayList<Note> getAllNotes() {
        log.SeeLog(String.format("LOG: Создается список всех записок"));
        return reposit.getAllNotes();
    }

    @Override
    public int createNote(Note note) {
        log.SeeLog(String.format("LOG: Производится создание новой записки"));
        return reposit.createNote(note);
    }

    @Override
    public void updateNote(Note note) {
        log.SeeLog(String.format("LOG: Производится обновление записки с id=" + note.getId()));
        reposit.updateNote(note);
    }

    @Override
    public void deleteNote(int idNote) {
        log.SeeLog(String.format("LOG: Производится удаление записки с id=" + idNote));
        reposit.deleteNote(idNote);
    }
}
