/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Ricardo
 */
public class SongsFile {

    File file;
    String fileName;

    public SongsFile() throws IOException {
        this.fileName = "C:\\Users\\Ricardo\\Documents\\songs.obj";
        this.file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
            save(new SongsSet());
        }
    }

    public void save(SongsSet s) throws FileNotFoundException, IOException {
        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(fileName));
        outStream.writeObject(s);
        outStream.close();
    }

    public SongsSet read() throws IOException, ClassNotFoundException {
        ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(fileName));
        SongsSet s = (SongsSet) inStream.readObject();
        inStream.close();
        return s;
    }
}
