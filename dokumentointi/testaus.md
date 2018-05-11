# Testausdokumentti

Ohjelmaa on testattu automaattisilla yksikkö- ja integraatiotesteillä JUnitilla ja manuaalisilla järjestelmätason testeillä.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Integraatiotesti _TetrisServiceUserTest_ simuloi käyttöliittymän _TetrisService_-olion avulla suoritettavia toimintoja. Testi simuloi pysyväistallennusta DAO-rajapinnan toteuttavan _FakeUseDao_:n avulla.

Luokille _User_, _Piece_, _Game_, _TetrominoI_, _TetrominoJ_ jne. on tehty yksikkötestit. _GameTest_ testaa samalla  myös luokkia _Tetromino_ ja _Piece_.

### DAO
_UserDbDao_ testissä luodaan tilapäinen testaustiedosto _userTest.db_ suoritushakemistoon.

### Testauskattavuus

Käyttöliittymä poislukien sovelluksen rivikattavuus on 90 % ja haarautumiskattavuus 85 %. Testauksen ulkopuolelle jäi muun muassa joitain pelilogiikan haaroja (esim. rivien pudotus).

## Järjestelmätestaus

Järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on haettu [käyttöohjeen](https://github.com/idaliisa/otm-harjoitustyo/blob/master/dokumentointi/kayttoohje.md) mukaisesti ja testattu MacOS-ympäristössä. Testaus on suoritettu tilanteessa, jossa käyttäjiä ei vielä ole olemassa.

### Toiminnallisuudet

[Määrittelydokumentissa](https://github.com/idaliisa/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md) ja käyttöohjeessa mainitut toiminnallisuudet on käyty läpi. Ohjelma on yritetty saada kaatumaan syöttämällä virheellisiä ja tyhjiä arvoja. Nappeja on yritetty painaa eri skenaarioissa.

## Sovellukseen jääneet laatuongelmat
Testauksessa ja itse ohjelmassa käytetään suorituhakemistoon generoituvia tiedostoja, joita käyttäjä ei voi itse nimetä.

Käyttöliittymässä on seuraavat bugit:

- Ohjelman käynnistymisen jälkeen peli nopeutuu jokaisella kerralla kun aloitetaan uusi peli.
- Gameover ei näy käyttäjälle mitenkään. 
