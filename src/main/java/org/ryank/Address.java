package org.ryank;

import lombok.Data;

@Data
public class Address {

    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public static boolean isPostalCodeValid(String code) {
        if (code == null) return false;
        code = code.toUpperCase().replace(" ", "");
        if (code.length() != 6) return false;
        return Character.isLetter(code.charAt(0)) &&
                Character.isDigit(code.charAt(1)) &&
                Character.isLetter(code.charAt(2)) &&
                Character.isDigit(code.charAt(3)) &&
                Character.isLetter(code.charAt(4)) &&
                Character.isDigit(code.charAt(5));
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode) {

        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = Util.toTitleCase(street);
            this.city = Util.toTitleCase(city);
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }
}
