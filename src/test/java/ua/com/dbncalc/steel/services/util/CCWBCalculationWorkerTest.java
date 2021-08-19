package ua.com.dbncalc.steel.services.util;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.dbncalc.steel.models.sections.IBeamSection;
import ua.com.dbncalc.steel.models.sections.Section;
import ua.com.dbncalc.steel.models.sections.with_units.IBeamSectionWithUnits;
import ua.com.dbncalc.steel.models.sections.with_units.SectionWithUnits;
import static tech.units.indriya.quantity.Quantities.getQuantity;

import static org.junit.jupiter.api.Assertions.*;
import static ua.com.dbncalc.steel.services.util.units.StructuralUnits.*;

@SpringBootTest
class CCWBCalculationWorkerTest {

    @Autowired
    private CCWBCalculationWorker calculationWorker;

    @Test
    void givenValidSection_whenMapSectionToSectionWithUnits_thenOk() {
        IBeamSection section = IBeamSection.builder()
                .width(1.)
                .depth(2.)
                .area(3.)
                .weightPerLength(4.)
                .secondMomentAboutYAxis(5.)
                .secondMomentAboutZAxis(6.)
                .sectionModulusAboutYAxis(7.)
                .sectionModulusAboutZAxis(8.)
                .radiusOfGyrationYAxis(9.)
                .radiusOfGyrationZAxis(10.)
                .flangeThick(11.)
                .webThick(12.)
                .insideRadius(13.)
                .firstMomentAboutYAxis(14.)
                .build();

        SectionWithUnits sectionWithUnits = calculationWorker.mapSectionToSectionWithUnits(section, Section.SectionType.I_BEAM);
        assertEquals(getQuantity(1, MILLIMETRE), sectionWithUnits.getWidth());
        assertEquals(getQuantity(2, MILLIMETRE), sectionWithUnits.getDepth());
        assertEquals(getQuantity(3, SQUARE_CENTIMETRE), sectionWithUnits.getArea());
        assertEquals(getQuantity(4, KILOGRAM_PER_METRE), sectionWithUnits.getWeightPerLength());
        assertEquals(getQuantity(5, CENTIMETRE_TO_THE_FOURTH), sectionWithUnits.getSecondMomentAboutYAxis());
        assertEquals(getQuantity(6, CENTIMETRE_TO_THE_FOURTH), sectionWithUnits.getSecondMomentAboutZAxis());
        assertEquals(getQuantity(7, CENTIMETRE_TO_THE_THIRD), sectionWithUnits.getSectionModulusAboutYAxis());
        assertEquals(getQuantity(8, CENTIMETRE_TO_THE_THIRD), sectionWithUnits.getSectionModulusAboutZAxis());
        assertEquals(getQuantity(9, MILLIMETRE), sectionWithUnits.getRadiusOfGyrationYAxis());
        assertEquals(getQuantity(10, MILLIMETRE), sectionWithUnits.getRadiusOfGyrationZAxis());
        assertEquals(getQuantity(11, MILLIMETRE), ((IBeamSectionWithUnits)sectionWithUnits).getFlangeThick());
        assertEquals(getQuantity(12, MILLIMETRE), ((IBeamSectionWithUnits)sectionWithUnits).getWebThick());
        assertEquals(getQuantity(13, MILLIMETRE), ((IBeamSectionWithUnits)sectionWithUnits).getInsideRadius());
        assertEquals(getQuantity(14, CENTIMETRE_TO_THE_THIRD), ((IBeamSectionWithUnits)sectionWithUnits).getFirstMomentAboutYAxis());

    }
}