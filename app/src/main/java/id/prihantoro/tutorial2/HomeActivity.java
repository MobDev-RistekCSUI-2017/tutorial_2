package id.prihantoro.tutorial2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wahyu on 09 Maret 2017.
 */

public class HomeActivity extends AppCompatActivity {

    TextView usernameTextView;
    TextView passwordTextView;
    Button logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usernameTextView = (TextView) findViewById(R.id.username);
        passwordTextView = (TextView) findViewById(R.id.password);
        logout = (Button) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.remove("username");
                editor.remove("password");
                editor.commit();
                finish();
            }
        });

        SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
        String username = sharedPref.getString("username", null);
        String password = sharedPref.getString("password", null);
        usernameTextView.setText(username);
        passwordTextView.setText(password);

    }
}
