package main;

import racingcar.RacingGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String carNames = scanner.nextLine();
            int times = scanner.nextInt();

            RacingGame game = new RacingGame();
            game.setCarNames(carNames);
            game.run(times);

            System.out.println(game.getRacingCar());
            System.out.println(game.getWinners());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
