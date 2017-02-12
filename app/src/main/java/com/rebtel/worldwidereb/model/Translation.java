package com.rebtel.worldwidereb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by helena on 11/02/17.
 * <p>
 * Holds translations. JSONProperty annotation is used for parsing out data
 */

public class Translation implements Serializable {

    @JsonProperty("de")
    private String mGermanTranslation;

    @JsonProperty("es")
    private String mSpanishTranslation;

    @JsonProperty("fr")
    private String mFrenchTranslation;

    @JsonProperty("ja")
    private String mJapaneseTranslation;

    @JsonProperty("it")
    private String mItalianTranslation;

    /**
     * Returns the German translation
     *
     * @return The German translation
     */
    public String getGermanTranslation() {
        if (mGermanTranslation == null) {
            return "-";
        } else {
            return mGermanTranslation;
        }
    }

    /**
     * Returns the Spanish translation
     *
     * @return The Spanish translation
     */
    public String getSpanishTranslation() {
        if (mSpanishTranslation == null) {
            return "-";
        } else {
            return mSpanishTranslation;
        }
    }

    /**
     * Returns the French translation
     *
     * @return The French translation
     */
    public String getFrenchTranslation() {
        if (mFrenchTranslation == null) {
            return "-";
        } else {
            return mFrenchTranslation;
        }
    }

    /**
     * Returns the Japanese translation
     *
     * @return The Japanese translation
     */
    public String getJapaneseTranslation() {
        if (mJapaneseTranslation == null) {
            return "-";
        } else {
            return mJapaneseTranslation;
        }
    }

    /**
     * Returns the Italian translation
     *
     * @return The Italian translation
     */
    public String getItalianTranslation() {
        if (mItalianTranslation == null) {
            return "-";
        } else {
            return mItalianTranslation;
        }
    }
}
