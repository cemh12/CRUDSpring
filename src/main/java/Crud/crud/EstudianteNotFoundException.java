package Crud.crud;

public class EstudianteNotFoundException extends RuntimeException {
    public EstudianteNotFoundException(int id) {

        super("Could not find employee " + id);
    }
}
