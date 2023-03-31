package com.midhun.hawkssolutions.transport.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.midhun.hawkssolutions.transport.Dao.ProductsDao;
import com.midhun.hawkssolutions.transport.Modal.Products;

@Database(entities = {Products.class}, version = 2)
public abstract class ProductDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="ProductDatabase";

    public abstract ProductsDao productsDao();

    private static volatile ProductDatabase INSTANCE;

    public static ProductDatabase getInstance(Context context){
        if(INSTANCE == null)
        {
            synchronized (ProductDatabase.class){
                if(INSTANCE == null)
                {
                    INSTANCE= Room.databaseBuilder(context, ProductDatabase.class,
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
        private ProductsDao productsDao;
        PopulateAsynTask(ProductDatabase productDatabase)
        {
            productsDao=productDatabase.INSTANCE.productsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            productsDao.deleteAll();
            return null;
        }
    }
}
