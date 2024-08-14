package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFIve;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnZero;
    Button btnStar;
    Button btnHashTag;
    Button btnCall;
    Button btnDelete;

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.buttonOne);
        btnTwo = findViewById(R.id.buttonTwo);
        btnThree = findViewById(R.id.buttonThree);
        btnFour = findViewById(R.id.buttonFour);
        btnFIve = findViewById(R.id.buttonFive);
        btnSix = findViewById(R.id.buttonSix);
        btnSeven = findViewById(R.id.buttonSeven);
        btnEight = findViewById(R.id.buttonEight);
        btnNine = findViewById(R.id.buttonNine);
        btnZero = findViewById(R.id.buttonZero);
        btnStar = findViewById(R.id.buttonStar);
        btnHashTag = findViewById(R.id.buttonHashTag);
        btnCall = findViewById(R.id.buttonCall);
        btnDelete = findViewById(R.id.buttonBackspace);

        input = findViewById(R.id.phoneText);

    }


    public void onButtonOne(View view){
        onButtonClick(btnOne, input, "1");
    }
    public void onButtonTwo(View view){
        onButtonClick(btnTwo, input, "2");
    }
    public void onButtonThree(View view){
        onButtonClick(btnThree, input, "3");
    }
    public void onButtonFour(View view){
        onButtonClick(btnFour, input, "4");
    }
    public void onButtonFive(View view){
        onButtonClick(btnFIve, input, "5");
    }
    public void onButtonSix(View view){
        onButtonClick(btnSix, input, "6");
    }
    public void onButtonSeven(View view){
        onButtonClick(btnSeven, input, "7");
    }
    public void onButtonEight(View view){
        onButtonClick(btnEight, input, "8");
    }
    public void onButtonNine(View view){
        onButtonClick(btnNine, input, "9");
    }
    public void onButtonZero(View view){
        onButtonClick(btnZero, input, "0");
    }
    public void onButtonStar(View view){
        onButtonClick(btnStar, input, "*");
    }
    public void onButtonHashTag(View view){
        onButtonClick(btnHashTag, input, "#");
    }

    public void onButtonCall(View view){
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        String hash = input.getText().toString();
//        if(hash.contains("#")) {
//            hash = hash.replace("#", "%23");
//        }
//        intent.setData(Uri.parse("tel:"+ hash));

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    0);
        }
        else
            makePhoneCall();
    }

    public void makePhoneCall(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        String hash = input.getText().toString();
        if(hash.length()<=3){
            Toast.makeText(this, "pleanse enter a valid number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(hash.contains("#")) {
            hash = hash.replace("#", "%23");
        }
        intent.setData(Uri.parse("tel:"+ hash));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            }
    }


    public void onDelete(View view){
        String phoneNum = input.getText().toString();
        phoneNum = phoneNum.substring(0,phoneNum.length()-1);
        input.setText(phoneNum);
    }

    public void onButtonClick(Button btn, EditText input, String number){
        String phoneNum = input.getText().toString();
        input.setText(phoneNum + number);
    }


}