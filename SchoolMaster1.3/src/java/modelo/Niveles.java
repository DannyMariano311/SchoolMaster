/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Danny
 */
public class Niveles {
    private int id_niveles;
    private String nombre_nivel;
    private int jornada;
    private String nombre_jornada;
    private int id_profesor_nivel;
    private String info_profe;

    public Niveles(int id_niveles, String nombre_nivel, int jornada, String nombre_jornada, int id_profesor_nivel, String info_profe) {
        this.id_niveles = id_niveles;
        this.nombre_nivel = nombre_nivel;
        this.jornada = jornada;
        this.nombre_jornada = nombre_jornada;
        this.id_profesor_nivel = id_profesor_nivel;
        this.info_profe = info_profe;
    }

    public int getId_niveles() {
        return id_niveles;
    }

    public void setId_niveles(int id_niveles) {
        this.id_niveles = id_niveles;
    }

    public String getNombre_nivel() {
        return nombre_nivel;
    }

    public void setNombre_nivel(String nombre_nivel) {
        this.nombre_nivel = nombre_nivel;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public int getId_profesor_nivel() {
        return id_profesor_nivel;
    }

    public void setId_profesor_nivel(int id_profesor_nivel) {
        this.id_profesor_nivel = id_profesor_nivel;
    }

    public String getNombre_jornada() {
        return nombre_jornada;
    }

    public void setNombre_jornada(String nombre_jornada) {
        this.nombre_jornada = nombre_jornada;
    }

    public String getInfo_profe() {
        return info_profe;
    }

    public void setInfo_profe(String info_profe) {
        this.info_profe = info_profe;
    }
    
    
    
}
