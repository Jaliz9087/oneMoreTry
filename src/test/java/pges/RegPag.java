package pges;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pges.components.CalendarComponent;
import pges.components.CheckResultTable;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegPag {
    public SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            selectGender = $("#genterWrapper"),
            userNumInput = $("#userNumber"),
            calendarDateInput = $("#dateOfBirthInput"),
            selectSubject = $("#subjectsInput"),
            selectHobbies = $("#hobbiesWrapper"),
            uploadPic = $("#uploadPicture"),
            selectAddress = $("#currentAddress"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            clickSubmitForm = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultTable checkResultTable = new CheckResultTable();


    public RegPag openPage() {
        open("/automation-practice-form");

        return this;
    }

//    public RegPag removeBan() {
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");
//        return this;
//    }

    public RegPag SetFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegPag SetLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegPag SetUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;

    }

    public RegPag SetGender(String value) {
        selectGender.$(byText(value)).click();
        return this;

    }

    public RegPag SetUserNumber(String value) {
        userNumInput.setValue(value);
        return this;
    }

    public RegPag SetBirthDate(String day, String month, String year) {
        calendarDateInput.click();
        calendarComponent.SetDate(day, month, year);

        return this;

    }

    public RegPag SetSubject(String value) {
        selectSubject.setValue(value).pressEnter();
        return this;
    }

    public RegPag SetHobbies(String value) {
        selectHobbies.$(byText(value)).click();
        return this;
    }

    public RegPag SetUploadPicture(String value) {
        uploadPic.uploadFromClasspath(value);
        return this;
    }

    public RegPag SetSelectAddress(String value) {
        selectAddress.setValue(value);
        return this;
    }

    public RegPag SetSelectState(String value) {
        selectState.setValue(value).pressEnter();
        return this;
    }

    public RegPag SetSelectCity(String value) {
        selectCity.setValue(value).pressEnter();
        return this;
    }

    public RegPag ClickSubmitForm() {
        clickSubmitForm.scrollIntoView(true).click();
        return this;
    }


    //check result
    public RegPag checkResult(String key, String value) {
        checkResultTable.CheckResult(key, value);
        return this;

    }

    //fpr negTest
    public RegPag InvalidFirstName() {
        firstNameInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public RegPag InvalidLastName() {
        lastNameInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public RegPag InvalidUserEmail() {
        userEmailInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    //minTest
    public RegPag fillFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegPag fillLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegPag fillUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegPag fillGender(String value) {
        selectGender.$(byText(value)).click();
        return this;
    }

    public RegPag fillUserNumber(String value) {
        userNumInput.setValue(value);
        return this;
    }

    public RegPag fillBirthDate(String day, String month, String year) {
        calendarDateInput.click();
        calendarComponent.SetDate(day, month, year);
        return this;
    }

    public RegPag fillHobbies(String value) {
        selectHobbies.$(byText(value)).click();
        return this;
    }

    public RegPag fillAddress(String value) {
        selectAddress.setValue(value);
        return this;
    }

}