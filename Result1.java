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

public class Result1 extends AppCompatActivity {

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
        String[] ilceAdlari = {
                "Arnavutköy", "Avcılar", "Bahçelievler", "Başakşehir", "Beykoz", "Beylikdüzü", "Beyoğlu", "Büyükçekmece", "Esenler", "Esenyurt", "Eyüp", "Güngören", "Kağıthane", "Kâğıthane", "Küçükçekmece", "Maltepe", "Pendik", "Silivri", "Sultanbeyli", "Tuzla", "Zeytinburnu", "Çekmeköy", "Ümraniye"};

        // ArrayAdapter ile Spinner'ı doldur
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ilceAdlari);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIlceler.setAdapter(adapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedIlce = spinnerIlceler.getSelectedItem().toString();
                if(selectedIlce=="Arnavutköy") {
                    textView.setText("İstanbul'un en kalabalık 11. ilçesidir. Tarım ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 384.880'dir. İlçenin belediye başkanı Ak Partili Ahmet Haşim Baltacı'dır. İlçenin yüzölçümü 222,27 km²'dir. İlçenin ortalama ev fiyatları 2.500.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, tarihi ve turistik birçok yer bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Avcılar") {
                    textView.setText("İstanbul'un en kalabalık 12. ilçesidir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 439.714'tür. İlçenin belediye başkanı Ak Partili Turan Hançerli'dir. İlçenin yüzölçümü 32,50 km²'dir. İlçenin ortalama ev fiyatları 3.500.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Bahçelievler") {
                    textView.setText("İstanbul'un en kalabalık 6. ilçesidir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 820.636'dır. İlçenin belediye başkanı Ak Partili Mehmet Demir'dir. İlçenin yüzölçümü 15,15 km²'dir. İlçenin ortalama ev fiyatları 4.000.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Başakşehir") {
                    textView.setText(" İstanbul'un en kalabalık 5. ilçesidir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 1.221.146'dır. İlçenin belediye başkanı Ak Partili Yasin Kartoğlu'dur. İlçenin yüzölçümü 43,67 km²'dir. İlçenin ortalama ev fiyatları 6.000.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Beykoz") {
                    textView.setText(" İstanbul'un en büyük ilçesidir. Tarım ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 348.046'dır. İlçenin belediye başkanı Ak Partili Murat Aydın'dır. İlçenin yüzölçümü 650,18 km²'dir. İlçenin ortalama ev fiyatları 4.500.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sebze, meyve, tahıl ve hayvancılık faaliyetleri yaygındır. Doğa güzellikleriyle ünlü birçok yer bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Beylikdüzü") {
                    textView.setText("İstanbul'un en kalabalık 4. ilçesidir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 872.219'dur. İlçenin belediye başkanı Ak Partili Mehmet Murat Çalık'tır. İlçenin yüzölçümü 36,53 km²'dir. İlçenin ortalama ev fiyatları 5.000.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Beyoğlu") {
                    textView.setText(" İstanbul'un en merkezi ilçesidir. Ticaret ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 260.350'dir. İlçenin belediye başkanı CHP'li Haydar Ali Yıldız'dır. İlçenin yüzölçümü 9,02 km²'dir. İlçenin ortalama ev fiyatları 5.500.000 TL'dir. İlçenin tarihi, Bizans dönemin:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Büyükçekmece") {
                    textView.setText("İstanbul'un en büyük gölüne ev sahipliği yapmaktadır. Tarım ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 1.134.254'tür. İlçenin belediye başkanı Ak Partili Hasan Akgün'dür. İlçenin yüzölçümü 309,25 km²'dir. İlçenin ortalama ev fiyatları 5.000.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, sebze, meyve, tahıl ve hayvancılık faaliyetleri yaygındır. Doğa güzellikleriyle ünlü birçok yer bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Esenler") {
                    textView.setText("İstanbul'un en kalabalık 7. ilçesidir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 933.841'dir. İlçenin belediye başkanı Ak Partili Mehmet Tevfik Göksu'dur. İlçenin yüzölçümü 20,65 km²'dir. İlçenin ortalama ev fiyatları 4.500.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Esenyurt") {
                    textView.setText("İstanbul'un en kalabalık 3. ilçesidir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 1.295.842'dir. İlçenin belediye başkanı Ak Partili Kemal Deniz Bozkurt'tur. İlçenin yüzölçümü 299,26 km²'dir. İlçenin ortalama ev fiyatları 6.000.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Eyüp") {
                    textView.setText("İstanbul'un en tarihi ilçelerinden biridir. Tarım ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 322.809'dur. İlçenin belediye başkanı Ak Partili Deniz Köken'dir. İlçenin yüzölçümü 111,29 km²'dir. İlçenin ortalama ev fiyatları 5.000.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, tarihi ve turistik birçok yer bulunmaktadır.\n" +
                            "\n:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Güngören") {
                    textView.setText("İstanbul'un en kalabalık 8. ilçesidir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 854.643'tür. İlçenin belediye başkanı Ak Partili Şakir Yücel Karaman'dır. İlçenin yüzölçümü 19,44 km²'dir. İlçenin ortalama ev fiyatları 4.000.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.\n" +
                            "\n:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Kağıthane") {
                    textView.setText("İstanbul'un en önemli sanayi merkezlerinden biridir. İlçelerin nüfusu 2023 yılı nüfus sayımına göre sırasıyla 568.847 ve 639.956'dır. İlçelerin belediye başkanları Ak Partili Mevlüt Uysal ve Mevlüt Öztekin'dir. İlçelerin yüzölçümü sırasıyla 37,52 ve 29,27 km²'dir. İlçelerin ortalama ev fiyatları sırasıyla 5.500.000 TL ve 6.000.000 TL'dir. İlçelerin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçelerde, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Küçükçekmece") {
                    textView.setText("İstanbul'un en kalabalık 2. ilçesidir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 1.291.699'dur. İlçenin belediye başkanı Ak Partili Kemal Çebi'dir. İlçenin yüzölçümü 327,54 km²'dir. İlçenin ortalama ev fiyatları 5.500.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Maltepe") {
                    textView.setText("İstanbul'un en önemli sahil ilçelerinden biridir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 804.428'dir. İlçenin belediye başkanı Ak Partili Ali Kılıç'tır. İlçenin yüzölçümü 100,30 km²'dir. İlçenin ortalama ev fiyatları 6.000.000 TL'dir:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Pendik") {
                    textView.setText(" İstanbul'un en önemli sahil ilçelerinden biridir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 774.689'dur. İlçenin belediye başkanı Ak Partili Ahmet Cin'dir. İlçenin yüzölçümü 82,12 km²'dir. İlçenin ortalama ev fiyatları 6.500.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, sahil turizmi ve sanayi gelişmiştir.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Silivri") {
                    textView.setText(" İstanbul'un en batısında yer alan ilçesidir. Tarım ve turizm merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 304.240'dır. İlçenin belediye başkanı Ak Partili Volkan Yılmaz'dır. İlçenin yüzölçümü 680,27 km²'dir. İlçenin ortalama ev fiyatları 5.000.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, sebze, meyve, tahıl ve hayvancılık faaliyetleri yaygındır. Doğa güzellikleriyle ünlü birçok yer bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Sultanbeyli") {
                    textView.setText(" İstanbul'un en önemli sanayi merkezlerinden biridir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 758.440'dır. İlçenin belediye başkanı Ak Partili Hüseyin Keskin'dir. İlçenin yüzölçümü 132,94 km²'dir. İlçenin ortalama ev fiyatları 5.000.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Tuzla") {
                    textView.setText("İstanbul'un en önemli sahil ilçelerinden biridir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 731.495'tir. İlçenin belediye başkanı Ak Partili Şadi Yazıcı'dır. İlçenin yüzölçümü 84,67 km²'dir. İlçenin ortalama ev fiyatları 6.500.000 TL'dir. İlçenin tarihi, Bizans dönemine kadar uzanmaktadır. İlçede, sahil turizmi ve sanayi gelişmiştir.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Zeytinburnu") {
                    textView.setText("İstanbul'un en kalabalık 9. ilçesidir. Sanayi ve ticaret merkezidir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 838.376'dır. İlçenin belediye başkanı Ak Partili Ömer Arısoy'dur. İlçenin yüzölçümü 30,91 km²'dir. İlçenin ortalama ev fiyatları 5.000.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Çekmeköy") {
                    textView.setText("İstanbul'un en önemli sanayi merkezlerinden biridir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 695.521'dir. İlçenin belediye başkanı Ak Partili Ahmet Poyraz'dır. İlçenin yüzölçümü 34,54 km²'dir. İlçenin ortalama ev fiyatları 6.500.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="Ümraniye") {
                    textView.setText("İstanbul'un en önemli sanayi merkezlerinden biridir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 854.396'dır. İlçenin belediye başkanı Ak Partili İsmet Yıldırım'dır. İlçenin yüzölçümü 51,31 km²'dir. İlçenin ortalama ev fiyatları 6.000.000 TL'dir. İlçenin tarihi, Osmanlı dönemine kadar uzanmaktadır. İlçede, sanayi ve ticaret merkezleri bulunmaktadır.:\n" + selectedIlce.toString());
                }



            }
        });
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result1.this, MainActivity.class);
                startActivity(intent);
                // ResultActivity'yi kapat
                finish();// Geri tuşuna basıldığında yapılacak işlemleri buraya ekleyebilirsiniz.
            }
        });


    }




    private void fetchAndDisplayIlceler() {
        DatabaseReference ilcelerRef = FirebaseDatabase.getInstance().getReference("orta");

        ilcelerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Veritabanındaki her bir çocuk (ilçe) üzerinde dön
                StringBuilder ilceResult = new StringBuilder();
                for (DataSnapshot ilceSnapshot : dataSnapshot.getChildren()) {
                    String ilceAdi = ilceSnapshot.getKey();
                    String yasabilirlik = ilceSnapshot.child("orta").getValue(String.class);

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
