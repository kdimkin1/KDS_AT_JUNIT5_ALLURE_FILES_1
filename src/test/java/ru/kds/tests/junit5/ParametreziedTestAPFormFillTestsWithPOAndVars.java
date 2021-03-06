package ru.kds.tests.junit5;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kds.pages.demoqa.RegistrationPage;
import ru.kds.tests.demoqa.TestBase;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;


public class ParametreziedTestAPFormFillTestsWithPOAndVars extends TestBase {

    //Test data variables
    String firstNameDefault = "Anton",
           lastNameDefault = "Gorodetskiy",
           userEmailDefault = "Anton.Gorodetskiy@mail.com",
            gender = "Male",
            userNumberDefault = "9296112233",
            dateOfBirthYear = "1982",
            dateOfBirthMonth = "August",
            subjectsInputFirst = "Social Studies",
            subjectsInputSecond = "Accounting",
            hobbiesFirst = "Sports",
            hobbiesSecond = "Music",
            fileWithPictureName = "AntonG.jpg",
            currentAddress = "Karnal Bus Stand",
            state = "Haryana",
            city = "Karnal";
    Integer dateOfBirthDay = 19;
    File fileWithPicture = new File("src/test/resources/AntonG.jpg");

    RegistrationPage registrationPage = new RegistrationPage();



    @Description("ParameterizedCsvSourceAutomationPracticeFormFillTests")
    @DisplayName("ParameterizedCsvSourceAutomationPracticeFormFillTests(demoqa.com).")
    @CsvSource(value = {
            "Anton| Городетский | Anton.Gorodetskiy@mail.com | 9296112233" ,
            "Ivan | Ivanov | Ivan.Ivanov@mail.com | 9296112255",
            "Fedor | Sukhanov | Fedor.Sukhanov@mail.com | 9416112255"
    }, delimiter = '|')
    @ParameterizedTest(name = "Проверка заполнения тестовой формы для данных: \"{0}\"")
    void csvSourceapfSuccessFillTest(String firstName, String lastName, String userEmail, String userNumber) {
        step("Открыть https://demoqa.com/automation-practice-form", () -> {
            registrationPage.openPage();
        });

        step("Заполнить поле First Name(Anton)", () -> {
            registrationPage.setFirstName(firstName);
        });

        step("Заполнить поле Last Name (Gorodetskiy)", () -> {
            //$("#lastName").setValue(lastName);
            registrationPage.setLastName(lastName);
        });

        step("Заполнить поле Email (Anton.Gorodetskiy@mail.com)", () -> {
            registrationPage.setUserEmail(userEmail);
        });

        step("Заполнить поле Gender (Male)", () -> {
            registrationPage.setFieldWText(gender);
        });

        step("Заполнить поле Mobile (9296112233)", () -> {
            registrationPage.setUserNumber(userNumber);
        });

        step("Заполнить поле Date of Birth (19 Aug 1982)", () -> {
            registrationPage.setDateofBirth(dateOfBirthYear, dateOfBirthMonth, dateOfBirthDay);
        });

        step("Заполнить поле Subject (Social Studies, Accounting)", () -> {
            registrationPage.setSubjects(subjectsInputFirst, subjectsInputSecond);
        });

        step("Заполнить чекбокс Hobbies (Sports, Music)", () -> {
            registrationPage.setFieldWText(hobbiesFirst);
            registrationPage.setFieldWText(hobbiesSecond);
        });

        step("Добавить картинку Picture (AntonG.jpg)", () -> {
            registrationPage.setUploadPicture(fileWithPicture);
        });

        step("Заполнить поле Current Address (Karnal Bus Stand)", () -> {
            registrationPage.setCurrentAddress(currentAddress);
        });

        step("Заполнить поле State(Haryana)", () -> {
            // скрыть блок рекламы, если есть
            registrationPage.adClose();
            registrationPage.setState(state);
        });

        step("Заполнить поле City (Karnal)", () -> {
            registrationPage.setCity(city);
        });

        step("Отправить форму (Submit)", () -> {
            registrationPage.setSubmit();
        });

        step("Проверить успешную отправку (содержание формы ответа).", () -> {
            registrationPage.checkForm(firstName, lastName, userEmail, gender, userNumber, dateOfBirthDay,
                    dateOfBirthMonth, dateOfBirthYear, subjectsInputFirst, subjectsInputSecond, hobbiesFirst,
                    hobbiesSecond, fileWithPictureName, currentAddress, state, city);
        });
        step("Закрыть форму (Close)", () -> {
            registrationPage.setClose();
        });
    }

