package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.PageObject.Description;
import ru.netology.PageObject.Page;
import ru.netology.data.*;


import static com.codeborne.selenide.Selenide.open;

public class TestDiplom {
    Description tour;
    Page card;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() {
        SQLHelper.cleanBD();
        open("http://localhost:8080");
        tour = new Description();
        card = tour.chooseCardPayment();

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Поля заполнены валидными значениями и номером карты APPROVED")
    void shouldBeSuccessfulTourCard() {
        card.pay(DataHelper.cardNumberApproved());
        card.approved();
        Payment entity = SQLHelper.paymentEntity();
        Assertions.assertEquals("APPROVED", entity.getStatus());
    }


    @org.junit.jupiter.api.Test
    @DisplayName("Поля заполнены валидными значениями и номером карты DECLINED")
    void shouldBeDeclinedPurchaseTourCard() {
        card.pay(DataHelper.cardNumberDeclined());
        card.declined();
        Payment entity = SQLHelper.paymentEntity();
        Assertions.assertEquals("DECLINED", entity.getStatus());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка пустой формы")
    void shouldEmptyForm() {
        card.pay(DataHelper.emptyForm());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с пустым полем номер карты")
    void SendFormWithEmptyFieldCardNumber() {
        card.pay(DataHelper.cardNumberEmpty());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод нижнего граничного значения для поля Номер карты")
    void SubmitFormCardNumberLowerBound() {
        card.pay(DataHelper.cardNumberLowerBound());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод букв на латинице в поле Номер карты")
    void shouldLettersCharInNumber() {
        card.pay(DataHelper.cardLettersNumber());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод букв на кириллице в поле Номер карты")
    void shouldLettersCyrillicCharInNumber() {
        card.pay(DataHelper.cardLettersCyrillicNumber());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод спецсимволов в поле Номер карты")
    void shouldSpecSymbolCharInNumber() {
        card.pay(DataHelper.cardSymbolsNumber());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с пустым полем Месяц")
    void shouldEmptyMonth() {
        card.pay(DataHelper.emptyMonth());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы со значением в поле Месяц ниже минимального месяца")
    void shouldLowerBoundMonth() {
        card.pay(DataHelper.lowerBoundMonth());
        card.wrongValidityNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы со значением в поле Месяц больше максимального месяца")
    void shouldUppedBoundMonth() {
        card.pay(DataHelper.upperBoundMonth());
        card.wrongValidityNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод букв на кириллице в поле Месяц")
    void shouldLettersCyrillicMonth() {
        card.pay(DataHelper.lettersCyrillicMonth());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод букв на латинице в поле Месяц")
    void shouldLettersMonth() {
        card.pay(DataHelper.lettersMonth());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод спецсимволов в поле Месяц")
    void shouldLettersSymbolsMonth() {
        card.pay(DataHelper.lettersSymbolsMonth());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод нижнего граничного значения для поля Месяц")
    void shouldGetMonthWrongFormat() {
        card.pay(DataHelper.getMonthWrongFormat());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод верхнего граничного значения для поля Месяц")
    void shouldGetMoreWrongFormat() {
        card.pay(DataHelper.getMonthMoreFormat());
        card.wrongValidityNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы со значением в поле Месяц истекшего по срокам месяц")
    void submitFormShouldGetPreviousMonth() {
        card.pay(DataHelper.getPreviousMonth());
        card.wrongValidityNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка данных с пустым полем Год")
    void suFormEmptyYear() {
        card.pay(DataHelper.emptyYear());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод нижнего граничного значения в поле Год")
    void submitFormGetYearWrongFormat() {
        card.pay(DataHelper.getYearWrongFormat());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод спецсимволов в поле Год")
    void submitFormGetSymbolsYear() {
        card.pay(DataHelper.getSymbolsYear());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод букв на латинице в поле Год")
    void submitFormLettersYear() {
        card.pay(DataHelper.lettersYear());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод букв на кириллице в поле Год")
    void submitFormLettersCyrillicYear() {
        card.pay(DataHelper.lettersCyrillicYear());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с истекшим сроком года")
    void submitFormGetPreviousYear() {
        card.pay(DataHelper.getPreviousYear());
        card.expiredNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с большим сроком года, чем предусмотренно")
    void submitFormUppedBoundYear() {
        card.pay(DataHelper.uppedBoundYear());
        card.wrongValidityNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка данных с пустым полем Владелец")
    void submitFormEmptyHolder() {
        card.pay(DataHelper.emptyHolder());
        card.requiredFieldNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с именем и фамилией введенными на кириллице в поле Владелец")
    void submitFormLettersCyrillicInHolder() {
        card.pay(DataHelper.lettersCyrillicInHolder());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с введенными спецсимволами в поле Владелец")
    void submitFormGetSymbolsHolder() {
        card.pay(DataHelper.getSymbolsHolder());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с введенными цифрами в поле Владелец")
    void submitFormNumbersInHolder() {
        card.pay(DataHelper.numbersInHolder());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с введенными именем и фамилией в нижнем регистре")
    void submitFormGetLowerCaseLettersInHolder() {
        card.pay(DataHelper.getLowerCaseLettersInHolder());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с введенным только одной буквой в поле Владелец")
    void submitFormGetOneHolder() {
        card.pay(DataHelper.getOneHolder());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с пустым полем CVC/CVV")
    void submitFormEmptyCVV() {
        card.pay(DataHelper.emptyCVV());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Отправка формы с количеством цифр в поле CVC/CVV меньше минимального значения")
    void getLowerBondCVV() {
        card.pay(DataHelper.getLowerBondCVV());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод латинских букв в поле CVC/CVV")
    void getLettersCVV() {
        card.pay(DataHelper.getLettersCVV());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод букв на кириллице в поле CVC/CVV")
    void getLettersCyrillicCVV() {
        card.pay(DataHelper.getLettersCyrillicCVV());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Ввод спецсимволов в поле CVC/CVV")
    void getSymbolsCVV() {
        card.pay(DataHelper.getSymbolsCVV());
        card.formatNotification();
        SQLHelper.assertDbEmpty();
    }
}
