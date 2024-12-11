package menu;

import menu.domains.coaches.CoachHandler;
import menu.domains.menu.Menu;
import menu.helpers.InputHandler;
import menu.ui.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        CoachHandler coachHandler = new CoachHandler();
        OutputView outputView = new OutputView();

        outputView.printGreeting();
        String name = inputHandler.getCoachInput();
        List<String> names = List.of(name.split(","));
        names.forEach(coachHandler::addCoach);

        coachHandler.initMenus(inputHandler);
        Menu menu = new Menu();

        for (int i = 0; i < 5; i++) {
            coachHandler.suggestMenus(menu);
        }

        outputView.printResultHeader();
        menu.printCategories(outputView);
        coachHandler.printResults(outputView);

        outputView.printEnding();
    }
}
