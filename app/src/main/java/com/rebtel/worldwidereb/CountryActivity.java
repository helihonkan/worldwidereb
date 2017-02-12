package com.rebtel.worldwidereb;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.rebtel.worldwidereb.model.Country;

/**
 * Activity that present all the information about a country
 */
public class CountryActivity extends Activity {

    private final String TAG = CountryActivity.class.getSimpleName();

    private Country mCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        mCountry = (Country) getIntent().getExtras().getSerializable(ActivityKeys.KEY_COUNTRY);

        if (mCountry == null) {
            Log.e(TAG, "Did not provide with country");
            finish();
        }

        setFlag();
        setInformation();
    }

    /**
     * Sets the flag of the country on UI
     */
    private void setFlag() {
        ImageView flagImage = (ImageView) findViewById(R.id.image_country_flag);

        for (String altSpelling : mCountry.getAltSpellings()) {

            //Modify string to match drawable resources
            String drawableString = altSpelling.toLowerCase() + "_";

            Resources resources = this.getResources();
            final int resourceId = resources.getIdentifier(drawableString, "drawable",
                    this.getPackageName());
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    flagImage.setImageDrawable(getDrawable(resourceId));
                } else {
                    flagImage.setImageDrawable(getResources().getDrawable(resourceId));
                }
                break;
            } catch (Resources.NotFoundException e) {
                Log.e(TAG, "Resource not found");
            }
        }
    }

    /**
     * Sets the name and information about the country on UI
     */
    private void setInformation() {
        TextView name = (TextView) findViewById(R.id.country_name);
        name.setText(mCountry.getName());

        TextView countryInformation = (TextView) findViewById(R.id.country_information);
        countryInformation.setText(mCountry.toInformativeString(this));
    }
}
