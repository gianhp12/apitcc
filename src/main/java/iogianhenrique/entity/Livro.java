package iogianhenrique.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "livro")
public class Livro {

    @Id
    @Column(name = "codigo")
    Integer codigo;

    @Column(name = "titulo")
    String titulo;

    @Column(name = "autor")
    String autor;

    @Column(name = "datacompra")
    String datacompra;

}
