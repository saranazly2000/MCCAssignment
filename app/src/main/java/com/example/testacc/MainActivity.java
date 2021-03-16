package com.example.testacc;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editTextUserName;
    EditText editTextUserAddress;
    EditText editTextUserNumber;
    ProgressDialog progressDialog;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName=findViewById(R.id.user_name);
        editTextUserAddress=findViewById(R.id.user_address);
        editTextUserNumber=findViewById(R.id.user_number);

    }
    public void saveToFirebase(View v){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        String userName=editTextUserName.getText().toString();
        String userAddress=editTextUserAddress.getText().toString();
        String userNumber=editTextUserNumber.getText().toString();
        Map<String, Object> user = new HashMap<>();
        user.put("name", userName);
        user.put("address", userAddress);
        user.put("number", userNumber);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "DocumentSnapshot added with ID: " );
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document");
                    }
                });
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        progressDialog.dismiss();
    }
}
