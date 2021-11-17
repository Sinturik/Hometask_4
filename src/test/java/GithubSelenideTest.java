import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSelenideTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void PresenceSoftAssertionsPage() {
        //открыть сайт github.com
        open("https://github.com");

        //ввести в строку поиска "selenide" и нажать кнопку Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();

        //перейти в раздел Wiki
        $("[data-search-type=Wikis]").click();

        //убедиться, что в списке страниц есть страница SoftAssertions
        $(".page-responsive").shouldHave(text("SoftAssertions"));

        //открыть страницу SoftAssertions
        $(".page-responsive").$(By.linkText("SoftAssertions")).click();

        //убедиться, что внутри есть пример кода для JUnit5
        $("[id=wiki-wrapper]").shouldHave(text("Using JUnit5 extend test class:"));

    }
}
