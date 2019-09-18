package me.ashaneediri.fbretrieve.util;

import java.util.Base64;

/**
 * Util class used for general conversions.
 *
 */
class EncodingUtility {

    /**
     * Converts given string to a base64 encoded string
     *
     * @param val value string need to be encoded
     * @return String
     */
    static String getBase64EncodedString(String val) {
        return Base64.getEncoder().encodeToString(val.getBytes());
    }
}
