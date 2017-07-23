package com.house.witch.animalarena;

import android.provider.BaseColumns;

/**
 * Created by steven on 23/07/2017.
 */

public final class AnimalDbContract {
        // To prevent someone from accidentally instantiating the contract class,
        // make the constructor private.
        private AnimalDbContract() {}

        /* Inner class that defines the table contents */
        public static class AnimalEntry implements BaseColumns {
            public static final String TABLE_NAME = "entry";
            public static final String COLUMN_NAME_TITLE = "title";
            public static final String COLUMN_NAME_SUBTITLE = "subtitle";
        }
}
