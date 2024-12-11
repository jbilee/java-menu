package menu.helpers;

import menu.domains.coaches.Coach;
import menu.ui.InputView;

import java.util.List;

public class InputHandler {
    private final static InputView inputView = new InputView();
    private final static Validator validator = new Validator();

    public String getCoachInput() {
        while (true) {
            try {
                String input = inputView.readCoaches();
                validator.checkNames(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getCoachMenu(List<Coach> coaches) {
        while (true) {
            try {
                coaches.forEach(coach -> {
                    coach.addMenu(inputView, validator);
                });
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
