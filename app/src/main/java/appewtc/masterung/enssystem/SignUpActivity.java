package appewtc.masterung.enssystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SignUpActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText, nameEditText, surnameEditText,
            phoneEditText, emailEditText;
    private RadioGroup sexRadioGroup;
    private String userString, passwordString, nameString, surnameString,
            phoneString, emailString, sexString;
    private boolean statusABoolean = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widget
        bindWidget();

        //RadioGroup Controller
        ragController();

    }   // Main Method

    private void ragController() {

        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkID) {

                statusABoolean = false;

                switch (checkID) {
                    case R.id.radioButton:
                        sexString = getResources().getString(R.string.male);
                        break;
                    case R.id.radioButton2:
                        sexString = getResources().getString(R.string.female);
                        break;
                }   // switch

            }   // event
        });

    }   // ragController

    private void bindWidget() {

        userEditText = (EditText) findViewById(R.id.editText3);
        passwordEditText = (EditText) findViewById(R.id.editText4);
        nameEditText = (EditText) findViewById(R.id.editText5);
        surnameEditText = (EditText) findViewById(R.id.editText6);
        phoneEditText = (EditText) findViewById(R.id.editText8);
        emailEditText = (EditText) findViewById(R.id.editText9);
        sexRadioGroup = (RadioGroup) findViewById(R.id.ragSex);


    }   // bindWidget

    public void clickSignUpSave(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        nameString = nameEditText.getText().toString().trim();
        surnameString = surnameEditText.getText().toString().trim();
        phoneString = phoneEditText.getText().toString().trim();
        emailString = emailEditText.getText().toString().trim();

        if (checkSpace() || statusABoolean) {
            //Have Space
            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.MyDialog(SignUpActivity.this,
                    R.drawable.icon_question, "กรอกข้อมูลไม่ครบ",
                    "กรุณากรอกข้อมูล และ เลือกข้อมูล ให้ครบ คะ");


        } else {
            //No Space
            confirmSignUp();

        }   // if


    }   // clickSignUpSave

    private void confirmSignUp() {

        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.logo48);
        objBuilder.setTitle("โปรดตรวจข้อมูล");
        objBuilder.setMessage("User = " + userString + "\n" +
                "Password = " + passwordString + "\n" +
                "ชื่อ = " + nameString + "\n" +
                "นามสกุล = " + surnameString + "\n" +
                "เพศ = " + sexString + "\n" +
                "เบอร์โทร = " + phoneString + "\n" +
                "Email = " + emailString);
        objBuilder.setCancelable(false);
        objBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                updateValueToMySQL();
            }
        });
        objBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });



        objBuilder.show();
    }   // confirmSignUp

    private void updateValueToMySQL() {



    }   // updateValueToMySQL

    private boolean checkSpace() {
        return userString.equals("") ||
                passwordString.equals("") ||
                nameString.equals("") ||
                surnameString.equals("") ||
                phoneString.equals("") ||
                emailString.equals("");
    }

}   // Main Class
