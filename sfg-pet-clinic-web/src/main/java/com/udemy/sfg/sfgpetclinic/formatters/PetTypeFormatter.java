package com.udemy.sfg.sfgpetclinic.formatters;

import com.udemy.sfg.sfgpetclinic.model.PetType;
import com.udemy.sfg.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String petTypeInput, Locale locale) throws ParseException {
        return petTypeService.findAll().stream()
                .filter(petType -> petType.getTypeName().equals(petTypeInput))
                .findFirst()
                .orElseThrow(() -> new ParseException("Pet Type not found by name " + petTypeInput, 0));
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getTypeName();
    }
}
