package com.udemy.sfg.sfgpetclinic.bootstrap;

import com.udemy.sfg.sfgpetclinic.model.Owner;
import com.udemy.sfg.sfgpetclinic.model.Pet;
import com.udemy.sfg.sfgpetclinic.model.PetType;
import com.udemy.sfg.sfgpetclinic.model.Vet;
import com.udemy.sfg.sfgpetclinic.services.OwnerService;
import com.udemy.sfg.sfgpetclinic.services.PetTypeService;
import com.udemy.sfg.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setTypeName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setTypeName("Cat");
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
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Owners saved");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jimmy");
        vet1.setLastName("Jones");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("James");
        vet2.setLastName("Timmons");
        vetService.save(vet2);

        System.out.println("Vets saved");
    }
}
