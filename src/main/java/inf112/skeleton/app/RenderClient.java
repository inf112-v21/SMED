package inf112.skeleton.app;

import java.io.IOException;


public class RenderClient extends RenderServer {

    @Override
    public void setUpGame(){
        Player temp = player1;
        player1 = player2;
        player2 = temp;

        try {
            connection.setUpClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void simulateRound() {
        try {
            gameLogic.doRoundClient();
            cardsToPickFrom = gameLogic.cardsToPickFrom;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
