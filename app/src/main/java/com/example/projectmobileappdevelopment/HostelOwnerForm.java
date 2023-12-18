package com.example.projectmobileappdevelopment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class HostelOwnerForm extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri imageUri;
    private HostelOwner hostelOwner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_owner_form);

        // Initialize Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("hostelOwners");

        // Initialize HostelOwner object
        hostelOwner = new HostelOwner();

        Button submitButton = findViewById(R.id.SubmitButton);
        submitButton.setOnClickListener(v -> submitForm());

        Button chooseImageButton = findViewById(R.id.buttonChooseImage);
        chooseImageButton.setOnClickListener(v -> openFileChooser());
    }

    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
        }
    }

    private void submitForm() {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String hostelName = ((EditText) findViewById(R.id.HostleName)).getText().toString();
        String location = ((EditText) findViewById(R.id.Location)).getText().toString();
        String contactNumber = ((EditText) findViewById(R.id.Cotact_Number)).getText().toString();

        CheckBox checkBoxWiFi = findViewById(R.id.checkBoxWiFi);
        CheckBox checkBoxParking = findViewById(R.id.checkBoxParking);
        CheckBox checkBoxLaundry = findViewById(R.id.checkBoxLaundry);

        boolean wifi = checkBoxWiFi.isChecked();
        boolean parking = checkBoxParking.isChecked();
        boolean laundry = checkBoxLaundry.isChecked();

        int singleRooms = Integer.parseInt(((EditText) findViewById(R.id.editTextSingleRooms)).getText().toString());
        double singlePrice = Double.parseDouble(((EditText) findViewById(R.id.editTextSinglePrice)).getText().toString());

        int doubleRooms = Integer.parseInt(((EditText) findViewById(R.id.editTextDoubleRooms)).getText().toString());
        double doublePrice = Double.parseDouble(((EditText) findViewById(R.id.editTextDoublePrice)).getText().toString());

        int sharedRooms = Integer.parseInt(((EditText) findViewById(R.id.editTextSharedRooms)).getText().toString());
        double sharedPrice = Double.parseDouble(((EditText) findViewById(R.id.editTextSharedPrice)).getText().toString());

        hostelOwner.setUsername(username);
        hostelOwner.setHostelName(hostelName);
        hostelOwner.setLocation(location);
        hostelOwner.setContactNumber(contactNumber);
        hostelOwner.setWifi(wifi);
        hostelOwner.setParking(parking);
        hostelOwner.setLaundry(laundry);
        hostelOwner.setSingleRooms(singleRooms);
        hostelOwner.setSinglePrice(singlePrice);
        hostelOwner.setDoubleRooms(doubleRooms);
        hostelOwner.setDoublePrice(doublePrice);
        hostelOwner.setSharedRooms(sharedRooms);
        hostelOwner.setSharedPrice(sharedPrice);

        if (imageUri != null) {
            String imageBase64 = imageToBase64(imageUri);
            hostelOwner.setImageBase64(imageBase64);
        }

        String key = databaseReference.push().getKey();

        databaseReference.child(key).setValue(hostelOwner)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(HostelOwnerForm.this, "Hostel owner details added successfully", Toast.LENGTH_SHORT).show();
                    clearForm();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(HostelOwnerForm.this, "Failed to add hostel owner details: " + e, Toast.LENGTH_SHORT).show();
                });
    }

    private String imageToBase64(Uri imageUri) {
        try {
            InputStream inputStream = getContentResolver().openInputStream(imageUri);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return Base64.encodeToString(byteArray, Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void clearForm() {
        // Clear all input fields
        ((EditText) findViewById(R.id.username)).setText("");
        ((EditText) findViewById(R.id.HostleName)).setText("");
        ((EditText) findViewById(R.id.Location)).setText("");
        ((EditText) findViewById(R.id.Cotact_Number)).setText("");
        ((CheckBox) findViewById(R.id.checkBoxWiFi)).setChecked(false);
        ((CheckBox) findViewById(R.id.checkBoxParking)).setChecked(false);
        ((CheckBox) findViewById(R.id.checkBoxLaundry)).setChecked(false);
        ((EditText) findViewById(R.id.editTextSingleRooms)).setText("");
        ((EditText) findViewById(R.id.editTextSinglePrice)).setText("");
        ((EditText) findViewById(R.id.editTextDoubleRooms)).setText("");
        ((EditText) findViewById(R.id.editTextDoublePrice)).setText("");
        ((EditText) findViewById(R.id.editTextSharedRooms)).setText("");
        ((EditText) findViewById(R.id.editTextSharedPrice)).setText("");
        // You may want to clear the image view and other relevant UI elements
    }
}
