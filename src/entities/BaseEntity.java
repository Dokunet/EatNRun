package entities;

import gui.Window;

public class BaseEntity {
    public int x;
    public int y;
    public int width;
    public int height;

    public BaseEntity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(int dx, int dy) {
        this.y = dy;
        this.x = dx;
    }

    public void draw(Window window) {
        window.setColor(255, 0, 0);
        window.fillRect(this.x, this.y, this.width, this.height);
    }

    public void draw2(Window window) {
        window.setColor(0, 255, 0);
        window.fillRect(this.x, this.y, this.width, this.height);
    }

    public boolean intersects(BaseEntity other) {
        return x - width / 2 < other.x + other.width / 2
                && x + width / 2 > other.x - other.width / 2
                && y - height / 2 < other.y + other.height / 2
                && y + height / 2 > other.y - other.height / 2;
    }

}
