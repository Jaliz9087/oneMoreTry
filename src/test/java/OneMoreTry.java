import org.junit.jupiter.api.Test;
import pges.RegPag;

public class OneMoreTry extends TestBase {
    RegPag regPag = new RegPag();

    @Test
    void forFormTest() {
        regPag.openPage()
                .removeBan()
                .SetFirstName("Anatoly")
                .SetLastName("Vorishka")
                .SetUserEmail("ganja@gmail.com")
                .SetGender("Male")
                .SetUserNumber("0000000000").
                SetBirthDate("3", "January", "2009")
                .SetSubject("Maths")
                .SetHobbies("Music")
                .SetUploadPicture("mountain-reflections-3840x2400.png")
                .SetSelectAddress("Niznekamsk")
                .SetSelectState("NCR")
                .SetSelectCity("Noida").ClickSubmitForm();
        regPag.checkResult("Student Name", "Anatoly Vorishka")
                .checkResult("Student Email", "ganja@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0000000000")
                .checkResult("Date of Birth", "03 January,2009")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "mountain-reflections-3840x2400.png")
                .checkResult("Address", "Niznekamsk")
                .checkResult("State and City", "NCR Noida");
    }
    @Test
    void negativeTest() {
        regPag.openPage()
                .removeBan()
                .SetFirstName("")
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
                .SetSelectCity("Noida").ClickSubmitForm();
        regPag.InvalidFirstName()
                .InvalidLastName()
                .InvalidUserEmail();

    }
    @Test
    void minimalFillFormTest() {
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
        regPag.checkResult("Student Name", "Anatoly Vorishka")
                .checkResult("Student Email", "ganja@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0000000000")
                .checkResult("Date of Birth", "03 January,2009")
                .checkResult("Hobbies", "Music")
                .checkResult("Address", "Niznekamsk");

    }
}
