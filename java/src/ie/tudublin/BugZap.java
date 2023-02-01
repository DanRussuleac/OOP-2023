package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {
  float playerX;
  float playerY;
  float playerWidth;

  // Bug variables
  float bugX;
  float bugY;
  float bugSpeed;
  boolean bugAlive;

  // Score variables
  int score;

  public void settings() {
    size(500, 500);
  }

  public void setup() {
    playerX = width / 2;
    playerY = height - playerWidth;
    playerWidth = 20;

    bugX = width / 2;
    bugY = 0;
    bugSpeed = 2;
    bugAlive = true;

    score = 0;
  }

  public void drawPlayer(float x, float y, float w) {
    float h = w * 0.5f;
    stroke(255);
    line(x - w / 2, y - h / 2, x + w / 2, y + h / 2);
    line(x - w / 2, y + h / 2, x + w / 2, y - h / 2);
  }

  public void drawBug(float x, float y) {
    stroke(255, 0, 0);
    ellipse(x, y, 10, 10);
  }

  public void drawScore() {
    textSize(20);
    fill(255);
    text("Score: " + score, width - 100, 20);
  }

  public void draw() {
    background(0);
    drawPlayer(playerX, playerY, playerWidth);

    if (bugAlive) {
      drawBug(bugX, bugY);
      bugY += bugSpeed;

      if (bugY + 10 >= playerY && bugX >= playerX - playerWidth / 2 && bugX <= playerX + playerWidth / 2) {
        bugAlive = false;
        println("Game Over");
        if (!bugAlive) {
          textSize(40);
          fill(255);
          text("Game Over!", width / 2 - 80, height / 2);
          text("Press 'R' to restart", width / 2 - 120, height / 2 + 50);
          if (key == 'r' || key == 'R') {
            score = 0;
            bugSpeed = 2;
            loop();
          }
        }
        noLoop();
      }
    } else {
      bugX = random(0, width);
      bugY = 0;
      bugAlive = true;
      bugSpeed += 0.2;  // increment the speed every time a bug is killed
    }

    drawScore();
  }

  public void keyPressed() {
    if (keyCode == LEFT) {
      playerX -= 10;
      if (playerX - playerWidth / 2 < 0) {
        playerX = playerWidth / 2;
      }
    }
    if (keyCode == RIGHT) {
      playerX += 10;
      if (playerX + playerWidth / 2 > width) {
        playerX = width - playerWidth / 2;
      }
    }
    if (key == ' ') {
      stroke(255);
      line(playerX, playerY, playerX, 0);

      if (bugAlive && bugY >= 0 && bugX >= playerX - playerWidth / 2 && bugX <= playerX + playerWidth / 2) {
        bugAlive = false;
        score++;
      }
    }
  }
}
