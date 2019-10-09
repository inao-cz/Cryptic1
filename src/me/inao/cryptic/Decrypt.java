package me.inao.cryptic;

import java.util.Base64;

class Decrypt {
    private String data, key;
    private char[] map;
    private int vec;
    Decrypt(String data, String key, char[] map){
        this.data = data;
        this.key = new String(Base64.getDecoder().decode(key));
        this.map = map;
        vec = getVector();
    }
    private int getVector(){
        String[] keys = key.split("(?!^)");
        for(int i = 0; i < map.length; i++){
            if(String.valueOf(map[i]).equals(keys[1])){
                return i;
            }
        }
        return 0;
    }
    void decrypt(){
        int rounds = Integer.decode(key.split(";")[1]);
        String dec = data;
        StringBuilder toSave = new StringBuilder();
        for(int a = 0; a < rounds; a++){
            if(a == 0) {
                for (String enc : dec.split("(?!^)")) {
                    toSave.append(decr(enc));
                }
            }else{
                for(String enc : dec.split("(?!^)")){
                    toSave.append(decr(enc));
                }
            }
            dec = toSave.toString();
            toSave = new StringBuilder();
        }
        System.out.println(dec);
    }
    private String decr(String ch){
        if(ch.equals(" ")){
            return ch;
        }
        for(int i = 0; i < map.length; i++){
            if(String.valueOf(map[i]).equals(ch)){
                if((i-vec) < 0){
                    return String.valueOf(map[(i-vec) + map.length]);
                }else{
                    return String.valueOf((map[i-vec]));
                }
            }
        }
        return null;
    }
}
