package com.nasser.ma99.social_e_commerce.Fragment.CreateCopaignFragment;

import static android.app.Activity.RESULT_OK;

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

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentMoodboardBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;
import com.nasser.ma99.social_e_commerce.utilities.PreferenceManager;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class MoodboardFragment extends Fragment {
    FragmentMoodboardBinding binding;
    private String encodedImage;
    private PreferenceManager preferenceManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMoodboardBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        preferenceManager = new PreferenceManager(getContext());

        binding.btNextMoodboardDec.setOnClickListener(view1 -> {
                if(isNotEmpty()){
                    Bundle b = getArguments();
                    Fragment  f = new MoodDescriptionFragment();

                    String imageMoodboard   =encodedImage;
                    String Do   =binding.etDo.getText().toString();
                    String Dont   =binding.etDont.getText().toString();

                    preferenceManager.putString(Constants.KEY_MOODBOARD,imageMoodboard);
                    preferenceManager.putString(Constants.KEY_DO,Do);
                    preferenceManager.putString(Constants.KEY_DONT,Dont);

                    f.setArguments(b);




                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView,f).commit();


                }





        });
        binding.addMoodboard.setOnClickListener(v->{
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            picKImage.launch(intent);
        });


        binding.btBackSetBreif.setOnClickListener(view1 -> {

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView,new SetBreifFragment()).commit();


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
                if (result.getResultCode() == RESULT_OK ) {
                    if (result.getData() != null) {
                        Uri imageUri = result.getData().getData();

                        try {
                            InputStream inputStream = getActivity().getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            binding.addMoodboard.setImageBitmap(bitmap);

                            encodedImage = encodeImage(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();

                        }
                    }

                }
            }

    );

    private void showToast(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isNotEmpty() {

        if (binding.etDo.getText().toString().isEmpty()) {
            showToast("Enter Do");
            return false;
        } else if (binding.etDont.getText().toString().isEmpty()) {
            showToast("Enter Dont ");
            return false;
        } else
            return true;
    }

}
