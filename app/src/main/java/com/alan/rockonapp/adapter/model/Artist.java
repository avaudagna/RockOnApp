package com.alan.rockonapp.adapter.model;

/**
 * Created by alan on 21/09/15.
 */
public class Artist {
    /*
         "artists":
         {
            "id":"5087443",
            "url":"http://ar.5gig.com/artistas/2Cellos",
            "name":"2Cellos",
            "art_logo":"http://d36jiqg3u1m7g0.cloudfront.net/artistas/131x131/v2_131_thumb_5087443_2cellos1_web.jpg"
         }
     */
    private String name;
    private String artLogo;

    public Artist setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Artist setArtLogo(String artLogo) {
        this.artLogo = artLogo;
        return this;
    }

    public String getArtLogo() {
        return artLogo;
    }
}
