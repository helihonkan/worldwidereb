package com.rebtel.worldwidereb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rebtel.worldwidereb.R;
import com.rebtel.worldwidereb.model.Country;

import java.util.List;

/**
 * Created by helena on 11/02/17.
 * <p>
 * Adapter for countries.
 */

public class CountryListAdapter extends ArrayAdapter<Country> {

    public CountryListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public CountryListAdapter(Context context, int resource, List<Country> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        Country country = getItem(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_country, null);
            holder.textView = (TextView) convertView.findViewById(R.id.list_item_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(country.getName());
        return convertView;
    }

    /**
     * View holder class
     */
    private static class ViewHolder {
        TextView textView;
    }
}
