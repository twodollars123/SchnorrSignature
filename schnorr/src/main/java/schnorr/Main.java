package schnorr;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    static String pathSign = "D:\\Spacework\\java\\antoanbaomat_schnorr_signature\\schnorr\\schnorr\\src\\main\\java\\schnorr\\Sign.txt";
    static String pathPublicKey = "D:\\Spacework\\java\\antoanbaomat_schnorr_signature\\schnorr\\schnorr\\src\\main\\java\\schnorr\\PublicKey.txt";
    static String pathPrivateKey = "D:\\Spacework\\java\\antoanbaomat_schnorr_signature\\schnorr\\schnorr\\src\\main\\java\\schnorr\\PrivateKey.txt";

    public Main() {
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("1 <bits in q> - generate keys");
        System.out.println("2 <file path> - make sign");
        System.out.println("3 <file path> - check sign");

        int type;
        do {
            type= s.nextInt();
            if (type == 1) {
//                int blq = s.nextInt();
                int blq = 8;
                Signature.generate(blq, pathPublicKey, pathPrivateKey);
            }

            String pathFile = "D:\\Spacework\\java\\antoanbaomat_schnorr_signature\\schnorr\\schnorr\\src\\main\\java\\schnorr\\BanRo.txt";
            if (type == 2) {
//                pathFile = s.next();
                Signature.makeSign(pathFile, pathPublicKey, pathPrivateKey, pathSign);
            }
            String pathFileCheck = "D:\\Spacework\\java\\antoanbaomat_schnorr_signature\\schnorr\\schnorr\\src\\main\\java\\schnorr\\check.txt";
            if (type == 3) {
//                pathFile = s.next();
                Signature.checkSign(pathFileCheck, pathPublicKey, pathSign);
            }
        } while(type < 4);

    }
}
