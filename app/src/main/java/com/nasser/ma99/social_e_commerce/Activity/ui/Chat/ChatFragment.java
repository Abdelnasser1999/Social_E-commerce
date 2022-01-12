package com.nasser.ma99.social_e_commerce.Activity.ui.Chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.nasser.ma99.social_e_commerce.R;
import com.nasser.ma99.social_e_commerce.databinding.FragmentChatBinding;
import com.nasser.ma99.social_e_commerce.utilities.Constants;

import java.util.Date;
import java.util.HashMap;


public class ChatFragment extends Fragment {

    private FragmentChatBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentChatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.sendMessageButton.setOnClickListener(v->{

            Navigation.findNavController(v).navigate(R.id.action_navigation_chat_to_chatSupportFragment);

        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}