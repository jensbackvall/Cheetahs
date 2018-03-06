package kea.adventurexp.models;

import kea.adventurexp.services.ActivityService;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Activity {

    @Id
    private String Name;
    private String Description;
    private String Limitations;
    private int MinParticipants;
    private int MaxParticipants;
    private int MinAge;
    private int MaxAge;
    private int MinHeight;
    private int MaxHeight;
    private int MinWeight;
    private int MaxWeight;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLimitations() {
        return Limitations;
    }

    public void setLimitations(String limitations) {
        Limitations = limitations;
    }

    public int getMinParticipants() {
        return MinParticipants;
    }

    public void setMinParticipants(int minParticipants) {
        MinParticipants = minParticipants;
    }

    public int getMaxParticipants() {
        return MaxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        MaxParticipants = maxParticipants;
    }

    public int getMinAge() {
        return MinAge;
    }

    public void setMinAge(int minAge) {
        MinAge = minAge;
    }

    public int getMaxAge() {
        return MaxAge;
    }

    public void setMaxAge(int maxAge) {
        MaxAge = maxAge;
    }

    public int getMinHeight() {
        return MinHeight;
    }

    public void setMinHeight(int minHeight) {
        MinHeight = minHeight;
    }

    public int getMaxHeight() {
        return MaxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        MaxHeight = maxHeight;
    }

    public int getMinWeight() {
        return MinWeight;
    }

    public void setMinWeight(int minWeight) {
        MinWeight = minWeight;
    }

    public int getMaxWeight() {
        return MaxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        MaxWeight = maxWeight;
    }
}
