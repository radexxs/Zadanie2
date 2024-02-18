@addToCart

Feature: Wybranie telefonu z listy ofert na stronie T-Mobile


  Scenario: Klient wybiera telefon bez abonamentu z listy ofert

    Given Uzytkownik powinien zobaczyc strone glowna TMobile
    When Uzytkownik wybiera urządzenia z menu
    Then Widoczna jest rozlijalna lista

    When Uzytkownik wybiera sekcje Urzadzenia i wybiera te bez abonamentu
    Then Powinna zostac wyswietlona lista smartfonow

    When Klikam w pierwszy element z listy smartfonow
    Then Powinna zostac wyswietlona strona produktu

    When Dodaje produkt do koszyka
    Then Strona Twoj koszyk zostaje wyswietlona z odpowiednimi kwotami

    When Uzytkownik wraca na strone głown TMobile
    Then Widoczna jest ikonka koszyka z liczba produktow w koszyku