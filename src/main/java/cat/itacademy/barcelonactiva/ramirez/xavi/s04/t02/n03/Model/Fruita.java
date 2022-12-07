package cat.itacademy.barcelonactiva.ramirez.xavi.s04.t02.n03.Model;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;




    //Annotations
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Document(collection = "Fruita")



    public class Fruita {

    //Atributs

    @Id
    private int id;
    private String nom;
    private int quantitatQuilos;


}
