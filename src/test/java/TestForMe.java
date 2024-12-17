import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestForMe {
    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void TestForMeTest(){
        //Порядок выполнения
        open("https://zvuk.com/");
        //Проверяем что получилось
        $("#Text_text__7_imM Text_alignLeft__I9hpQ Text_variantBodyS__2eN0i Text_gutterNone__q_Sqi Text_colorWhite__QW6pn Text_regular__FRo0v Search_text__zfXnF" +
                "" +
                "").shouldHave(Condition.text("Найти трек, подкаст, книгу..."));



    }
}
