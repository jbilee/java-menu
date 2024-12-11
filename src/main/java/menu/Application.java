package menu;

import menu.domains.coaches.CoachHandler;
import menu.helpers.InputHandler;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        CoachHandler coachHandler = new CoachHandler();

        String name = inputHandler.getCoachInput();
        List<String> names = List.of(name.split(","));
        names.forEach(coachHandler::addCoach);

        
    }
}
