package schnorr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Key {
    private ArrayList<BigInteger> Entity;

    public Key() {
        this.Entity = new ArrayList();
    }

    public Key(BigInteger[] keys) {
        this.Entity = new ArrayList();

        for(int i = 0; i < keys.length; ++i) {
            this.Entity.add(keys[i]);
        }

    }

    public Key(String path) throws FileNotFoundException {
        this.readFromFile(path);
    }

    public BigInteger get(int idx) {
        if (idx >= this.Entity.size()) {
            throw new IllegalArgumentException("idx more then size");
        } else {
            return (BigInteger)this.Entity.get(idx);
        }
    }

    public void readFromFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(path));
        this.Entity = new ArrayList();

        while(scanner.hasNextBigInteger()) {
            this.Entity.add(scanner.nextBigInteger());
        }

        scanner.close();
    }

    public void writeToFile(String path) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File(path));
        Iterator var3 = this.Entity.iterator();

        while(var3.hasNext()) {
            BigInteger element = (BigInteger)var3.next();
            printWriter.println(element);
        }

        printWriter.close();
    }
}
