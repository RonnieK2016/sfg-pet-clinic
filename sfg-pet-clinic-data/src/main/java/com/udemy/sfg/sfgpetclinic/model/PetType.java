package com.udemy.sfg.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "types")
public class PetType extends BaseEntity {

    @Column(name = "name")
    String typeName;

    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.typeName = name;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
