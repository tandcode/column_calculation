package ua.com.dbncalc.steel.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@EntityListeners(AuditingEntityListener.class)
public class CCWBCalculation implements Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    CCWBInput input;

    @OneToOne(cascade = {CascadeType.ALL})
    CCWBResult result;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    Date creationDateTime;
}