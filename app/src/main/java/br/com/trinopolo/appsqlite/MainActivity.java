package br.com.trinopolo.appsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.trinopolo.appsqlite.db.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper dbHelper = new DatabaseHelper(this);

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        database.execSQL("insert into pessoa (id, nome, email) values (1, 'marcos', 'marconvcm@gmail.com');");

        textView = (TextView) findViewById(R.id.textView);

        Cursor cursor = database.rawQuery("select * from pessoa", new String[]{});

        textView.setText(String.valueOf(cursor.getCount()));

        database.execSQL("insert into oferta (id, valor, desconto) values (1, 1, 1);");
    }
}
