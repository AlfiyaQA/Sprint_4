package model;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean isCorrectSpace(String name) {
        int spaceCount = 0;
        for (char element : name.toCharArray()) {
            if (element == ' ') {
                spaceCount++;
            }
        } return name.contains(" ") && !(name.startsWith(" ")) && !(name.endsWith(" ")) && !(spaceCount > 1);
    }

    public boolean checkNameToEmboss() {
        return name.length() >= 3 && name.length() <= 19 && isCorrectSpace(name);
    }
}
