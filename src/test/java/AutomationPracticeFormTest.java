import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1050";
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void checkPracticeForm() {
        $("#firstName").setValue("Ilia");
        $("#lastName").setValue("Sharahov");
        $("#userEmail").setValue("mail@mail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1997");
        $(byAttribute("aria-label", "Choose Wednesday, August 6th, 1997")).click();
        $("#subjectsInput").setValue("Co")
                .pressEnter();
        $("#hobbies-checkbox-1").parent()
                .click();
        $("#hobbies-checkbox-2").parent()
                .click();
        $("#hobbies-checkbox-3").parent()
                .click();
        $("#uploadPicture").uploadFromClasspath("img/selfy.png");
        $("#currentAddress").setValue("USA");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR"))
                .click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi"))
                .click();
        $("#submit").scrollTo()
                .click();

        $(".table-responsive")
                .shouldHave(text("Ilia Sharahov"))
                .shouldHave(text("mail@mail.com"))
                .shouldHave(text("Male"))
                .shouldHave(text("0123456789"))
                .shouldHave(text("06 August,1997"))
                .shouldHave(text("Computer Science"))
                .shouldHave(text("Sports, Reading, Music"))
                .shouldHave(text("selfy.png"))
                .shouldHave(text("USA"))
                .shouldHave(text("NCR Delhi"));
    }
}
