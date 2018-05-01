# OTM harjoitustyö - Tetris
## Dokumentointi
#### [Vaatimusmäärittely](https://github.com/idaliisa/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)
#### [Arkkitehtuuri](https://github.com/idaliisa/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)
#### [Käyttöohje](https://github.com/idaliisa/otm-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)
#### [Työaikakirjanpito](https://github.com/idaliisa/otm-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)
## Releaset
#### [Viikko 6](https://github.com/idaliisa/otm-harjoitustyo/releases)
## Komentorivitoiminnot
### Testaus
Testien suoritus komennolla 
```
mvn test
````
Testikattavuusraportin luominen komennolla
```
mvn jacoco:report
````
ja tarkastelu selaimella avaamalla tiedosto _target/site/jacoco/index.html_
### Checkstyle
Tiedostossa [checkstyle.xml](https://github.com/idaliisa/otm-harjoitustyo/blob/master/Tetris/checkstyle.xml) määriteltyjen tyylitarkastusten suorittaminen komennolla
```
 mvn jxr:jxr checkstyle:checkstyle
```
ja tarkastelu selaimella avaamalla tiedosto  _target/site/checkstyle.html_
### Jar-tiedoston generointi
Suoritettavan ohjelman luominen komennolla
```
mvn package
````
Ohjelma löytyy hakemistosta _target_ nimellä _Tetris-1.0-SNAPSHOT.jar_
### Javadoc
Javadocin luominen komennolla
```
mvn javadoc:javadoc
````
ja tarkastelu selaimella avaamalla tiedosto _target/site/apidocs/index.html_
