package com.example.a1401587_0.t1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;
import android.provider.ContactsContract;
import butterknife.BindView;
import android.net.Uri;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MensagemActivity extends Activity {
    @BindView(R.id.btnContato) Button btnContato;
    @BindView(R.id.etContato) EditText etContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnContato)
    public void procuraContato(){
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Uri contactUri = data.getData();
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
                cursor.moveToFirst();
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);

                debug(number);
        }
        }
    }
    public void debug(String s){
        Toast.makeText(getApplicationContext(),
                s,
                Toast.LENGTH_SHORT)
                .show();
    }

    public void debug(Integer s){
        Toast.makeText(getApplicationContext(),
                s,
                Toast.LENGTH_SHORT)
                .show();
    }
}
