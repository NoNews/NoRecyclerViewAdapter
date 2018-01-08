package com.example.alexbykov.recyclerviewtestselection.NoMaskP;

import android.text.Editable;
import android.text.InputFilter;
import android.util.Log;
import android.widget.EditText;

/**
 * @author Alex Bykov
 *         Date: 17.12.2017.
 *         <p>
 *         You can contact me at me@alexbykov.ru
 */

public class PhoneUtils {


    private static final String TAG = "PhoneUtils";
    private static final int DEFAULT_PHONE_LENGTH = 16;


    public static void formatByCountry(Editable editable, EditText editText) {

        setMaxLength(editText, DEFAULT_PHONE_LENGTH);
        Country country = Countries.getCountryByFirstSymbols(editable.toString());
        if (country!=null){
            Log.d(TAG, "formatByCountry: " + country.getName());
        }
    }

    private static void setMaxLength(EditText editText, int length) {
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(length)});
    }

}
