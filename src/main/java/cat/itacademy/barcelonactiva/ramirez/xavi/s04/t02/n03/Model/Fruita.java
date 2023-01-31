package cat.itacademy.barcelonactiva.ramirez.xavi.s04.t02.n03.Model;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Document(collection = "Fruit")
    public class Fruita {

    @Id
    private int id;
    private String nom;
    private int quantitatQuilos;


}
