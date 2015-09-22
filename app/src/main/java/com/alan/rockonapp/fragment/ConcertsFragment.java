package com.alan.rockonapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alan.rockonapp.R;
import com.alan.rockonapp.activity.DetailsActivity;
import com.alan.rockonapp.adapter.ConcertsAdapter;
import com.alan.rockonapp.adapter.model.Concert;
import com.alan.rockonapp.constant.IntentConst;
import com.alan.rockonapp.controller.AppController;
import com.alan.rockonapp.parser.ConcertParser;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 *  Fragment class that represents the message app UI.
 *
 *  @author alan
 */
public class ConcertsFragment extends Fragment implements
        AdapterView.OnItemClickListener,
        Response.Listener<JSONArray>,
        Response.ErrorListener,
        IntentConst {

    private static final String LOG_TAG = ConcertsFragment.class.getSimpleName();
    private ConcertsAdapter mAdapter;

    public ConcertsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_concerts, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.list);

        mAdapter = new ConcertsAdapter(getContext(), new ArrayList());

        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);

        final String JSON_URL = "http://10.0.2.2:8081/api/concerts?city=Buenos Aires";

        final JsonArrayRequest request = new JsonArrayRequest(JSON_URL, this, this);

        request.setRetryPolicy(new DefaultRetryPolicy(
                6000,
                3,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance(getContext()).addToRequestQueue(request);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Concert concert = (Concert) parent.getAdapter().getItem(position);

        Intent detailsActivity = new Intent(getActivity(), DetailsActivity.class);

        detailsActivity.putExtra(INTENT_NAME, concert.getName());
        detailsActivity.putExtra(INTENT_ARTIST_NAME, concert.getName());
        detailsActivity.putExtra(INTENT_MEDIUM_IMAGE_URL, concert.getMediumImageUrl());
        detailsActivity.putExtra(INTENT_EVENT_DATE, concert.getConcertDate());
        detailsActivity.putExtra(INTENT_VENUE_NAME, concert.getVenue().getName());
        detailsActivity.putExtra(INTENT_VENUE_CITY, concert.getVenue().getCity());
        detailsActivity.putExtra(INTENT_VENUE_COUNTRY, concert.getVenue().getCountry());
        detailsActivity.putExtra(INTENT_VENUE_STREET, concert.getVenue().getStreet());
        detailsActivity.putExtra(INTENT_VENUE_LATITUDE, concert.getVenue().getLatitude());
        detailsActivity.putExtra(INTENT_VENUE_LONGITUDE, concert.getVenue().getLongitude());

        startActivity(detailsActivity);
    }

    @Override
    public void onResponse(JSONArray response) {
        ConcertParser parser = new ConcertParser(response);

        mAdapter.setItems(parser.jsonToConcertsList());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        VolleyLog.d(LOG_TAG, "Error: " + error.getMessage());
    }
}
