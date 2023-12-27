
public class ExamQuestion {
    String Qid;
        String Question;
        String OptionA;
        String OptionB;
        String OptionC;
        String OptionD;
        String Correctanswer; 
        String userans ="";
        int Sno;
        ExamQuestion( String Qid,String Question,String OptionA,String OptionB,String OptionC,String OptionD,String Correctanswer,int Sno)
        {
            this.Question= Question;
            this.OptionA = OptionA;
            this.OptionB = OptionB;
            this.OptionC = OptionC;
             this.OptionD = OptionD;
            this.Correctanswer = Correctanswer;
            this.userans = userans;
            this.Sno = Sno;
        }

    public String getCorrectanswer() {
        return Correctanswer;
    }

    public void setCorrectanswer(String Correctanswer) {
        this.Correctanswer = Correctanswer;
    }

    public String getUserans() {
        return userans;
    }

    public void setUserans(String userans) {
        this.userans = userans;
    }
        
}
