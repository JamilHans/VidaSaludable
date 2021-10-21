package com.example.vidasaludable.adapters.imcAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.vidasaludable.control.ImcFragment;
import com.example.vidasaludable.control.RecortdFragment;

public class IMCFragmentAdapter extends FragmentStateAdapter {

    private String[] titles = {"IMC", "Record"};

    public IMCFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new ImcFragment();
            case 1:
                return new RecortdFragment();
        }
        return new ImcFragment(); }

    @Override
    public int getItemCount() {
        return titles.length;    }
}
