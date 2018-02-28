package soundsystem;

import org.springframework.stereotype.Component;


public class ChinesePeppers implements CompactDisc {
    @Override
    public void play() {
        System.out.println("中文歌曲你看怎么样");
    }
}
