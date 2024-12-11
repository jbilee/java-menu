package menu.domains.coaches;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> menu = new ArrayList<>();
    private final List<String> recommended = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addMenu(List<String> newMenu) {
        this.menu.addAll(newMenu);
    }
}
