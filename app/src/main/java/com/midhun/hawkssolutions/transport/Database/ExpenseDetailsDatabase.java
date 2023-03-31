package com.midhun.hawkssolutions.transport.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.midhun.hawkssolutions.transport.Dao.ExpenseDetailsDao;
import com.midhun.hawkssolutions.transport.Dao.ExpenseTypeDao;
import com.midhun.hawkssolutions.transport.Modal.ExpensesDetails;


@Database(entities ={ExpensesDetails.class},version = 2)
public abstract class ExpenseDetailsDatabase extends RoomDatabase {

    private static final String DATABASE_NAME="ExpenseDetailsDatabase";
    public abstract ExpenseDetailsDao expenseDetailsDao();

    private static volatile ExpenseDetailsDatabase INSTANCE;

    public static ExpenseDetailsDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ExpenseDetailsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, ExpenseDetailsDatabase.class,
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
        private ExpenseDetailsDao expenseDetailsDao;
        PopulateAsynTask(ExpenseDetailsDatabase expenseDetailsDatabase)
        {
            expenseDetailsDao=expenseDetailsDatabase.INSTANCE.expenseDetailsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            expenseDetailsDao.deleteExpenseDetails();
            return null;
        }
    }

}
