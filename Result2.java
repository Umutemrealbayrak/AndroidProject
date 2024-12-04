// ResultActivity.java içinde

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Result2 extends AppCompatActivity {

    private TextView txtResult;
    private Button myButton;
    private Spinner spinnerIlceler;
    private Button button1;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = findViewById(R.id.txtResult);
        button1 = findViewById(R.id.button1);
        myButton  =findViewById(R.id.myButton);
        spinnerIlceler = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);


        // Firebase'den verileri çek ve ekranda göster
        fetchAndDisplayIlceler();
        String[] ilceAdlari = {"Adalar", "Ataşehir", "Bakırköy", "Beşiktaş", "Fatih" ,"Kadıköy","Kartal","Sarıyer"};

        // ArrayAdapter ile Spinner'ı doldur
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ilceAdlari);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIlceler.setAdapter(adapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedIlce = spinnerIlceler.getSelectedItem().toString();
                if(selectedIlce=="Adalar") {
                    textView.setText(" İstanbul'un en küçük ilçesidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 10.000'dir. İlçenin belediye başkanı CHP'li Erdem Gül'dür. İlçenin yüzölçümü 15,36 km²'dir. İlçenin ortalama ev fiyatları 10.000.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, doğal güzellikleri ile ünlü birçok ada bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Ataşehir") {
                    textView.setText("İstanbul'un en yeni ilçelerinden biridir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 485.859'dur. İlçenin belediye başkanı AK Partili Battal İlgezdi'dir. İlçenin yüzölçümü 24,25 km²'dir. İlçenin ortalama ev fiyatları 8.000.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, modern bir yaşam tarzı hakimdir.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Bakırköy") {
                    textView.setText("İstanbul'un en önemli sahil ilçelerinden biridir. Ticaret ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 774.689'dur. İlçenin belediye başkanı CHP'li Bülent Kerimoğlu'dur. İlçenin yüzölçümü 38,09 km²'dir. İlçenin ortalama ev fiyatları 7.500.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, sahil turizmi ve ticaret gelişmiştir.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Beşiktaş") {
                    textView.setText(" İstanbul'un en önemli kültür ve sanat merkezlerinden biridir. Ticaret ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 226.279'dur. İlçenin belediye başkanı AK Partili Rıza Akpolat'tır. İlçenin yüzölçümü 22,18 km²'dir. İlçenin ortalama ev fiyatları 8.500.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, Boğaz manzaralı birçok tarihi ve turistik yer bulunmaktadır.    :\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Fatih") {
                    textView.setText("İstanbul'un en tarihi ilçesidir. Kültür ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 700.000'dir. İlçenin belediye başkanı AK Partili Ergün Turan'dır. İlçenin yüzölçümü 100,66 km²'dir. İlçenin ortalama ev fiyatları 8.000.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, Ayasofya, Topkapı Sarayı, Sultanahmet Camii gibi dünyaca ünlü tarihi ve turistik yerler bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Kadıköy") {
                    textView.setText(" İstanbul'un en önemli kültür ve sanat merkezlerinden biridir. Ticaret ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 804.428'dir. İlçenin belediye başkanı CHP'li Şerdil Dara Odabaşı'dır. İlçenin yüzölçümü 100,30 km²'dir. İlçenin ortalama ev fiyatları 9.000.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, Kadıköy Moda, Kadıköy Yeldeğirmeni gibi önemli kültür ve sanat merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Kartal") {
                    textView.setText(" İstanbul'un en önemli sahil ilçelerinden biridir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 786.061'dir. İlçenin belediye başkanı AK Partili Gökhan Yüksel'dir. İlçenin yüzölçümü 30,05 km²'dir. İlçenin ortalama ev fiyatları 6.000.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, sahil turizmi ve sanayi gelişmiştir.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Sarıyer") {
                    textView.setText("İstanbul'un en büyük ikinci ilçesidir. Tarım ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 314.551'dir. İlçenin belediye başkanı Ak Partili Şükrü Genç'tir. İlçenin yüzölçümü 420,74 km²'dir. İlçenin ortalama ev fiyatları 6.500.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, sebze, meyve, tahıl ve hayvancılık faaliyetleri yaygındır.:\n" + selectedIlce.toString());
                }

            }
        });
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result2.this, MainActivity.class);
                startActivity(intent);
                // ResultActivity'yi kapat
                finish();// Geri tuşuna basıldığında yapılacak işlemleri buraya ekleyebilirsiniz.
            }
        });


    }




    private void fetchAndDisplayIlceler() {
        DatabaseReference ilcelerRef = FirebaseDatabase.getInstance().getReference("iyi");

        ilcelerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Veritabanındaki her bir çocuk (ilçe) üzerinde dön
                StringBuilder ilceResult = new StringBuilder();
                for (DataSnapshot ilceSnapshot : dataSnapshot.getChildren()) {
                    String ilceAdi = ilceSnapshot.getKey();
                    String yasabilirlik = ilceSnapshot.child("iyi").getValue(String.class);

                    // Burada ilceAdi ve yasabilirlik değerlerini kullanarak bir şeyler yapabilirsiniz.
                    // Örneğin, bir StringBuilder'a ekleyebilirsiniz.
                    ilceResult.append(ilceAdi);
                }

                // Sonucu ekrana yazdır
                txtResult.setText("SİZE ÖNEREBİLECEĞİM İLÇELER:\n" + ilceResult.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Hata durumunda yapılacaklar
            }
        });
    }
}
