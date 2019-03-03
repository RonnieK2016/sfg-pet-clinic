package com.udemy.sfg.sfgpetclinic.bootstrap;

import com.udemy.sfg.sfgpetclinic.model.Owner;
import com.udemy.sfg.sfgpetclinic.model.Vet;
import com.udemy.sfg.sfgpetclinic.services.OwnerService;
import com.udemy.sfg.sfgpetclinic.services.VetService;
import com.udemy.sfg.sfgpetclinic.services.map.impl.OwnerMapService;
import com.udemy.sfg.sfgpetclinic.services.map.impl.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerMapService();
        vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Jackson");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jack");
        owner2.setLastName("Johnson");
        ownerService.save(owner2);

        System.out.println("Owners saved");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Jimmy");
        vet1.setFirstName("Jones");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("James");
        vet2.setFirstName("Timmons");
        vetService.save(vet2);

        System.out.println("Vets saved");
    }
}
