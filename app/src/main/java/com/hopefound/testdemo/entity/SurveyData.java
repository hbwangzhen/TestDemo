package com.hopefound.testdemo.entity;

import com.hopefound.testdemo.gen.AnswerDataDao;
import com.hopefound.testdemo.gen.DaoSession;
import com.hopefound.testdemo.gen.SurveyDataDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by 王震 on 2018/4/25 0025.
 */
@Entity
public class SurveyData {
    @Id
    private Long id;
    private String questionName;
    private boolean isAnswed;
    @ToMany(referencedJoinProperty = "questionId")
    private List<AnswerData> answerStr;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1832661909)
    private transient SurveyDataDao myDao;
    @Generated(hash = 1556114614)
    public SurveyData(Long id, String questionName, boolean isAnswed) {
        this.id = id;
        this.questionName = questionName;
        this.isAnswed = isAnswed;
    }
    @Generated(hash = 1724948157)
    public SurveyData() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getQuestionName() {
        return this.questionName;
    }
    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }
    public boolean getIsAnswed() {
        return this.isAnswed;
    }
    public void setIsAnswed(boolean isAnswed) {
        this.isAnswed = isAnswed;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1893789182)
    public List<AnswerData> getAnswerStr() {
        if (answerStr == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AnswerDataDao targetDao = daoSession.getAnswerDataDao();
            List<AnswerData> answerStrNew = targetDao
                    ._querySurveyData_AnswerStr(id);
            synchronized (this) {
                if (answerStr == null) {
                    answerStr = answerStrNew;
                }
            }
        }
        return answerStr;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 158572426)
    public synchronized void resetAnswerStr() {
        answerStr = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 421100369)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSurveyDataDao() : null;
    }


    @Override
    public String toString() {
        String answerListStr = "";
        if (getAnswerStr().size()>0){
            for (AnswerData answerData : getAnswerStr()){
                answerListStr +=answerData.toString();
            }
        }else {
            answerListStr = "null";
        }
        return "question{"+
                "id"+id+
                "name"+questionName+
                "answerList"+answerListStr;
    }
}
