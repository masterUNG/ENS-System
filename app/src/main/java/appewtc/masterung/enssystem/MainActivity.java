package appewtc.masterung.enssystem;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;
    private ManageTABLE objManageTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Request Database
        objManageTABLE = new ManageTABLE(this);

        //Test Add Value
        testAddValue();

        //Synchronize JSON to SQLite
        synJSONtoSQLite();


    }   // Main Method

    private void testAddValue() {

        objManageTABLE.addUser("user", "pass", "name", "Sur", "male", "123456", "abc@gmail.com");

        objManageTABLE.addNews("title", "detail", "video", "photo", "day news", "user admin");

    }   // testAddValue

    private void synJSONtoSQLite() {

        //Change Policy
        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);

        int intTABLE = 1 ;   //intTABLE ==> amount of Table
        while (intTABLE <= 2) {

            String strURLuser = "http://swiftcodingthai.com/ens/php_get_user_master.php";
            String strURLnews = "http://swiftcodingthai.com/ens/php_get_news_master.php";

            //1. Create InputStream

            //2. Create JSON String

            //3. Update to SQLite



            intTABLE += 1;
        }   // while



    }   // synJSONtoSQLite

    private void bindWidget() {

        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);

    }   // bindWidget

    public void clickSignIn(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {
            //Have Space
            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.MyDialog(MainActivity.this, R.drawable.icon_question,
                    "Have Space", "Please Fill All Every Blank");

        } else {
            //No Space

        }   // if


    }   // clickSignIn


    public void clickSignUp(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }


}   // Main Class
