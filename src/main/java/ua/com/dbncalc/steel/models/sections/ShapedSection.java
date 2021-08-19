package ua.com.dbncalc.steel.models.sections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

@SuperBuilder
@AllArgsConstructor
public class ShapedSection extends Section{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String standard;

    //profile number(identifier)
    private String profileNumber;
}
