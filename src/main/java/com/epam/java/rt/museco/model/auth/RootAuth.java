package com.epam.java.rt.museco.model.auth;

import java.util.ArrayList;
import java.util.List;

/**
 * Municipal Service Company
 */
public class RootAuth {
    List<Action> actions = new ArrayList<Action>();
    List<Role> roles = new ArrayList<Role>();
    List<User> users = new ArrayList<User>();

    public RootAuth() {
    }
}
