package notes.model;

import java.util.ArrayList;
import java.util.List;

public class NoteContent {  //Содержимое записки
    public StringBuilder readContent(Note note) {    //Чтение содержимого записки
        StringBuilder noteContent = new StringBuilder();
        noteContent.append(note.getId()).append("\n").append(note.getHeader()).append("\n")
                .append(note.getText()).append("\n");
        return noteContent;
    }

    public Note readContent(StringBuilder stringBuilder) {
        int index = stringBuilder.indexOf("\n");
        int indexPlus = 0;
        if (index == 0) {
            index += 2;
            indexPlus += 1;
        }
        int idNote = Integer.parseInt(stringBuilder.substring(indexPlus, index));
        indexPlus = index + 1;
        index = stringBuilder.indexOf("\n", index + 1);
        String headerNote = stringBuilder.substring(indexPlus, index);
        Note note = new Note(idNote, headerNote, new StringBuilder(stringBuilder.substring(index + 1)));
        return note;
    }
}
