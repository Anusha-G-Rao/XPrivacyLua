package eu.faircode.xlua.android.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import eu.faircode.xlua.log.XLuaDatabaseLogging;

public class XLuaDataBaseUtils {

    private static SQLiteDatabase db = null;
    private static ReentrantReadWriteLock dbLock = new ReentrantReadWriteLock(true);

    public static void addToRecord(String[] valuesForRecord, SQLiteDatabase database) throws Throwable {
        XLuaDatabaseLogging.addToRecord(valuesForRecord);

        if (db == null)
            db = database;

        if (valuesForRecord[0] != null && valuesForRecord[1] != null && valuesForRecord[2] != null && valuesForRecord[3] != null && valuesForRecord[4] != null && valuesForRecord[5] != null) {
            updateRecordDb(valuesForRecord);
        }


    }

    private static void updateRecordDb(String[] valuesForRecord) throws Throwable {

        dbLock.writeLock().lock();
        try {
            db.beginTransaction();
            try {
                // Store event
                ContentValues cv = new ContentValues();
                cv.put("timestamp", valuesForRecord[0]);
                cv.put("method", valuesForRecord[1]);
                cv.put("uid", Integer.valueOf(valuesForRecord[2]));
                cv.put("package", valuesForRecord[3]);
                cv.put("screenlock", valuesForRecord[4]);
                cv.put("foreground", valuesForRecord[5]);
                cv.put("old", valuesForRecord[6]);
                cv.put("new", valuesForRecord[7]);

                long rows = db.insertWithOnConflict("`record`", null, cv, SQLiteDatabase.CONFLICT_REPLACE);
                if (rows < 0)
                    throw new Throwable("Error inserting record");

                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        } finally {
            dbLock.writeLock().unlock();
        }
    }

    public static void addToReserve(String[] valuesForRecord) {
        XLuaDatabaseLogging.addToReserve(valuesForRecord);
    }
}
