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
public class Acudiente {
    private int id_acudiente;
    private int tipo_identidad_acu;
    private String nombre_t_identidad;// crear nuevas variables que soloo se utilizarán cuando el metodo de mostrar un acudiente especificamente sea invocado 
    private String numero_identidad_acu;
    private String nombre_acudiente;
    private String primer_apellido_acu;
    private String segundo_apellido_acu;
    private String correo_acu;
    private Date fecha_nacimiento_acu;
    private int genero_acu;
    private String nombre_genero;
    private String telefono_fijo_acu;
    private String telefono_movil_acu;
    private int id_alumno_acu;
    private String info_alum;
    private String parentesco;

    public Acudiente(int id_acudiente, int tipo_identidad_acu, String nombre_t_identidad, String numero_identidad_acu, String nombre_acudiente, String primer_apellido_acu, String segundo_apellido_acu, String correo_acu, Date fecha_nacimiento_acu, int genero_acu, String nombre_genero, String telefono_fijo_acu, String telefono_movil_acu, int id_alumno_acu, String info_alum, String parentesco) {
        this.id_acudiente = id_acudiente;
        this.tipo_identidad_acu = tipo_identidad_acu;
        this.nombre_t_identidad = nombre_t_identidad;
        this.numero_identidad_acu = numero_identidad_acu;
        this.nombre_acudiente = nombre_acudiente;
        this.primer_apellido_acu = primer_apellido_acu;
        this.segundo_apellido_acu = segundo_apellido_acu;
        this.correo_acu = correo_acu;
        this.nombre_genero = nombre_genero;
        this.fecha_nacimiento_acu = fecha_nacimiento_acu;
        this.genero_acu = genero_acu;
        this.telefono_fijo_acu = telefono_fijo_acu;
        this.telefono_movil_acu = telefono_movil_acu;
        this.id_alumno_acu = id_alumno_acu;
        this.info_alum = info_alum;
        this.parentesco = parentesco;
    }

    public int getId_acudiente() {
        return id_acudiente;
    }

    public void setId_acudiente(int id_acudiente) {
        this.id_acudiente = id_acudiente;
    }

    public int getTipo_identidad_acu() {
        return tipo_identidad_acu;
    }

    public void setTipo_identidad_acu(int tipo_identidad_acu) {
        this.tipo_identidad_acu = tipo_identidad_acu;
    }

    public String getNumero_identidad_acu() {
        return numero_identidad_acu;
    }

    public void setNumero_identidad_acu(String numero_identidad_acu) {
        this.numero_identidad_acu = numero_identidad_acu;
    }

    public String getNombre_acudiente() {
        return nombre_acudiente;
    }

    public void setNombre_acudiente(String nombre_acudiente) {
        this.nombre_acudiente = nombre_acudiente;
    }

    public String getPrimer_apellido_acu() {
        return primer_apellido_acu;
    }

    public void setPrimer_apellido_acu(String primer_apellido_acu) {
        this.primer_apellido_acu = primer_apellido_acu;
    }

    public String getSegundo_apellido_acu() {
        return segundo_apellido_acu;
    }

    public void setSegundo_apellido_acu(String segundo_apellido_acu) {
        this.segundo_apellido_acu = segundo_apellido_acu;
    }

    public String getCorreo_acu() {
        return correo_acu;
    }

    public void setCorreo_acu(String correo_acu) {
        this.correo_acu = correo_acu;
    }

    public Date getFecha_nacimiento_acu() {
        return fecha_nacimiento_acu;
    }

    public void setFecha_nacimiento_acu(Date fecha_nacimiento_acu) {
        this.fecha_nacimiento_acu = fecha_nacimiento_acu;
    }

    public int getGenero_acu() {
        return genero_acu;
    }

    public void setGenero_acu(int genero_acu) {
        this.genero_acu = genero_acu;
    }

    public String getTelefono_fijo_acu() {
        return telefono_fijo_acu;
    }

    public void setTelefono_fijo_acu(String telefono_fijo_acu) {
        this.telefono_fijo_acu = telefono_fijo_acu;
    }

    public String getTelefono_movil_acu() {
        return telefono_movil_acu;
    }

    public void setTelefono_movil_acu(String telefono_movil_acu) {
        this.telefono_movil_acu = telefono_movil_acu;
    }

    public int getId_alumno_acu() {
        return id_alumno_acu;
    }

    public void setId_alumno_acu(int id_alumno_acu) {
        this.id_alumno_acu = id_alumno_acu;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
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

    public String getInfo_alum() {
        return info_alum;
    }

    public void setInfo_alum(String info_alum) {
        this.info_alum = info_alum;
    }
    
    
}
