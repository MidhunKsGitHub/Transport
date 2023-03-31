package com.midhun.hawkssolutions.transport.Response;

import com.google.gson.annotations.SerializedName;
import com.midhun.hawkssolutions.transport.Modal.TripDetails;

import java.util.List;

public class TripDetailsApiModel {
    @SerializedName("tripDetails")
    List<TripDetails> tripDetailsList;

    public TripDetailsApiModel(List<TripDetails> tripDetailsList) {
        this.tripDetailsList = tripDetailsList;
    }

    public List<TripDetails> getTripDetailsList() {
        return tripDetailsList;
    }

    public void setTripDetailsList(List<TripDetails> tripDetailsList) {
        this.tripDetailsList = tripDetailsList;
    }
}
