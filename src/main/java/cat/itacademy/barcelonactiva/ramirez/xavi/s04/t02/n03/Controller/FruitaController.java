package cat.itacademy.barcelonactiva.ramirez.xavi.s04.t02.n03.Controller;

import cat.itacademy.barcelonactiva.ramirez.xavi.s04.t02.n03.Model.Fruita;
import cat.itacademy.barcelonactiva.ramirez.xavi.s04.t02.n03.Repository.FruitaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:3306")
public class FruitaController {

        @Autowired
        FruitaRepository fruitaRepository;

        @PostMapping("/add")
        public String saveBook(@RequestBody Fruita fruita){
            fruitaRepository.save(fruita);

            return "Added Successfully";

        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Fruita> updateFruit(@PathVariable("id") int id, @Valid @RequestBody Fruita fruita) {
            Optional<Fruita> fruitData = fruitaRepository.findById(id);

            if (fruitData.isPresent()) {
                Fruita _fruita = fruitData.get();
                _fruita.setNom(fruita.getNom());
                _fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
                //_fruita.setPublished(tutorial.isPublished());
                return new ResponseEntity<>(fruitaRepository.save(_fruita), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/delete/{id}")
        public String deleteFruit(@PathVariable int id){
            fruitaRepository.deleteById(id);

            return "Deleted Successfully";
        }

        @GetMapping("/getOne/{id}")
        public Optional<Fruita> getFruita(@PathVariable int id) {
            return fruitaRepository.findById(id);
        }

        @GetMapping("/getAll")
        public List<Fruita> getFruites() {

            return fruitaRepository.findAll();
        }
}
