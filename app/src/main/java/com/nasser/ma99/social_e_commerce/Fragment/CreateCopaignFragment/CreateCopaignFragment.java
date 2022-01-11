package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.nasser.ma99.social_e_commerce.Activity.LoginActivity;
import com.nasser.ma99.social_e_commerce.Activity.MainActivity;
import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentCreateCopaignBinding;
import com.nasser.ma99.social_e_commerce.databinding.FragmentSetBreifBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import static android.app.Activity.RESULT_OK;


public class CreateCopaignFragment extends Fragment {

    private String encodedImage;
    private String encodedImage2;

    int imageheader1 = 100;
    boolean isSave = false;

    FragmentCreateCopaignBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCreateCopaignBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btNextSetBreif.setOnClickListener(view1 -> {
            if(isNotEmpty()) {
                isSave = true;
                Save();
            }

        });


        binding.btBackToLogin.setOnClickListener(view1 -> {

            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);


        });
        binding.addHeaderImage.setOnClickListener(v -> {
            imageheader1 = 100;
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            picKImage.launch(intent);
        });
        binding.addBrandImage.setOnClickListener(v -> {
            imageheader1 = 200;
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            picKImage.launch(intent);
        });

        binding.tvSaveAtNewCompaign.setOnClickListener(v -> {

            if (isNotEmpty()) {
                Save();


            }
        });


        return view;
    }

    private String encodeImage(Bitmap bitmap) {
        int previewWidth = 150;
        int previewHeight = bitmap.getHeight() * previewWidth / bitmap.getWidth();
        Bitmap previewBitmap = Bitmap.createScaledBitmap(bitmap, previewWidth, previewHeight, false);
        ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayInputStream);
        byte[] bytes = byteArrayInputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);

    }

    private final ActivityResultLauncher<Intent> picKImage = registerForActivityResult(

            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && imageheader1 == 100) {
                    if (result.getData() != null) {
                        Uri imageUri = result.getData().getData();

                        try {
                            InputStream inputStream = getActivity().getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            binding.imagecopaign.setImageBitmap(bitmap);

                            encodedImage = encodeImage(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();

                        }
                    }

                } else if (result.getResultCode() == RESULT_OK && imageheader1 == 200) {
                    if (result.getData() != null) {
                        Uri imageUri = result.getData().getData();

                        try {
                            InputStream inputStream = getActivity().getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            binding.imageCopaignBrand.setImageBitmap(bitmap);

                            encodedImage2 = encodeImage(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();

                        }
                    }

                }
            }

    );

    private void Save() {
        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String, Object> company = new HashMap<>();
        company.put(Constants.KEY_BRAND_NAME, binding.etBrandName.getText().toString());
        company.put(Constants.KEY_BRAND_DISCRIPE, binding.etDescripeBrand.getText().toString());
        company.put(Constants.KEY_CATAGORIS, binding.etCatagorie.getText().toString());
        company.put(Constants.KEY_URL_BRAND, binding.etUrlBrand.getText().toString());
        company.put(Constants.KEY_IMAGE_BRAND, encodedImage2);
        company.put(Constants.KEY_IMAGE_COMP, encodedImage);

        database.collection(Constants.KEY_COLLECTION_COMPAIGN)
                .add(company)
                .addOnSuccessListener(documentReference -> {
                    loading(false);
                    showToast("Save Successfully");

                    if(isSave) {
                        SetBreifFragment f = new SetBreifFragment();
                        Bundle b = new Bundle();
                        b.putString("path",documentReference.getPath());
                        f.setArguments(b);


                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainerView, f).commit();
                    }

                })
                .addOnFailureListener(Exception -> {
                    loading(false);
                    showToast(Exception.getMessage());
                    showToast("Save Failed");

                });

    }

    private void loading(Boolean isLoading) {

        if (isLoading) {
            binding.progressBar.setVisibility(View.VISIBLE);

        } else {
            binding.progressBar.setVisibility(View.INVISIBLE);

        }
    }

    private void showToast(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isNotEmpty() {

        if (encodedImage == null) {
            showToast("Select Compagin image ");
            return false;
        } else if (encodedImage2 == null) {
            showToast("Select Brand image ");
            return false;
        } else if (binding.etBrandName.getText().toString().isEmpty()) {
            showToast("Enter Brand Name");
            return false;
        } else if (binding.etDescripeBrand.getText().toString().isEmpty()) {
            showToast("Enter Descripetion of Brand");
            return false;
        } else if (binding.etCatagorie.getText().toString().isEmpty()) {
            showToast("Enter Catagorie");
            return false;
        } else if (binding.etUrlBrand.getText().toString().isEmpty()) {
            showToast("Enter Url Brand");
            return false;
        } else {

            return true;

        }
    }
}

