package appewtc.masterung.enssystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 1/27/16 AD.
 */
public class ManageTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE_userTABLE = "userTABLE";
    public static final String COLUMN_id = "_id";
    public static final String COLUMN_User = "User";
    public static final String COLUMN_Password = "Password";
    public static final String COLUMN_Name = "Name";
    public static final String COLUMN_Surname = "Surname";
    public static final String COLUMN_Sex = "Sex";
    public static final String COLUMN_Phone = "Phone";
    public static final String COLUMN_Email = "Email";

    public static final String TABLE_callTABLE = "callTABLE";
    public static final String COLUMN_Name_Call = "Name_Call";
    public static final String COLUMN_Phone_Call = "Phone_Call";

    public static final String TABLE_newsTABLE = "newsTABLE";
    public static final String COLUMN_Title_News = "Title_News";
    public static final String COLUMN_Detail_News = "Detail_News";
    public static final String COLUMN_Video_News = "Video_News";
    public static final String COLUMN_Photo_News = "Photo_News";
    public static final String COLUMN_Day_News = "Day_News";
    public static final String COLUMN_User_Admin = "User_Admin";

    public ManageTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor

}   // Main Class
