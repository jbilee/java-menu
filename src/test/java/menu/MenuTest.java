package menu;

import menu.domains.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTest {
    @DisplayName("enum에 없으면 예외 발생")
    @Test
    void 메뉴_확인_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Menu.isValidMenu("가"));
    }
}
