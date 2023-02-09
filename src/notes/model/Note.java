package notes.model;

public class Note { //Записка

    private int id; //id записки
    private String header;  //Заголовок записки
    private StringBuilder text; //Текст записки

    public Note(int id, String header, StringBuilder text) {
        this.id = id;
        this.header = header;
        this.text = text;
    }

    public Note(String header, StringBuilder text) {
        this.header = header;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public StringBuilder getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + String.valueOf(id) + '\'' +
                ", header='" + header + '\'' +
                ", text=" + text +
                '}';
    }
}
