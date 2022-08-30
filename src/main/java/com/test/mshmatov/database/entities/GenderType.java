package com.test.mshmatov.database.entities;

public enum GenderType {
    M("M"),
    W("W"),
    MW("MW");


    private final String alias;

    GenderType(String alias) {
        this.alias = alias;
    }

    public static GenderType of(String gender) {
        String genderAlias = gender.trim().toUpperCase();
        for (GenderType value : values()) {
            if (value.alias.equals(genderAlias)) {
                return value;
            }
        }
        return MW;
    }

    public String getAlias() {
        return alias;
    }
}
