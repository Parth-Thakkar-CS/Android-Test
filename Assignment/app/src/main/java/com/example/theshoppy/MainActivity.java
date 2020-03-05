package com.example.theshoppy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] arrayProvince = new String[]{"Ontario", "Quebec", "Nova Scotia", "New Brunswick", "Manitoba", "British Columbia", "Prince Edward Island", "Saskatchewan", "Alberta", "Newfoundland and Labrador"};
    private static final String[] arrayCountry = new String[]{"Canada", "United States of America"};
    private static final String[] arraySpinner = new String[]{"All", "Dell", "Hp", "Lenovo"};

    RadioGroup radioGroupOption, radioGroupLaptop, radioGroupDesktop;
    RadioButton radioButtonDesktop, radioButtonLaptop, radioButtonDesktopWebcam, radioButtonDesktopExternalHD, radioButtonLaptopCoolingMat, deskLap, radioButtonLaptopLaptopUsbCHub, radioButtonLaptopStand, radioTemp, radioTemp2;
    ScrollView scrollDesktop, scrollLaptop;
    ImageView imageLogo;
    Spinner spinnerBrand;
    LinearLayout layoutDell, layoutHp, layoutLenovo, layoutDelll, layoutHpl, layoutLenovol, layoutScrollDesktop, layoutDesktopAdditional, layoutLaptopAdditional;
    Button btnConfirm;
    TextView viewBrand, viewName, viewInvoice;
    CheckBox checkBoxSSD, checkBoxPrinter;

    int costSSD, costPrinter, costCoolingMat, costUsbCHub, costLaptopStand, costWebcam, costExternalHD, invoice, costDell, costHp, costLenovo, costDellL, costHpL, costLenovoL, brand;
    String myInvoice, brandName,SSD = "", Printer = "", handleDesktopPeripherals = "", handleLaptopPeripherals;
    float taxInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("The Shoppy");
        // scrollDesktop.setVisibility(View.GONE);
        // scrollLaptop.setVisibility(View.GONE);

        final AutoCompleteTextView autoCompleteTextViewProvince = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewProvince);
        final AutoCompleteTextView autoCompleteTextViewCountry = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewCountry);
        radioGroupOption = (RadioGroup) findViewById(R.id.radioGroupOption);
        radioButtonDesktop = (RadioButton) findViewById(R.id.radioButtonDesktop);
        radioButtonLaptop = (RadioButton) findViewById(R.id.radioButtonLaptop);
        radioButtonDesktopWebcam = (RadioButton) findViewById(R.id.radioButtonDesktopWebcam);
        radioButtonDesktopExternalHD = (RadioButton) findViewById(R.id.radioButtonDesktopExternalHD);
        radioButtonLaptopCoolingMat = (RadioButton) findViewById(R.id.radioButtonLaptopCoolingMat);
        radioButtonLaptopLaptopUsbCHub = (RadioButton) findViewById(R.id.radioButtonLaptopLaptopUsbCHub);
        radioButtonLaptopStand = (RadioButton) findViewById(R.id.radioButtonLaptopStand);
        scrollDesktop = (ScrollView) findViewById(R.id.scrollDesktop);
        scrollLaptop = (ScrollView) findViewById(R.id.scrollLaptop);
        imageLogo = (ImageView) findViewById(R.id.imageLogo);
        spinnerBrand = (Spinner) findViewById(R.id.spinnerBrand);
        layoutDell = (LinearLayout) findViewById(R.id.layoutDell);
        layoutHp = (LinearLayout) findViewById(R.id.layoutHp);
        layoutLenovo = (LinearLayout) findViewById(R.id.layoutLenovo);
        layoutDelll = (LinearLayout) findViewById(R.id.layoutDelll);
        layoutHpl = (LinearLayout) findViewById(R.id.layoutHpl);
        layoutLenovol = (LinearLayout) findViewById(R.id.layoutLenovol);
        layoutScrollDesktop = (LinearLayout) findViewById(R.id.layoutScrollDesktop);
        layoutDesktopAdditional = (LinearLayout) findViewById(R.id.layoutDesktopAdditional);
        layoutLaptopAdditional = (LinearLayout) findViewById(R.id.layoutLaptopAdditional);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        viewBrand = (TextView) findViewById(R.id.viewBrand);
        viewName = (TextView) findViewById(R.id.viewName);
        viewInvoice = (TextView) findViewById(R.id.viewInvoice);
        checkBoxSSD = (CheckBox) findViewById(R.id.checkBoxSSD);
        checkBoxPrinter = (CheckBox) findViewById(R.id.checkBoxPrinter);
        radioGroupLaptop = (RadioGroup) findViewById(R.id.radioGroupLaptop);
        radioGroupDesktop = (RadioGroup) findViewById(R.id.radioGroupDesktop);


        // Auto Complete Text View:
        autoCompleteTextViewProvince.setThreshold(2);
        ArrayAdapter<String> adapterProvince;
        adapterProvince = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arrayProvince);
        autoCompleteTextViewProvince.setAdapter(adapterProvince);

        autoCompleteTextViewCountry.setThreshold(2);
        ArrayAdapter<String> adapterCountry;
        adapterCountry = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arrayCountry);
        autoCompleteTextViewCountry.setAdapter(adapterCountry);


        // Array Adapter Spinner:
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBrand.setAdapter(adapter);

        spinnerBrand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                brand = position;
                brandName = parent.getItemAtPosition(position).toString();

                if (radioButtonDesktop.isChecked()) {
                    switch (position) {
                        case 0:
                            if (position == 0) {
                                layoutDell.setVisibility(View.VISIBLE);
                                layoutHp.setVisibility(View.VISIBLE);
                                layoutLenovo.setVisibility(View.VISIBLE);
                            }
                            break;
                        case 1:
                            if (position == 1) {
                                layoutDell.setVisibility(View.VISIBLE);
                                layoutHp.setVisibility(View.GONE);
                                layoutLenovo.setVisibility(View.GONE);
                            }
                            break;
                        case 2:
                            if (position == 2) {
                                layoutHp.setVisibility(View.VISIBLE);
                                layoutDell.setVisibility(View.GONE);
                                layoutLenovo.setVisibility(View.GONE);
                            }
                            break;
                        case 3:
                            if (position == 3) {
                                layoutLenovo.setVisibility(View.VISIBLE);
                                layoutHp.setVisibility(View.GONE);
                                layoutDell.setVisibility(View.GONE);
                            }
                            break;
                    }
                }
                else {
                    switch (position) {
                        case 0:
                            if (position == 0) {
                                layoutDelll.setVisibility(View.VISIBLE);
                                layoutHpl.setVisibility(View.VISIBLE);
                                layoutLenovol.setVisibility(View.VISIBLE);
                            }
                            break;
                        case 1:
                            if (position == 1) {
                                layoutDelll.setVisibility(View.VISIBLE);
                                layoutHpl.setVisibility(View.GONE);
                                layoutLenovol.setVisibility(View.GONE);
                            }
                            break;
                        case 2:
                            if (position == 2) {
                                layoutHpl.setVisibility(View.VISIBLE);
                                layoutDelll.setVisibility(View.GONE);
                                layoutLenovol.setVisibility(View.GONE);
                            }
                            break;
                        case 3:
                            if (position == 3) {
                                layoutLenovol.setVisibility(View.VISIBLE);
                                layoutHpl.setVisibility(View.GONE);
                                layoutDelll.setVisibility(View.GONE);
                            }
                            break;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                layoutDelll.setVisibility(View.VISIBLE);
                layoutHpl.setVisibility(View.VISIBLE);
                layoutLenovol.setVisibility(View.VISIBLE);
                layoutLenovo.setVisibility(View.VISIBLE);
                layoutHp.setVisibility(View.VISIBLE);
                layoutDell.setVisibility(View.VISIBLE);
            }
        });

        radioGroupOption.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radioButtonDesktop.isChecked()) {
                    scrollLaptop.setVisibility(View.GONE);
                    scrollDesktop.setVisibility(View.VISIBLE);
                    layoutDesktopAdditional.setVisibility(View.VISIBLE);
                    layoutLaptopAdditional.setVisibility(View.GONE);
                    radioButtonLaptopCoolingMat.setChecked(false);
                    radioButtonLaptopLaptopUsbCHub.setChecked(false);
                    radioButtonLaptopStand.setChecked(false);

                } else if (radioButtonLaptop.isChecked()) {
                    scrollDesktop.setVisibility(View.GONE);
                    scrollLaptop.setVisibility(View.VISIBLE);
                    layoutDesktopAdditional.setVisibility(View.GONE);
                    layoutLaptopAdditional.setVisibility(View.VISIBLE);
                    radioButtonDesktopWebcam.setChecked(false);
                    radioButtonDesktopExternalHD.setChecked(false);

                }
            }
        });

        checkBoxSSD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    costSSD = 60;
                    SSD = "SSD";
                }
                if (!b) {
                    costSSD -= 60;
                    SSD = "";
                }
            }
        });

        checkBoxPrinter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    costPrinter = 100;
                    Printer = "Printer";
                }
                if (!b) {
                    costPrinter -= 100;
                    Printer = "";
                }
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                viewInvoice.setVisibility(View.VISIBLE);

                if (radioButtonDesktop.isChecked()) {
                    switch (brand) {
                        case 0:
                            viewBrand.setTextColor(R.color.colorAccent);
                            break;

                        case 1:
                            costDell = 475;
                            // Toast.makeText(MainActivity.this, "Dell: " + costDell, Toast.LENGTH_SHORT).show();
                            break;

                        case 2:
                            costHp = 400;
                            break;

                        case 3:
                            costLenovo = 450;
                    }
                } else {
                    switch (brand) {
                        case 0:
                            viewBrand.setTextColor(R.color.colorAccent);
                            break;

                        case 1:
                            costDellL = 1250;
                            break;

                        case 2:
                            costHpL = 1150;
                            break;

                        case 3:
                            costLenovoL = 1550;
                            break;
                    }
                }

                int radioGroup = radioGroupLaptop.getCheckedRadioButtonId();
                radioTemp = (RadioButton) findViewById(radioGroup);
                switch (radioGroup) {
                    case R.id.radioButtonLaptopCoolingMat:
                        if (radioButtonLaptopCoolingMat.isChecked()) {
                            costCoolingMat = 33;
                        }
                        else {
                            costCoolingMat = 0;
                        }
                        break;

                    case R.id.radioButtonLaptopLaptopUsbCHub:
                        if (radioButtonLaptopLaptopUsbCHub.isChecked()) {
                            costUsbCHub = 60;
                        }
                        else {
                            costUsbCHub = 0;
                        }
                        break;

                    case R.id.radioButtonLaptopStand:
                        if (radioButtonLaptopStand.isChecked()) {
                            costLaptopStand = 139;
                        }
                        else {
                            costLaptopStand = 0;
                        }
                        break;
                }

                int radioGroupDesk = radioGroupDesktop.getCheckedRadioButtonId();
                radioTemp2 = (RadioButton) findViewById(radioGroup);
                switch (radioGroupDesk) {
                    case R.id.radioButtonDesktopWebcam:
                        if (radioButtonDesktopWebcam.isChecked()) {
                            costWebcam = 95;
                        }
                        else {
                            costWebcam = 0;
                        }
                        break;

                    case R.id.radioButtonDesktopExternalHD:
                        if (radioButtonDesktopExternalHD.isChecked()) {
                            costExternalHD = 64;
                        }
                        else {
                            costExternalHD = 0;
                        }
                        break;
                }

                invoice = costSSD + costPrinter + costCoolingMat +costExternalHD +costLaptopStand + costWebcam + costUsbCHub + costDell + costHp + costLenovo + costDellL + costHpL + costLenovoL;
                taxInvoice = (float)invoice * 0.13f + invoice;


//                handleDesktopPeripherals = radioTemp2.getText().toString();
//
//                handleLaptopPeripherals = radioTemp.getText().toString();

                int selectedComputer = radioGroupOption.getCheckedRadioButtonId();
                deskLap = (RadioButton)findViewById(selectedComputer) ;
                myInvoice = "Customer Name: " + viewName.getText().toString() + "\n" +
                            "Province: " + autoCompleteTextViewProvince.getText().toString() + "\n" +
                            "Computer: " + deskLap.getText().toString() + "\n" +
                            "Brand: " + brandName + "\n" +
                            "Additional: "+ SSD + Printer + "\n" +
                            "Added Pheripheral: " + "\n" +
                            "Cost: " + taxInvoice;
                viewInvoice.setText(myInvoice);
            }
        });
    }
}