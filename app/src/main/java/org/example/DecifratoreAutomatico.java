package org.example;

public class DecifratoreAutomatico {

    public void decifra(String message){
        msgIsValid(message);
        for(int i = 1; i <26 ; i++){
            CifrarioDiCesare cifrarioDiCesare = new CifrarioDiCesare(i);
            System.out.println("Chiave "+ i +" DecMsg: "+ cifrarioDiCesare.decifra(message));
        }
    }
    private void msgIsValid(String messaggio) {
        if (messaggio == null || messaggio.isEmpty())
            throw new NullPointerException("messaggio vuoto");
    }
}
