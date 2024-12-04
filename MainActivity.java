package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText etUlasim, etGuvenlik, etAltyapi, etFiyat, etCevresel, etYatirim, etSosyal, etKonut;
    private Button btnPredict;
    private TextView txtPrediction;

    // DatabaseReference tanımlaması
    private DatabaseReference ilcelerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUlasim = findViewById(R.id.etUlasim);
        etGuvenlik = findViewById(R.id.etGuvenlik);
        etAltyapi = findViewById(R.id.etAltyapi);
        etFiyat = findViewById(R.id.etFiyat);
        etCevresel = findViewById(R.id.etCevresel);
        etYatirim = findViewById(R.id.etYatirim);
        etSosyal = findViewById(R.id.etSosyal);
        etKonut = findViewById(R.id.etKonut);
        btnPredict = findViewById(R.id.btnPredict);
        txtPrediction = findViewById(R.id.txtPrediction);

        // DatabaseReference'in Firebase düğümüne işaret etmesi için tanımlanması
        ilcelerRef = FirebaseDatabase.getInstance().getReference("iyi");

        btnPredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculateAndDisplayPrediction();
                // Firebase'den ilçeleri çekip ekrana yazdır

                // Tahmin metnini al
                String predictionText = txtPrediction.getText().toString();

                if(predictionText == "."){
                // ResultActivity'yi başlatmak için bir Intent oluşturun
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                // Prediction metnini ResultActivity'ye geçirin
                intent.putExtra("predictionText", predictionText);

                // ResultActivity'yi başlatın
                startActivity(intent);

            }
                if(predictionText == ".."){
                    // ResultActivity'yi başlatmak için bir Intent oluşturun
                    Intent intent = new Intent(MainActivity.this, Result2.class);

                    // Prediction metnini ResultActivity'ye geçirin
                    intent.putExtra("predictionText", predictionText);

                    // ResultActivity'yi başlatın
                    startActivity(intent);

                }
                if(predictionText == ","){
                    // ResultActivity'yi başlatmak için bir Intent oluşturun
                    Intent intent = new Intent(MainActivity.this, Result1.class);

                    // Prediction metnini ResultActivity'ye geçirin
                    intent.putExtra("predictionText", predictionText);

                    // ResultActivity'yi başlatın
                    startActivity(intent);

                }}
        });


    }

    private void calculateAndDisplayPrediction() {
        try {
            // Kullanıcının girdiği değerleri al
            double ulasim = Double.parseDouble(etUlasim.getText().toString());
            double guvenlik = Double.parseDouble(etGuvenlik.getText().toString());
            double altyapi = Double.parseDouble(etAltyapi.getText().toString());
            double fiyat = Double.parseDouble(etFiyat.getText().toString());
            double cevresel = Double.parseDouble(etCevresel.getText().toString());
            double yatirim = Double.parseDouble(etYatirim.getText().toString());
            double sosyal = Double.parseDouble(etSosyal.getText().toString());
            double konut = Double.parseDouble(etKonut.getText().toString());

            // Ortalamayı hesapla
            double average = (ulasim + guvenlik + altyapi + fiyat + cevresel + yatirim + sosyal + konut) / 8;

            // Sonucu ekrana yazdır
            displayResult(average);
        } catch (NumberFormatException e) {
            // Kullanıcının girdiği değerler sayısal bir formata dönüştürülemezse buraya düşer.
            txtPrediction.setText("Lütfen tüm puanları doğru bir şekilde giriniz.");
        }
    }

    private void fetchAndDisplayIlceler() {
        ilcelerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Veritabanındaki her bir çocuk (ilçe) üzerinde dön
                StringBuilder ilceResult = new StringBuilder();
                for (DataSnapshot ilceSnapshot : dataSnapshot.getChildren()) {
                    String ilceAdi = ilceSnapshot.getKey();
                    String yasabilirlik = ilceSnapshot.child("iyi1").getValue(String.class);

                    // Burada ilceAdi ve yasabilirlik değerlerini kullanarak bir şeyler yapabilirsiniz.
                    // Örneğin, bir StringBuilder'a ekleyebilirsiniz.
                    ilceResult.append(ilceAdi).append(": ").append(yasabilirlik).append("\n");
                }


                // Sonucu ekrana yazdır
                txtPrediction.append("\nFirebase'den çekilen ilçeler:\n" + ilceResult.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Hata durumunda yapılacaklar
            }
        });
    }

    public void displayResult(double average) {
        // Ortalamaya göre durumu belirle
        if (average >= 1 && average <= 5) {
            txtPrediction.setText(".");

        } else if (average > 5 && average <= 7) {
            txtPrediction.setText(",");

        } else if (average > 7 && average <= 10) {
            txtPrediction.setText("..");

        }
    }
}
