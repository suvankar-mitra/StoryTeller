package mitra.suvankar.storyteller;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class LoginBackFragment extends Fragment {

    private Typeface mTypefaceJosefinRegular;
    private Typeface mTypefaceJosefinBold;
    private Button mStart;
    private TextView mTitle;
    private TextView mMsg;

    public LoginBackFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_back, container, false);
        //Initializing custom font
        AssetManager am = getActivity().getAssets();
        mTypefaceJosefinRegular = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "JosefinSans-Regular.ttf"));
        mTypefaceJosefinBold = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "JosefinSans-Bold.ttf"));

        mTitle = (TextView) view.findViewById(R.id.login_title);
        mMsg = (TextView) view.findViewById(R.id.login_frag_back_msg);
        mStart = (Button) view.findViewById(R.id.frag_back_start);
        setTypeface(mStart, mTypefaceJosefinRegular);
        setTypeface(mTitle, mTypefaceJosefinBold);
        setTypeface(mMsg, mTypefaceJosefinRegular);
        return view;
    }

    public void setTypeface(TextView mViewElement, Typeface typeface) {
        if(typeface !=null)
            mViewElement.setTypeface(typeface);
    }
}
