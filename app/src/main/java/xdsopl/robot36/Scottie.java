/*
Scottie modes

Copyright 2024 Ahmet Inan <xdsopl@gmail.com>
*/

package xdsopl.robot36;

public class Scottie implements Mode {
	private final int scanLineSamples;
	private final String name;

	Scottie(String name, double channelSeconds, int sampleRate) {
		this.name = "Scottie " + name;
		double syncPulseSeconds = 0.009;
		double separatorSeconds = 0.0015;
		double scanLineSeconds = syncPulseSeconds + 3 * (channelSeconds + separatorSeconds);
		scanLineSamples = (int) Math.round(scanLineSeconds * sampleRate);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getScanLineSamples() {
		return scanLineSamples;
	}

	@Override
	public boolean decodeScanLine(int[] pixelBuffer, float[] scanLineBuffer, int prevPulseIndex, int scanLineSamples) {
		if (prevPulseIndex < 0 || prevPulseIndex + scanLineSamples >= scanLineBuffer.length)
			return false;
		for (int i = 0; i < pixelBuffer.length; ++i) {
			int position = (i * scanLineSamples) / pixelBuffer.length + prevPulseIndex;
			int intensity = (int) Math.round(255 * Math.sqrt(scanLineBuffer[position]));
			int pixelColor = 0xff000000 | 0x00010101 * intensity;
			pixelBuffer[i] = pixelColor;
		}
		return true;
	}
}