package menu.domains.menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MenuItems {
    JP("일식", List.of("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼".split(", "))),
    NONE("없음", Collections.EMPTY_LIST);

    private final String category;
    private final List<String> items;

    MenuItems(String category, List<String> items) {
        this.category = category;
        this.items = items;
    }

    public static MenuItems findByItem(String name) {
        return Arrays.stream(MenuItems.values())
                .filter(category -> category.hasItem(name))
                .findAny()
                .orElse(NONE);
    }

    public boolean hasItem(String name) {
        return items.stream().anyMatch(item -> item.equals(name));
    }

    public String getCategory() {
        return category;
    }
}