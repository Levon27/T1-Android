package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.Bitmap;

import java.io.File;
import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnMemes)
    public void Memes(){
        Uri uri = Uri.parse("https://www.google.com.br/search?q=jojo's_dank_memes&source=lnms&tbm=isch");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    @OnClick(R.id.btnAlarme)
    public void Alarme(){
        Intent intent = new Intent(this,AlarmeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnSMS)
    public void Sms(){
        Intent intent = new Intent(this,MensagemActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.btnMapa)
    public void Mapa(){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:47.6,-122.3?z=11"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, 1);
            }

    }

    @OnClick(R.id.btnGoleta)
    public void goleta(){

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);
        }
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                debug("vai ficar sem nude");
            }
            if (photoFile != null) {
                Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                File f = new File(mCurrentPhotoPath);
                Uri contentUri = Uri.fromFile(f);
                mediaScanIntent.setData(contentUri);
                this.sendBroadcast(mediaScanIntent);
            }
        }


    }

    @OnClick(R.id.btnTelefone)
    public void telefone(){
        Intent intent = new Intent(this,TelefoneActivity.class);
        startActivity(intent);

    }
    public void debug(String s){
        Toast.makeText(getApplicationContext(),
                s,
                Toast.LENGTH_SHORT)
                .show();
    }
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @OnClick(R.id.btnFaustao)
    public void faustao(){
        int[] valores = {R.raw.churrasqueira_do_faustao,R.raw.faustao_errou,R.raw.faustao_errou2,R.raw.pegando_fogo_bicho};
        int num= new Random().nextInt(valores.length);
        MediaPlayer ring= MediaPlayer.create(MainActivity.this,valores[num]);

        ring.start();
    }

    @OnClick(R.id.btnCrono)
    public void cronometro(){
        Intent intent = new Intent(this,CronometroActivity.class);
        startActivity(intent);
    }
}
