package menu.helpers;

import menu.ui.constants.ErrorMessages;

import java.util.List;

public class Validator {
    private final static String DELIMITER = ",";

    public void checkNames(String input) {
        List<String> names = List.of(input.split(DELIMITER));
        int nameCount = names.size();
        int uniqueCount = (int) names.stream().distinct().count();
        if (nameCount != uniqueCount) {
            throw new IllegalArgumentException(ErrorMessages.INVALID.getMessage());
        }
        if (uniqueCount < 2 || uniqueCount > 5) {
            throw new IllegalArgumentException(ErrorMessages.INVALID.getMessage());
        }
        names.forEach(name -> {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(ErrorMessages.INVALID.getMessage());
            }
        });
    }
}
