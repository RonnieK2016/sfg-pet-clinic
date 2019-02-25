package com.udemy.sfg.sfgpetclinic.model;

public class PetType extends BaseEntity {

    String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
