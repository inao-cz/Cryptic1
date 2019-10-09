package me.inao.cryptic;

import java.util.Base64;

class Encrypt {
    private String data;
    private char[] table;
    private int iniVector, rounds;
    Encrypt(String data, char[] table, int iniVector, int rounds){
        this.data = data;
        this.table = table;
        this.iniVector = iniVector;
        this.rounds = rounds;
    }
    void getEncrypted(){
        String encrypted = data;
        StringBuilder toSave = new StringBuilder();
        for(int a = 0; a < rounds; a++){
            if(a == 0) {
                for (String enc : data.split("(?!^)")) {
                    toSave.append(encs(enc));
                }
            }else{
                for(String enc : encrypted.split("(?!^)")){
                    toSave.append(encs(enc));
                }
            }
            encrypted = toSave.toString();
            toSave = new StringBuilder();
        }
        System.out.println(encrypted);
        createKey();
        System.out.println("----Checksums----");
        new Checksum().getChecksum(data, "Plain");
        new Checksum().getChecksum(encrypted, "Encrypted");
        System.out.println("----End checksums----");
    }
    private void createKey(){
        System.out.println(Base64.getEncoder().encodeToString((String.valueOf(table[0]) + table[iniVector] + ";" + rounds).getBytes()));
    }
    private String encs(String ch){
        if(ch.equals(" ")){
            return ch;
        }
        for(int i = 0; i < table.length; i++){
            if(String.valueOf(table[i]).equals(ch)){
                if((i+iniVector) >= table.length){
                    return String.valueOf(table[(i+iniVector) - table.length]);
                }else{
                    return String.valueOf((table[i+iniVector]));
                }
            }
        }
        return null;
    }
}
