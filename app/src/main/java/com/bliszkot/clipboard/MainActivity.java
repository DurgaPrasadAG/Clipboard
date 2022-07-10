package com.bliszkot.clipboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView clipboardText = findViewById(R.id.clipboardText);
        TextView pasteText = findViewById(R.id.pasteText);

        Button copy = findViewById(R.id.copy);
        Button paste = findViewById(R.id.paste);

        ClipboardManager myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        copy.setOnClickListener(v -> {
            String text = clipboardText.getText().toString();

            ClipData myClip = ClipData.newPlainText("text", text);
            myClipboard.setPrimaryClip(myClip);
        });

        paste.setOnClickListener(v -> {
            ClipData getText = myClipboard.getPrimaryClip();
            ClipData.Item item = getText.getItemAt(0);

            String text = item.getText().toString();
            pasteText.setText(text);
        });
    }
}