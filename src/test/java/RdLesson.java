import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByTagAndText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class RdLesson {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void testGitGubTestNumTwo(){
        open("https://github.com");
        $(new ByTagAndText("button", "Solutions")).hover();
        $("a[href=\"https://github.com/enterprise\"]").click();
        $("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered developer platform"));
    }

}
