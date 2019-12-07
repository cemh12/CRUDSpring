package Crud.crud;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Data
@Entity
public class Estudiante {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private @Id @GeneratedValue int id;
    private int matricula;
    private String nombre;
    private String telefono;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    Estudiante() {}

    Estudiante(int id, int matricula, String nombre, String telefono) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
