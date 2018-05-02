# Arkkitehtuurikuvaus

## Rakenne
Ohjelma noudattaa kolmitasoista kerrosarkkitehtuuria, jossa pakkausrakenne on seuraava
- _tetris.ui_: käyttöliittymäluokka
- _tetris.domain_: kirjautumisen ja pelaamisen loogisesta toteutuksest vastaavat luokat
- _tetris.dao_: tietojen tallennuksesta vastaavat luokat

## Sovelluslogiikka
Luokat [TetrisService](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/domain/TetrisService.java) ja [GameBoard](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/domain/GameBoard.java) tarjoavat metodit käyttöliittymän toiminnoille. _TetrisServicen_ kautta hoidetaan järjestelmään kirjautuminen ja _GameBoard_ tarjoaa metodit Tetriksen pelaamiseen.

Luokka [User](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/domain/User.java) kuvaa käyttäjää ja muodostaa loogisen datamallin kirjautumisominaisuudelle. _TetrisService_ pääsee käyttäjiin käsiksi [UserDao](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/dao/UserDao.java)-rajapinnan toteuttavan luokan [UserFileDao](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/dao/UserFileDao.java) kautta. 

Luokat [Tetromino](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/domain/Tetromino.java) ja [Piece](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/domain/Piece.java) kuvaavat pelin kannalta oleellisia yksiköitä. _Tetromino_ on abstrakti luokka, josta on toteutettu perimällä seitsemän erimuotoista tetrominoa. _Tetrominot_ on toteutettu luokan _Piece_ avulla. _GameBoard_ pääsee suoraan käsiksi sekä _Tetromino_ että _Piece_ luokkaan.

Sovelluksen luokkakaavio, ilman käyttöliittymää, on seuraava:

<img src= "https://github.com/idaliisa/otm-harjoitustyo/blob/master/dokumentointi/kuvat/luokkakaavio.png" width="800">







## Päätoiminnallisuudet

#### Tetrominon liikuttaminen vasemmalle
<img src= "https://github.com/idaliisa/otm-harjoitustyo/blob/master/dokumentointi/kuvat/Sekvenssikaavio.png" width="800">
