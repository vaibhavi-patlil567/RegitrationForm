package com.example.companyregistrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText ecompany_name, eowner_name, ecompany_address, enumber, ewebsite, eemailid, egst_number,
            epan_number, emobile_number, ecemailid, ecnumber, eextention_number, epassword, erepassword ;
    Button submit_button, echoose_file;
    Spinner estate, ecity, eposition;
    RadioButton option1, option2;




    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView company_details = (TextView) findViewById(R.id.company_Details);
        company_details.setPaintFlags(company_details.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TextView contact_details = (TextView) findViewById(R.id.contact_details);
        contact_details.setPaintFlags(contact_details.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        estate = findViewById(R.id.estate);
        ecity = findViewById(R.id.ecity);
        eposition =findViewById(R.id.eposition);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        ecompany_name = findViewById(R.id.ecompany_name);
        eowner_name = findViewById(R.id.eowner_name);
        ecompany_address = findViewById(R.id.ecompany_address);
        enumber = findViewById(R.id.enumber);
        ewebsite = findViewById(R.id.ewebsite);
        eemailid = findViewById(R.id.eemailid);
        egst_number = findViewById(R.id.egst_number);
        epan_number = findViewById(R.id.epan_number);
        emobile_number = findViewById(R.id.emobile_number);
        ecemailid = findViewById(R.id.ecemailid);
        ecnumber = findViewById(R.id.ecnumber);
        eextention_number = findViewById(R.id.eextention_number);
        epassword = findViewById(R.id.epassword);
        erepassword = findViewById(R.id.erepassword);
        submit_button = findViewById(R.id.submit_button);

        submit_button.setOnClickListener(v -> {

            Intent intent = new Intent(this, DisplayActivity.class);
            String CompanyName = ecompany_name.getText().toString();
            String OwnerName = eowner_name.getText().toString();
            String CompanyAddress = ecompany_address.getText().toString();
            String LandlineNumber = enumber.getText().toString();
            String Website = ewebsite.getText().toString();
            String EmailID = eemailid.getText().toString();
            String GSTNumber = egst_number.getText().toString();
            String PanNumber = epan_number.getText().toString();
            String MobileNumber = emobile_number.getText().toString();
            String CEmailID = ecemailid.getText().toString();
            String CLandlineNumber = ecnumber.getText().toString();
            String ExtentionNumber = eextention_number.getText().toString();
            String Password = epassword.getText().toString();
            String RePassword = erepassword.getText().toString();


            intent.putExtra("CompanyName", CompanyName);
            intent.putExtra("OwnerName", OwnerName);
            intent.putExtra("CompanyAddress", CompanyAddress);
            intent.putExtra("LandlineNumber", LandlineNumber);
            intent.putExtra("Website", Website);
            intent.putExtra("EmailID", EmailID);
            intent.putExtra("GSTNumber", GSTNumber);
            intent.putExtra("PanNumber", PanNumber);
            intent.putExtra("MobileNumber", MobileNumber);
            intent.putExtra("CEmailID", CEmailID);
            intent.putExtra("CLandlineNumber", CLandlineNumber);
            intent.putExtra("ExtentionNumber", ExtentionNumber);
            intent.putExtra("Password", Password);
            intent.putExtra("RePassword", RePassword);

            submit_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkValidation();
                }
            });


            startActivity(intent);

        });
    }

    int requestcode = 1;

    public void checkValidation() {
        if (checkEmpty(ecompany_name)) {
            ecompany_name.setError("Company Name Empty Field Not Allowed");
        }
        if (checkEmpty(eowner_name)) {
            eowner_name.setError("Owner Name Empty Field Not Allowed");
        }
        if (checkEmpty(ecompany_address)) {
            ecompany_address.setError("Company Address Empty Field Not Allowed");
        }
        if (checkEmpty(enumber)) {
            enumber.setError("Mobile Number Empty Field Not Allowed");
        }
        if (checkEmpty(ewebsite)) {
            ewebsite.setError("Website Empty Field Not Allowed");
        }
        if (checkEmpty(eemailid)) {
            eemailid.setError("Mobile Number Empty Field Not Allowed");
        }
        if (checkEmpty(egst_number)) {
            egst_number.setError("GST Number Empty Field Not Allowed");
        }
        if (checkEmpty(epan_number)) {
            epan_number.setError("Pan Number Empty Field Not Allowed");
        }
        if (checkEmpty(emobile_number)) {
            emobile_number.setError("Mobile Number Empty Field Not Allowed");
        }
        if (checkEmpty(ecemailid)) {
            ecemailid.setError("Mobile Number Empty Field Not Allowed");
        }
        if (checkEmpty(ecnumber)) {
            ecnumber.setError("Landline Number Empty Field Not Allowed");
        }
        if (checkEmpty(eextention_number)) {
            eextention_number.setError("Extention Number Empty Field Not Allowed");
        }
        if (checkEmpty(epassword)) {
            epassword.setError("Password Empty Field Not Allowed");
        }
        if (checkEmpty(erepassword)) {
            erepassword.setError("Re-Password Empty Field Not Allowed");
        }

        if (!checkCompanyName(ecompany_name)) {
            ecompany_name.setError("Company Name Digit Must Be 50:");
        }
        if (!checkOwnerName(eowner_name)) {
            eowner_name.setError("Owner Name Digit Must Be 30:");
        }
        if (!checkLength(enumber)) {
            enumber.setError("Landline Number Digit Must Be 11:");
        }
        if (!checkWebsite(ewebsite)) {
            ewebsite.setError("Website Must be in staring :");
        }
        if (!checkEmailID(eemailid)) {
            eemailid.setError("EmailID Must be  :");
        }
//        if (!checkGSTNumber(egst_number)) {
//            egst_number.setError("GST Number Must Be 15:");
//        }
//        if (!checkPanNumber(epan_number)) {
//            epan_number.setError("Pan Card Number Must Be 10:");
//        }
//        if (!checkMobile(emobile_number)) {
//            emobile_number.setError("Mobile Number Digit Must Be 10:");
//        }
//        if (!checkCEmailID(ecemailid)) {
//            ecemailid.setError("EmailID Must be  :");
//        }
//        if (!checkLandline(ecnumber)) {
//            ecnumber.setError("CLandline Number Digit Must Be 11:");
//        }
//        if (!checkExtention(eextention_number)) {
//            eextention_number.setError("Extention Number Digit Must Be 10:");
//        }

    }

    boolean checkEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean checkCompanyName(EditText text) {
        CharSequence str = text.getText().toString();
        return (str.length() > 10);
    }

    boolean checkOwnerName(EditText text) {
        CharSequence str = text.getText().toString();
        return (str.length() > 10);
    }

    boolean checkWebsite(EditText text) {
        CharSequence ewebsite = text.getText().toString();
        return (Patterns.WEB_URL.matcher(ewebsite).matches());
    }

    boolean checkEmailID(EditText text) {
        CharSequence eemailid = text.getText().toString();
        return (Patterns.EMAIL_ADDRESS.matcher(eemailid).matches());
    }

    boolean checkLength(EditText text) {
        CharSequence str = text.getText().toString();
        return (str.length() == 11);
    }

