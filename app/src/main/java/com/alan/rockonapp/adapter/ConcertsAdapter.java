package com.alan.rockonapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alan.rockonapp.adapter.model.Concert;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.alan.rockonapp.controller.AppController;
import com.alan.rockonapp.R;

import java.util.List;

/**
 * Custom adapter class
 *
 * @author alan
 */
public class ConcertsAdapter extends BaseAdapter {
    private ImageLoader mImageLoader;
    private Context mContext;
    private List mItems;

    /**
     * Constructor with parameters
     *
     * @param context - the context where the adapter is going to be used.
     * @param items - the list of items that the adapter must represent.
     */
    public ConcertsAdapter(@NonNull final Context context, List items) {
        this.mImageLoader = AppController.getInstance(context).getImageLoader();
        this.mContext = context;
        this.mItems = items;
    }

    public void setItems(List items) {
        this.mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if(null != convertView) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater
                    .from(mContext)
                    .inflate(R.layout.concert_item, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        bindViews(viewHolder, position);

        return convertView;
    }

    /**
     * Method that bind views with the data to be shown.
     *
     * @param viewHolder - the viewHolder used to set the data.
     * @param position - the position where of the data to get.
     */
    private void bindViews(@NonNull final ViewHolder viewHolder, final int position) {
        final Concert concert = (Concert) getItem(position);

        viewHolder.profile.setImageUrl(concert.getMediumImageUrl(), mImageLoader);
        viewHolder.name.setText(concert.getName());
    }

    /**
     * ViewHolder class used for caching the views needed by our adapter.
     *
     * @author alan
     */
    protected static class ViewHolder {
        private NetworkImageView profile;
        private TextView  name;
        private TextView eventDate;

        /**
         * Constructor with parameters.
         *
         * @param view - The root view that contains all the views needed.
         */
        public ViewHolder(@NonNull final View view) {
            profile = (NetworkImageView) view.findViewById(R.id.concert_small_picture);
            name = (TextView) view.findViewById(R.id.concert_item_name);
            eventDate = (TextView) view.findViewById(R.id.item_event_date);
        }
    }
}
