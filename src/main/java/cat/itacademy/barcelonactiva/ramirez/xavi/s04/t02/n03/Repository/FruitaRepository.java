package cat.itacademy.barcelonactiva.ramirez.xavi.s04.t02.n03.Repository;

import cat.itacademy.barcelonactiva.ramirez.xavi.s04.t02.n03.Model.Fruita;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface FruitaRepository extends MongoRepository<Fruita, Integer> {
}
