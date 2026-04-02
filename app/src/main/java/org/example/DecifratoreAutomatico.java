package org.example;

public class DecifratoreAutomatico {
    public int decifra(String message){
        for(int i = 1; i <26 ; i++){
            CifrarioDiCesare cifrarioDiCesare1 = new CifrarioDiCesare(i);
            System.out.println(i +" "+ cifrarioDiCesare1.decifra(message));
        }
        return 1;
    }
}
