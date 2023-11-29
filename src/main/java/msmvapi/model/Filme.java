package msmvapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID filmeId;

    @JsonProperty("Title")
    @Column(name = "titulo")
    private String title;

    @JsonProperty("Year")
    @Column(name = "ano")
    private String year;

    @JsonProperty("Director")
    @Column(name = "diretor")
    private String director;


    public Filme(String title, String year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }
}