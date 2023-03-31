package com.midhun.hawkssolutions.transport.Response;

import com.google.gson.annotations.SerializedName;
import com.midhun.hawkssolutions.transport.Modal.TripsInfo;

import java.util.List;

public class TripInfoApiModel {
    @SerializedName("trips")
    List<TripsInfo> tripDetailsList;

    public List<TripsInfo> getTripDetailsList() {
        return tripDetailsList;
    }

    public void setTripDetailsList(List<TripsInfo> tripDetailsList) {
        this.tripDetailsList = tripDetailsList;
    }
}
