package appewtc.masterung.enssystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CallListView extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView cat0ImageView, cat1ImageView,
            cat2ImageView, cat3ImageView, cat4ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_list_view);

        //Bind Widget
        bindWidget();

        //Image Controller
        imageController();

    }   // Main Method

    private void imageController() {
        cat0ImageView.setOnClickListener(this);
        cat1ImageView.setOnClickListener(this);
        cat2ImageView.setOnClickListener(this);
        cat3ImageView.setOnClickListener(this);
        cat4ImageView.setOnClickListener(this);
    }

    private void bindWidget() {
        cat0ImageView = (ImageView) findViewById(R.id.imageView10);
        cat1ImageView = (ImageView) findViewById(R.id.imageView11);
        cat2ImageView = (ImageView) findViewById(R.id.imageView12);
        cat3ImageView = (ImageView) findViewById(R.id.imageView13);
        cat4ImageView = (ImageView) findViewById(R.id.imageView14);
    }

    @Override
    public void onClick(View view) {

        int[] iconInts = {R.drawable.catagory1, R.drawable.catagory2,
                R.drawable.catagory3, R.drawable.catagory4, R.drawable.catagory5};
        int intUserChoose = R.drawable.catagory1;

        switch (view.getId()) {

            case R.id.imageView10:
                intUserChoose = iconInts[0];
                break;
            case R.id.imageView11:
                intUserChoose = iconInts[1];
                break;
            case R.id.imageView12:
                intUserChoose = iconInts[2];
                break;
            case R.id.imageView13:
                intUserChoose = iconInts[3];
                break;
            case R.id.imageView14:
                intUserChoose = iconInts[4];
                break;
        }   // switch

        Intent intent = new Intent(CallListView.this, CallPhone.class);
        intent.putExtra("Icon", intUserChoose);
        startActivity(intent);

    }   // onClick

}   // Main Class
