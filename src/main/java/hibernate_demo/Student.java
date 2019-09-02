package hibernate_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //to jest encja bazodanowa
public class Student {
    @Id
    // dodatkowa tabela "hibernate sequence" - sztuczne identyfikatory
    // identity - generuj identyfikator z bazy, pobierz i przypisz do pola
    // sequency - pobierz identyfikator, przypisz go do pola, zapisz obiekt
    // table    -
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Formula(value = "(SELECT AVG(g.value) FROM GRADE g WHERE g.student_id =id)")
    private Double average;  //nullable - nie ma "not null"
    private int age; // "not null"
    private boolean alive; //"not null"

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<Grade> gradeList;

    //wewnątrz modelu może istnieć tylko jedna relacja fetch type eager z listą

}
