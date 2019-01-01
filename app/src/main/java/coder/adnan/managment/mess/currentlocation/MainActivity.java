package coder.adnan.managment.mess.currentlocation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    AdView adv;
    TextView locatTV;
    WebView studyWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locatTV = findViewById(R.id.locTV);

        adv=findViewById(R.id.adView);

        String AppID="ca-app-pub-7527296650503295~9745504649";
        MobileAds.initialize(this,AppID);

        AdRequest request=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adv.loadAd(request);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        String adunitId="ca-app-pub-3940256099942544/6300978111";
        adView.setAdUnitId(adunitId);

        studyWV=findViewById(R.id.webYoutubeWV);
        getSupportActionBar().hide();

        studyWV.loadUrl("https://www.youtube.com/channel/UCYqrVQ4JHqWihZpS9nZucZA");
        WebSettings webSettings=studyWV.getSettings();
        webSettings.setJavaScriptEnabled(true);
        studyWV.setWebViewClient(new WebViewClient());

    }
}
