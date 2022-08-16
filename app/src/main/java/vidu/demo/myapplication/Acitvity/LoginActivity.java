package vidu.demo.myapplication.Acitvity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import vidu.demo.myapplication.Adapter.AdapterPhoto;
import vidu.demo.myapplication.Model.ImagePhoto;
import vidu.demo.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    ViewPager mViewPager;
    CircleIndicator mCircleIndicator;
    AdapterPhoto adapterPhoto;
    ArrayList<ImagePhoto> arrayList;
    Timer mTimer;
    CallbackManager callbackManager;
    LoginButton btn_login;
    SignInButton signInButton;
    TextView txt_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(getApplication ());
        callbackManager = CallbackManager.Factory.create ();
        Init ();
        arrayList = new ArrayList<> ();
        arrayList.add (new ImagePhoto (R.drawable.slide1));
        arrayList.add (new ImagePhoto (R.drawable.slide2));
        arrayList.add (new ImagePhoto (R.drawable.slide3));

        adapterPhoto = new AdapterPhoto (this,arrayList);
        mViewPager.setAdapter (adapterPhoto);

        mCircleIndicator.setViewPager (mViewPager);
        adapterPhoto.registerDataSetObserver (mCircleIndicator.getDataSetObserver ());

        AotuSlideImage();
        btn_login.registerCallback (callbackManager, new FacebookCallback<LoginResult> () {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d ("TAG", "onSuccess: " + loginResult);
                startActivity (new Intent (LoginActivity.this,TrangChuActivity.class));
                Toast.makeText (LoginActivity.this, "Login thành công", Toast.LENGTH_SHORT).show ();
            }
            @Override
            public void onCancel() {

            }

            @Override
            public void onError(@NonNull FacebookException e) {
                Log.d ("TAG", "onError: " + e);
            }
        });
        Login ();

    }

    private void AotuSlideImage() {
        if(arrayList == null || arrayList.isEmpty () || mViewPager == null){
            return;
        }
        if(mTimer == null){
            mTimer = new Timer ();
        }
        mTimer.schedule (new TimerTask () {
            @Override
            public void run() {
                new Handler (Looper.getMainLooper ()).post (new Runnable () {
                    @Override
                    public void run() {
                        int index_anh = mViewPager.getCurrentItem ();
                        int int_list_image = arrayList.size () - 1;
                        if(index_anh < int_list_image){
                            index_anh++;
                            mViewPager.setCurrentItem (index_anh);
                        }else {
                            mViewPager.setCurrentItem (0);
                        }
                    }
                });
            }
        },6000,6000);
    }

    public void Init(){
        mViewPager = findViewById (R.id.view_page_image);
        mCircleIndicator = findViewById (R.id.cire);
        btn_login = findViewById (R.id.login_button);
        signInButton =  findViewById (R.id.sign_in_button);
        txt_login = findViewById (R.id.txt_login);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        if(mTimer != null ){
            mTimer.cancel ();
            mTimer = null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void Login(){
        txt_login.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (LoginActivity.this,TrangChuActivity.class));
            }
        });
    }

}