package hellojpa4;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@DiscriminatorValue(value = "B")
public class Book extends Item {


    private String autor;
    private String isbn;
}
