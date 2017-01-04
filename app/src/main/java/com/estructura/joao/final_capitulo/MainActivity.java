package com.estructura.joao.final_capitulo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FACEBOOK
        if(AccessToken.getCurrentAccessToken()==null){
            goLoginAcivity();
        }

        //PUBLICIDAD
        adView=(AdView) findViewById(R.id.ad_view);
        AdRequest adRequest= new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);
    }

    //Ir a Ventana Login
    private void goLoginAcivity(){
        Intent intent= new Intent(this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //SALIRE
    public void salir(View view){
        LoginManager.getInstance().logOut();
        goLoginAcivity();
    }
}
