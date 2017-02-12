package com.rebtel.worldwidereb.server;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rebtel.worldwidereb.model.Country;

import java.io.IOException;
import java.util.List;


/**
 * Created by helena on 10/02/17.
 * <p>
 * All methods needed for fetching country information
 */

public class CountryApi {

    private static CountryApi mInstance;
    private final Context mContext;

    private CountryApi(@NonNull final Context context) {
        mContext = context;
    }

    /**
     * The current instance of this singleton.
     *
     * @param context The current context.
     * @return The current instance of this singleton.
     */
    public static CountryApi getInstance(@NonNull final Context context) {
        if (mInstance == null) {
            mInstance = new CountryApi(context);
        }
        return mInstance;
    }

    /**
     * Calls a get-request for all countries
     *
     * @param responseListener holds callback methods
     */
    public void getAllCountries(final ResponseListener responseListener) {
        getRequest(UrlConstants.URL_ALL, responseListener);
    }

    /**
     * Calls a get-request for countries with a certain sub string
     *
     * @param subString        part of country name
     * @param responseListener holds callback methods
     */
    public void getCountryByName(String subString, final ResponseListener responseListener) {
        getRequest(UrlConstants.URL_NAME_SUBSTRING + subString, responseListener);
    }

    /**
     * Makes the get-request. On success: it will try and map the
     * string response into a country object
     *
     * @param url      The URL were information is gathered
     * @param listener holds callback methods
     */
    private void getRequest(String url, final ResponseListener listener) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(mInstance.mContext);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            List<Country> countryList = objectMapper.readValue(
                                    response,
                                    new TypeReference<List<Country>>() {
                                    });
                            listener.onSuccess(countryList);
                        } catch (IOException e) {
                            e.printStackTrace();
                            listener.onError();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError();
            }
        });
        queue.add(stringRequest);
    }
}
