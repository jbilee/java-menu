package menu.domains.coaches;

import menu.domains.menu.Menu;
import menu.helpers.InputHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachHandler {
    private final List<Coach> coaches = new ArrayList<>();
    private Map<String, Integer> suggestedCategories = new HashMap<>();

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

    public void suggestMenus(Menu menu) {
        String randomCategory = menu.getRandomCategory();
        if (this.suggestedCategories.get(randomCategory) >= 2) {
            do {
                randomCategory = menu.getRandomCategory();
            } while(this.suggestedCategories.get(randomCategory) >= 2);
        }
        menu.addToFinalCategories(randomCategory);
    }
}
