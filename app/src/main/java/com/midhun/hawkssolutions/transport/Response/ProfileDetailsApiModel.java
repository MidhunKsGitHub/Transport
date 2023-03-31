package com.midhun.hawkssolutions.transport.Response;

import com.midhun.hawkssolutions.transport.Modal.ProfileDetails;

import java.util.List;

public class ProfileDetailsApiModel {
    List<ProfileDetails> profileDetails;

    public ProfileDetailsApiModel(List<ProfileDetails> profileDetails) {
        this.profileDetails = profileDetails;
    }

    public List<ProfileDetails> getProfileDetails() {
        return profileDetails;
    }

    public void setProfileDetails(List<ProfileDetails> profileDetails) {
        this.profileDetails = profileDetails;
    }
}
