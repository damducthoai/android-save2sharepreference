package butchjgo.com.sharepreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String key, value;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void prepareData() {
        EditText editText = findViewById(R.id.txtKey);
        key = editText.getText().toString();

        EditText editTextValue = findViewById(R.id.txtValue);
        value = editTextValue.getText().toString();
    }

    void doSet(View view) {
        prepareData();
        sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).apply();
        Toast.makeText(this, "Data setted", Toast.LENGTH_LONG).show();
    }

    void doGet(View view) {
        prepareData();
        sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        String txtData = sharedPreferences.getString(key, "No data getted");
        Toast.makeText(this, txtData, Toast.LENGTH_LONG).show();

    }
}
