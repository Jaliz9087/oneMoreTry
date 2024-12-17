package pges.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultTable {
    public void CheckResult(String key , String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(Condition.text(value));

    }
}
