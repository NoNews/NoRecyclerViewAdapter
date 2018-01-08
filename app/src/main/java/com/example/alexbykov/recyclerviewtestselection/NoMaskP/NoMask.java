package com.example.alexbykov.recyclerviewtestselection.NoMaskP;

import android.content.Context;
import android.widget.EditText;

/**
 * @author Alex Bykov
 *         Date: 17.12.2017.
 *         <p>
 *         You can contact me at me@alexbykov.ru
 */

public class NoMask {

    private Context context;
    private EditText editText;

    private NoMask(Context context) {
        this.context = context;
    }

    public static NoMask with(Context context) {
        return new NoMask(context);
    }

    public NoMask formatPhone(EditText editText) {
        this.editText = editText;
        return this;
    }

    public void build() {
        editText.addTextChangedListener(new PhoneTextWatcher(editText));
    }


}
