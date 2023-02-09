package notes.model;

import java.io.*;
import java.util.ArrayList;

import static notes.model.Constant.SEPAR;

public class FileOperationImpl implements FileOperation {
    private String fileName;

    public FileOperationImpl(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Чтение всех записок из файла
    @Override
    public ArrayList<StringBuilder> readAllNotes() {
        StringBuilder oneNote = new StringBuilder();    //Сюда запишется все из файла
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if (line != null) {
                    if (!line.equals(SEPAR)) {
                        oneNote.append(line).append("\n");
                     } else {
                        oneNote.append(SEPAR).append("\n");
                    }
                    line = reader.readLine();
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Создаем список записок типа StringBuilder
        int count = 0;
        ArrayList<StringBuilder> notes = new ArrayList<>();
        while (count < oneNote.length() - 1) {
            int ind = oneNote.indexOf(SEPAR, count);
            notes.add(new StringBuilder(oneNote.substring(count, ind - 1)));
            count = ind + SEPAR.length() + 1;
        }
        return notes;
    }

    @Override
    public void saveAllNotes(ArrayList<StringBuilder> notes) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (StringBuilder note : notes) {
                int index = note.indexOf("\n");
                writer.write(note.substring(0, index + 1));
                int indexPlus = index + 1;
                index = note.indexOf("\n", index + 1);
                writer.write(note.substring(indexPlus, index + 1));
                indexPlus = index + 1;
                writer.write(note.substring(indexPlus, note.length() - 1));
                writer.append("\n" +SEPAR + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
