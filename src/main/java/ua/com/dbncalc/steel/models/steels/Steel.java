package ua.com.dbncalc.steel.models.steels;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Steel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    //steel grade
    private String steelName;

    //minimal thickness of the steel profile in mm
    private Double steelThickLowLim;

    //maximal thickness of the steel profile in mm
    private Double steelThickUppLim;

    //characteristic yield strange of steel sheets (Ryn) in N/mm^2
    private Double charYieldStrangeSheet;

    //characteristic ultimate strange of steel sheets (Run) in N/mm^2
    private Double charUltimateStrangeSheet;

    //characteristic yield strange of shaped profiles (Ryn) in N/mm^2
    private Double charYieldStrangeShape;

    //characteristic ultimate strange of shaped profiles (Run) in N/mm^2
    private Double charUltimateStrangeShape;

    //design yield strange of steel sheets (Ry) in N/mm^2
    private Double designYieldStrangeSheet;

    //design ultimate strange of steel sheets (Ru) in N/mm^2
    private Double designUltimateStrangeSheet;

    //design yield strange of shaped profiles (Ry) in N/mm^2
    private Double designYieldStrangeShape;

    //design ultimate strange of shaped profiles (Ru) in N/mm^2
    private Double designUltimateStrangeShape;

    public Steel(Double designYieldStrangeShape) {
        this.designYieldStrangeShape = designYieldStrangeShape;
    }

}
