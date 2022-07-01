package com.example.call;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber=findViewById(R.id.phoneNumberEditText);
    }

    public void inputNumber(View view) {
        Button btn = (Button) view;
        String digit = btn.getText().toString();
        String phNum = phoneNumber.getText().toString();
        phoneNumber.setText(phNum+digit);
    }

    public void clearEvent(View view) {
        phoneNumber.getText().clear();
    }

    public void saveEvent(View view) {
        String phNum = phoneNumber.getText().toString();
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE,phNum);
        startActivity(intent);
    }

    public void callEvent(View view) {
        String phNum = phoneNumber.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("the telephone no is:"+phNum));
        startActivity(intent);

    }
}
