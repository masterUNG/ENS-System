package appewtc.masterung.enssystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        //Create ListView
        createListView();


    } // Main Method

    private void createListView() {

        //Read All Data from SQLite
        int intDigit = 30;  // จำนวนตัวอักษรที่จะอ่านมาแสดงที่ Title

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + ManageTABLE.TABLE_newsTABLE, null);
        cursor.moveToFirst();

        int intCount = cursor.getCount();
        final String[] titleFullStrings = new String[intCount];
        String[] titleShortStrings = new String[intCount];
        final String[] dateStrings = new String[intCount];
        final String[] photoNewStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] videoStrings = new String[intCount];

        for (int i = 0; i < intCount; i++) {

            titleFullStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.COLUMN_Title_News));
            dateStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.COLUMN_Day_News));
            photoNewStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.COLUMN_Photo_News));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.COLUMN_Detail_News));
            videoStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.COLUMN_Video_News));

            titleShortStrings[i] = titleFullStrings[i].substring(0, intDigit) + " ... ";

            cursor.moveToNext();
        }   //for
        cursor.close();

        NewsAdapter newsAdapter = new NewsAdapter(NewsListView.this,
                titleShortStrings, dateStrings, photoNewStrings);
        newsListView.setAdapter(newsAdapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(NewsListView.this, NewsDetail.class);
                intent.putExtra("Title", titleFullStrings[i]);
                intent.putExtra("Image", photoNewStrings[i]);
                intent.putExtra("Date", dateStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Video", videoStrings[i]);
                startActivity(intent);

            }   // onItemClick
        });


    }   // createListView

    public void clickBackNewsList(View view) {
        finish();
    }

}   // Main Class
