package com.example.loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextEmail;
    private EditText mEditTextPhone;
    private CheckBox mCheckBoxAcceptTerms;
    private Button mButtonSubmit;
    private TextView mTextViewDisplayInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mEditTextEmail = findViewById(R.id.edit_text_email);
        mEditTextPhone = findViewById(R.id.edit_text_phone);
        mCheckBoxAcceptTerms = findViewById(R.id.checkbox_accept_terms);
        mButtonSubmit = findViewById(R.id.button_submit);
        mTextViewDisplayInfo = findViewById(R.id.text_view_display_info);
    }

    private boolean validateEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public void displayValidatedInfo(View view) {
        String emailAddress = mEditTextEmail.getText().toString();
        String phoneNumber = mEditTextPhone.getText().toString();
        boolean termsAccepted = mCheckBoxAcceptTerms.isChecked();

        if (!validateEmail(emailAddress)) {
            mEditTextEmail.setError("Invalid email!");
        }

        if (phoneNumber.isEmpty()) {
            mEditTextPhone.setError("Required!");
        }

        if (!termsAccepted) {
            mCheckBoxAcceptTerms.setError("Please accept terms!");
        } else {
            mCheckBoxAcceptTerms.setError(null);
        }

        if (validateEmail(emailAddress) && !phoneNumber.isEmpty() && termsAccepted) {
            String infoText = "Email: " + emailAddress + "\n" + "Phone number: " + phoneNumber;
            mTextViewDisplayInfo.setText(infoText);
        } else {
            mTextViewDisplayInfo.setText("");
        }

    }
}
