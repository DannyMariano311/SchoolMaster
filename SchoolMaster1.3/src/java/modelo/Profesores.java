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
public class Profesores {
    private int id_profesor;
    private int tipo_identidad;
    private String nombre_t_identidad;
    private String numero_identidad_pro;
    private String nombre_pro;
    private String primer_apellido_pro;
    private String segundo_apellido_pro;
    private String correo_electronico_pro;
    private Date fecha_nacimiento_pro;
    private int genero_pro;
    private String nombre_genero;
    private String direccion_residencia_pro;
    private String telefono_fijo_pro;
    private String telefono_movil_pro;
    private Date fecha_ingreso_pro;


    public Profesores(){
        
    }
    
    public Profesores(int id_profesor, int tipo_identidad, String nombre_t_identidad, String numero_identidad_pro, String nombre_pro, String primer_apellido_pro, String segundo_apellido_pro, String correo_electronico_pro, Date fecha_nacimiento_pro, int genero_pro, String nombre_genero, String direccion_residencia_pro, String telefono_fijo_pro, String telefono_movil_pro, Date fecha_ingreso_pro) {
        this.id_profesor = id_profesor;
        this.tipo_identidad = tipo_identidad;
        this.nombre_t_identidad = nombre_t_identidad;
        this.numero_identidad_pro = numero_identidad_pro;
        this.nombre_pro = nombre_pro;
        this.primer_apellido_pro = primer_apellido_pro;
        this.segundo_apellido_pro = segundo_apellido_pro;
        this.correo_electronico_pro = correo_electronico_pro;
        this.fecha_nacimiento_pro = fecha_nacimiento_pro;
        this.genero_pro = genero_pro;
        this.nombre_genero = nombre_genero;
        this.direccion_residencia_pro = direccion_residencia_pro;
        this.telefono_fijo_pro = telefono_fijo_pro;
        this.telefono_movil_pro = telefono_movil_pro;
        this.fecha_ingreso_pro = fecha_ingreso_pro;
        
    }

    
    
    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getTipo_identidad() {
        return tipo_identidad;
    }

    public void setTipo_identidad(int tipo_identidad) {
        this.tipo_identidad = tipo_identidad;
    }

    public String getNumero_identidad_pro() {
        return numero_identidad_pro;
    }

    public void setNumero_identidad_pro(String numero_identidad_pro) {
        this.numero_identidad_pro = numero_identidad_pro;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public String getPrimer_apellido_pro() {
        return primer_apellido_pro;
    }

    public void setPrimer_apellido_pro(String primer_apellido_pro) {
        this.primer_apellido_pro = primer_apellido_pro;
    }

    public String getSegundo_apellido_pro() {
        return segundo_apellido_pro;
    }

    public void setSegundo_apellido_pro(String segundo_apellido_pro) {
        this.segundo_apellido_pro = segundo_apellido_pro;
    }

    public String getCorreo_electronico_pro() {
        return correo_electronico_pro;
    }

    public void setCorreo_electronico_pro(String correo_electrónico_pro) {
        this.correo_electronico_pro = correo_electrónico_pro;
    }

    public Date getFecha_nacimiento_pro() {
        return fecha_nacimiento_pro;
    }

    public void setFecha_nacimiento_pro(Date fecha_nacimiento_pro) {
        this.fecha_nacimiento_pro = fecha_nacimiento_pro;
    }

    public int getGenero_pro() {
        return genero_pro;
    }

    public void setGenero_pro(int genero_pro) {
        this.genero_pro = genero_pro;
    }

    public String getDireccion_residencia_pro() {
        return direccion_residencia_pro;
    }

    public void setDireccion_residencia_pro(String direccion_residencia_pro) {
        this.direccion_residencia_pro = direccion_residencia_pro;
    }

    public String getTelefono_fijo_pro() {
        return telefono_fijo_pro;
    }

    public void setTelefono_fijo_pro(String telefono_fijo_pro) {
        this.telefono_fijo_pro = telefono_fijo_pro;
    }

    public String getTelefono_movil_pro() {
        return telefono_movil_pro;
    }

    public void setTelefono_movil_pro(String telefono_movil_pro) {
        this.telefono_movil_pro = telefono_movil_pro;
    }

    public Date getFecha_ingreso_pro() {
        return fecha_ingreso_pro;
    }

    public void setFecha_ingreso_pro(Date fecha_ingreso_pro) {
        this.fecha_ingreso_pro = fecha_ingreso_pro;
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
    
    
}
