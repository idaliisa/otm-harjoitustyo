# Arkkitehtuurikuvaus

## Rakenne
Ohjelman pakkausrakenne on seuraava:
<img src= "">
- _tetris.ui_: vastaa käyttöliittymästä
 -_tetris.ui.contoller: FXML:n toteutus
- _tetris.logics_: vastaa sovelluslogiikasta
 -_tetris.logics.game_: erityisesti pelin toteutus
 -_tetris.logics.user: erityisesti käyttäjän toteutus
- _tetris.dao_: vastaa tietojen tallennuksesta

## Käyttöliittymä
Käyttöliittymässä on kaksi näkymää

- kirjautuminen ja uuden käyttäjän luominen
- itse peli

joista kumpikin on toteutettu oman Scene-olion avulla. Näkymät on luotu asettamalla Scene vuorollaan Stage-olioon. Käyttöliittymä on rakennettu [tetris.ui.TetrisUi]()-luokassa ja rajapinnan [tetris.ui.controller.FXMLController]() toteuttavissa luokissa. Ulkoasu on määritelty [FXML]()-formaatissa.

Käyttöliittymä on pyritty eriytettämään sovelluslogiikasta siten, että käyttöliittymä käyttää ainoastaan sovelluslogiikan kokoavan [TetrisService]()-luokan metodeja ja välillisesti myös [Game]()-luokan metodeja.

Pelinäkymä päivittyy AnimationTimer-olion kutsuessa _getAllPiecesOnBoard()_-metodia.


## Sovelluslogiikka

Luokat [TetrisService](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/domain/TetrisService.java) ja [Game](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/domain/GameBoard.java) tarjoavat metodit käyttöliittymän toiminnoille. _TetrisServicen_ kautta hoidetaan järjestelmään kirjautuminen ja _Game_ tarjoaa metodit Tetriksen pelaamiseen.

Luokka [User](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/domain/User.java) kuvaa käyttäjää ja muodostaa loogisen datamallin kirjautumisominaisuudelle. _TetrisService_ pääsee käyttäjiin käsiksi [UserDao](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/dao/UserDao.java)-rajapinnan toteuttavan luokan [UserDbDao](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/dao/UserFileDao.java) kautta. Käyttäjätietoja käsitellään tietokannassa, joten _UserDbDao_ käyttää [Database]()-oliota.

Luokat [Tetromino](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/domain/Tetromino.java) ja [Piece](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/src/main/java/tetris/domain/Piece.java) kuvaavat pelin kannalta oleellisia yksiköitä. _Tetromino_ on abstrakti luokka, josta on toteutettu perimällä seitsemän erimuotoista tetrominoa. _Tetrominot_ on toteutettu luokan _Piece_ avulla. _Game_ pääsee suoraan käsiksi sekä _Tetromino_ että _Piece_ luokkaan.

Sovelluksen luokkakaavio, ilman käyttöliittymää, on seuraava:

<img src= "https://github.com/idaliisa/otm-harjoitustyo/blob/master/dokumentointi/kuvat/luokkakaavio.png" width="800">

## Tietojen pysyväistallennus

Pakkauksen _tetris.dao_ luokka _UserDbDao_ hoitaa käyttäjätietojen tallentamisen tietokantaan. Luokka noudattaa DAO-suunnittelumallia, jolloin se on helppo korvata uudella toteutuksella. Tämä helpottaa esimerkiksi testausta. _UserDao_ on eristetty rajapinnan taakse, eikä ole suoraan sovelluslogiikan käytössä.

### Tietokanta
Sovellus tallettaa käyttäjätiedot _users.db_-nimiseen SqLite-tietokantaan. Tietokanta generoidaan ohjelman suorituskansioon. Tietokannassa on _User_-tietokantataulu, joka sisältää kaksi saraketta: _id_ ja _username_.

## Päätoiminnallisuudet

Seuraavaksi muutaman toiminnallisuuden kuvaus.

#### käyttäjän kirjautuminen
Kirjautumisnäkymässä käyttäjä kirjoittaa syötekenttään nimen ja painaa _Login_. Tällöin tapahtumankäsittelijä kutsuu käyttöliittymän _LoginAndNewUserController_-olion _handleLogin_-metodin sisältä sovelluslogiikan _TetrisService_-olion metodia _login_, jonka parametrina on kirjoitettu käyttäjätunnus. Jos _TetrisService_:lle parametrina annettun _UserDbDao-olion_ _findByUsername_-metodi löytää tietokannasta kyseisisen käyttäjätunnuksen, silloin _LoginAndNewUserController_-olio asettaa näkymäksi peli-/pelinaloitusnäkymän. 

Seuraavaksi eräs sekvenssikaavio, jolla kuvataan sovelluksen toimintalogiikkaa:

Tetrominon liikuttaminen vasemmalle kun tetromino ei törmää reunaan tai palikkaan ja voi liikkua vapaasti vasemmalle:
<img src= "https://github.com/idaliisa/otm-harjoitustyo/blob/master/dokumentointi/kuvat/Sekvenssikaavio.png" width="800">

## Ohjelman heikkoudet

### Dao
Tietokanta-tiedosto on kovakoodattu koodiin. Sen voisi määrittää konfiguraatiotiedostossa.

### Sovelluslogiikka
_TetrisService_-luokassa voisi toteuttaa kaikki ne metodit, joita käyttöliittymä tarvitsee. Nyt käyttöliittymä joutuu käyttämään _TetrisService_:n oliomuuuttujana määritellyn _Game_-olion metodeita.

_Game_-luokan moveTetromino-metodien toimivuus törmäystilanteissa on toteutettu toisilleen vastakkaisten liikkeiden avulla. Tämä kannattaisi korjata muuttamalla _Tetromino_-luokan hit-metodeita.

_Piece_ luokan metodit _hit(Piece piece)_ ja _equals(Object object)_ ovat toiminnalisuudeltaan lähes samat, joten ensimmäisen voisi korvata jälkimmäisellä.


