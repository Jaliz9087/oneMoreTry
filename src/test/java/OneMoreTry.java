import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pges.RegPag;
import utils.ForFaker;

import static io.qameta.allure.Allure.step;

public class OneMoreTry extends TestBase {
    RegPag regPag = new RegPag();
    ForFaker forFaker = new ForFaker();


    @Test
    @Tag("Form_test")
    void formTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        step("Заполняем и сабмитим форму", () -> {
            regPag.openPage()
                    .removeBan()
                    .SetFirstName(forFaker.FirstName)
                    .SetLastName(forFaker.LastName)
                    .SetUserEmail(forFaker.UserEmail)
                    .SetGender(forFaker.Gender)
                    .SetUserNumber(forFaker.UserNumber)
                    .SetBirthDate(forFaker.BirthDay, forFaker.BirthMonth, forFaker.BirthYear)
                    .SetSubject(forFaker.Subject)
                    .SetHobbies(forFaker.Hobbies)
                    .SetUploadPicture(forFaker.Picture)
                    .SetSelectAddress(forFaker.Address)
                    .SetSelectState(forFaker.state)
                    .SetSelectCity(forFaker.city)
                    .ClickSubmitForm();
        });
        step("Проверка отработки", () -> {
            regPag.checkResult("Student Name", forFaker.FirstName + " " + forFaker.LastName)
                    .checkResult("Student Email", forFaker.UserEmail)
                    .checkResult("Gender", forFaker.Gender)
                    .checkResult("Mobile", forFaker.UserNumber)
                    .checkResult("Date of Birth", forFaker.BirthDay + " " + forFaker.BirthMonth + "," + forFaker.BirthYear)
                    .checkResult("Subjects", forFaker.Subject)
                    .checkResult("Hobbies", forFaker.Hobbies)
                    .checkResult("Picture", forFaker.Picture)
                    .checkResult("Address", forFaker.Address)
                    .checkResult("State and City", forFaker.state + " " + forFaker.city);
        });
    }

        @Test
        void negativeTest() {
            step("negativeFillForm n submit", () -> {
                regPag.SetFirstName("")
                        .SetLastName("")
                        .SetUserEmail("bhbjd-llao")
                        .SetGender("Male")
                        .SetUserNumber("LAOKA09866")
                        .SetBirthDate("3", "January", "2009")
                        .SetSubject("Maths")
                        .SetHobbies("Music")
                        .SetUploadPicture("mountain-reflections-3840x2400.png")
                        .SetSelectAddress("Niznekamsk")
                        .SetSelectState("NCR")
                        .SetSelectCity("Noida")
                        .ClickSubmitForm();
            });
            step("Check errors", () -> {
                regPag.InvalidFirstName()
                        .InvalidLastName()
                        .InvalidUserEmail();
            });
        }
        @Test
        void minimalFillFormTest () {
            step("minimal fill form n submit", () -> {
                regPag.openPage()
                        .removeBan()
                        .SetFirstName("Anatoly")
                        .SetLastName("Vorishka")
                        .SetUserEmail("ganja@gmail.com")
                        .SetGender("Male")
                        .SetUserNumber("0000000000")
                        .SetBirthDate("3", "January", "2009")
                        .SetHobbies("Music")
                        .SetSelectAddress("Niznekamsk")
                        .ClickSubmitForm();
            });
            step("Check success result" , () -> {
                regPag.checkResult("Student Name", "Anatoly Vorishka")
                        .checkResult("Student Email", "ganja@gmail.com")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "0000000000")
                        .checkResult("Date of Birth", "03 January,2009")
                        .checkResult("Hobbies", "Music")
                        .checkResult("Address", "Niznekamsk");
            });
        }
}

