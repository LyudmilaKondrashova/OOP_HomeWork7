package notes.model;

public class ConsoleLogger implements Logable{
    @Override
    public void SeeLog(String operation) {
        System.out.println(operation);
    }
}
