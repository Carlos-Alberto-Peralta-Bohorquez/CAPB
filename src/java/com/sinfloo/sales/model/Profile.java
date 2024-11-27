
package com.sinfloo.sales.model;

public class Profile {
    private int profileId;
    private String description;
    private String state;

    public Profile() {
    }

    public Profile(int profileId, String description, String state) {
        this.profileId = profileId;
        this.description = description;
        this.state = state;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
}
