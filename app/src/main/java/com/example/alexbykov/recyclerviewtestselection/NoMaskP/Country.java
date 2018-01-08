package com.example.alexbykov.recyclerviewtestselection.NoMaskP;

/**
 * @author Alex Bykov
 *         Date: 17.12.2017.
 *         <p>
 *         You can contact me at me@alexbykov.ru
 */

public class Country {


    private String code;
    private String name;
    private final int dialCode;

    public Country(String code, String name, int dialCode) {
        this.code = code;
        this.name = name;
        this.dialCode = dialCode;
    }

    public Country(int dialCode) {
        this.dialCode = dialCode;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getDialCode() {
        return dialCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return dialCode == country.dialCode;
    }

    @Override
    public int hashCode() {
        return dialCode;
    }
}
