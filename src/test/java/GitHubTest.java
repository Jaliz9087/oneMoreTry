import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class GitHubTest {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";

    }

    @Test
    void testGitHubTest(){
        open("/selenide/selenide");
        //open selenide page
        $("#wiki-tab").click();
        //wiki page click
        $("#wiki-body").shouldHave(text("Soft Assertions"));
        // find softAssertions button
        $("a[href=\'/selenide/selenide/wiki/SoftAssertions\']").shouldHave(text("Soft Assertions")).click();
        // and click
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
        // find JUnit5 example

        //sleep(5000);
    }
}