        static Stream<Arguments> mixedArgumentsTestDataProvider() {
            return Stream.of(
                    Arguments.of("Anton", "Городетский", "Anton.Gorodetskiy@mail.com", "9296112233", 19),
                    Arguments.of("Ivan","Ivanov", "Ivan.Ivanov@mail.com","9296112255", 19),
                    Arguments.of("Fedor","Sukhanov","Fedor.Sukhanov@mail.com","9416112255", 19)
            );
        }

        @Description("ParameterizedMixedArgumentsSourceAutomationPracticeFormFillTests")
        @DisplayName("ParameterizedMixedArgumentsSourceAutomationPracticeFormFillTests(demoqa.com).")
        @MethodSource(value = "mixedArgumentsTestDataProvider")
        @ParameterizedTest(name = "Проверка заполнения тестовой формы для данных: \"{0}\"")
        void mixedArgumentsapfSuccessFillTest(String firstName, String lastName, String userEmail, String userNumber, int dateOfBirthDay) {
            step("Открыть https://demoqa.com/automation-practice-form", () -> {
                registrationPage.openPage();
            });

            step("Заполнить поле First Name(Anton)", () -> {
                registrationPage.setFirstName(firstName);
            });

            step("Заполнить поле Last Name (Gorodetskiy)", () -> {
                //$("#lastName").setValue(lastName);
                registrationPage.setLastName(lastName);
            });

            step("Заполнить поле Email (Anton.Gorodetskiy@mail.com)", () -> {
                registrationPage.setUserEmail(userEmail);
            });

            step("Заполнить поле Gender (Male)", () -> {
                registrationPage.setFieldWText(gender);
            });

            step("Заполнить поле Mobile (9296112233)", () -> {
                registrationPage.setUserNumber(userNumber);
            });

            step("Заполнить поле Date of Birth (19 Aug 1982)", () -> {
                registrationPage.setDateofBirth(dateOfBirthYear,dateOfBirthMonth,dateOfBirthDay);
            });

            step("Заполнить поле Subject (Social Studies, Accounting)", () -> {
                registrationPage.setSubjects(subjectsInputFirst, subjectsInputSecond);
            });

            step("Заполнить чекбокс Hobbies (Sports, Music)", () -> {
                registrationPage.setFieldWText(hobbiesFirst);
                registrationPage.setFieldWText(hobbiesSecond);
            });

            step("Добавить картинку Picture (AntonG.jpg)", () -> {
                registrationPage.setUploadPicture(fileWithPicture);
            });

            step("Заполнить поле Current Address (Karnal Bus Stand)", () -> {
                registrationPage.setCurrentAddress(currentAddress);
            });

            step("Заполнить поле State(Haryana)", () -> {
                // скрыть блок рекламы, если есть
                registrationPage.adClose();
                registrationPage.setState(state);
            });

            step("Заполнить поле City (Karnal)", () -> {
                registrationPage.setCity(city);
            });

            step("Отправить форму (Submit)", () -> {
                registrationPage.setSubmit();
            });

            step("Проверить успешную отправку (содержание формы ответа).", () -> {
                registrationPage.checkForm(firstName, lastName, userEmail,gender,userNumber,dateOfBirthDay,
                        dateOfBirthMonth,dateOfBirthYear,subjectsInputFirst,subjectsInputSecond,hobbiesFirst,
                        hobbiesSecond,fileWithPictureName,currentAddress,state,city);
            });
            step("Закрыть форму (Close)", () -> {
                registrationPage.setClose();
            });


    }

}