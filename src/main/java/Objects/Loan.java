package Objects;

import java.util.Date;

public class Loan {
    private int loanID;
    private int article;
    private String userName;
    private int loanDuration;
    private Date loanStartDate;
    private int active;

    public Loan(int loanID, int article, String userName, int loanDuration, Date loanStartDate, int active) {
        this.loanID = loanID;
        this.article = article;
        this.userName = userName;
        this.loanDuration = loanDuration;
        this.loanStartDate = loanStartDate;
        this.active = active;
    }

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public Date getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(Date loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
