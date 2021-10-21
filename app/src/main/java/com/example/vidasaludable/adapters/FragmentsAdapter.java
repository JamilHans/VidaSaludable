package com.example.vidasaludable.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.vidasaludable.alimentos.fragments.AlimentosFragment;
import com.example.vidasaludable.alimentos.fragments.ComidasTipicasFragment;

public class FragmentsAdapter extends FragmentStateAdapter {

    private String[] titles = {"Comida Tipicas", "Alimentos"};

    public FragmentsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new ComidasTipicasFragment();
            case 1:
                return new AlimentosFragment();
        }
        return new ComidasTipicasFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
