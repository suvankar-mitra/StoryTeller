package mitra.suvankar.storyteller;


import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.TextInputLayout;
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
public class SignupFragment extends Fragment {

    private Typeface mTypefaceJosefinRegular;
    private Typeface mTypefaceJosefinBold;
    private TextInputLayout mEmailLayout;
    private TextInputLayout mPasswordLayout;
    private TextInputLayout mNameLayout;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mName;
    private Button mLoginButton;
    private Button mSignupButton;
    private TextView mTitle;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        //Initializing custom font
        AssetManager am = getActivity().getAssets();
        mTypefaceJosefinRegular = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "JosefinSans-Regular.ttf"));
        mTypefaceJosefinBold = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "JosefinSans-Bold.ttf"));

        mEmailLayout = (TextInputLayout) view.findViewById(R.id.signup_email_layout);
        mPasswordLayout = (TextInputLayout) view.findViewById(R.id.signup_password_layout);
        mNameLayout = (TextInputLayout) view.findViewById(R.id.signup_name_layout);
        mEmail = (EditText) view.findViewById(R.id.signup_email_input);
        mName = (EditText) view.findViewById(R.id.signup_email_input);
        mPassword = (EditText) view.findViewById(R.id.signup_name_input);
        mLoginButton = (Button) view.findViewById(R.id.signup_login_button);
        mSignupButton = (Button) view.findViewById(R.id.signup_signup_button);
        mTitle = (TextView) view.findViewById(R.id.signup_title);

        setTypeface(mLoginButton, mTypefaceJosefinRegular);
        setTypeface(mSignupButton, mTypefaceJosefinRegular);
        setTypeface(mTitle, mTypefaceJosefinBold);
        mEmailLayout.setTypeface(mTypefaceJosefinRegular);
        mPasswordLayout.setTypeface(mTypefaceJosefinRegular);
        mNameLayout.setTypeface(mTypefaceJosefinRegular);

        return view;
    }
    public void setTypeface(TextView mViewElement, Typeface typeface) {
        if(typeface !=null)
            mViewElement.setTypeface(typeface);
    }

}
