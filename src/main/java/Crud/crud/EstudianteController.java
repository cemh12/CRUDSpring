package Crud.crud;
import Crud.crud.Estudiante;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EstudianteController {

    private final EstudianteRepository repository;

    EstudianteController(EstudianteRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/Estudiantes")
    List<Estudiante> all() {
        return repository.findAll();
    }

    @PostMapping("/Estudiantes")
    Estudiante newEstudiante(@RequestBody Estudiante newEstudiante) {
        return repository.save(newEstudiante);
    }

    // Single item

    @GetMapping("/Estudiantes/{id}")
    Estudiante one(@PathVariable int id) {

        return repository.findById(id).orElseThrow(() -> new EstudianteNotFoundException(id));
    }

    @PutMapping("/Estudiantes/{id}")
    Estudiante replaceEstudiante(@RequestBody Estudiante newEstudiante, @PathVariable int id) {

        return repository.findById(id)
                .map(estudiante -> {
                    estudiante.setMatricula(newEstudiante.getMatricula());
                    estudiante.setNombre(newEstudiante.getNombre());
                    estudiante.setTelefono(newEstudiante.getTelefono());
                    return repository.save(estudiante);
                })
                .orElseGet(() -> {
                    newEstudiante.setId(id);
                    return repository.save(newEstudiante);
                });
    }

    @DeleteMapping("/Estudiantes/{id}")
    void deleteEstudiante(@PathVariable int id) {
        repository.deleteById(id);
    }
}