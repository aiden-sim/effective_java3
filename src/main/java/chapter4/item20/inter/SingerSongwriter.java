package chapter4.item20.inter;

import chapter4.item20.inter.example.AudioClip;
import chapter4.item20.inter.example.Singer;
import chapter4.item20.inter.example.SongWriter;

public interface SingerSongwriter extends Singer, SongWriter {
	AudioClip strum();

	void actSensitive();
}