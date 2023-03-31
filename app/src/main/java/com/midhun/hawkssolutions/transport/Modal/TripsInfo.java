package com.midhun.hawkssolutions.transport.Modal;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "TripsInfo",indices = @Index(value = {"id"},unique = true))
public class TripsInfo {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String id;
    private String trip;
    private String from_date;
    private String to_date;
    private String starting_km;
    private String end_km;
    private String registration_number;
    private String driver;
    private String start_location;
    private String end_location;
    private String start_state;
    private String end_state;
    private String vehicleType;
    private String trip_status;

    public TripsInfo(String id, String trip, String from_date, String to_date, String starting_km, String end_km, String registration_number, String driver, String start_location, String end_location, String start_state, String end_state, String vehicleType,String trip_status) {
        this.id = id;
        this.trip = trip;
        this.from_date = from_date;
        this.to_date = to_date;
        this.starting_km = starting_km;
        this.end_km = end_km;
        this.registration_number = registration_number;
        this.driver = driver;
        this.start_location = start_location;
        this.end_location = end_location;
        this.start_state = start_state;
        this.end_state = end_state;
        this.vehicleType = vehicleType;
        this.trip_status=trip_status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public String getStarting_km() {
        return starting_km;
    }

    public void setStarting_km(String starting_km) {
        this.starting_km = starting_km;
    }

    public String getEnd_km() {
        return end_km;
    }

    public void setEnd_km(String end_km) {
        this.end_km = end_km;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getStart_location() {
        return start_location;
    }

    public void setStart_location(String start_location) {
        this.start_location = start_location;
    }

    public String getEnd_location() {
        return end_location;
    }

    public void setEnd_location(String end_location) {
        this.end_location = end_location;
    }

    public String getStart_state() {
        return start_state;
    }

    public void setStart_state(String start_state) {
        this.start_state = start_state;
    }

    public String getEnd_state() {
        return end_state;
    }

    public void setEnd_state(String end_state) {
        this.end_state = end_state;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTrip_status() {
        return trip_status;
    }

    public void setTrip_status(String trip_status) {
        this.trip_status = trip_status;
    }
}
