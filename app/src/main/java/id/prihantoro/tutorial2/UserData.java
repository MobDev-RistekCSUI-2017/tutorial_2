package id.prihantoro.tutorial2;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.sharedpreferences.Pref;

/**
 * Created by wahyu on 27 April 2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class UserData {
    @Pref
    UserPref_ userPref;

    public String getUsername() {
        return userPref.username().get();
    }

    public void setUsername(String username) {
        userPref.edit().username().put(username).apply();
    }
}
