# Gra w Statki (Java)

Jest to prosta implementacja klasycznej gry w statki napisana w języku Java. Dwóch graczy na zmianę rozmieszcza swoje statki na planszy i próbuje trafić w statki przeciwnika, zgadując ich lokalizacje.

## Spis Treści
- [Funkcje](#funkcje)
- [Zasady Gry](#zasady-gry)
- [Instrukcja Instalacji](#instrukcja-instalacji)
- [Jak Grać](#jak-grać)
- [Struktura Kodu](#struktura-kodu)
- [Autor](#autor)

## Funkcje
- Dwuosobowa gra turowa.
- Możliwość rozmieszczenia statków o różnych rozmiarach (2, 3, 4 pola).
- Strzelanie w planszę przeciwnika i informacja o trafieniach.
- Wizualizacja planszy z wykorzystaniem symboli:
  - `~` - Puste pole.
  - `S` - Statek.
  - `X` - Trafiony statek.
  - `O` - Pudło.
- Zwycięstwo ogłasza gracza, który pierwszy zatopi wszystkie statki przeciwnika.

## Zasady Gry
- Każdy gracz ma planszę o wymiarach 10x10.
- Gracze rozmieszczają swoje statki, wybierając współrzędne początkowe i orientację (poziomą lub pionową).
- Po rozmieszczeniu statków gracze na zmianę oddają strzały, próbując trafić statki przeciwnika.
- Gracz wygrywa, gdy zatopi wszystkie statki przeciwnika.

