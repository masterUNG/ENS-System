package appewtc.masterung.enssystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetail extends AppCompatActivity {

    //Explicit
    private TextView titleTextView, dateTextView, detailTextView;
    private ImageView newsImageView;
    private String titleString, dateString, detailString, urlNewsImageString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        //Bind Widget
        bindWidget();

        //Show View
        showView();


    }   // Main Method

    private void showView() {

        //Receive Value From Intent
        titleString = getIntent().getStringExtra("Title");
        urlNewsImageString = getIntent().getStringExtra("Image");
        dateString = getIntent().getStringExtra("Date");
        detailString = getIntent().getStringExtra("Detail");

        titleTextView.setText(titleString);
        dateTextView.setText(dateString);
        detailTextView.setText(detailString);

        Picasso.with(NewsDetail.this)
                .load(urlNewsImageString)
                .resize(250, 125)
                .into(newsImageView);



    }   // showView

    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.txtTitleNewsDetail);
        dateTextView = (TextView) findViewById(R.id.txtDay);
        detailTextView = (TextView) findViewById(R.id.txtDetail);
        newsImageView = (ImageView) findViewById(R.id.imvDetail);
    }

}   // Main Class
