package me.inao.cryptic;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new NewMain().start();
    }
}

class NewMain{
    private char[] alpha = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '.', '-', '_', ',' , 'ě', 'š', 'č', 'ř', 'ž', 'ý', 'á', 'í', 'é', 'ď',
    };
    void start(){
        Scanner sc = new Scanner(System.in);
        String mode;
        while(!(mode = sc.nextLine()).equalsIgnoreCase("exit")){
            if(mode.contains("enc")){
                System.out.println("Selected encrypt mode.. Message 1: Text to encrypt. Message 2: Rounds");
                new Encrypt(sc.nextLine(), alpha, new Random().nextInt(alpha.length), sc.nextInt()).getEncrypted();
            }if(mode.contains("dec")){
                System.out.println("Selected decrypt mode.. Message 1: Encrypted text. Message 2: Key");
                new Decrypt(sc.nextLine(), sc.nextLine(), alpha).decrypt();
            }
        }
    }
}