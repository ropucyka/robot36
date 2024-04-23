/*
Exponential Moving Average

Copyright 2024 Ahmet Inan <xdsopl@gmail.com>
*/

package xdsopl.robot36;

public class ExponentialMovingAverage {
	private float alpha;
	private float prev;

	ExponentialMovingAverage() {
		this.alpha = 1;
	}

	public float avg(float input) {
		return prev = prev * (1 - alpha) + alpha * input;
	}

	public void reset(float alpha) {
		this.alpha = alpha;
		prev = 0;
	}
}
