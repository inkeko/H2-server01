package org.example;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;


//. Ezt futtatva a program generál egy biztonságos,
// base64-kódolt titkos kulcsot, amit aztán kimásolhatsz, és beilleszthetsz az application.properties
// fájlba (vagy a megfelelő konfigurációs forrásba) az éles környezethez.
public class KeyGenerator {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String base64Key = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("Generated Key: " + base64Key);
    }
}

