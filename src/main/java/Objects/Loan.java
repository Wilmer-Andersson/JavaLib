package Objects;

import java.util.Date;

public class Loan {
    private int loanID;
    private Artikel article;
    private User user;
    private int loanDuration;
    private Date loanStartDate;

    public Loan(int loanID, Artikel article, User user, int loanDuration, Date loanStartDate) {
        this.loanID = loanID;
        this.article = article;
        this.user = user;
        this.loanDuration = loanDuration;
        this.loanStartDate = loanStartDate;
    }

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public Artikel getArticle() {
        return article;
    }

    public void setArticle(Artikel article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
