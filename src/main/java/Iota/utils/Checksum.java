package Iota.utils;

import Iota.error.InvalidAddressException;
import Iota.pow.ICurl;
import Iota.pow.JCurl;
import Iota.pow.SpongeFactory;

//This class defines utility methods to add/remove the checksum to/from an address.

public class Checksum {

    /**
     * Adds the checksum to the specified address.
     *
     * @param address The address without checksum.
     * @return The address with the appended checksum.
     * @throws InvalidAddressException is thrown when the specified address is not an valid address.
     **/
    public static String addChecksum(String address) throws InvalidAddressException {
        String addressWithChecksum = address;
        addressWithChecksum += calculateChecksum(address);
        return addressWithChecksum;
    }

    private static String calculateChecksum(String address) {
        ICurl curl = SpongeFactory.create(SpongeFactory.Mode.CURLP27);
        curl.reset();
        curl.absorb(Converter.trits(address));
        int[] checksumTrits = new int[JCurl.HASH_LENGTH];
        curl.squeeze(checksumTrits);
        String checksum = Converter.trytes(checksumTrits);
        String checksumPrt = checksum.substring(0, 9);
        return checksumPrt;
    }
}
