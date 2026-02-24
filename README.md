# 2D Adventure

This is a simple 2D adventure game created in Java to understand the underlying logic of game development.

## How it was created (Step-by-Step)

1.  **Project-Setup**: 
    - Created a new Java project.
    - Organized the project into packages for better structure: `main`, `entity`, `tile`, and `res`.

2.  **Creating the Game Window**:
    - The `Main.java` class serves as the entry point.
    - A `JFrame` is created to act as the game window.
    - A `GamePanel` (a `JPanel`) is created and added to the `JFrame`.

3.  **The Game Loop**:
    - The `GamePanel` implements the `Runnable` interface to create a game loop.
    - A `Thread` is started that calls the `run` method, which contains the game loop.
    - The game loop updates the game state and repaints the screen at a target FPS (Frames Per Second).

4.  **Handling Player Input**:
    - A `KeyHandler` class is created that implements the `KeyListener` interface.
    - It listens for key presses (W, A, S, D) and updates boolean flags (`upPressed`, `downPressed`, etc.).

5.  **Creating the Player**:
    - An `Entity` class is created to hold basic properties for game objects (position, speed).
    - A `Player` class extends `Entity` and contains player-specific logic.
    - The `Player` class loads the player's sprite images.
    - The `update` method in the `Player` class updates the player's position based on the input from the `KeyHandler`.
    - The `draw` method in the `Player` class draws the player's sprite on the screen.

6.  **Creating the World (Tiles)**:
    - A `Tile` class is created to represent a single tile in the game world.
    - A `TileManager` class is created to manage all the tiles.
    - The `TileManager` loads the tile images (grass, wall, water).
    - It also loads a map from a text file (`/res/maps/map.txt`).
    - The `draw` method in the `TileManager` draws the entire map on the screen.

## Future Goals

- [ ] **Collision Detection**: Implement collision detection to prevent the player from walking through walls and other obstacles.
- [ ] **More Maps**: Add more maps and a way to transition between them.
- [ ] **NPCs**: Add non-player characters (NPCs) with which the player can interact.
- [ ] **Enemies**: Add enemies that the player can fight.
- [ ] **Combat System**: Implement a simple combat system.
- [ ] **Inventory System**: Allow the player to collect and use items.
- [ ] **Sound Effects and Music**: Add sound effects for player actions and background music.
- [ ] **UI**: Create a user interface to display player health, score, and other information.
- [ ] **More Advanced Rendering**: Implement more advanced rendering techniques, such as lighting and particle effects.
- [ ] **Animations**: Improve the player and NPC animations.
