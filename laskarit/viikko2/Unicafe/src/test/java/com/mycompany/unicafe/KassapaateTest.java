
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti maksukortti10;
    Maksukortti maksukortti1000;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        maksukortti10 = new Maksukortti(10);
        maksukortti1000 = new Maksukortti(1000);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void kassanRahamaaraAlussaOikein() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void myytyjenEdullistenLounaidenMaaraAlussaOikein() {
        kassapaate.syoMaukkaasti(500);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myytyjenMaukkaidenLounaidenMaaraAlussaOikein() {
        kassapaate.syoEdullisesti(300);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassaKasvaaEdullisenHinnallaKunMaksuRiittava() {
        kassapaate.syoEdullisesti(300);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void edullisenLounaanVaihtorahaOikeaKunMaksuRiittava() {
        assertEquals(60, kassapaate.syoEdullisesti(300));
    }
    
    @Test
    public void kassaKasvaaMaukkaanHinnallaKunMaksuRiittava() {
        kassapaate.syoMaukkaasti(500);
        assertEquals(100400, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void maukkaanLounaanVaihtorahaOikeaKunMaksuRiittava() {
        assertEquals(100, kassapaate.syoMaukkaasti(500));
    }
    
    @Test
    public void edullistenLounaidenMaaraOikeaKunMaksuRiittava() {
        kassapaate.syoEdullisesti(300);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());    
    }
    
    @Test
    public void maukkaidenLounaidenMaaraOikeaKunMaksuRiittava() {
        kassapaate.syoMaukkaasti(500);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());    
    }
    
    @Test
    public void edullisenLounaanMaksuEiRiittavaJotenKassanRahamaaraEiMuutu() {
        kassapaate.syoEdullisesti(100);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void maukkaanLounaanMaksuEiRiittavaJotenKassanRahamaaraEiMuutu() {
        kassapaate.syoMaukkaasti(100);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void edullisenLounaanMaksuEiRiittavaJotenMaksuPalautetaan() {
        assertEquals(100, kassapaate.syoEdullisesti(100));
    }
    
    @Test
    public void maukkaanLounaanMaksuEiRiittavaJotenMaksuPalautetaan() {
        assertEquals(100, kassapaate.syoMaukkaasti(100));
    }
    
    @Test
    public void edullisenLounaanMaksuEiRiittavaJotenMyytyjenEdullistenLounaidenMaaraEiMuutu() {
        kassapaate.syoEdullisesti(100);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaanLounaanMaksuEiRiittavaJotenMyytyjenMaukkaidenLounaidenMaaraEiMuutu() {
        kassapaate.syoMaukkaasti(100);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortiltaVeloitetaanEdullisenLounaanHintaOikeinKunRahaRiittaa() {
        kassapaate.syoEdullisesti(maksukortti1000);
        assertEquals(760, maksukortti1000.saldo());
    }
    
    @Test
    public void kortiltaVeloitetaanMaukkaanLounaanHintaOikeinKunRahaRiittaa() {
        kassapaate.syoMaukkaasti(maksukortti1000);
        assertEquals(600, maksukortti1000.saldo());
    }
    
    @Test
    public void edullisenLounaanOstossaPalautetaanTrueKunRahaKortillaRiittaa() {
        assertEquals(true,kassapaate.syoEdullisesti(maksukortti1000));
    }
    
    @Test
    public void maukkaanLounaanOstossaPalautetaanTrueKunRahaKortillaRiittaa() {
        assertEquals(true,kassapaate.syoMaukkaasti(maksukortti1000));
    }
    
    @Test
    public void edullistenLounaidenMaaraKasvaaOikeinKunRahaKortillaRiittava() {
        kassapaate.syoEdullisesti(maksukortti1000);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaidenLounaidenMaaraKasvaaOikeinKunRahaKortillaRiittava() {
        kassapaate.syoMaukkaasti(maksukortti1000);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    

    @Test
    public void edullisenLounaanHintaaEiVeloitetaKortiltaKunRahaKortillaEiRiitta() {
        kassapaate.syoEdullisesti(maksukortti10);
        assertEquals(10, maksukortti10.saldo());
    }
    
    @Test
    public void maukkaanLounaanHintaaEiVeloitetaKortiltaKunRahaKortillaEiRiitta() {
        kassapaate.syoMaukkaasti(maksukortti10);
        assertEquals(10, maksukortti10.saldo());
    }
    
    @Test
    public void edullisenLounaanOstossaPalautetaanFalseKunRahaKortillaEiRiita() {
        assertEquals(false, kassapaate.syoEdullisesti(maksukortti10));
    }
    
    @Test
    public void maukkaanLounaanOstossaPalautetaanFalseKunRahaKortillaEiRiita() {
        assertEquals(false,kassapaate.syoMaukkaasti(maksukortti10));
    }
    
    @Test
    public void myytyjenEdullistenLounaidenMaaraEiKasvaKunRahaKortillaEiRiita() {
        kassapaate.syoEdullisesti(maksukortti10);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myytyjenMaukkaidenLounaidenMaaraEiKasvaKunRahaKortillaEiRiita() {
        kassapaate.syoMaukkaasti(maksukortti10);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassanRahamaaraEiMuutuKunOstetaanEdullinenLounasKortilla() {
        kassapaate.syoEdullisesti(maksukortti1000);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kassanRahamaaraEiMuutuKunOstetaanMaukasLounasKortilla() {
        kassapaate.syoMaukkaasti(maksukortti1000);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kortinSaldoKasvaaKunSilleLadataanRahaaEiNegatiivinenSumma() {
        kassapaate.lataaRahaaKortille(maksukortti10, 230);
        assertEquals(240, maksukortti10.saldo());
    }
    
    @Test
    public void kassaKasvaaKortilleLadatullaSummallaKunSummaOnEiNegatiivinen() {
        kassapaate.lataaRahaaKortille(maksukortti10, 230);
        assertEquals(100230, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void ladatessaRahaaKortillePalautetaanTrueKunLadattavaSummaOnEiNegatiivinen() {
        assertEquals(true, kassapaate.lataaRahaaKortille(maksukortti10, 230));
    }
    
    @Test
    public void kortinSaldoEiMuutuKunSilleYritetaanLadataNegatiivinenArvo() {
        kassapaate.lataaRahaaKortille(maksukortti10, -10);
        assertEquals(10, maksukortti10.saldo());
    }
    
    @Test
    public void kassaEiMuutuKunKortilleYritetaanLadataNegatiivinenArvo() {
        kassapaate.lataaRahaaKortille(maksukortti10, -10);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void ladatessaRahaaKortillePalautetaanFalseKunLadattavaSummaOnNegatiivinen() {
        assertEquals(false, kassapaate.lataaRahaaKortille(maksukortti10, -10));
    }
    
            
            
}
