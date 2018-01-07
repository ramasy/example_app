package com.example.asus.testapp.Controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.asus.testapp.Model.User;
import com.example.asus.testapp.R;

public class MainActivity extends AppCompatActivity {
    private TextView mMessage;
    private EditText mNom;
    private Button mBouton;
    private User appUser;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessage = (TextView) findViewById(R.id.activity_main_message);
        mNom = (EditText) findViewById(R.id.activity_main_edit_name);
        mBouton = (Button) findViewById(R.id.activity_button_save);
        mMessage = (TextView) findViewById(R.id.activity_main_message);
        mNom = (EditText) findViewById(R.id.activity_main_edit_name);
        mBouton = (Button) findViewById(R.id.activity_button_save);
        appUser = new User();
        mBouton.setEnabled(false);
        mNom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence str, int i, int i1, int i2) {
                mBouton.setEnabled(str.toString().length() >= 1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appUser.setFirstName(mNom.getText().toString());
                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
                startActivityForResult(gameActivity, GAME_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GAME_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            double resultScore = (double) data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE,0);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("info")
                    .setMessage(appUser.getFirstName() + " Votre score est de : " + (int)(20 * (resultScore/4)) + "/20")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create()
                    .show();
        }
    }
}
