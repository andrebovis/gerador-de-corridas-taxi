package com.geradordecorridas.domain;

import java.util.UUID;

public class Id {
    private UUID id;

    public Id(UUID id) {
        this.id = id;
    }

    public static Id generateId() {
        return new Id(UUID.randomUUID());
    }

    public UUID getId() {
        return id;
    }

}
