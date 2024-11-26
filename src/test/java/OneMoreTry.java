import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OneMoreTry {
    @BeforeAll
    static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";



}

    @Test
    void testForForm(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Anatoly");
        $("#lastName").setValue("Vorishka");
        $("#userEmail").setValue("ganja@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0000000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2009");
        $(".react-datepicker__day.react-datepicker__day--003").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("mountain-reflections-3840x2400.png");
        $("#currentAddress").setValue("Niznekamsk");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();

        $("#submit").click();

        //Проверяем че там отработало

        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Anatoly Vorishka"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("ganja@gmail.com"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("0000000000"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("03 January,2009"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Music"));
        $(".table").shouldHave(text("Picture")).shouldHave(text("mountain-reflections-3840x2400.png"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("Niznekamsk"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Noida"));





    }
}
