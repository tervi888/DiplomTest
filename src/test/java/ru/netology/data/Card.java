package ru.netology.data;

import lombok.Value;

@Value
public class Card {
     String number;
     String month;
     String year;
     String holder;
     String cvv;
}

