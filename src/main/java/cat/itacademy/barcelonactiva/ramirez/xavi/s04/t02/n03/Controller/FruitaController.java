package cat.itacademy.barcelonactiva.ramirez.xavi.s04.t02.n03.Controller;

import cat.itacademy.barcelonactiva.ramirez.xavi.s04.t02.n03.Model.Fruita;
import cat.itacademy.barcelonactiva.ramirez.xavi.s04.t02.n03.Repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/fruits")
public class FruitaController {

        @Autowired
        FruitaRepository fruitaRepository;

    @PostMapping("/add")
    public ResponseEntity<?>addFruit(@RequestBody Fruita fruita) {
        boolean findFruit = fruitaRepository.existsById(fruita.getId());
        ResponseEntity<?> responseEntity;
        if (!findFruit) {
            fruitaRepository.save(fruita);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body("Fruit " + fruita.getId() + " added");
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("fruit with id " + fruita.getId() + "already exists");
        }
        return responseEntity;
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Fruita fruita) {
        ResponseEntity<?> responseEntity;
        Optional<Fruita> fruitUpdate = fruitaRepository.findById(fruita.getId());
        if (fruitUpdate.isPresent()) {
            Fruita _fruita = fruitUpdate.get();
            _fruita.setNom(fruita.getNom());
            _fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
            fruitaRepository.save(_fruita);
            responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).body(_fruita);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("fruit with id " + fruita.getId() + " does not exist");
        }
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFruit(@PathVariable int id) {
        ResponseEntity<?> responseEntity;
        boolean findFruit = fruitaRepository.existsById(id);
        if (findFruit) {
            fruitaRepository.deleteById(id);
            responseEntity = ResponseEntity.status(HttpStatus.OK).body("Fruit with id " + id + " deleted");
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fruit with id " + id + " does not exist");
        }
        return responseEntity;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id) {
        ResponseEntity<?> responseEntity;
        boolean findFruit = fruitaRepository.existsById(id);
        if (findFruit) {
            responseEntity = ResponseEntity.status(HttpStatus.FOUND).body(fruitaRepository.findById(id));
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("fruit with id " + id + " does not exist");
        }
        return responseEntity;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFruit() {
        ResponseEntity<?> responseEntity;
        List<Fruita> list = fruitaRepository.findAll();
        if (list.isEmpty()) {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found");
        } else {
            responseEntity =  ResponseEntity.status(HttpStatus.FOUND).body(fruitaRepository.findAll());
        }
        return responseEntity;
    }

}
