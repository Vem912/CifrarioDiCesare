package org.example;

import java.text.Normalizer;

/**
 * La cifratura ammette solo caratteri dell'insieme [a..z] unicode [97..122]
 * tutti gli altri verranno filtrati
 * la cifratura restituisce un messaggio con caratteri dell'insieme [A..Z] unicode [65..90]
 * può essere inserito qualsiasi valore di chiave, verrà poi ricalcolata in modulo 26
 */
public class CifrarioDiCesare {
    private final int key;

    public CifrarioDiCesare(int key) {
        this.key = checkKey(key);
    }
    
    public CifrarioDiCesare(String chiave) {
        int key = 0;
        try{
           key = Integer.parseInt(chiave);
        } catch(NumberFormatException e) {
            System.out.println("Inserisci un numero");
        }
        this(key);
    }

    public String cifra(String messaggio){
        msgIsValid(messaggio);
        String msg = normalizeMsg(messaggio);
        return elabora(msg, this.key, 97, 65);
    }

    public String decifra(String messaggio){
        msgIsValid(messaggio);
        return elabora(messaggio, -this.key, 65, 97);
    }

    private String elabora(String messaggio, int key, int baseP, int baseA) {
            StringBuilder risultato = new StringBuilder();
            for (char c : messaggio.toCharArray()) {
                int digit = (c -baseP +key +26) %26 +baseA;
                risultato.append(Character.toChars(digit));
            }
            return risultato.toString();
    }

    public String normalizeMsg(String input) {
        String Normalized = Normalizer.normalize(input, Normalizer.Form.NFD)
                .replace(" ","")
                .toLowerCase();
        StringBuilder msg = new StringBuilder();
        for (char c : Normalized.toCharArray()) {
            if (c >= 'a' && c <= 'z' ) {
                msg.append(c);
            }
        }
        return msg.toString();
    }

    private int checkKey(int chiave) {
        if (chiave == 0) System.out.println("Chiave non valida");
        return Math.abs(chiave) % 26;
    }

    private void msgIsValid(String messaggio) {
        if (messaggio == null || messaggio.isEmpty()) {
            System.out.println("Error: inserire messaggio");
        }
    }
}
