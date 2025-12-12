package solipsismal.olympiacosfcapp.utils;

import solipsismal.olympiacosfcapp.model.Player;

public final class PlayerUtils {

    private PlayerUtils() {}

    public static String formatPlayerFullName(Player player) {
        String lastname = player.getLastname();
        String firstname = player.getFirstname();
        if (firstname == null || firstname.isEmpty()) return lastname;
        return lastname + " " + firstname.charAt(0) + ".";
    }

    public static String getConcatenatedName(String lastname, String firstname) {
        if (firstname == null || firstname.isEmpty()) return lastname;
        return lastname + " " + firstname.charAt(0) + ".";
    }
}