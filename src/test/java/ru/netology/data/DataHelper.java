package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    public static String getApprovedCardNumber() {
        return ("1111 2222 3333 4444");
    }

    public static String getDeclinedCardNumber() {
        return ("5555 6666 7777 8888");
    }

    public static String getShiftedMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("mm"));
    }

    public static String getExpiredMonth() {
        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("mm"));
    }

    public static String getShiftedYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getUppedExpiredYear() {
        return LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getLowerExpiredYear() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static Card cardNumberApproved() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card cardNumberDeclined() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getDeclinedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card emptyForm() {
        return new Card("", "", "", "", "");
    }


    public static Card cardNumberEmpty() {
        Faker faker = new Faker(new Locale("en"));
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card("", month, year, holder, cvv);
    }

    public static Card cardNumberLowerBound() {
        Faker faker = new Faker(new Locale("en"));
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        String number = getApprovedCardNumber().substring(15);
        return new Card(number, month, year, holder, cvv);
    }

    public static Card cardLettersNumber() {
        Faker faker = new Faker(new Locale("en"));
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card("qwerty", month, year, holder, cvv);
    }

    public static Card cardLettersCyrillicNumber() {
        Faker faker = new Faker(new Locale("en"));
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card("нетология", month, year, holder, cvv);
    }

    public static Card cardSymbolsNumber() {
        Faker faker = new Faker(new Locale("en"));
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card("!@#$%^&", month, year, holder, cvv);
    }


    public static Card emptyMonth() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, "", year, holder, cvv);
    }

    public static Card lettersMonth() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, "qwerty", year, holder, cvv);
    }

    public static Card lettersCyrillicMonth() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, "нетология", year, holder, cvv);
    }

    public static Card lettersSymbolsMonth() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, "!@#$%^&*", year, holder, cvv);
    }

    public static Card upperBoundMonth() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, "13", year, holder, cvv);
    }

    public static Card lowerBoundMonth() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, "00", year, holder, cvv);
    }

    public static Card getMonthWrongFormat() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = faker.number().digits(1);
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card getMonthMoreFormat() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = faker.number().digits(3);
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card getPreviousMonth() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getExpiredMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }


    public static Card emptyYear() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, "", holder, cvv);
    }

    public static Card getPreviousYear() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getLowerExpiredYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card uppedBoundYear() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getUppedExpiredYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card getYearWrongFormat() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = faker.number().digits(1);
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card getSymbolsYear() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, "!@#$%^&", holder, cvv);
    }

    public static Card lettersCyrillicYear() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, "нетология", holder, cvv);
    }

    public static Card lettersYear() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, "qwerty", holder, cvv);
    }


    public static Card emptyHolder() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, " ", cvv);
    }

    public static Card numbersInHolder() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String holder = faker.number().digits(5);
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card lettersCyrillicInHolder() {
        Faker faker = new Faker(new Locale("ru"));
        String cardNumber = getApprovedCardNumber();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card getSymbolsHolder() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, "!@#$%^&", cvv);
    }

    public static Card getLowerCaseLettersInHolder() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String holder = faker.name().firstName().toLowerCase(Locale.ROOT) + " " + faker.name().lastName().toLowerCase(Locale.ROOT);
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card getOneHolder() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String holder = String.valueOf(faker.name().firstName().charAt(0));
        String cvv = faker.number().digits(3);
        return new Card(cardNumber, month, year, holder, cvv);
    }


    public static Card emptyCVV() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        return new Card(cardNumber, month, year, holder, "");
    }

    public static Card getLowerBondCVV() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        String cvv = faker.number().digits(2);
        return new Card(cardNumber, month, year, holder, cvv);
    }

    public static Card getLettersCVV() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        return new Card(cardNumber, month, year, holder, "qwerty");
    }

    public static Card getLettersCyrillicCVV() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        return new Card(cardNumber, month, year, holder, "нетология");
    }

    public static Card getSymbolsCVV() {
        Faker faker = new Faker(new Locale("en"));
        String cardNumber = getApprovedCardNumber();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear();
        return new Card(cardNumber, month, year, holder, "12))");
    }
}
