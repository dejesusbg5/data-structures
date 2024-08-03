/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Song;
import data.SongsFile;
import data.SongsSet;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String menu = "Menú de opciones\n"
                + "1. Agregar\n"
                + "2. Mostrar\n"
                + "3. Buscar\n"
                + "4. Eliminar\n"
                + "5. Canción mas larga\n"
                + "6. Salir";

        SongsFile file = new SongsFile();
        SongsSet songs = file.read();
        Song s;
        int option;

        end:
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (option) {
                case 1:
                    s = new Song(
                            JOptionPane.showInputDialog("Nombre:"),
                            JOptionPane.showInputDialog("Género:"),
                            JOptionPane.showInputDialog("Compositor:"),
                            Float.parseFloat(JOptionPane.showInputDialog("Calificación:")),
                            Float.parseFloat(JOptionPane.showInputDialog("Duración:"))
                    );

                    if (songs.add(s)) {
                        System.out.println("Canción agregada");
                        file.save(songs);
                    } else {
                        System.out.println("Canción no agregada");
                    }

                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, songs.toString());
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, songs.contains(JOptionPane.showInputDialog("Nombre a buscar:"))
                            ? "Canción encontrada" : "Canción no encontrada");
                    break;

                case 4:
                    songs.remove(JOptionPane.showInputDialog("Nombre a eliminar:"));
                    file.save(songs);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, songs.maxLength().toString());
                    break;

                case 6:
                    break end;
            }
        } while (true);
    }
}
