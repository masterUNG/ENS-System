package appewtc.masterung.enssystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class CallPhone extends AppCompatActivity {

    //Explicit
    private LinearLayout topLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);

        //Bind Widget
        bindWidget();

        //Show Choose
        showChoose();


    }   // Main Method

    private void showChoose() {
        int intBackGround = getIntent().getIntExtra("Icon", R.drawable.catagory1);
        topLinearLayout.setBackgroundResource(intBackGround);
    }

    private void bindWidget() {
        topLinearLayout = (LinearLayout) findViewById(R.id.linTopCallPhone);

    }

}   // Main Class
