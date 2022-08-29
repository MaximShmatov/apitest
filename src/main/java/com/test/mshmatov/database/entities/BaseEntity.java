package com.test.mshmatov.database.entities;

import java.io.Serializable;

public interface BaseEntity <T extends Serializable> {
    T getId();
}
