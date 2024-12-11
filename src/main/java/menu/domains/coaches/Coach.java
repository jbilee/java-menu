package menu.domains.coaches;

import menu.helpers.Validator;
import menu.ui.InputView;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> menu = new ArrayList<>();
    private final List<String> recommended = new ArrayList<>();
    private boolean enteredMenu = false;

    public Coach(String name) {
        this.name = name;
    }

    public void addMenu(InputView inputView, Validator validator) {
        if (this.enteredMenu) {
            return;
        }
        String input = inputView.readCoachMenu(this.name);
        validator.checkMenuNames(input);
        List<String> newMenu = List.of(input.split(","));
        this.menu.addAll(newMenu);
        this.enteredMenu = true;
    }

    public boolean isAlreadyRecommended(String menu) {
        return this.recommended.contains(menu);
    }

    public void addRecommended(String menu) {
        this.recommended.add(menu);
    }
}
