package project;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import engine.Input;
import project.Estados.Estado;
import engine.Game;

public class Jugador extends ObjetoDeJuego {

	private class Vec2 {
		public int x, y;

		public Vec2(int _x, int _y) {
			x = _x;
			y = _y;
		}
	}

	private ArrayList<Vec2> pos;

	private Estado estatico;
	private Estado moviendo;
	private Estado saltando;
	private Estado bloqueando;
	private Estado muriendo;
	private Estado golpeando;
	private Estado golpe_especial;
	private Estado estado;
	private boolean jugador1;

	public Jugador() {
		height = 100;
		width = 30;
		jugador1 = true;
		pos = new ArrayList<>();
		hitbox = new Rectangle(posX, posY, width, height);
		pos.add(new Vec2(posX, posY));

	}

	public Jugador(boolean jugador1) {
		posX = 50; // tentativo
		posY = 476; // tentativo
		height = 100;
		width = 30;
		this.jugador1 = jugador1;
		pos = new ArrayList<>();
		hitbox = new Rectangle(posX, posY, width, height);
		pos.add(new Vec2(posX, posY));
		this.spawn();
	}

	public boolean isJugador1() {
		return jugador1;
	}

	public void setJugador1(boolean jugador1) {
		this.jugador1 = jugador1;
	}

	public void spawn() {
		posY = 476; // tentativo
		if (this.isJugador1())
			posX = 50; // tentativo
		else
			posX = 900; // tentativo
	}

	public void accion() {

	}

	public void animacion() {

	}

	public void tick() {
		Input input = Input.get();
		if (isJugador1()) {
			if (input.isKeyPressed(KeyEvent.VK_A))
				posX -= 5;
			if (input.isKeyPressed(KeyEvent.VK_D))
				posX += 5;
			if (input.isKeyPressed(KeyEvent.VK_W))
				posY -= 5;
			if (input.isKeyPressed(KeyEvent.VK_S))
				posY += 5;

			hitbox.x = posX;
			hitbox.y = posY;

			pos.add(new Vec2(posX, posY));
		}

		else {
			if (input.isKeyPressed(KeyEvent.VK_LEFT))
				posX -= 5;
			if (input.isKeyPressed(KeyEvent.VK_RIGHT))
				posX += 5;
			if (input.isKeyPressed(KeyEvent.VK_UP))
				posY -= 5;
			if (input.isKeyPressed(KeyEvent.VK_DOWN))
				posY += 5;

			hitbox.x = posX;
			hitbox.y = posY;

			pos.add(new Vec2(posX, posY));
		}

	}

	public boolean collides(ObjetoDeJuego obj) {
		return hitbox.intersects(obj.getHitbox());
	}

	@Override
	public void render(Graphics2D g) {
		if (isJugador1()) {
			g.setColor(Color.RED);
			g.fillRect(posX, posY, width, height);
		}
		else {
			g.setColor(Color.BLUE);
			g.fillRect(posX, posY, width, height);
		}

	}

}
