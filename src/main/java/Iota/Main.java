package Iota;

import Iota.error.InvalidAddressException;
import Iota.error.InvalidSecurityLevelException;
import Iota.pow.ICurl;
import Iota.pow.SpongeFactory;
import Iota.utils.IotaAPIUtils;

public class Main {
    public static void main(String[] args){
        IotaAPIUtils iota = new IotaAPIUtils();
        String address = "";
        ICurl curl = SpongeFactory.create(SpongeFactory.Mode.CURLP27);
        // Seed should be of 81 chars with A-Z and number 9. Such data type is considered as a trits.
        // This should be random.
        String seed = "YYQQQGOMDRHGXVHOQLCSWEBGRKASNK9TM9CCIEQEXBZCRKFVIBI9JJUEGNTTRS9FCCWZXURCOXZSOZKYF";
        try {
            // Takes a trit seed
            // Security can be 1,2,3
            // Index starts from 0. index is added to seed to get private key
            // Checksum is additional 9 trits added to address of length 81 to give an address of length 90.
            address = iota.newAddress(seed, 1, 0 ,true, curl);
        } catch (InvalidAddressException e) {
            e.printStackTrace();
        } catch (InvalidSecurityLevelException e) {
            e.printStackTrace();
        }
        System.out.println(address);
    }
}
