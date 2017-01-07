package com.example.cagla.bilbilebilirsen;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoruActivity extends AppCompatActivity {

    private TextView soru, zaman, puan;
    private String[]  sorular;
    private String[][]  cevaplar;
    private int[]      cevap;
    private Button a, b, c, d, pas;

    private int    dogruSayisi=0, clikKontrol, sn=11, soruKontrol=0;

    private MediaPlayer  tiktak, sonsaat, rongrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru);

        soru= (TextView) findViewById(R.id.soru);
        puan= (TextView) findViewById(R.id.puan);
        zaman = (TextView) findViewById(R.id.zaman);
        a= (Button) findViewById(R.id.buttona);
        b= (Button) findViewById(R.id.buttonb);
        c= (Button) findViewById(R.id.buttonc);
        d= (Button) findViewById(R.id.buttond);
        pas= (Button) findViewById(R.id.button7);
        zaman= (TextView) findViewById(R.id.zaman);
        puan= (TextView) findViewById(R.id.puan);

        sonsaat= MediaPlayer.create(SoruActivity.this, R.raw.sonsaat);
        tiktak= MediaPlayer.create(SoruActivity.this, R.raw.tiktak);
        rongrong= MediaPlayer.create(SoruActivity.this, R.raw.rongrong);

        sorular= new String[]{
                "Houston, bir sorunumuz var. Repliğiyle ünlü film hangisidir?",
                "Bilgi kuvvetse, Tanrı benim, Kafein seni öldürecek, Bir arkadaş aramıyorum. Şu an bir ortağa ihtiyacım var. Replikleriyle ünlü film hangisidir? ",
                "Onu çal Sam, As Time Goes By ı çal, Paris hep olacak diyen Humphrey Bogart Replikleriyle ünlü film hangisidir?",
                "Alec Guinness'ın Kuvvet seninle olsun dediği Repliğiyle ünlü film hangisidir? ",
                "Atlas Okyanusu o zamanlar bir şeydi. Evet, Atlas okyanusunu o günlerde görmeliydin.Repliğiyle ünlü film hangisidir?",
                "Hayallere bağlanmak ve yaşamayı unutmak iyi değildir. Repliğinin geçtiği ünlü film serisi nedir?"
        };
        //cevap
        cevaplar= new String[][]{
                {"Apollo 13","Yağmur Adam","Rocky","Çağrı"},
                {"Pamuk Prenses ve Yedi Cüceler","Batman Forever","Oz Büyücüsü","Siyah Elbiseli Adamlar"},
                {"The Blues Brothers 2000","Indiana Jones, Raiders of the Lost Ark","Casablanca","Çıplak Ayaklı Kontes"},
                {"Yıldız Savaşlar","Mutlak Güç","Dün Gece Hakkında","The Abyss"},
                {"Auntie Mame","The Band Wagon","Bar Kelebeği","Atlantic City"},
                {"Harry Potter ve Felsefe Taşı","Alaca  Karanlık Efsanesi","Narnia Günlükleri","Yüzüklerin Efendisi"}


        };
        // 1 a, 2 b, 3 c, 4 d
        cevap= new int[]{1,2,3,1,4,1
        };

        //Geri Sayım
        zaman = (TextView) findViewById(R.id.zaman);
        new CountDownTimer(50000,1000) {
            public void onTick(long millisUntilFinished) {
                sn--;
                zaman.setText("" + sn);
                if (clikKontrol==1){
                    sn=11;
                }
                if (sn==3){
                    sonsaat.start();

                }   if (sn==0){
                        sn=11;
                        clikKontrol=1;
                    }


                // soru
                soru.setText(sorular[soruKontrol]);

                a.setText(cevaplar[soruKontrol][0]);
                b.setText(cevaplar[soruKontrol][1]);
                c.setText(cevaplar[soruKontrol][2]);
                d.setText(cevaplar[soruKontrol][3]);

                // cevaplar
                a.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(clikKontrol==0) {
                            if (cevap[soruKontrol] == 1) {
                                dogruSayisi += 1;
                                a.setBackgroundColor
                                        (Color.parseColor("#ff669900"));
                                puan.setText("puanınız: "+3*dogruSayisi);
                                tiktak.start();
                            } else {
                                a.setBackgroundColor
                                        (Color.parseColor("red"));
                                 rongrong.start();
                            }
                            clikKontrol = 1;
                        }
                    }
                });
                b.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(clikKontrol==0) {
                            if (cevap[soruKontrol] == 2) {
                                dogruSayisi += 1;
                                b.setBackgroundColor
                                        (Color.parseColor("#ff669900"));
                                puan.setText("puanınız: "+3*dogruSayisi);
                               tiktak.start();
                            } else {
                                b.setBackgroundColor
                                        (Color.parseColor("red"));
                                rongrong.start();
                            }
                            clikKontrol = 1;
                        }
                    }
                });
                c.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(clikKontrol==0) {
                            if (cevap[soruKontrol] == 3) {
                                dogruSayisi += 1;
                                c.setBackgroundColor
                                        (Color.parseColor("#ff669900"));
                                puan.setText("puanınız: "+3*dogruSayisi);
                                tiktak.start();
                            } else {
                                c.setBackgroundColor
                                        (Color.parseColor("red"));
                                rongrong.start();
                            }
                            clikKontrol = 1;
                        }
                    }
                });
                d.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(clikKontrol==0) {
                            if (cevap[soruKontrol] == 4) {
                                dogruSayisi += 1;
                                d.setBackgroundColor
                                        (Color.parseColor("#ff669900"));
                                puan.setText("puanınız: "+3*dogruSayisi);
                                tiktak.start();
                            } else {
                                d.setBackgroundColor
                                        (Color.parseColor("red"));
                                rongrong.start();
                            }
                            clikKontrol = 1;
                        }
                    }
                });
                // alternatif clikler
                pas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(clikKontrol==0) {
                            clikKontrol = 1;
                        }
                    }
                });

                // yeni soru
                // cevap verdikten yarım sn sonra komut çalışsın
                if(clikKontrol==1){
                    soruKontrol+=1;
                    if (soruKontrol==6){
                        Intent i = new Intent(SoruActivity.this,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    clikKontrol  =0;
                                    a.setBackgroundColor
                                            (Color.parseColor("#ffd6d7d7"));
                                    b.setBackgroundColor
                                            (Color.parseColor("#ffd6d7d7"));
                                    c.setBackgroundColor
                                            (Color.parseColor("#ffd6d7d7"));
                                    d.setBackgroundColor
                                            (Color.parseColor("#ffd6d7d7"));
                                }
                            }, 500);
                }
            }
            public void onFinish(){
                Intent i = new Intent(SoruActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }.start();


    }
}
