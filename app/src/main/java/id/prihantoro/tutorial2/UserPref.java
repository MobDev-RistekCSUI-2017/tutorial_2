package id.prihantoro.tutorial2;

import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by wahyu on 27 April 2017.
 */

@SharedPref
public interface UserPref {
    @DefaultString("hehe")
    String username();

    @DefaultString("")
    String password();

    @DefaultInt(213123)
    int number();
}
