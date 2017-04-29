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

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewById
    EditText username;
    @ViewById
    EditText password;
    @Pref
    UserPref_ userPref;

    @Bean
    UserData userData;

    @AfterViews
    void init(){
        Toast.makeText(this, Database.getInstance(this).getUserById(1).getEmail()+"", Toast.LENGTH_SHORT).show();
//        SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
//        String username = sharedPref.getString("username", null);
        String username = userPref.username().get();
        if (!username.isEmpty()) {
            Intent intent = new Intent(this, HomeActivity_.class);
            startActivity(intent);
        }
    }


    @Click
    public void login(){
//        SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("username", username.getText().toString());
//        editor.putString("password", password.getText().toString());
//        editor.commit();
        userPref.edit().username().put(username.getText().toString()).apply();
        userPref.edit().password().put(password.getText().toString()).apply();
        userData.setUsername(username.getText().toString());
//        Intent intent = new Intent(getApplicationContext(), HomeActivity_.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        getApplicationContext().startActivity(intent);
        HomeActivity_.intent(this).start();
        Toast.makeText(this, userPref.username().get(), Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        username = (EditText) findViewById(R.id.username);
//        password = (EditText) findViewById(R.id.password);
//        login = (Button) findViewById(R.id.login);
//        Toast.makeText(this, Database.getInstance(this).getUserById(1).getEmail()+"", Toast.LENGTH_SHORT).show();
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putString("username", username.getText().toString());
//                editor.putString("password", password.getText().toString());
//                editor.commit();
//                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                getApplicationContext().startActivity(intent);
//            }
//        });
//
//        SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
//        String username = sharedPref.getString("username", null);
//        if (username != null) {
//            Intent intent = new Intent(this, HomeActivity.class);
//            startActivity(intent);
//        }
//
//    }

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
