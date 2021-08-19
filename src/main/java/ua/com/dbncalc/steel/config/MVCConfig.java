package ua.com.dbncalc.steel.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import ua.com.dbncalc.steel.models.sections.HollowSection;
import ua.com.dbncalc.steel.models.sections.IBeamSection;
import ua.com.dbncalc.steel.models.sections.Section;
import ua.com.dbncalc.steel.models.sections.UProfileSection;
import ua.com.dbncalc.steel.models.sections.with_units.HollowSectionWithUnits;
import ua.com.dbncalc.steel.models.sections.with_units.IBeamSectionWithUnits;
import ua.com.dbncalc.steel.models.sections.with_units.SectionWithUnits;
import ua.com.dbncalc.steel.models.sections.with_units.UProfileSectionWithUnits;
import ua.com.dbncalc.steel.models.validation.PasswordMatchesValidator;
import ua.com.dbncalc.steel.services.util.CCWBCalculationWorker;
import ua.com.dbncalc.steel.services.util.units.quantity.SecondMoment;
import ua.com.dbncalc.steel.services.util.units.quantity.WeightPerLength;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;
import java.util.Locale;

import static tech.units.indriya.quantity.Quantities.getQuantity;
import static ua.com.dbncalc.steel.services.util.units.StructuralUnits.*;

@Configuration
@ComponentScan
public class MVCConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CCWBCalculationWorker ccwbCalculationWorker(){
        return new CCWBCalculationWorker();
    }

    @Bean
    public PasswordMatchesValidator passwordMatchesValidator() {
        return new PasswordMatchesValidator();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        initSectionTypeMappers(mapper);
        return mapper;
    }

    public void initSectionTypeMappers(ModelMapper modelMapper) {
        Converter<Double, Quantity<Length>> lengthConv = ctx -> getQuantity(ctx.getSource(), MILLIMETRE);
        Converter<Double, Quantity<Area>> areaConv = ctx -> getQuantity(ctx.getSource(), SQUARE_CENTIMETRE);
        Converter<Double, Quantity<WeightPerLength>> weightPerLengthConv = ctx -> getQuantity(ctx.getSource(), KILOGRAM_PER_METRE);
        Converter<Double, Quantity<SecondMoment>> secondMomentConv = ctx -> getQuantity(ctx.getSource(), CENTIMETRE_TO_THE_FOURTH);
        Converter<Double, Quantity<Volume>> volumeConv = ctx -> getQuantity(ctx.getSource(), CENTIMETRE_TO_THE_THIRD);

        modelMapper.typeMap(Section.class, SectionWithUnits.class).addMappings(mapper -> {
            mapper.using(lengthConv).map(Section::getDepth, SectionWithUnits::setDepth);
            mapper.using(lengthConv).map(Section::getWidth, SectionWithUnits::setWidth);
            mapper.using(areaConv).map(Section::getArea, SectionWithUnits::setArea);
            mapper.using(weightPerLengthConv).map(Section::getWeightPerLength, SectionWithUnits::setWeightPerLength);
            mapper.using(secondMomentConv).map(Section::getSecondMomentAboutYAxis, SectionWithUnits::setSecondMomentAboutYAxis);
            mapper.using(secondMomentConv).map(Section::getSecondMomentAboutZAxis, SectionWithUnits::setSecondMomentAboutZAxis);
            mapper.using(volumeConv).map(Section::getSectionModulusAboutYAxis, SectionWithUnits::setSectionModulusAboutYAxis);
            mapper.using(volumeConv).map(Section::getSectionModulusAboutZAxis, SectionWithUnits::setSectionModulusAboutZAxis);
            mapper.using(lengthConv).map(Section::getRadiusOfGyrationYAxis, SectionWithUnits::setRadiusOfGyrationYAxis);
            mapper.using(lengthConv).map(Section::getRadiusOfGyrationZAxis, SectionWithUnits::setRadiusOfGyrationZAxis);
        })
                .include(IBeamSection.class, IBeamSectionWithUnits.class)
                .include(UProfileSection.class, UProfileSectionWithUnits.class)
                .include(HollowSection.class, HollowSectionWithUnits.class);

        modelMapper.typeMap(IBeamSection.class, IBeamSectionWithUnits.class).addMappings(mapper -> {
            mapper.using(lengthConv).map(IBeamSection::getWebThick, IBeamSectionWithUnits::setWebThick);
            mapper.using(lengthConv).map(IBeamSection::getFlangeThick, IBeamSectionWithUnits::setFlangeThick);
            mapper.using(volumeConv).map(IBeamSection::getFirstMomentAboutYAxis, IBeamSectionWithUnits::setFirstMomentAboutYAxis);
            mapper.using(lengthConv).map(IBeamSection::getInsideRadius, IBeamSectionWithUnits::setInsideRadius);
        });


        modelMapper.typeMap(UProfileSection.class, UProfileSectionWithUnits.class).addMappings(mapper -> {
            mapper.using(lengthConv).map(UProfileSection::getWebThick, UProfileSectionWithUnits::setWebThick);
            mapper.using(lengthConv).map(UProfileSection::getFlangeThick, UProfileSectionWithUnits::setFlangeThick);
            mapper.using(volumeConv).map(UProfileSection::getFirstMomentAboutYAxis, UProfileSectionWithUnits::setFirstMomentAboutYAxis);
            mapper.using(lengthConv).map(UProfileSection::getInsideRadius, UProfileSectionWithUnits::setInsideRadius);
            mapper.using(lengthConv).map(UProfileSection::getCenterOfTheWeight, UProfileSectionWithUnits::setCenterOfTheWeight);
        });


        modelMapper.typeMap(HollowSection.class, HollowSectionWithUnits.class).addMappings(mapper -> {
            mapper.using(lengthConv).map(HollowSection::getWebThick, HollowSectionWithUnits::setWebThick);
            mapper.using(lengthConv).map(HollowSection::getInsideRadius, HollowSectionWithUnits::setInsideRadius);
        });
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }


}
