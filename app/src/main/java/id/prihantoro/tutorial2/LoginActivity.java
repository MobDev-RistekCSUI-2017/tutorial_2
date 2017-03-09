package id.prihantoro.tutorial2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        Toast.makeText(this, Database.getInstance(this).getUserById(1).getEmail()+"", Toast.LENGTH_SHORT).show();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("username", username.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
            }
        });

        SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
        String username = sharedPref.getString("username", null);
        if (username != null) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tutorial 2", "ini onresume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tutorial 2", "ini onstart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tutorial 2", "ini onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tutorial 2", "ini onstop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("tutorial 2", "ini onrestart");
    }
}
