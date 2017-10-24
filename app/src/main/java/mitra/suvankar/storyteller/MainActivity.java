package mitra.suvankar.storyteller;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Typeface mTypefaceJosefinRegular;
    private Typeface mTypefaceJosefinBold;

    private TextView mStoryViews;
    private TextView mProfStories;
    private ImageView mProfPicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Initializing custom font
        AssetManager am = getApplicationContext().getAssets();
        mTypefaceJosefinRegular = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "JosefinSans-Regular.ttf"));
        mTypefaceJosefinBold = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "JosefinSans-Bold.ttf"));

        mStoryViews = (TextView) findViewById(R.id.main_prof_views);
        mProfStories = (TextView) findViewById(R.id.main_prof_stories);
        mProfPicView = (ImageView) findViewById(R.id.main_prof_pic_view);
        setTypeface(mStoryViews,mTypefaceJosefinRegular);
        setTypeface(mProfStories,mTypefaceJosefinRegular);

    }

    public void setTypeface(TextView mViewElement, Typeface typeface) {
        if(typeface !=null)
            mViewElement.setTypeface(typeface);
    }

    public void showProfilePicture(View view) {
        mProfPicView.setAnimation(null);
        mProfPicView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.zoom_in));
        mProfPicView.setVisibility(View.VISIBLE);
        findViewById(R.id.main_prof_pic_view_underlay).setVisibility(View.VISIBLE);
        //mProfPicView.setAnimation(null);
    }

    public void hideProfilePicture(View view) {
        mProfPicView.setAnimation(null);
//        mProfPicView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.zoom_out));
        mProfPicView.setVisibility(View.GONE);
        findViewById(R.id.main_prof_pic_view_underlay).setVisibility(View.GONE);
        //mProfPicView.setAnimation(null);
    }
}
