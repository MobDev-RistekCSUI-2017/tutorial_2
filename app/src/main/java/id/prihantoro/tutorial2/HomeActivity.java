package id.prihantoro.tutorial2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

/**
 * Created by wahyu on 09 Maret 2017.
 */

@EActivity(R.layout.activity_home)
public class HomeActivity extends AppCompatActivity {

    @Bean
    UserData userData;

    @Pref
    UserPref_ userPref;

    @ViewById
    TextView username;
    @ViewById
    TextView password;
    Button logout;

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//        username = (TextView) findViewById(R.id.username);
//        password = (TextView) findViewById(R.id.password);
//        logout = (Button) findViewById(R.id.logout);
//
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.remove("username");
//                editor.remove("password");
//                editor.commit();
//                finish();
//            }
//        });
//
//        SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
//        String username = sharedPref.getString("username", null);
//        String password = sharedPref.getString("password", null);
//        username.setText(username);
//        password.setText(password);
//
//    }

    @AfterViews
    void init(){
        Toast.makeText(this, userData.getUsername(), Toast.LENGTH_SHORT).show();

        String username = userData.getUsername();
        String password = userPref.password().get();
        this.username.setText(username);
        this.password.setText(password);

    }

    @Click
    public void logout(){
//        SharedPreferences sharedPref = getSharedPreferences("tutorial 2", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.remove("username");
//        editor.remove("password");
//        editor.commit();
        finish();
    }
}
