/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author ESTUDIANTE
 */
public class Song implements Serializable {

    private String name;
    private String genre;
    private String composer;
    private float score;
    private float length;

    public Song(String name, String genre, String composer, float score, float length) {
        this.name = name;
        this.genre = genre;
        this.composer = composer;
        this.score = score;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Song{" + "name=" + name + ", genre=" + genre + ", composer=" + composer + ", score=" + score + ", length=" + length + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public float getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

}
