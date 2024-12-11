package menu.ui;

import menu.domains.coaches.Coach;

public class OutputView {
    public void printGreeting() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printResultHeader() {
        System.out.println("메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public void printEnding() {
        System.out.println("추천을 완료했습니다.");
    }

    public void printCategories(String text) {
        System.out.println(text);
    }

    public void printCoachResults(Coach coach) {
        String text = coach.getPrint();
        System.out.println(text);
    }
}

