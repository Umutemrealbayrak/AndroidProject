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

public class ResultActivity extends AppCompatActivity {

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
        String[] ilceAdlari = {"BAYRAMPAŞA", "BAĞCILAR", "GAZİOSMANPAŞA", "SANCAKTEPE", "SULTANGAZİ" ,"ÇATALCA"};

        // ArrayAdapter ile Spinner'ı doldur
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ilceAdlari);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIlceler.setAdapter(adapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedIlce = spinnerIlceler.getSelectedItem().toString();
                if(selectedIlce=="BAYRAMPAŞA") {
                    textView.setText("Bayrampaşa, İstanbul'un önemli ulaşım merkezlerinden biridir. Yüzölçümü 34,37 km²'dir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 551.414'tür. İlçenin belediye başkanı Ak Parti'li Atila Aydıner'dir.\n" + "Bayrampaşa, İstanbul'un önemli sanayi ve ticaret merkezlerinden biridir. İlçede tekstil, kimya, metal ve gıda gibi sektörlerde faaliyet gösteren birçok fabrika bulunmaktadır. Ayrıca, Bayrampaşa'da önemli bir ticaret merkezi bulunmaktadır.\n" + ":\n" + selectedIlce.toString());
                }
                if(selectedIlce=="BAĞCILAR") {
                    textView.setText("İstanbul'un en kalabalık ilçesidir. Yüzölçümü 36,48 km²'dir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 775.760'tur. İlçenin belediye başkanı Ak Parti'li Abdullah Özdemir'dir.\n" +
                            "Bağcılar, İstanbul'un önemli sanayi ve ticaret merkezlerinden biridir. İlçede tekstil, kimya, metal ve gıda gibi sektörlerde faaliyet gösteren birçok fabrika bulunmaktadır. Ayrıca, Bağcılar'da önemli bir ticaret merkezi bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="GAZİOSMANPAŞA") {
                    textView.setText("Gaziosmanpaşa, İstanbul'un bir ilçesidir. 2023 yılı nüfus sayımına göre nüfusu 469.969'dur. İlçenin belediye başkanı Ak Parti'li Hasan Tahsin Usta'dır. Yüzölçümü 20,26 km²'dir. Ortalama ev fiyatları 3.500.000 TL'dir. İlçenin tarihi, Osmanlı döneminde \"Küçükköy\" adıyla bir köy olarak kurulmasına dayanmaktadır. İstanbul'un en önemli sanayi ve ticaret merkezlerinden biridir. Ayrıca, İstanbul'un en önemli ulaşım merkezlerinden biridir.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="SANCAKTEPE") {
                    textView.setText(" İstanbul'un önemli sanayi ve ticaret merkezlerinden biridir. Yüzölçümü 24,16 km²'dir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 504.631'dir. İlçenin belediye başkanı Ak Parti'li Şeyma Döğücü'dür.\n" + "Sancaktepe, İstanbul'un önemli sanayi ve ticaret merkezlerinden biridir. İlçede tekstil, kimya, metal ve gıda gibi sektörlerde faaliyet gösteren birçok fabrika bulunmaktadır. Ayrıca, Sancaktepe'de önemli bir ticaret merkezi bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="SULTANGAZİ") {
                    textView.setText("İstanbul'un önemli sanayi ve ticaret merkezlerinden biridir. Yüzölçümü 22,52 km²'dir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 627.990'dur. İlçenin belediye başkanı Ak Parti'li Abdurrahman Dursun'dur.\n" +
                            "Sultangazi, İstanbul'un önemli sanayi ve ticaret merkezlerinden biridir. İlçede tekstil, kimya, metal ve gıda gibi sektörlerde faaliyet gösteren birçok fabrika bulunmaktadır. Ayrıca, Sultangazi'de önemli bir ticaret merkezi bulunmaktadır.:\n" + selectedIlce.toString());
                }
                if(selectedIlce=="ÇATALCA") {
                    textView.setText("İstanbul'un önemli tarım ve turizm merkezlerinden biridir. Yüzölçümü 779,31 km²'dir. İlçenin nüfusu 2023 yılı nüfus sayımına göre 157.656'dır. İlçenin belediye başkanı Ak Parti'li Mesut Üner'dir.\n" +
                            "Çatalca, İstanbul'un önemli tarım ve turizm merkezlerinden biridir. İlçede sebze, meyve, tahıl ve hayvancılık gibi faaliyetler yapılmaktadır. Ayrıca, Çatalca'da doğal güzellikleri ile ünlü birçok yer bulunmaktadır.:\n" + selectedIlce.toString());
                }

            }
        });
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                // ResultActivity'yi kapat
                finish();// Geri tuşuna basıldığında yapılacak işlemleri buraya ekleyebilirsiniz.
            }
        });


    }




    private void fetchAndDisplayIlceler() {
        DatabaseReference ilcelerRef = FirebaseDatabase.getInstance().getReference("kötü");

        ilcelerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Veritabanındaki her bir çocuk (ilçe) üzerinde dön
                StringBuilder ilceResult = new StringBuilder();
                for (DataSnapshot ilceSnapshot : dataSnapshot.getChildren()) {
                    String ilceAdi = ilceSnapshot.getKey();
                    String yasabilirlik = ilceSnapshot.child("kötü").getValue(String.class);

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
