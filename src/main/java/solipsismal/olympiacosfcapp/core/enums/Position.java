package solipsismal.olympiacosfcapp.core.enums;

public enum Position {
    DO_NOT_USE(0, "DO_NOT_USE"),
    GOALKEEPER(1, "GK"),
    RIGHT_BACK(2, "RB"),
    CENTER_BACK(3, "CB"),
    SWEEPER(4, "SW"),
    LEFT_BACK(5, "LB"),
    DEFENDING_MIDFIELDER(6, "DM"),
    RIGHT_MIDFIELDER(7, "RM"),
    CENTER_MIDFIELDER(8, "CM"),
    LEFT_MIDFIELDER(9, "LM"),
    ATTACKING_MIDFIELDER(10, "AM"),
    RIGHT_WINGER(13, "RW"),
    LEFT_WINGER(14, "LW"),
    SECOND_STRIKER(12, "SS"),
    STRIKER(11, "ST");

    private final int positionNumber;
    private final String abbreviation;

    Position(int positionNumber, String abbreviation) {
        this.positionNumber = positionNumber;
        this.abbreviation = abbreviation;
    }

    public int getPositionNumber() {
        return this == DO_NOT_USE ? -1 : positionNumber;
    }

    public String getAbbreviation() {
        return this == DO_NOT_USE ? "Error" : abbreviation;
    }

    public boolean isGoalkeeper() {
        return this == GOALKEEPER;
    }

    public boolean isDefender() {
        return this == RIGHT_BACK || this == CENTER_BACK || this == SWEEPER || this == LEFT_BACK;
    }

    public boolean isMidfielder() {
        return this == DEFENDING_MIDFIELDER || this == RIGHT_MIDFIELDER || this == CENTER_MIDFIELDER
                || this == LEFT_MIDFIELDER || this == ATTACKING_MIDFIELDER;
    }

    public boolean isAttacker() {
        return this == STRIKER || this == SECOND_STRIKER || this == RIGHT_WINGER || this == LEFT_WINGER;
    }
}