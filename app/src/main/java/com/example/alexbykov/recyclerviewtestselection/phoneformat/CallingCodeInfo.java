package com.example.alexbykov.recyclerviewtestselection.phoneformat;

import java.util.ArrayList;

/**
 * @author Alex Bykov
 *         Date: 14.12.2017.
 *         <p>
 *         You can contact me at me@alexbykov.ru
 */

public class CallingCodeInfo {

    public ArrayList<String> countries = new ArrayList<>();
    public String callingCode = "";
    public ArrayList<String> trunkPrefixes = new ArrayList<>();
    public ArrayList<String> intlPrefixes = new ArrayList<>();
    public ArrayList<RuleSet> ruleSets = new ArrayList<>();
    //public ArrayList formatStrings;

    String matchingAccessCode(String str) {
        for (String code : intlPrefixes) {
            if (str.startsWith(code)) {
                return code;
            }
        }
        return null;
    }

    String matchingTrunkCode(String str) {
        for (String code : trunkPrefixes) {
            if (str.startsWith(code)) {
                return code;
            }
        }

        return null;
    }

    String format(String orig) {
        String str = orig;
        String trunkPrefix = null;
        String intlPrefix = null;
        if (str.startsWith(callingCode)) {
            intlPrefix = callingCode;
            str = str.substring(intlPrefix.length());
        } else {
            String trunk = matchingTrunkCode(str);
            if (trunk != null) {
                trunkPrefix = trunk;
                str = str.substring(trunkPrefix.length());
            }
        }

        for (RuleSet set : ruleSets) {
            String phone = set.format(str, intlPrefix, trunkPrefix, true);
            if (phone != null) {
                return phone;
            }
        }

        for (RuleSet set : ruleSets) {
            String phone = set.format(str, intlPrefix, trunkPrefix, false);
            if (phone != null) {
                return phone;
            }
        }

        if (intlPrefix != null && str.length() != 0) {
            return String.format("%s %s", intlPrefix, str);
        }

        return orig;
    }

    boolean isValidPhoneNumber(String orig) {
        String str = orig;
        String trunkPrefix = null;
        String intlPrefix = null;
        if (str.startsWith(callingCode)) {
            intlPrefix = callingCode;
            str = str.substring(intlPrefix.length());
        } else {
            String trunk = matchingTrunkCode(str);
            if (trunk != null) {
                trunkPrefix = trunk;
                str = str.substring(trunkPrefix.length());
            }
        }

        for (RuleSet set : ruleSets) {
            boolean valid = set.isValid(str, intlPrefix, trunkPrefix, true);
            if (valid) {
                return true;
            }
        }

        for (RuleSet set : ruleSets) {
            boolean valid = set.isValid(str, intlPrefix, trunkPrefix, false);
            if (valid) {
                return true;
            }
        }

        return false;
    }
}
