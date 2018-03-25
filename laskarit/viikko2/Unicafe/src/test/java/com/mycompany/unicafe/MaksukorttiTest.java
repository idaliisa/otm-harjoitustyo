package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(2000);
        assertEquals("saldo: 20.10", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikeinJosRahaaRiittavasti() {
        kortti.otaRahaa(8);
        assertEquals("saldo: 0.02", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiRiittavasti() {
        kortti.otaRahaa(12);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void palauttaaTrueJosRahaRiittaa() {
        assertEquals(true, kortti.otaRahaa(2));
    }
    
    @Test
    public void palauttaaFalseJosRahaEiRiita() {
        assertEquals(false, kortti.otaRahaa(12));
    }
    
    @Test
    public void saldoOikein() {
        assertEquals(10, kortti.saldo());
    }

}
