package Islemler;

public class FirebaseBoolean {

    private static boolean LoginAddFonksiyonaGirisKontrol;
    private static boolean LoginAddIslemSonucKontrol;

    public static boolean getLoginAddFonksiyonaGirisKontrol(){
        return LoginAddFonksiyonaGirisKontrol;
    }

    public static void setLoginAddFonksiyonaGirisKontrol(boolean loginAddFonksiyonaGirisKontrol){
        LoginAddFonksiyonaGirisKontrol = loginAddFonksiyonaGirisKontrol;
    }

    public static boolean getLoginAddIslemSonucKontrol(){
        return LoginAddIslemSonucKontrol;
    }

    public static void setLoginAddIslemSonucKontrol(boolean loginAddIslemSonucKontrol){
        LoginAddIslemSonucKontrol =loginAddIslemSonucKontrol;
    }

    /*****************************************************/
    private static boolean MenuFonksiyonaGirisKontrol =true;
    private static boolean MenuIslemSonucKontrol;

    public static boolean getMenuFonksiyonaGirisKontrol(){
        return MenuFonksiyonaGirisKontrol;
    }
    public static void setMenuFonksiyonaGirisKontrol(boolean menuFonksiyonaGirisKontrol){
        MenuFonksiyonaGirisKontrol = menuFonksiyonaGirisKontrol;
    }

    public static boolean getMenuIslemSonucGirisKontrol(){
        return MenuIslemSonucKontrol;
    }

    public static void setMenuIslemSonucKontrol(boolean menuIslemSonucKontrol){
        MenuIslemSonucKontrol = menuIslemSonucKontrol;
    }

    /*****************************************************/


    private static boolean MasaFonksiyonaGirisKontrol;
    private static boolean MasaIslemSonucKontrol;

    public static boolean getMasaFonksiyonaGirisKontrol(){
        return MasaFonksiyonaGirisKontrol;
    }

    public static void setMasaFonksiyonaGirisKontrol(boolean masaFonksiyonaGirisKontrol){
        MasaFonksiyonaGirisKontrol = masaFonksiyonaGirisKontrol;
    }

    public static boolean getMasaIslemSonucKontrol(){
        return MasaIslemSonucKontrol;
    }

    public static void setMasaIslemSonucKontrol(boolean masaIslemSonucKontrol){
        MasaIslemSonucKontrol = masaIslemSonucKontrol;

    }

    /*****************************************************/


    private static boolean MuzikFonksiyonaGirisKontrol;
    private static boolean MuzikIslemSonucKontrol;
    public static boolean getMuzikFonksiyonaGirisKontrol(){
        return MenuFonksiyonaGirisKontrol;
    }

    public static void setMuzikFonksiyonaGirisKontrol(boolean muzikFonksiyonaGirisKontrol){
        MuzikFonksiyonaGirisKontrol = muzikFonksiyonaGirisKontrol;
    }

    public static boolean getMuzikIslemSonucKontrol(){
        return MuzikIslemSonucKontrol;
    }

    public static void setMuzikIslemSonucKontrol(boolean muzikIslemSonucKontrol){
        MuzikIslemSonucKontrol = muzikIslemSonucKontrol;
    }





}
