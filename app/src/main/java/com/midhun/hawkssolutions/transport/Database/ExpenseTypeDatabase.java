package com.midhun.hawkssolutions.transport.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.midhun.hawkssolutions.transport.Dao.ExpenseTypeDao;
import com.midhun.hawkssolutions.transport.Modal.ExpenseType;


@Database(entities = {ExpenseType.class}, version = 2)
public abstract class ExpenseTypeDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "ExpenseTypeDatabase";

    public abstract ExpenseTypeDao expenseTypeDao();

    private static volatile ExpenseTypeDatabase INSTANCE;

    public static ExpenseTypeDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ExpenseTypeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, ExpenseTypeDatabase.class,
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
        private ExpenseTypeDao expenseTypeDao;
        PopulateAsynTask(ExpenseTypeDatabase expenseTypeDatabase)
        {
            expenseTypeDao=expenseTypeDatabase.INSTANCE.expenseTypeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            expenseTypeDao.deleteALlExpenseType();
            return null;
        }
    }
}

