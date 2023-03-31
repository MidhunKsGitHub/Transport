package com.midhun.hawkssolutions.transport.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.midhun.hawkssolutions.transport.Dao.TripDao;
import com.midhun.hawkssolutions.transport.Modal.TripsInfo;

@Database(entities = {TripsInfo.class},version = 2)
public abstract class TripInfoDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="TripInfoDatabase";
    public abstract TripDao tripDao();

    private static volatile TripInfoDatabase INSTANCE;

    public static TripInfoDatabase getInstance(Context context){
        if(INSTANCE == null)
        {
            synchronized (TripInfoDatabase.class){
                if(INSTANCE == null)
                {
                    INSTANCE= Room.databaseBuilder(context, TripInfoDatabase.class,
                                    DATABASE_NAME)
                            .addCallback(callback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static RoomDatabase.Callback callback=new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsynTask(INSTANCE);
        }
    };
    static class PopulateAsynTask extends AsyncTask<Void,Void,Void>
    {
        private TripDao tripDao;
        PopulateAsynTask(TripInfoDatabase tripInfoDatabase)
        {
            tripDao =tripInfoDatabase.INSTANCE.tripDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            tripDao.deleteAll();
            return null;
        }
    }

}
