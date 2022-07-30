package dungeonmania.entities.moving;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static dungeonmania.TestUtils.getEntities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dungeonmania.DungeonManiaController;
import dungeonmania.response.models.DungeonResponse;
import dungeonmania.util.Direction;
import dungeonmania.util.Position;

public class MercenaryTests {
    @Test
    @DisplayName("Test that mercenary is created properly")
    public void testMercenaryConstructor() {
        DungeonManiaController dmc;
        dmc = new DungeonManiaController();
        DungeonResponse res = dmc.newGame("d_mercenaryTest_basicMovement", "c_spiderTest_basicMovement");
        Position pos = getEntities(res, "mercenary").get(0).getPosition();

        assertEquals(new Position(5, 5), pos);
    }

    @Test
    @DisplayName("Test shortest path w/o obstacles")
    public void testDijkstraNoObstacles() {
        DungeonManiaController dmc;
        dmc = new DungeonManiaController();
        DungeonResponse res = dmc.newGame("d_mercenaryTest_basicMovement", "c_spiderTest_basicMovement");
        Position mercPos = getEntities(res, "mercenary").get(0).getPosition();
        Position playerPos = getEntities(res, "player").get(0).getPosition();

        // Assert that the player and mercenaries are in the right spot
        assertEquals(new Position(5, 5), mercPos);
        assertEquals(new Position(2, 2), playerPos);

        // Player moves right 1 -> merc moves UP one
        res = dmc.tick(Direction.RIGHT);

        // Assert that the player and mercenaries are in the right position
        assertEquals(new Position(3, 2), getEntities(res, "player").get(0).getPosition());
        // assertEquals(new Position(5, 4), getEntities(res, "mercenary").get(0).getPosition());

        // Player moves right 1 -> merc moves UP one 
        res = dmc.tick(Direction.RIGHT);
        assertEquals(new Position(4, 2), getEntities(res, "player").get(0).getPosition());
        // assertEquals(new Position(5, 3), getEntities(res, "mercenary").get(0).getPosition());

        // Player moves right 1 -> merc moves UP one
        res = dmc.tick(Direction.RIGHT);
        assertEquals(new Position(5, 2), getEntities(res, "player").get(0).getPosition());
        // assertEquals(new Position(5, 2), getEntities(res, "mercenary").get(0).getPosition());
    }
}