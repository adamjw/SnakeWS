package snake.game;

import org.lwjgl.input.Keyboard;

import simpleio.common.Direction;
import simpleio.common.Point;
import simpleio.common.Position;
import simpleio.display.Window;
import simpleio.keyboard.BufferedKeyboard;
import snake.game.controller.CollisionController;
import snake.game.controller.FruitController;
import snake.game.controller.GameInfoController;
import snake.game.controller.SnakeController;
import snake.game.controller.StateController;
import snake.game.drawer.BoardDrawer;
import snake.game.drawer.FruitDrawer;
import snake.game.drawer.GameInfoDrawer;
import snake.game.drawer.SnakeDrawer;
import snake.game.state.Board;
import snake.game.state.Fruit;
import snake.game.state.GameInfo;
import snake.game.state.Snake;

public class SnakeGame {

	// Constants
	private static final int FRAMES_PER_MOVE = 10;
	private static final int HEADER_HEIGHT = 36;
	private static final int CELL_SIZE = 24;
	private static final int NUMBER_OF_CELLS = 15;
	private static final int WINDOW_WIDTH = CELL_SIZE * NUMBER_OF_CELLS;
	private static final int WINDOW_HEIGHT = CELL_SIZE * NUMBER_OF_CELLS + HEADER_HEIGHT;

	// IO
	private Window window;
	private BufferedKeyboard bufferedKeyboard;

	// Meta-State
	private boolean hasStarted = false;

	// State
	private Board board;
	private Snake snake;
	private Fruit fruit;
	private GameInfo gameInfo;

	// Drawers
	private BoardDrawer boardDrawer;
	private SnakeDrawer snakeDrawer;
	private FruitDrawer fruitDrawer;
	private GameInfoDrawer gameInfoDrawer;

	// Controllers
	private SnakeController snakeController;
	private FruitController fruitController;
	private StateController stateController;
	private GameInfoController gameInfoController;
	private CollisionController collisionController;

	/**
	 * Begins the game - this method doesn't return until the game is ended.
	 */
	public void start() {
		if (!hasStarted) {
			hasStarted = true;

			initializeIo();

			initializeState();
			initializeDrawers();
			initializeControllers();

			gameLoop();
		}
	}

	/**
	 * Initializes IO. Creates and displays a window, and initializes a keyboard
	 * device.
	 */
	private void initializeIo() {
		window = new Window("Snake", WINDOW_WIDTH, WINDOW_HEIGHT);
		window.display();

		int[] keys = new int[] { Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT, Keyboard.KEY_UP, Keyboard.KEY_DOWN,
				Keyboard.KEY_SPACE };
		bufferedKeyboard = new BufferedKeyboard(keys);
	}

	private void initializeState() {
		fruit = new Fruit();
		board = new Board(NUMBER_OF_CELLS, NUMBER_OF_CELLS);
		snake = new Snake(Direction.right, new Position(NUMBER_OF_CELLS / 2, NUMBER_OF_CELLS / 2), 3);
		gameInfo = new GameInfo("Snake", FRAMES_PER_MOVE);
	}
	
	private void reinitializeState() {
		fruit = new Fruit();
		board = new Board(NUMBER_OF_CELLS, NUMBER_OF_CELLS);
		snake = new Snake(Direction.right, new Position(NUMBER_OF_CELLS / 2, NUMBER_OF_CELLS / 2), 3);
		int highScore = gameInfo.getHighScore();
		gameInfo = new GameInfo("Snake", FRAMES_PER_MOVE);
		gameInfo.setHighScore(highScore);
	}

	private void initializeDrawers() {
		boardDrawer = new BoardDrawer(window, new Point(0, HEADER_HEIGHT), CELL_SIZE);
		snakeDrawer = new SnakeDrawer(boardDrawer);
		fruitDrawer = new FruitDrawer(boardDrawer);
		gameInfoDrawer = new GameInfoDrawer(window, new Point(0, 0));
	}

	private void initializeControllers() {
		snakeController = new SnakeController();
		fruitController = new FruitController();
		stateController = new StateController();
		gameInfoController = new GameInfoController();
		collisionController = new CollisionController();
	}

	private void gameLoop() {
		while (!window.isCloseRequested()) {
			updateLogic();
			updateScreen();
			window.refresh();
			bufferedKeyboard.poll();
		}
	}

	private void updateLogic() {
		// not started state
		if (gameInfo.getState() == GameInfo.GameState.NOT_STARTED) {
			stateController.changeState(bufferedKeyboard, gameInfo);
		}

		// dead state
		if (gameInfo.getState() == GameInfo.GameState.DEAD) {
			stateController.changeState(bufferedKeyboard, gameInfo);

		}

		// restarting state
		if (gameInfo.getState() == GameInfo.GameState.RESTARTING) {
			reinitializeState();
			stateController.setState(GameInfo.GameState.NOT_STARTED, gameInfo);
		}

		// playing state
		if (gameInfo.getState().equals(GameInfo.GameState.PLAYING)) {
			gameInfoController.incrementFrame(gameInfo);

			if (gameInfo.getFrame() % gameInfo.getFramesPerMove() == 0) {

				snakeController.updateMovingDirection(bufferedKeyboard, snake);
				bufferedKeyboard.clear();

				if (collisionController.isMoveValid(board, snake)) {
					snakeController.move(snake);

					if (collisionController.isCollidingWithFruit(snake, fruit)) {
						fruitController.moveFruit(snake.getSegments(), board, fruit);
						fruitController.recolourFruit(fruit);
						snake.addSegment();
						gameInfoController.addScore(10, gameInfo);
					}
				}

				else {
					gameInfo.setState(GameInfo.GameState.DEAD);
				}
			}
		}
	}

	private void updateScreen() {
		boardDrawer.drawBoard(board);
		fruitDrawer.drawFruit(fruit);
		snakeDrawer.drawSnake(snake);

		gameInfoDrawer.drawTitle(gameInfo);
		gameInfoDrawer.drawMessage(gameInfo);
		gameInfoDrawer.drawScore(gameInfo);
		gameInfoDrawer.drawHighScore(gameInfo);

	}
}
