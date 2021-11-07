package pk.edu.uiit.arid2480.assignment2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String  databasename = "Studentform";
    private static final String  tablename = "signup";
    private static final String  table_col_name = "signup";
    private static final int  dbversion = 1;
    SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context){
        super(context,databasename,null,dbversion);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ tablename+"(student_id INTEGER PRIMARY KEY AUTOINCREMENT, student_name VARCHAR,student_email VARCHAR,student_password VARCHAR,student_phone VARCHAR,student_country VARCHAR)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + tablename);
    }
    public  long singup(String name,String email, String password,String phone,String country){

        ContentValues contentValues = new ContentValues();

        contentValues .put("student_name", name);
        contentValues .put("student_email", email);
        contentValues.put("student_password", password);
        contentValues.put("student_phone", phone);
        contentValues.put("student_country", country);

        long user_data= sqLiteDatabase.insert(tablename,null,contentValues);
        return user_data;

    }
    public Cursor login(String Email, String password){
        Cursor userdata= sqLiteDatabase.rawQuery("Select * from " +tablename+"where student_email ='"+Email+"' And student_password='"+password+"'",null);
        return userdata;
    }
}