//    public static boolean isValidGSTNumber(String s) {
//        Pattern egst_number_pattern = Pattern.compile("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}+$\n");
//        return egst_number_pattern.matcher(s).matches();
//    }
//
//    boolean checkGSTNumber(EditText text) {
//        CharSequence str = text.getText().toString();
//        return (str.length() == 15 && isValidGSTNumber(text.getText().toString()));
//    }
//
//    public static boolean isValidPanNumber(String t) {
//        Pattern epan_number_pattern = Pattern.compile("^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$\n");
//        return epan_number_pattern.matcher(t).matches();
//    }
//
//    boolean checkPanNumber(EditText text) {
//        CharSequence str = text.getText().toString();
//        return (str.length() == 10 && isValidPanNumber(text.getText().toString()));
//    }
//    boolean checkMobile(EditText text) {
//        CharSequence emobile_number = text.getText().toString();
//        return (emobile_number.length() == 10);
//    }
//    boolean checkCEmailID(EditText text) {
//        CharSequence ecemailid = text.getText().toString();
//        return (Patterns.EMAIL_ADDRESS.matcher(ecemailid).matches());
//    }
//    boolean checkLandline(EditText text) {
//        CharSequence ecnumber = text.getText().toString();
//        return (ecnumber.length() == 11);
//    }
//    boolean checkExtention(EditText text) {
//        CharSequence eextention_number = text.getText().toString();
//        return (eextention_number.length() == 10);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Context context = getApplicationContext();
        if (requestcode == requestcode && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }
            Uri uri = data.getData();
            Toast.makeText(context,uri.getPath(), Toast.LENGTH_SHORT).show();
        }
    }
    public void openfilechooser(View view)
    {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, requestcode);
    }
}