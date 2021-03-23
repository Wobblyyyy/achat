package me.wobblyyyy.achat;

public class UserParser {
    public static String parse(String username,
                               String id) {
        return "{User " + username + ", ID " + id + "}";
    }
}
