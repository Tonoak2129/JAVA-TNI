package MiniGameParty;

public class GameHub {
    private UserAccount userData;
    private Playable game = null;
    public GameHub(UserAccount userData){
        this.userData = userData;
    }

    public void launch(String gameName){
        switch (gameName){

            case "Rock Paper Scissors":
                game = new RockPaperScissors(this.userData);
                break;

            case "Tic Tac Toe":
                game = new TicTacToe(this.userData);
                break;

            case "Hangman":
                game = new Hangman(this.userData);
                break;

            case "Highlow":
                game = new Highlow(this.userData);
                break;
        }

        if(game != null){
            game.play();
        }
    }

    public static void main(String[] args) {
        System.out.println("Program started");

        UserAccount testUser = new UserAccount("Admin", "inwza");

        GameHub gameService = new GameHub(testUser);

        gameService.launch("Rock Paper Scissors");
    }
}
