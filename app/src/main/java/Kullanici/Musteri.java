package Kullanici;

public class Musteri extends Kullanici2 {
    private static Musteri musteri;

    public static Kullanici2 getObjeck() {
        //  olurda sayfalar arası geçiş olursa kullanıcı sınıfı tek olsun uğraşmayalım diye yapıldı.
        if (musteri == null)
            musteri = new Musteri();
        return musteri;
    }
}
