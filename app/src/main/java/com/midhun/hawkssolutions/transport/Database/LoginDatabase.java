package com.midhun.hawkssolutions.transport.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.midhun.hawkssolutions.transport.Dao.LoginDao;
import com.midhun.hawkssolutions.transport.Dao.ProductsDao;
import com.midhun.hawkssolutions.transport.Modal.Login;
import com.midhun.hawkssolutions.transport.Modal.Products;

@Database(entities = {Login.class}, version = 2)
public abstract class LoginDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="LoginDatabase";

    public abstract LoginDao loginDao();

    private static volatile LoginDatabase INSTANCE;

    public static LoginDatabase getInstance(Context context){
        if(INSTANCE == null)
        {
            synchronized (LoginDatabase.class){
                if(INSTANCE == null)
                {
                    INSTANCE= Room.databaseBuilder(context, LoginDatabase.class,
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
        private LoginDao loginDao;
        PopulateAsynTask(LoginDatabase loginDatabase)
        {
            loginDao=loginDatabase.INSTANCE.loginDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            loginDao.deleteAll();
            return null;
        }
    }
}
