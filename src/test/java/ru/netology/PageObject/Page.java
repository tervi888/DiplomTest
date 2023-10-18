package ru.netology.PageObject;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.Card;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Page {
    private final SelenideElement cardNumber = $("input[placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $("input[placeholder='08']");
    private final SelenideElement year = $("input[placeholder='22']");
    private final SelenideElement owner = $$(".input").find(exactText("Владелец")).$(".input__control");
    private final SelenideElement cvc = $("[placeholder='999']");
    private final SelenideElement button = $$(".button").find(exactText("Продолжить"));


    public void pay(Card data) {
        cardNumber.setValue(data.getNumber());
        month.setValue(data.getMonth());
        year.setValue(data.getYear());
        owner.setValue(data.getHolder());
        cvc.setValue(data.getCvv());
        button.click();
    }


    public void approved() {
        SelenideElement successfulNotification = $(".notification_status_ok .notification__content")
                .shouldHave(text("Операция одобрена Банком."), Duration.ofSeconds(20));
        successfulNotification.shouldBe(visible);
    }

    public void declined() {
        SelenideElement declineNotification = $(".notification_status_error .notification__content")
                .shouldHave(text("Ошибка! Банк отказал в проведении операции."), Duration.ofSeconds(15));
        declineNotification.shouldBe(visible);
    }

    public void formatNotification() {
        SelenideElement wrongFormat = $(".input__sub").shouldHave(text("Неверный формат"));
        wrongFormat.shouldBe(visible);
    }

    public void requiredFieldNotification() {
        SelenideElement empty = $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
        empty.shouldBe(visible);
    }

    public void expiredNotification() {
        SelenideElement expired = $(".input__sub").shouldHave(text("Истёк срок действия карты"));
        expired.shouldBe(visible);
    }

    public void wrongValidityNotification() {
        SelenideElement expired = $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
        expired.shouldBe(visible);
    }
}
