/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neighbs;

/**
 *
 * @author ESTUDIANTE
 */
public class Neighb {

    private int code;
    private String name;
    private int pop;

    public Neighb(int code, String name, int pop) {
        this.code = code;
        this.name = name;
        this.pop = pop;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    @Override
    public String toString() {
        return "Neighb{" + "code=" + code + ", name=" + name + ", pop=" + pop + '}';
    }
}
