package me.kimxu.gitclient;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import me.kimxu.gitclient.adapter.ListAdapter;
import me.kimxu.gitclient.databinding.ActivityMainBinding;
import me.kimxu.gitclient.listener.Callbacks;
import me.kimxu.gitclient.model.SearchResult;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        SearchResult searchResult=new SearchResult();
        searchResult.searchResult="this is ok";
        activityMainBinding.setUser(searchResult);
        ListAdapter listAdapter = new ListAdapter(this);
        activityMainBinding.setHandler(new Callbacks(listAdapter));
        activityMainBinding.listView.setAdapter(listAdapter);
    }
}
