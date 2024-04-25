/*
Pixel buffer

Copyright 2024 Ahmet Inan <xdsopl@gmail.com>
*/

package xdsopl.robot36;

public class PixelBuffer {
	public int[] pixels;
	public int width;
	public int height;

	PixelBuffer(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}
}