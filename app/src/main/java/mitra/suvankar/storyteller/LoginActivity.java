package mitra.suvankar.storyteller;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //add the login front fragment
        getFragmentManager().beginTransaction()
                .add(R.id.container,new LoginFrontFragment()).commit();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Note").setMessage("Thank you for choosing to be an Alpha tester! Your feedback is warmly welcome.\nPlease" +
                " share your feedback by emailing us at suvankarmitra.me@gmail.com\n\n- Story Teller Team (v1.0.0.1.alpha)")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();
    }

    public void flipToBackView(View view) {
        getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)
                .replace(R.id.container,new LoginBackFragment())
                .addToBackStack(null)
                .commit();
    }

    public void flipToFrontView(View view) {
        getFragmentManager().popBackStack();
    }

    public void showSignupFragment(View view) {
        getFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out,
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out)
                .replace(R.id.container,new SignupFragment())
                .addToBackStack(null)
                .commit();
    }

    public void showLoginFragment(View view) {
        getFragmentManager().popBackStack();
    }
}
