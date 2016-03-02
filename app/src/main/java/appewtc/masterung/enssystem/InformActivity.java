package appewtc.masterung.enssystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class InformActivity extends AppCompatActivity {

    //Explicit
    private TextView showNameTextView;
    private DatePicker datePicker;
    private EditText phoneEditText, detailEditText;
    private Spinner typeSpinner;
    private Button addPhotoButton, addVideoButton,
            addLocationButton, updateToSQLButton;
    private String nameLoginString, dateString, phoneString, detailString,
            typeString, photoURLString, videoURLString, latString, lngString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform);

        //Bind Widget
        bindWidget();

        //Show Name
        showName();

    }   // Main Method

    private void showName() {

        nameLoginString = getIntent().getStringExtra("nameLogin");
        showNameTextView.setText(getResources().getString(R.string.th_infor) +
                " โดย " +
                nameLoginString);

    }   // showName

    private void bindWidget() {

        showNameTextView = (TextView) findViewById(R.id.textView16);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        phoneEditText = (EditText) findViewById(R.id.editText7);
        detailEditText = (EditText) findViewById(R.id.editText11);
        typeSpinner = (Spinner) findViewById(R.id.spinner);
        addPhotoButton = (Button) findViewById(R.id.button4);
        addVideoButton = (Button) findViewById(R.id.button9);
        addLocationButton = (Button) findViewById(R.id.button11);
        updateToSQLButton = (Button) findViewById(R.id.button5);

    }   // bindWidget

}   // Main Class
