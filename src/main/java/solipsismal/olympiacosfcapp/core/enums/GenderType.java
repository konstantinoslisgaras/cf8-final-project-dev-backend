package solipsismal.olympiacosfcapp.core.enums;

public enum GenderType {
    PREFER_NOT_TO_DISCLOSE("Prefer not to disclose"),
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String genderType;

    GenderType(String genderType) {
        this.genderType = genderType;
    }

    @Override
    public String toString() {
        return genderType;
    }
}