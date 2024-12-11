package menu.domains.coaches;

import menu.helpers.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class CoachHandler {
    private final List<Coach> coaches = new ArrayList<>();

    public void addCoach(String names) {
        List<String> coachNames = List.of(names.split(","));
        coachNames.forEach(name -> {
            Coach newCoach = new Coach(name);
            this.coaches.add(newCoach);
        });
    }

    public void initMenus(InputHandler inputHandler) {
        inputHandler.getCoachMenu(this.coaches);
    }
}
