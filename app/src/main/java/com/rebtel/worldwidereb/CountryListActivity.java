package com.rebtel.worldwidereb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rebtel.worldwidereb.adapter.CountryListAdapter;
import com.rebtel.worldwidereb.model.Country;
import com.rebtel.worldwidereb.server.CountryApi;
import com.rebtel.worldwidereb.server.ResponseListener;

import java.util.List;

/**
 * Launch activity
 * Displays a list with countries
 */

public class CountryListActivity extends Activity implements AdapterView.OnItemClickListener,
        TextWatcher, ResponseListener {

    //Progressbar to indicate loading
    private ProgressBar mProgressBar;

    //Adapter for list view
    private CountryListAdapter mAdapter;

    //Listview to populate countries
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        mProgressBar = (ProgressBar) findViewById(R.id.progressbar_loading_countries);

        //add search logic
        EditText editTextSearch = (EditText) findViewById(R.id.edit_text_search);
        editTextSearch.addTextChangedListener(this);

        mListView = (ListView) findViewById(R.id.list_view_countries);
        mListView.setOnItemClickListener(this);

        loadAllCountries();
    }

    /**
     * Use {@link CountryApi} to fetch info about countries
     */
    private void loadAllCountries() {
        CountryApi.getInstance(this).getAllCountries(this);
    }

    /**
     * Populate list view with countries.
     *
     * @param countries List of {@link Country}
     */
    private void populateList(List<Country> countries) {
        if (mAdapter == null) {
            mAdapter = new CountryListAdapter(this, R.layout.list_item_country, countries);
        } else {
            mAdapter.clear();
        }
        mAdapter.addAll(countries);
        mAdapter.notifyDataSetChanged();
        if (mListView.getAdapter() == null) {
            mListView.setAdapter(mAdapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent countryIntent = new Intent(this, CountryActivity.class);
        countryIntent.putExtra(ActivityKeys.KEY_COUNTRY, mAdapter.getItem(position));
        startActivity(countryIntent);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (s.length() == 0) {
            loadAllCountries();
        } else {
            CountryApi.getInstance(this).getCountryByName(s.toString(), this);
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void onSuccess(List<Country> countries) {
        populateList(countries);
        mListView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
        mListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onError() {
        mListView.setVisibility(View.GONE);
        if (!isNetworkConnected()) {
            Toast.makeText(this, getString(R.string.error_no_internet), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Check weather internet is connected or not
     *
     * @return true it connected, false if not
     */
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
