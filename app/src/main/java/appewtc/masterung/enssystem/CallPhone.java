package appewtc.masterung.enssystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ListView;

public class CallPhone extends AppCompatActivity {

    //Explicit
    private LinearLayout topLinearLayout;
    private ListView phoneListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);

        //Bind Widget
        bindWidget();

        //Show Choose
        showChoose();

        //Create ListView
        createListView();


    }   // Main Method

    private void createListView() {

        String[] callStrings = getIntent().getStringArrayExtra("Call");
        String[] phoneStrings = getIntent().getStringArrayExtra("Phone");

        PhoneAdapter phoneAdapter = new PhoneAdapter(CallPhone.this, callStrings, phoneStrings);
        phoneListView.setAdapter(phoneAdapter);


    }   // createListView

    private void showChoose() {
        int intBackGround = getIntent().getIntExtra("Icon", R.drawable.catagory1);
        topLinearLayout.setBackgroundResource(intBackGround);
    }

    private void bindWidget() {
        topLinearLayout = (LinearLayout) findViewById(R.id.linTopCallPhone);
        phoneListView = (ListView) findViewById(R.id.listView2);

    }

}   // Main Class
