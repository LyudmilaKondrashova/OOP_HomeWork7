package notes.views;

public enum Commands {
    NONE,
    CREATE, //Создать записку
    READ,   //Прочитать записку по номеру id
    UPDATE, //Отредактировать записку по номеру id
    LIST,   //Вывести список всех записок
    READALL,    //Вывести содержимое всех записок
    DELETE, //Удалить записку по номеру id
    EXIT    //Выход
}
