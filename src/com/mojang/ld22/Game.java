package com.mojang.ld22;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "Untitled Name";
	public static final int HEIGHT = 240;
	public static final int WIDTH = HEIGHT*16/9;

	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private boolean running = false;
	
	public void start() {
		new Thread(this).start();
	}
	
	public void stop() {
		running = false;
	}
	
	public void run() {
		while(running) {
			 runStep();
		}
	}
	
	private void runStep() {
		tick();
		render();
	}
	
	public void tick() {
		
	}

	public  void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH*2, HEIGHT*2));
		game.setMinimumSize(new Dimension(WIDTH*2, HEIGHT*2));
		game.setMaximumSize(new Dimension(WIDTH*2, HEIGHT*2));
				
		JFrame frame = new JFrame(Game.NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}


































