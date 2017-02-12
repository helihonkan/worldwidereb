package com.rebtel.worldwidereb.model;

import android.content.Context;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rebtel.worldwidereb.R;

import java.io.Serializable;
import java.util.List;

/**
 * Created by helena on 10/02/17.
 * <p>
 * Country object. Use JSONProperty to be able to parse out data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Serializable {

    @JsonProperty("name")
    private String mName;

    @JsonProperty("topLevelDomain")
    private List<String> mTopLevelDomain;

    @JsonProperty("alpha2Code")
    private String mAlpha2Code;

    @JsonProperty("alpha3Code")
    private String mAlpha3Code;

    @JsonProperty("callingCodes")
    private List<String> mCallingCodes;

    @JsonProperty("capital")
    private String mCapital;

    @JsonProperty("altSpellings")
    private List<String> mAltSpellings;

    @JsonProperty("relevance")
    private String mRelevance;

    @JsonProperty("region")
    private String mRegion;

    @JsonProperty("subregion")
    private String mSubRegion;

    @JsonProperty("translations")
    private Translation mTranslations;

    @JsonProperty("population")
    private String mPopulation;

    @JsonProperty("latlng")
    private List<String> mLattLong;

    @JsonProperty("demonym")
    private String mDemonym;

    @JsonProperty("area")
    private String mArea;

    @JsonProperty("gini")
    private String mGini;

    @JsonProperty("timezones")
    private List<String> mTimezones;

    @JsonProperty("borders")
    private List<String> mBorders;

    @JsonProperty("nativeName")
    private String mNativeName;

    @JsonProperty("numericCode")
    private String mNumericCode;

    @JsonProperty("currencies")
    private List<String> mCurrencies;

    @JsonProperty("languages")
    private List<String> mLanguages;

    /**
     * Return name of the country
     *
     * @return The name
     */
    public String getName() {
        return mName;
    }

    /**
     * Return top level domains as list
     *
     * @return Top level domains
     */
    public List<String> getTopLevelDomain() {
        return mTopLevelDomain;
    }

    /**
     * Return the alpha 2 code
     *
     * @return Alpha 2 code
     */
    public String getAlpha2Code() {
        return mAlpha2Code;
    }

    /**
     * Return the alpha 3 code
     *
     * @return Alpha 3 code
     */
    public String getAlpha3Code() {
        return mAlpha3Code;
    }

    /**
     * Return the calling codes as list
     *
     * @return Calling codes
     */
    public List<String> getCallingCodes() {
        return mCallingCodes;
    }

    /**
     * Return the capital of the country
     *
     * @return The capital
     */
    public String getCapital() {
        return mCapital;
    }

    /**
     * Return alternative spellings
     *
     * @return The alternative spellings
     */
    public List<String> getAltSpellings() {
        return mAltSpellings;
    }

    /**
     * Return relevance
     *
     * @return The relevance
     */
    public String getRelevance() {
        return mRelevance;
    }

    /**
     * Return the region
     *
     * @return The region
     */
    public String getRegion() {
        return mRegion;
    }

    /**
     * Return the sub region
     *
     * @return The sub region
     */
    public String getSubRegion() {
        return mSubRegion;
    }

    /**
     * Return translations as {@link Translation} object
     *
     * @return Translations
     */
    public Translation getTranslations() {
        return mTranslations;
    }

    /**
     * Return the population
     *
     * @return The population
     */
    public String getPopulation() {
        return mPopulation;
    }

    /**
     * Return the position as a list of latitude and longitude.
     *
     * @return The position of the country
     */
    public List<String> getLattLong() {
        return mLattLong;
    }

    /**
     * Some countries might not contain lat and long values. Make sure the size of the list is
     * two before converting it to string. If no values are available, replace it with "-".
     *
     * @param ctx current context
     * @return Position as string
     */
    public String getLattLongAsString(Context ctx) {
        if (mLattLong.size() == 2) {
            return ctx.getString(R.string.lat) + " " + mLattLong.get(0) + " " +
                    ctx.getString(R.string.long_) + " " + mLattLong.get(1);
        } else {
            return ctx.getString(R.string.lat) + " - " +
                    ctx.getString(R.string.long_) + " -";
        }
    }

    /**
     * Return the demonym
     *
     * @return The demonym
     */
    public String getDemonym() {
        return mDemonym;
    }

    /**
     * Return the area of the country
     *
     * @return The area
     */
    public String getArea() {
        return mArea;
    }

    /**
     * Return the gini of the country
     *
     * @return The gini
     */
    public String getGini() {
        return mGini;
    }

    /**
     * Return the timezones of the country
     *
     * @return The timezones
     */
    public List<String> getTimezones() {
        return mTimezones;
    }

    /**
     * Return name of countries adjoining the country
     *
     * @return The countries adjoining the country
     */
    public List<String> getBorders() {
        return mBorders;
    }

    /**
     * Return the native name of the country
     *
     * @return The native name
     */
    public String getNativeName() {
        return mNativeName;
    }

    /**
     * Return the numeric code of the country
     *
     * @return The numeric code
     */
    public String getNumericCode() {
        return mNumericCode;
    }

    /**
     * Return the currencies used in the country
     *
     * @return The currencies
     */
    public List<String> getCurrencies() {
        return mCurrencies;
    }

    /**
     * Return the languages used in the country
     *
     * @return The languages
     */
    public List<String> getLanguages() {
        return mLanguages;
    }

    /**
     * Return a string containing information and values of the country
     *
     * @param ctx The context
     * @return A string with all information about the country
     */
    public String toInformativeString(Context ctx) {

        return ctx.getString(R.string.top_level_domain) + " " + getListAsString(mTopLevelDomain) + "\n" +
                ctx.getString(R.string.alpha_2_code) + " " + mAlpha2Code + "\n" +
                ctx.getString(R.string.alpha_3_code) + " " + getAlpha3Code() + "\n" +
                ctx.getString(R.string.calling_codes) + " " + getListAsString(mCallingCodes) + "\n" +
                ctx.getString(R.string.capital) + " " + mCapital + "\n" +
                ctx.getString(R.string.alt_spelling) + " " + getListAsString(getAltSpellings()) + "\n" +
                ctx.getString(R.string.relevance) + " " + mRelevance + "\n" +
                ctx.getString(R.string.region) + " " + mRegion + "\n" +
                ctx.getString(R.string.sub_region) + " " + mSubRegion + "\n" +
                ctx.getString(R.string.translations) + "\n" +
                ctx.getString(R.string.german) + " " + mTranslations.getGermanTranslation() + "\n" +
                ctx.getString(R.string.spanish) + " " + mTranslations.getSpanishTranslation() + "\n" +
                ctx.getString(R.string.french) + " " + mTranslations.getFrenchTranslation() + "\n" +
                ctx.getString(R.string.japanese) + " " + mTranslations.getJapaneseTranslation() + "\n" +
                ctx.getString(R.string.italian) + " " + mTranslations.getItalianTranslation() + "\n" +
                ctx.getString(R.string.population) + " " + mPopulation + "\n" +
                ctx.getString(R.string.position) + " " + getLattLongAsString(ctx) + "\n" +
                ctx.getString(R.string.demonym) + " " + mDemonym + "\n" +
                ctx.getString(R.string.area) + " " + mArea + "\n" +
                ctx.getString(R.string.gini) + " " + mGini + "\n" +
                ctx.getString(R.string.timezones) + " " + getListAsString(mTimezones) + "\n" +
                ctx.getString(R.string.borders) + " " + getListAsString(mBorders) + "\n" +
                ctx.getString(R.string.native_name) + " " + mNativeName + "\n" +
                ctx.getString(R.string.numeric_code) + " " + mNumericCode + "\n" +
                ctx.getString(R.string.currencies) + " " + getListAsString(mCurrencies) + "\n" +
                ctx.getString(R.string.languages) + " " + getListAsString(mLanguages) + "\n";
    }

    /**
     * Transform a list of strings to a string
     *
     * @param list List of strings
     * @return One string with the string items
     */
    private String getListAsString(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
            if (i != list.size() - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}
