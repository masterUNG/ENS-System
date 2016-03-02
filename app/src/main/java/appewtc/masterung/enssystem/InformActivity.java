package appewtc.masterung.enssystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class InformActivity extends AppCompatActivity implements View.OnClickListener {

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

        typeController();

        //Button Controller
        buttonController();

    }   // Main Method

    private void buttonController() {

        addPhotoButton.setOnClickListener(this);
        addVideoButton.setOnClickListener(this);
        addLocationButton.setOnClickListener(this);
        updateToSQLButton.setOnClickListener(this);

    }   // buttonController

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

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button4:
                //Add Photo
                break;
            case R.id.button9:
                //Add Video
                break;
            case R.id.button11:
                //Add Location
                startActivity(new Intent(InformActivity.this, MapsActivity.class));
                break;
            case R.id.button5:
                //Update

                phoneString = phoneEditText.getText().toString();
                detailString = detailEditText.getText().toString();

                if (phoneString.equals("") || detailString.equals("")) {
                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.MyDialog(InformActivity.this, R.drawable.icon_question,
                            "มีช่องว่าง", "กรุณากรอกให้ครบ คะ");
                } else {
                    getDateFromDatePicker();

                    showLog();
                }

                break;

        } // switch

    }   // onClick

    private void typeController() {

        final String[] categoryStrings = new String[4];
        categoryStrings[0] = "อุบัติเหตุ";
        categoryStrings[1] = "ไฟไหม้";
        categoryStrings[2] = "แผ่นดินไหว";
        categoryStrings[3] = "น้ำท่วม";

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, categoryStrings);
        typeSpinner.setAdapter(stringArrayAdapter);

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                typeString = categoryStrings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                typeString = categoryStrings[0];
            }
        });

    }   // typeContorller

    private void getValueFromEditText() {


    }   // getValueFromEditText

    private void getDateFromDatePicker() {

        int intDay = datePicker.getDayOfMonth();
        int intMonth = datePicker.getMonth() + 1;
        int intYear = datePicker.getYear();

        dateString = Integer.toString(intDay) + "/" +
                Integer.toString(intMonth) + "/" + Integer.toString(intYear);

    }   // getDateFromDatePicker

    private void showLog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.logo48);
        builder.setTitle("โปรดตรวจสอบข้อมูล");
        builder.setMessage("ผู้แจ้งเหตุ = " + nameLoginString + "\n" +
                "วันที่เกิดเหตุ = " + dateString + "\n" +
                "เบอร์ของผู้แจ้ง = " + phoneString + "\n" +
                "ประเภทเหตุการณ์ = " + typeString + "\n" +
                "รายละเอียด = " + detailString + "\n" +
                "ละติจุต = " + latString + "\n" +
                "ลองจิจูต = " + lngString);
        builder.setCancelable(false);
        builder.setPositiveButton("แจ้งเหตุ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                updateDataToServer();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("แก้ไข", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();

    }   // showLog

    private void updateDataToServer() {

    }

}   // Main Class
