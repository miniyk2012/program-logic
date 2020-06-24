package headfirst.designpatterns.combined.djview;

public interface BeatModelInterface {
    void initialize();

    void on();

    void off();

    void setBPM(int bpm);

    int getBPM();

    // 这类观察者在每个节拍时都会被通知
    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void notifyBeatObservers();

    // 这类观察者只在BPM被改变时被通知
    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);

    void notifyBPMObservers();
}
