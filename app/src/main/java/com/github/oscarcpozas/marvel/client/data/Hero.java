package com.github.oscarcpozas.marvel.client.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Hero implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("realName")
    @Expose
    private String realName;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("abilities")
    @Expose
    private String abilities;
    @SerializedName("groups")
    @Expose
    private String groups;

    public Hero(Parcel in) {
        String[] data = new String[7];
        in.readStringArray(data);
        name = data[0];
        photo = data[1];
        realName = data[2];
        height = data[3];
        power = data[4];
        abilities = data[5];
        groups = data[6];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[] {
                name, photo, realName, height, power, abilities, groups
        });
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };
}
