package notes.model;

import java.util.ArrayList;

public interface FileOperation {    //Операции с файлом записок
    ArrayList<StringBuilder> readAllNotes(); //Получение всего файла записок

    void saveAllNotes(ArrayList<StringBuilder> notes);    //Запись всего файла записок
}
