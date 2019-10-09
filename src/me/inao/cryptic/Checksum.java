package me.inao.cryptic;

import java.math.BigInteger;
import java.security.MessageDigest;

class Checksum {
    void getChecksum(String data, String type){
        try{
            MessageDigest digst = MessageDigest.getInstance("SHA-512");
            byte[] Digest = digst.digest(data.getBytes());
            BigInteger intgr = new BigInteger(1, Digest);
            String checksum = intgr.toString(32);
            System.out.println("Checksum (" + type + "): " + checksum);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
