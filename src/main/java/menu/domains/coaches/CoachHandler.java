package menu.domains.coaches;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domains.menu.Menu;
import menu.helpers.InputHandler;
import menu.ui.OutputView;

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
        if (this.suggestedCategories.get(randomCategory) != null && this.suggestedCategories.get(randomCategory) >= 2) {
            do {
                randomCategory = menu.getRandomCategory();
            } while (this.suggestedCategories.get(randomCategory) >= 2);
        }
        menu.addToFinalCategories(randomCategory);
        this.suggestedCategories.computeIfPresent(randomCategory, (key, value) -> value + 1);
        this.suggestedCategories.computeIfAbsent(randomCategory, (key) -> 1);

        List<String> menuItems = menu.getMenuItems(randomCategory);

        this.coaches.forEach(coach -> {
            String randomMenu = Randoms.shuffle(menuItems).get(0);
            if (coach.isAlreadyRecommended(randomMenu) || !coach.canEat(randomMenu)) {
                do {
                    randomMenu = Randoms.shuffle(menuItems).get(0);
                } while (coach.isAlreadyRecommended(randomMenu) || !coach.canEat(randomMenu));
            }
            coach.addRecommended(randomMenu);
        });
    }

    public void printResults(OutputView outputView) {
        this.coaches.forEach(outputView::printCoachResults);
    }
}
