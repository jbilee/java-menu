package menu.domains.menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.ui.OutputView;
import menu.ui.constants.ErrorMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Menu {
    private final static List<String> categories = List.of("null", "일식", "한식", "중식", "아시안", "양식");
    private final static Map<String, String> allMenus = Map.of("일식", "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼", "한식", "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음", "중식", "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채", "아시안", "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜", "양식", "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");
    private final List<String> finalCategories = new ArrayList<>();

    public static void isValidMenu(String name) {
        MenuItems result = MenuItems.findByItem(name);
        if (result.getCategory().equals("없음")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID.getMessage());
        }
    }

    public List<String> getMenuItems(String category) {
        String categoryMenus = allMenus.get(category);
        return List.of(categoryMenus.split(", "));
    }

    public String getRandomCategory() {
        return categories.get(Randoms.pickNumberInRange(1, 5));
    }

    public void addToFinalCategories(String category) {
        this.finalCategories.add(category);
    }

    public void printCategories(OutputView outputView) {
        String result = "[ 카테고리 | " + String.join(" | ", this.finalCategories) + " ]";
        outputView.printCategories(result);
    }
}