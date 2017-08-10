package behavetype.commandpattern;

public class PlayCommand implements Command {
	private AudioPlayer myAudio;

	public PlayCommand(AudioPlayer audioPlayer) {
		myAudio = audioPlayer;
	}

	/**
	 * 执行方法
	 */
	public void execute() {
		myAudio.play();
	}
}
