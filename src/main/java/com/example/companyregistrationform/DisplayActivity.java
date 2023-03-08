package com.example.companyregistrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Bundle extras = getIntent().getExtras();
        String CompanyName = extras.getString("CompanyName");
        String OwnerName = extras.getString("OwnerName");
        String CompanyAddress = extras.getString("CompanyAddress");
        String LandlineNumber = extras.getString("LandlineNumber");
        String Website = extras.getString("Website");
        String EmailID = extras.getString("EmailID");
        String GSTNumber = extras.getString("GSTNumber");
        String PanNumber = extras.getString("PanNumber");
        String MobileNumber = extras.getString("MobileNumber");
        String CEmailID = extras.getString("CEmailID");
        String CLandlineNumber = extras.getString("CLandlineNumber");
        String ExtentionNumber = extras.getString("ExtentionNumber");

        TextView CompanyNameTextView = findViewById(R.id.ecompany_name_textview);
        CompanyNameTextView.setText(CompanyName);


        TextView OwnerNameTextView = findViewById(R.id.eowner_name_textview);
        OwnerNameTextView.setText(OwnerName);


        TextView CompanyAddressTextView = findViewById(R.id.ecompany_address_textview);
        CompanyAddressTextView.setText(CompanyAddress);

        TextView LandlineNumberTextView = findViewById(R.id.enumber_textview);
        LandlineNumberTextView.setText(LandlineNumber);

        TextView WebsiteTextView = findViewById(R.id.ewebsite_textview);
        WebsiteTextView.setText(Website);

        TextView EmailIDTextView = findViewById(R.id.eemailid_textview);
        EmailIDTextView.setText(EmailID);

        TextView GSTNumberTextView = findViewById(R.id.egst_number_textview);
        GSTNumberTextView.setText(GSTNumber);

        TextView PanNumberTextView = findViewById(R.id.epan_number_textview);
        PanNumberTextView.setText(PanNumber);

//        TextView MobileNumberTextView = findViewById(R.id.emobile_number_textview);
//        MobileNumberTextView.setText(MobileNumber);
//
//        TextView CEmailIDTextView = findViewById(R.id.ecemailid_textview);
//        CEmailIDTextView.setText(CEmailID);
//
//        TextView CLandlineNumberTextView = findViewById(R.id.ecnumber_textview);
//        CLandlineNumberTextView.setText(CLandlineNumber);
//
//        TextView ExtentionNumberTextView = findViewById(R.id.eextention_number_textview);
//        ExtentionNumberTextView.setText(ExtentionNumber);

    }
}