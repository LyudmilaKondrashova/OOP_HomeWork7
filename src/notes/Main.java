package notes;

import notes.controllers.UserController;
import notes.model.*;
import notes.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("Notes.txt");
        Repository repository = new NoteDecorator(new RepositoryFile(fileOperation), fileOperation,
                new ConsoleLogger());
        UserController controller = new UserController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}