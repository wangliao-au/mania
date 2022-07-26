package dungeonmania.entities.moving;

public class DefaultState implements PlayerState{
    private String playerState;

    public DefaultState() {
        this.playerState = "DefaultState";
    }

    @Override
    public void becomeInvincible(Player player) {
        player.setPlayerState(new InvincibleState());
    }

    @Override
    public void becomeInvisible(Player player) {
        player.setPlayerState(new InvisibleState());
    }

    @Override
    public void gameOver(Player player) {
        player.setPlayerState(new GameOverState());
        System.out.println("Game Over!");
    }

    @Override
    public void backToDefault(Player player) {
        player.setPlayerState(new DefaultState());
    }
}