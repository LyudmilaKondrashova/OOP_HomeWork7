package notes.views;

import notes.controllers.UserController;
import notes.model.Note;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewUser {
    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands command = Commands.NONE;

        while (true) {
            String strCommand = prompt("Введите команду: NONE, CREATE, READ, UPDATE, LIST, READALL, DELETE, EXIT\n");
            command = Commands.valueOf(strCommand.toUpperCase());

            if (command == Commands.EXIT) {
                return;
            }
            try {
                switch (command) {
                    case CREATE:
                        System.out.println("Создаем новую записку:");
                        String header = prompt("Заголовок: ");
                        StringBuilder text = new StringBuilder(prompt("Текст: "));
                        userController.saveNote(new Note(header, text));
                        System.out.println("Записка создана");
                        break;
                    case READ:
                        int id = Integer.parseInt(prompt("Введите id записки: "));
                        userController.inputIdValidation(id);
                        Note note = userController.readNote(id);
                        System.out.println(note);
                       break;
                    case UPDATE:
                        int idNt = Integer.parseInt(prompt("Введите идентификатор id редактируемой записки: "));
                        userController.inputIdValidation(idNt);
                        Note oldNote = userController.readNote(idNt);
                        System.out.println("Редактрируемая записка:");
                        System.out.println("Заголовок: " + oldNote.getHeader());
                        System.out.println("Текст: " + oldNote.getText());
                        System.out.println("Введите новые данные:");
                        userController.updateNote(idNt, createNote());
                        System.out.println("Записка обновлена!");
                        break;
                    case LIST:
                        ArrayList<Note> notes = userController.readList();
                        System.out.println("Список всех записок:");
                        notes.forEach(i -> System.out.println("id=" + i.getId() + " header=" + i.getHeader()));
                        break;
                    case READALL:
                        ArrayList<Note> notesAll = userController.readList();
                        System.out.println("Содержание всех записок:");
                        notesAll.forEach(i -> System.out.println("id=" + i.getId()
                                + " header=" + i.getHeader() + "   text=" + i.getText()));
                        break;
                    case DELETE:
                        int idNote = Integer.parseInt(prompt("Введите идентификатор id удаляемой записки: "));
                        userController.inputIdValidation(idNote);
                        userController.deleteNote(idNote);
                        System.out.println("Записка удалена!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String prompt(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.print(message);
        return scan.nextLine();
    }

    private Note createNote() {
        String header = prompt("Заголовок: ");
        StringBuilder text = new StringBuilder(prompt("Текст: "));
        Note newNote = new Note(header, text);
        return newNote;
    }
}
