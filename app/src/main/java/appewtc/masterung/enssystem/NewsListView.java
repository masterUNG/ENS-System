package appewtc.masterung.enssystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class NewsListView extends AppCompatActivity {

    //Explicit
    private ListView newsListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list_view);

        //Bind Widget
        newsListView = (ListView) findViewById(R.id.listView);




    } // Main Method

    public void clickBackNewsList(View view) {
        finish();
    }

}   // Main Class
