package fr.syudagye.josu.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GameMode {
    CATCH("catch"),
    MANIA("mania"),
    STANDARD("standard"),
    TAIKO("taiko");

    @JsonValue
    private String name;

    GameMode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
