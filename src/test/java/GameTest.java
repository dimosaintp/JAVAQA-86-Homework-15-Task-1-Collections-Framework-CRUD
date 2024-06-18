import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

public class GameTest {

    @Test
    public void whenSecondPlayerWinn() {
        Player player1 = new Player(11582, "Ivan", 130);
        Player player2 = new Player(29955, "Petr", 100);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Ivan", "Petr");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerWinn() {
        Player player1 = new Player(31236, "Yan", 130);
        Player player2 = new Player(767527, "Igor", 190);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Yan", "Igor");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenNobodyWinn() {
        Player player1 = new Player(11752, "Egor", 170);
        Player player2 = new Player(8443, "Dima", 170);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Egor", "Dima");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenSecondPlayerNotRegistered() {
        Player player1 = new Player(5454, "Egor", 170);
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Dima", "Egor");
        });
    }

    @Test
    public void whenFirstPlayerNotRegistered() {
        Player player1 = new Player(5454, "Egor", 170);
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Egor", "Dima");
        });
    }
}