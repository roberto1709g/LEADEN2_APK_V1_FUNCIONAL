package com.leaden2.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setPadding(dp(24), dp(32), dp(24), dp(24));
        root.setBackgroundColor(Color.rgb(7, 11, 20));

        TextView title = new TextView(this);
        title.setText("LEADEN2");
        title.setTextColor(Color.rgb(0, 229, 255));
        title.setTextSize(32);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, dp(12), 0, dp(6));
        root.addView(title, matchWrap());

        TextView subtitle = new TextView(this);
        subtitle.setText("APK V1 FUNCIONAL · PRUEBA DE SESIÓN MULTIMEDIA");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(13);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 0, 0, dp(22));
        root.addView(subtitle, matchWrap());

        status = new TextView(this);
        status.setText("Estado: todavía no activado. Pulsa ACTIVAR LEADEN2.");
        status.setTextColor(Color.WHITE);
        status.setTextSize(16);
        status.setGravity(Gravity.CENTER);
        status.setPadding(dp(12), dp(16), dp(12), dp(16));
        root.addView(status, matchWrap());

        Button activate = makeButton("ACTIVAR LEADEN2");
        activate.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlaybackService.class);
            intent.setAction(PlaybackService.ACTION_ACTIVATE);
            ContextCompat.startForegroundService(this, intent);
            status.setText("Solicitud enviada. Debe sonar comienza_el_ensamblaje.mp3. Mantén activa la sesión antes de bloquear el teléfono.");
        });
        root.addView(activate, buttonParams());

        Button local = makeButton("PRUEBA LOCAL: EJECUTAR ACCIÓN");
        local.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlaybackService.class);
            intent.setAction(PlaybackService.ACTION_ASSISTANT);
            ContextCompat.startForegroundService(this, intent);
            status.setText("Solicitud de acción local enviada. Debe reproducirse importando.mp3.");
        });
        root.addView(local, buttonParams());

        TextView instructions = new TextView(this);
        instructions.setText(
            "PRUEBA CON LAS GAFAS\\n" +
            "1. Activa LEADEN2 y confirma el audio inicial.\\n" +
            "2. Mantén la sesión activa y bloquea el teléfono.\\n" +
            "3. Pulsa una vez el botón central de las gafas.\\n" +
            "4. Comprueba si se reproduce importando.mp3.\\n\\n" +
            "El resultado depende de qué sesión multimedia elija Android. Esta app no puede garantizar que el evento se dirija a LEADEN2."
        );
        instructions.setTextColor(Color.rgb(205, 215, 230));
        instructions.setTextSize(14);
        instructions.setPadding(0, dp(20), 0, 0);
        root.addView(instructions, matchWrap());

        setContentView(root);
    }

    private Button makeButton(String text) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextColor(Color.BLACK);
        b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(0, 229, 255)));
        b.setAllCaps(false);
        return b;
    }

    private LinearLayout.LayoutParams buttonParams() {
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        p.topMargin = dp(12);
        return p;
    }

    private LinearLayout.LayoutParams matchWrap() {
        return new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }
}
