package com.alan.rockonapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alan.rockonapp.R;
import com.alan.rockonapp.constant.IntentConst;
import com.alan.rockonapp.constant.ParserConst;
import com.alan.rockonapp.controller.AppController;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author alan
 */
public class DetailsFragment extends Fragment implements
        Response.Listener<JSONObject>,
        Response.ErrorListener,
        ParserConst,
        IntentConst {

    private static final String LOG_TAG = DetailsFragment.class.getSimpleName();
    private static final String DATE_PATTERN = "yyyy.MM.dd HH:mm:ss";
    private NetworkImageView mConcertPicture;
    private TextView mConcertName;
    private RatingBar mConcertFavorite;
    private TextView mArtistName;
    private TextView mAddressNumber;

    public DetailsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_details, container, false);

        findViewsByParent(view);
        bindViews(getActivity().getIntent());

        return view;
    }

    /**
     *
     * @param view
     */
    private void findViewsByParent(@NonNull final View view) {
        mConcertPicture = (NetworkImageView) view.findViewById(R.id.concert_medium_picture);
        mConcertName = (TextView) view.findViewById(R.id.concert_details_name);
        mConcertFavorite = (RatingBar) view.findViewById(R.id.contact_favorite);
        mArtistName = (TextView) view.findViewById(R.id.artist_name);
        mAddressNumber = (TextView) view.findViewById(R.id.address_number);
    }

    /**
     *
     * @param intent
     */
    private void bindViews(@NonNull final Intent intent) {
        mConcertName.setText(intent.getStringExtra(INTENT_NAME));
        mArtistName.setText(intent.getStringExtra(INTENT_ARTIST_NAME));


        //setFormattedDate(intent.getLongExtra(INTENT_BIRTH_DATE, 0));
        //getDetailsFromNetwork(intent.getStringExtra(INTENT_DETAILS_URL));
    }

    /**
     *
     * @param millis
     */
    private void setFormattedDate(@NonNull final Long millis) {
        Date date = new Date(millis);
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN, Locale.getDefault());

        //mBirthDate.setText(formatter.format(date));
    }

    /**
     *
     * @param url
     */
    private void getDetailsFromNetwork(@NonNull final String url) {
        JsonObjectRequest jsonRequest = new JsonObjectRequest(url, this, this);
        AppController.getInstance(getContext()).addToRequestQueue(jsonRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        ImageLoader loader = AppController.getInstance(getContext()).getImageLoader();
        mConcertFavorite.setIsIndicator(true);
        mConcertFavorite.setNumStars(1);

        try {
            if(response.getBoolean(FAVORITE))
                mConcertFavorite.setRating(1);

            mConcertPicture.setImageUrl(response.getString(LARGE_IMAGE_URL), loader);
            //mAddressNumber.setText(getAddressFromJson(response.getJSONObject(ADDRESS)));

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        VolleyLog.d(LOG_TAG, "Error: " + error.getMessage());
    }

}
