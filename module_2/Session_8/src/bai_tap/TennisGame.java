package bai_tap;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int score1, int score2){
        String score ="";
        if(score1 == score2){
            score = getString(score1);
        }else if(score1 >= 4 || score2 >=4){
            score = getString(score1,score2);
        }else {
            score = getString(score1,score2,score);
        }
        return score;
    }

    public static String getString(int score1) {
        String score;
            switch (score1) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }

        return score;
    }
    private static String getString(int score1, int score2){
        String score;
            int minusResult = score1-score2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        return score;
    }


        private static String getString(int score1, int score2, String score){
            int tempScore;
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = score1;
                else {score+="-"; tempScore = score2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
            return score;
        }

    }

