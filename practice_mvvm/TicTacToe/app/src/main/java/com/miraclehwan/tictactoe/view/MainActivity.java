package com.miraclehwan.tictactoe.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.miraclehwan.tictactoe.R;
import com.miraclehwan.tictactoe.databinding.ActivityMainBinding;
import com.miraclehwan.tictactoe.viewmodel.TIcTacToeViewModel;

public class MainActivity extends AppCompatActivity {

    TIcTacToeViewModel ticTacToeViewModel = new TIcTacToeViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(ticTacToeViewModel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_reset:
                ticTacToeViewModel.onRestartSelected();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
