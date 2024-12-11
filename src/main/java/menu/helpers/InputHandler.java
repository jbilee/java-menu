package menu.helpers;

import menu.ui.InputView;

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


}
