package com.midhun.hawkssolutions.transport.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.midhun.hawkssolutions.transport.Dao.TripDetailsDao;
import com.midhun.hawkssolutions.transport.Modal.TripDetails;

@Database(entities = {TripDetails.class}, version = 2)
public abstract class TripDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="TripDatabase";

    public abstract TripDetailsDao tripDao();

    private static volatile TripDatabase INSTANCE;

    public static TripDatabase getInstance(Context context){
        if(INSTANCE == null)
        {
            synchronized (TripDatabase.class){
                if(INSTANCE == null)
                {
                    INSTANCE= Room.databaseBuilder(context, TripDatabase.class,
                            DATABASE_NAME)
                            .addCallback(callback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsynTask(INSTANCE);
        }
    };
    static class PopulateAsynTask extends AsyncTask<Void,Void,Void>
    {
        private TripDetailsDao tripDetailsDao;
        PopulateAsynTask(TripDatabase loginDatabase)
        {
            tripDetailsDao =loginDatabase.INSTANCE.tripDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            tripDetailsDao.deleteAll();
            return null;
        }
    }
}
