package com.example.fragmentsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.fragmentsexample.fragments.DetailFragment;
import com.example.fragmentsexample.fragments.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentSendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // получаем экземпляр манагера
        FragmentManager fm = getSupportFragmentManager();
        //создаем и выводим фрагмент список
        Fragment listFragment = fm.findFragmentById(R.id.listFragment);
        listFragment = new ListFragment();
        fm.beginTransaction()
                .add(R.id.listFragment, listFragment)
                .commit();

        //создаем и выводим фрагмент детали
        Fragment detailFragment = fm.findFragmentById(R.id.detailFragment);
        detailFragment = new DetailFragment();
        fm.beginTransaction()
                .replace(R.id.detailFragment, detailFragment)
                .commit();

    }

    //метод взаимодействия фрагментов
    @Override
    public void onSendData(String selectedItem) {
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailFragment);
        if (fragment != null)
            fragment.setSelectedItem(selectedItem);
    }
}