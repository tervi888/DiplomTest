package ru.netology.PageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class Description {
    private final SelenideElement title = $$("h2.heading").find(exactText("Путешествие дня"));
    private final SelenideElement buttonBuy = $$("button").find(text("Купить"));
    private final SelenideElement buttonBuyInCredit = $$("button").find((text("Купить в кредит")));

    public Description() {
        title.shouldBe(visible);
        buttonBuy.shouldBe(visible);
        buttonBuyInCredit.shouldBe(visible);
    }

    @SneakyThrows
    public Page chooseCardPayment() {
        buttonBuy.click();
        return new Page();
    }

    public Page chooseCreditPayment() {
        buttonBuyInCredit.click();
        return new Page();
    }
}
