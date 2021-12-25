package com.suru.usersapi.domain.responses;

import java.util.UUID;

public class EntityResponse {
    private UUID id;

    public EntityResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
