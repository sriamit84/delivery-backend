package com.fresure.entity;

import java.util.HashMap;
import java.util.Map;

public enum ERole {
	ROLE_USER("ROLE_USER"),
    ROLE_MODERATOR("ROLE_MODERATOR"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_DELIVERY_EXEC("ROLE_DELIVERY_EXEC"),;

    private String abbreviation = null;

    // Reverse-lookup map for getting a day from an abbreviation
    private static final Map<String, ERole> lookup = new HashMap<String, ERole>();

    static {
        for (ERole d : ERole.values()) {
            lookup.put(d.getAbbreviation(), d);
        }
    }


    ERole(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static ERole get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
