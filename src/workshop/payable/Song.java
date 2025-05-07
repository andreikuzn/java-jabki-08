package workshop.payable;

public class Song implements Playable {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Играю песню: " + this.title);
    }
}
