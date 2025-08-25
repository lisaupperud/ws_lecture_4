package com.lisa.lektion_4.model;
// Record vs Class
// Record -> takes in parameters
// Record -> automatically has getters & setters
// Record == object that can be a one-liner
public record CustomUser(
        String username,
        String password,
        boolean accountEnabled
) {



}
