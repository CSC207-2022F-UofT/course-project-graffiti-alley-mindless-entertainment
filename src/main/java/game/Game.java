package game;

import switch_managers.*;
import io.InputHandler;
import io.InputHandlerImpl;
import switch_managers.SwitchEventMediator;
import switch_managers.SwitchEventMediatorProxy;

public class Game {
    private final ManagerControllerFactory managerControllerFactory;

    private final InputHandler inputHandler;
    public static void main(String[] args) {

        Game g = new Game();
        g.startGame();

    }

    /**
     * Private constructor to prevent outside access.
     */
        private Game() {
            GameEntities gameEntities = new GameEntities();
            managerControllerFactory = new ManagerControllerFactory(gameEntities);
            inputHandler = new InputHandlerImpl();
        }

    /**
     * This constructor is for testing purposes only.
     * @param mockInputHandler the inputHandler to mock input with
     */
    public Game(InputHandler mockInputHandler) {
        GameEntities gameEntities = new GameEntities();
        managerControllerFactory = new ManagerControllerFactory(gameEntities);
        inputHandler = mockInputHandler;
    }

    public void startGame() {

        ManagerController managerController = managerControllerFactory.createManagerController();
        SwitchEventMediator switchEventMediator = SwitchEventMediatorProxy.getInstance();
        switchEventMediator.store(SwitchEventType.MAIN_MENU);
        Shell s = new Shell(inputHandler, managerController, switchEventMediator);
        s.startGame();
    }
}
