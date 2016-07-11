package com.epam.java.rt.museco.model.auth;

import com.epam.java.rt.museco.model.general.Term;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Municipal Service Company
 */
public class Role {
    private UUID id = UUID.randomUUID();
    private String name;
    private List<Action> actions = new ArrayList<Action>();
    private Term term;

    public Role() {
    }
}
