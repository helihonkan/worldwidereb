package com.rebtel.worldwidereb.server;

import com.rebtel.worldwidereb.model.Country;

import java.util.List;

/**
 * Created by helena on 10/02/17.
 * <p>
 * Interface to use for success and error responses when fetching country data.
 */

public interface ResponseListener {

    /**
     * Successfully fetched and parsed data
     *
     * @param countries List of countries
     */
    void onSuccess(List<Country> countries);

    /**
     * Fetching country data was unsuccessful
     */
    void onError();
}
