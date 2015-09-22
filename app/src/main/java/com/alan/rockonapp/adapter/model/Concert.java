package com.alan.rockonapp.adapter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO class representing a Concert.
 *
 * @author alan
 */
public class Concert {
    private String concertName;
    private List<Artist> artistsList = new ArrayList<Artist>();
    private String artistName;
    private Venue venue;
    private Ticket ticket;
    private String concertDate;
    private String smallImageUrl;
    private String mediumImageUrl;
    private String largeImageUrl;

    public Concert setName(String name) {
        this.concertName = name;
        return this;
    }

    public String getName() {
        return concertName;
    }


    public Concert setArtistsList(List<Artist> artistsList) {
        this.artistsList = artistsList;
        return this;
    }

    public List<Artist> getArtistsList() {
        return artistsList;
    }

    public Concert setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }

    public String getArtistName() { return artistName; }

    public Concert setVenue(Venue venue) {
        this.venue = venue;
        return this;
    }

    public Venue getVenue() {
        return venue;
    }

    public Concert setTicket(Ticket ticket_data) {
        this.ticket = ticket_data;
        return this;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Concert setConcertDate(String cDate) {
        this.concertDate = cDate;
        return this;
    }

    public String getConcertDate() {
        return concertDate;
    }


    public Concert setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
        return this;
    }

    public String getSmallImageUrl() { return smallImageUrl; }


    public Concert setMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
        return this;
    }

    public String getMediumImageUrl() { return mediumImageUrl; }


    public Concert setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
        return this;
    }

    public String getLargeImageUrl() { return largeImageUrl; }
}
