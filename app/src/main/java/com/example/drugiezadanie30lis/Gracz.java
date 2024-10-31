package com.example.drugiezadanie30lis;

import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    int pozostaleSekundy;
    boolean czyDziala;
    String czasDowyswietlenia;

    Button buttonGracz1;
    CountDownTimer countDownTimer;

    public Gracz(boolean czyDziala, Button buttonGracz1) {
        this.czyDziala = czyDziala;
        this.buttonGracz1 = buttonGracz1;
        pozostaleSekundy = 3*60;
    }

    public void stopTimer(){
        czyDziala = false;
        countDownTimer.cancel();
    }

    public void startTimer(){
        czyDziala = true;
        countDownTimer = new CountDownTimer(1000*pozostaleSekundy,1000) {
            @Override
            public void onTick(long l) {
                pozostaleSekundy = (int)l/1000;
                int h60 = pozostaleSekundy/3600;
                int m60 = (pozostaleSekundy - h60 * 3600)/60;
                int s60 = pozostaleSekundy%60;
                czasDowyswietlenia = String.format("%02d:%02d",m60,s60);
                buttonGracz1.setText(String.valueOf(czasDowyswietlenia));
                //TODO: poprawić wyświetlanie
            }

            @Override
            public void onFinish() {
                buttonGracz1.setText("KONIEC");
            }
        };
        countDownTimer.start();
    }
}
