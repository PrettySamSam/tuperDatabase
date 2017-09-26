package ai.api.sample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samela Candido on 9/26/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private  static final String DATABASE_NAME = "tuper.db";
    private static final String TABLE_NAME = "college";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "college_name";
    private static final String COLUMN_LOCATION= "college_loc";

    private SQLiteDatabase db;
    private static final String TABLE_CREATECOLLEGE="create table college (id integer primary key not null auto_increment , )" +
            "college_name text not null , college_loc text not null);";

    DatabaseHelper(Context context){

        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATECOLLEGE);

        this.db = db;
    }

    public String searchValue(String val){


        String query = "SELECT * FROM " + TABLE_NAME;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "Not Found";
        if(cursor.moveToFirst()){

            do{
                a = cursor.getString(0);


                if(a.equals(val)){
                    b = cursor.getString(1);
                    break;

                }
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return b;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXIST "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
