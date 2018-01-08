package com.example.alexbykov.recyclerviewtestselection;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * @author Alex Bykov
 *         Date: 14.12.2017.
 *         <p>
 *         You can contact me at me@alexbykov.ru
 */

public class NoPhoneFormattedEditText extends LinearLayout {

    private EditText etCode;
    private EditText etPhone;

    private static final String ENABLED_SYMBOLS = "+0123456789";
    private static final int MAX_CODE_LENGTH = 4;

    public NoPhoneFormattedEditText(Context context) {
        super(context);
        init();
    }

    public NoPhoneFormattedEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NoPhoneFormattedEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NoPhoneFormattedEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    private void init() {
        setupCodeEditText();
        setupPhoneEditText();
        addView(etCode);
        addView(etPhone);
    }

    private void setupPhoneEditText() {
        etPhone = new EditText(getContext());
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        etPhone.setLayoutParams(params);
        etPhone.setKeyListener(DigitsKeyListener.getInstance(ENABLED_SYMBOLS));
        etPhone.setInputType(InputType.TYPE_CLASS_PHONE);

        etPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher() {
            @Override
            public synchronized void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    etCode.requestFocus();
                }
                super.afterTextChanged(s);
            }
        });
    }

    private void setupCodeEditText() {
        etCode = new EditText(getContext());
        LayoutParams params = new LayoutParams(120, ViewGroup.LayoutParams.WRAP_CONTENT);
        etCode.setKeyListener(DigitsKeyListener.getInstance(ENABLED_SYMBOLS));
        etCode.setLayoutParams(params);
        etCode.setInputType(InputType.TYPE_CLASS_PHONE | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        int maxLength = 4;
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        etCode.setFilters(fArray);

        etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() != 0 && s.toString().charAt(0) != '+') {
                    etCode.setText(String.format("+%s", etCode.getText()));
                    etCode.setSelection(etCode.getText().length());
                }

                if (s.length() == MAX_CODE_LENGTH) {
                    etPhone.requestFocus();
                }
            }
        });

    }
}
