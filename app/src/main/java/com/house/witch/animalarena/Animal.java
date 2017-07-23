package com.house.witch.animalarena;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by steven on 23/07/2017.
 */

public class Animal implements Parcelable {
    private String name;

    Animal(String name) {
        this.name = name;
    }

    protected Animal(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
