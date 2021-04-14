package fr.syudagye.josu.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RankStatus {
    GRAVEYARD(-2, "graveyard"),
    WIP(-1, "wip"),
    PENDING(0, "pending"),
    RANKED(1, "ranked"),
    APPROVED(2, "approved"),
    QUALIFIED(3, "qualified"),
    LOVED(4, "loved");

    private int integer;
    @JsonValue
    private String string;

    RankStatus(int integer, String string) {
        this.string = string;
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    public String getString() {
        return string;
    }
}
