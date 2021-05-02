package org.launchcode.practicehub.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Practice {

    @Id
    @GeneratedValue
    private int id;

    private Date practiceDate;

    // arrayList of PracticeType (enum) types
//    private List<PracticeType> types = new ArrayList<>();

    private int numCredits;

    // Will need to add types to constructor
    public Practice(Date practiceDate, int numCredits) {
        this.practiceDate = practiceDate;
        this.numCredits = numCredits;
    }

    public Practice(){}

    public Date getPracticeDate() {
        return practiceDate;
    }

    public void setPracticeDate(Date practiceDate) {
        this.practiceDate = practiceDate;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(int numCredits) {
        this.numCredits = numCredits;
    }
}
