/*
RGB modes

Copyright 2024 Ahmet Inan <xdsopl@gmail.com>
*/

package xdsopl.robot36;

@SuppressWarnings("UnnecessaryLocalVariable")
public final class RGBModes {

	public static RGBDecoder Martin(String name, double channelSeconds, int sampleRate) {
		double syncPulseSeconds = 0.004862;
		double separatorSeconds = 0.000572;
		double scanLineSeconds = syncPulseSeconds + separatorSeconds + 3 * (channelSeconds + separatorSeconds);
		double greenBeginSeconds = separatorSeconds;
		double greenEndSeconds = greenBeginSeconds + channelSeconds;
		double blueBeginSeconds = greenEndSeconds + separatorSeconds;
		double blueEndSeconds = blueBeginSeconds + channelSeconds;
		double redBeginSeconds = blueEndSeconds + separatorSeconds;
		double redEndSeconds = redBeginSeconds + channelSeconds;
		return new RGBDecoder("Martin " + name, scanLineSeconds, greenBeginSeconds, redBeginSeconds, redEndSeconds, greenBeginSeconds, greenEndSeconds, blueBeginSeconds, blueEndSeconds, redEndSeconds, sampleRate);
	}

	public static RGBDecoder Scottie(String name, double channelSeconds, int sampleRate) {
		double syncPulseSeconds = 0.009;
		double separatorSeconds = 0.0015;
		double scanLineSeconds = syncPulseSeconds + 3 * (channelSeconds + separatorSeconds);
		double blueEndSeconds = -syncPulseSeconds;
		double blueBeginSeconds = blueEndSeconds - channelSeconds;
		double greenEndSeconds = blueBeginSeconds - separatorSeconds;
		double greenBeginSeconds = greenEndSeconds - channelSeconds;
		double redBeginSeconds = separatorSeconds;
		double redEndSeconds = redBeginSeconds + channelSeconds;
		return new RGBDecoder("Scottie " + name, scanLineSeconds, greenBeginSeconds, redBeginSeconds, redEndSeconds, greenBeginSeconds, greenEndSeconds, blueBeginSeconds, blueEndSeconds, redEndSeconds, sampleRate);
	}

	public static RGBDecoder Wraase_SC2_180(int sampleRate) {
		double syncPulseSeconds = 0.0055225;
		double syncPorchSeconds = 0.0005;
		double channelSeconds = 0.235;
		double scanLineSeconds = syncPulseSeconds + syncPorchSeconds + 3 * channelSeconds;
		double redBeginSeconds = syncPorchSeconds;
		double redEndSeconds = redBeginSeconds + channelSeconds;
		double greenBeginSeconds = redEndSeconds;
		double greenEndSeconds = greenBeginSeconds + channelSeconds;
		double blueBeginSeconds = greenEndSeconds;
		double blueEndSeconds = blueBeginSeconds + channelSeconds;
		return new RGBDecoder("Wraase SC2-180", scanLineSeconds, redBeginSeconds, redBeginSeconds, redEndSeconds, greenBeginSeconds, greenEndSeconds, blueBeginSeconds, blueEndSeconds, blueEndSeconds, sampleRate);
	}
}
