package hibernate_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Grade implements IBaseEntity { //ocena z przedmiotu
    @Override
    public Long getId() {
        return null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private GradeSubject subject;

    @CreationTimestamp
    private LocalDateTime dateAdded;

    private double value;

    // "nullable = false" == "not null"

    @ToString.Exclude
    @ManyToOne()
    private Student student;
}
