/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Danny
 */
public class Alumnos {
    private int id_alumno;
    private int tipo_identidad_alum;
    private String nombre_t_identidad;
    private String numero_identidad_alum;
    private String nombre_alumno;
    private String primer_apellido_alum;
    private String segundo_apellido_alum;
    private Date fecha_nacimiento_alum;
    private int genero_alum;
    private String nombre_genero;
    private Date fecha_ingreso_alum;
    private int nivel_academico;
    private String nombre_nivel;
    private String direccion_residencia_alum;

    public Alumnos(int id_alumno, int tipo_identidad_alum, String nombre_t_identidad, String numero_identidad_alum, String nombre_alumno, String primer_apellido_alum, String segundo_apellido_alum, Date fecha_nacimiento_alum, int genero_alum, String nombre_genero, Date fecha_ingreso_alum, int nivel_academico, String nombre_nivel, String direccion_residencia_alum) {
        this.id_alumno = id_alumno;
        this.tipo_identidad_alum = tipo_identidad_alum;
        this.nombre_t_identidad = nombre_t_identidad;
        this.numero_identidad_alum = numero_identidad_alum;
        this.nombre_alumno = nombre_alumno;
        this.primer_apellido_alum = primer_apellido_alum;
        this.segundo_apellido_alum = segundo_apellido_alum;
        this.fecha_nacimiento_alum = fecha_nacimiento_alum;
        this.genero_alum = genero_alum;
        this.nombre_genero = nombre_genero;
        this.fecha_ingreso_alum = fecha_ingreso_alum;
        this.nivel_academico = nivel_academico;
        this.nombre_nivel = nombre_nivel;
        this.direccion_residencia_alum = direccion_residencia_alum;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getTipo_identidad_alum() {
        return tipo_identidad_alum;
    }

    public void setTipo_identidad_alum(int tipo_identidad_alum) {
        this.tipo_identidad_alum = tipo_identidad_alum;
    }

    public String getNumero_identidad_alum() {
        return numero_identidad_alum;
    }

    public void setNumero_identidad_alum(String numero_identidad_alum) {
        this.numero_identidad_alum = numero_identidad_alum;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getPrimer_apellido_alum() {
        return primer_apellido_alum;
    }

    public void setPrimer_apellido_alum(String primer_apellido_alum) {
        this.primer_apellido_alum = primer_apellido_alum;
    }

    public String getSegundo_apellido_alum() {
        return segundo_apellido_alum;
    }

    public void setSegundo_apellido_alum(String segundo_apellido_alum) {
        this.segundo_apellido_alum = segundo_apellido_alum;
    }

    public Date getFecha_nacimiento_alum() {
        return fecha_nacimiento_alum;
    }

    public void setFecha_nacimiento_alum(Date fecha_nacimiento_alum) {
        this.fecha_nacimiento_alum = fecha_nacimiento_alum;
    }

    public int getGenero_alum() {
        return genero_alum;
    }

    public void setGenero_alum(int genero_alum) {
        this.genero_alum = genero_alum;
    }

    public Date getFecha_ingreso_alum() {
        return fecha_ingreso_alum;
    }

    public void setFecha_ingreso_alum(Date fecha_ingreso_alum) {
        this.fecha_ingreso_alum = fecha_ingreso_alum;
    }

    public int getNivel_academico() {
        return nivel_academico;
    }

    public void setNivel_academico(int nivel_academico) {
        this.nivel_academico = nivel_academico;
    }

    public String getDireccion_residencia_alum() {
        return direccion_residencia_alum;
    }

    public void setDireccion_residencia_alum(String direccion_residencia_alum) {
        this.direccion_residencia_alum = direccion_residencia_alum;
    }

    public String getNombre_t_identidad() {
        return nombre_t_identidad;
    }

    public void setNombre_t_identidad(String nombre_t_identidad) {
        this.nombre_t_identidad = nombre_t_identidad;
    }

    public String getNombre_genero() {
        return nombre_genero;
    }

    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }

    public String getNombre_nivel() {
        return nombre_nivel;
    }

    public void setNombre_nivel(String nombre_nivel) {
        this.nombre_nivel = nombre_nivel;
    }
    
    
    
}
