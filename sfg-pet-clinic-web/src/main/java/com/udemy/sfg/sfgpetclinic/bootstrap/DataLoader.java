package com.udemy.sfg.sfgpetclinic.bootstrap;

import com.udemy.sfg.sfgpetclinic.model.*;
import com.udemy.sfg.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      VisitService visitService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) {
        if(petTypeService.findAll().isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setTypeName("Dog");

        PetType cat = new PetType();
        cat.setTypeName("Cat");

        petTypeService.save(dog);
        petTypeService.save(cat);

        System.out.println("PetTypes saved");

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Jackson");
        owner1.setAddress("123 Test St");
        owner1.setCity("Test City");
        owner1.setPhoneNumber("+1-234-456-5678");

        Pet pet1 = new Pet();
        pet1.setName("Max");
        pet1.setPetType(dog);
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jack");
        owner2.setLastName("Johnson");
        owner2.setAddress("321 Test St");
        owner2.setCity("Test1 City");
        owner2.setPhoneNumber("+2-234-456-5678");
        Pet pet2 = new Pet();
        pet2.setName("Minnie");
        pet2.setPetType(cat);
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);
        ownerService.save(owner2);

        System.out.println("Owners saved");

        Visit catVisit = new Visit();
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Cat");
        visitService.save(catVisit);

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("Surgery");

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("Common");

        specialityService.save(speciality1);
        specialityService.save(speciality2);
        System.out.println("Specialities Saved");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jimmy");
        vet1.setLastName("Jones");
        vet1.getSpecialities().add(speciality1);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("James");
        vet2.setLastName("Timmons");
        vet2.getSpecialities().add(speciality2);
        vetService.save(vet2);

        System.out.println("Vets saved");
    }
}
