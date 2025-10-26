package solipsismal.olympiacosfcapp.core.enums;

import lombok.Getter;

@Getter
public enum PreferredFoot {
    BOTH("B"),
    RIGHT("R"),
    LEFT("L");

    private final String abbreviation;

    PreferredFoot(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}