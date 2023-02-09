package notes.model;

import java.util.ArrayList;

public interface Repository{
    ArrayList<Note> getAllNotes();   //Получение всех записок

    int createNote(Note note);   //Создание записки

    void updateNote(Note note); //Обновление записки

    void deleteNote(int idNote); //Удаление записки
}
