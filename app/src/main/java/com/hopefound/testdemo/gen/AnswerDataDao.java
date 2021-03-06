package com.hopefound.testdemo.gen;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.hopefound.testdemo.entity.AnswerData;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ANSWER_DATA".
*/
public class AnswerDataDao extends AbstractDao<AnswerData, Long> {

    public static final String TABLENAME = "ANSWER_DATA";

    /**
     * Properties of entity AnswerData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property AnswerId = new Property(0, Long.class, "answerId", true, "_id");
        public final static Property QuestionId = new Property(1, Long.class, "questionId", false, "QUESTION_ID");
        public final static Property AnswerStr = new Property(2, String.class, "answerStr", false, "ANSWER_STR");
    }

    private Query<AnswerData> surveyData_AnswerStrQuery;

    public AnswerDataDao(DaoConfig config) {
        super(config);
    }
    
    public AnswerDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ANSWER_DATA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: answerId
                "\"QUESTION_ID\" INTEGER," + // 1: questionId
                "\"ANSWER_STR\" TEXT);"); // 2: answerStr
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ANSWER_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AnswerData entity) {
        stmt.clearBindings();
 
        Long answerId = entity.getAnswerId();
        if (answerId != null) {
            stmt.bindLong(1, answerId);
        }
 
        Long questionId = entity.getQuestionId();
        if (questionId != null) {
            stmt.bindLong(2, questionId);
        }
 
        String answerStr = entity.getAnswerStr();
        if (answerStr != null) {
            stmt.bindString(3, answerStr);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AnswerData entity) {
        stmt.clearBindings();
 
        Long answerId = entity.getAnswerId();
        if (answerId != null) {
            stmt.bindLong(1, answerId);
        }
 
        Long questionId = entity.getQuestionId();
        if (questionId != null) {
            stmt.bindLong(2, questionId);
        }
 
        String answerStr = entity.getAnswerStr();
        if (answerStr != null) {
            stmt.bindString(3, answerStr);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AnswerData readEntity(Cursor cursor, int offset) {
        AnswerData entity = new AnswerData( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // answerId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // questionId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // answerStr
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AnswerData entity, int offset) {
        entity.setAnswerId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setQuestionId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setAnswerStr(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AnswerData entity, long rowId) {
        entity.setAnswerId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AnswerData entity) {
        if(entity != null) {
            return entity.getAnswerId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AnswerData entity) {
        return entity.getAnswerId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "answerStr" to-many relationship of SurveyData. */
    public List<AnswerData> _querySurveyData_AnswerStr(Long questionId) {
        synchronized (this) {
            if (surveyData_AnswerStrQuery == null) {
                QueryBuilder<AnswerData> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.QuestionId.eq(null));
                surveyData_AnswerStrQuery = queryBuilder.build();
            }
        }
        Query<AnswerData> query = surveyData_AnswerStrQuery.forCurrentThread();
        query.setParameter(0, questionId);
        return query.list();
    }

}
