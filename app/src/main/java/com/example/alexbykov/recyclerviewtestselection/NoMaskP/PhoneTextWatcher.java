package com.example.alexbykov.recyclerviewtestselection.NoMaskP;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.widget.EditText;
/**
 * @author Alex Bykov
 *         Date: 17.12.2017.
 *         <p>
 *         You can contact me at me@alexbykov.ru
 */

public class PhoneTextWatcher extends PhoneNumberFormattingTextWatcher {


    private EditText editText;

    public PhoneTextWatcher(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        super.beforeTextChanged(s, start, count, after);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        super.onTextChanged(s, start, before, count);
    }

    @Override
    public synchronized void afterTextChanged(Editable editable) {
        checkPlus(editable);
        PhoneUtils.formatByCountry(editable, editText);
        super.afterTextChanged(editable);
    }

    private void checkPlus(Editable editable) {
        final String value = editable.toString();
        if (value.isEmpty()) {
            editable.insert(0, "+");
        }

        if (value.length() > 0) {
            if (editable.charAt(0) != '+') {
                editable.insert(0, "+");
            }
        }
    }

}
