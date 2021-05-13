package ua.com.dbncalc.steel.models.sections;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ShapedSection extends Section{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String standard;

    //profile number(identifier)
    private String profileNumber;
}
