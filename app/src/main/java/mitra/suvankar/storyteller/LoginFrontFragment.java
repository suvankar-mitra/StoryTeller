package mitra.suvankar.storyteller;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFrontFragment extends Fragment {

    private Typeface mTypefaceJosefinRegular;
    private Typeface mTypefaceJosefinBold;
    private TextInputLayout mEmailLayout;
    private TextInputLayout mPasswordLayout;
    private EditText mEmail;
    private EditText mPassword;
    private Button mLoginButton;
    private Button mForgotButton;
    private Button mSignupButton;
    private TextView mTitle;

    public LoginFrontFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_front, container, false);

        //Initializing custom font
        AssetManager am = getActivity().getAssets();
        mTypefaceJosefinRegular = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "JosefinSans-Regular.ttf"));
        mTypefaceJosefinBold = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "JosefinSans-Bold.ttf"));

        mEmailLayout = (TextInputLayout) view.findViewById(R.id.login_email_layout);
        mPasswordLayout = (TextInputLayout) view.findViewById(R.id.login_password_layout);
        mEmail = (EditText) view.findViewById(R.id.login_email_input);
        mPassword = (EditText) view.findViewById(R.id.login_password_input);
        mLoginButton = (Button) view.findViewById(R.id.login_login_button);
        mSignupButton = (Button) view.findViewById(R.id.login_signup_button);
        mForgotButton = (Button) view.findViewById(R.id.login_forgot_password_button);
        mTitle = (TextView) view.findViewById(R.id.login_title);

        setTypeface(mLoginButton, mTypefaceJosefinRegular);
        setTypeface(mSignupButton, mTypefaceJosefinRegular);
        setTypeface(mForgotButton, mTypefaceJosefinRegular);
        setTypeface(mTitle, mTypefaceJosefinBold);
        mEmailLayout.setTypeface(mTypefaceJosefinRegular);
        mPasswordLayout.setTypeface(mTypefaceJosefinRegular);

        //login
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),HomeActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


    public void setTypeface(TextView mViewElement, Typeface typeface) {
        if(typeface !=null)
            mViewElement.setTypeface(typeface);
    }

}
