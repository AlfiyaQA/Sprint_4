package model;

import io.qameta.allure.Step;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step("Checking that name is not null")
    public boolean isNameNotNull(String name) {
        return name!=null;
    }

    @Step("Checking that name has correct length")
    public boolean isCorrectLength(String name) {
        return name.length() >= 3 && name.length() <= 19;
    }

    @Step("Checking that name has correct space")
    public boolean isCorrectSpace(String name) {
        int spaceCount = 0;
        for (char element : name.toCharArray()) {
            if (element == ' ') {
                spaceCount++;
            }
        } return name.contains(" ") && !(name.startsWith(" ")) && !(name.endsWith(" ")) && !(spaceCount > 1);
    }

    public boolean checkNameToEmboss() {
        return isNameNotNull(name) && isCorrectLength(name) && isCorrectSpace(name);
    }
}
