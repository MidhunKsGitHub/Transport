package com.midhun.hawkssolutions.transport.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.midhun.hawkssolutions.transport.Dao.ProfileDao;
import com.midhun.hawkssolutions.transport.Modal.ProfileDetails;

@Database(entities = {ProfileDetails.class}, version = 2)
public abstract class ProfileDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "ProfileDatabase";

    public abstract ProfileDao profileDao();

    public static volatile ProfileDatabase INSTANCE;


    public static ProfileDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (TripDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, ProfileDatabase.class,
                                    DATABASE_NAME)
                            .addCallback(callback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsynTask(INSTANCE);
        }
    };

    static class PopulateAsynTask extends AsyncTask<Void, Void, Void> {
        private ProfileDao profileDao;

        PopulateAsynTask(ProfileDatabase profileDatabase) {
            profileDao = profileDatabase.INSTANCE.profileDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            profileDao.deleteAllProfile();
            return null;
        }
    }
}
