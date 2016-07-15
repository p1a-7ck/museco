package com.epam.java.rt.museco.model.auth;

import com.epam.java.rt.museco.model.general.PersonName;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class User {
    private UUID id = UUID.randomUUID();
    private String userName;
    private String passwordHash;
    private PersonName personName;
    private List<Role> roles = new ArrayList<Role>();
//    private Term term;

    public User() {
    }
}
