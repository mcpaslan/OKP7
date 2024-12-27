package com.example.okp;

public class hataKontrol {
    public void kontrol(String kullanici_adi, String sifre) throws AlfabetikException, NumerikException {
        for (char c : kullanici_adi.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                throw new AlfabetikException("Kullanıcı adı yalnızca alfabetik karakterlerden oluşmalıdır.");
            }
        }
        for (char c :sifre.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new NumerikException("Şifre yalnızca sayısal karakterlerden oluşmalıdır.");
            }
        }
    }
}
