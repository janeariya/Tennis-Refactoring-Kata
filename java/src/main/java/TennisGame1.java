
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (isAll()) {
            if(m_score1>=3) score = "Deuce";
            else score = convertToString(m_score1)+"-All";
        }
        else if(isAdvantage()) {
            score = (m_score1 - m_score2 == 1) ? "Advantage player1" : "Advantage player2";
        }else if(isWinner()) {
            score = (m_score1-m_score2 >=2)? "Win for player1" : "Win for player2";
        }
        else {
            score = convertToString(m_score1)+ "-" + convertToString(m_score2);
        }
        return score;
    }

    public boolean isAll(){
        return (m_score1==m_score2);
    }

    public boolean isAdvantage(){
        return (Math.abs(m_score1-m_score2)==1 &&(m_score1>=4 || m_score2>=4));
    }

    public boolean isWinner(){
        return (Math.abs(m_score1-m_score2)>=2 &&(m_score1>=4 || m_score2>=4));
    }

    public String convertToString(int input){
        if(input>3) return "";
        String[] score = {"Love", "Fifteen", "Thirty", "Forty"};
        return score[input];
    }
}
