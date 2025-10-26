package solipsismal.olympiacosfcapp.core.enums;

import lombok.Getter;

@Getter
public enum Result {
    DRAW("D"),
    WIN("W"),
    LOSS("L");

    private final String abbreviation;

    Result(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}