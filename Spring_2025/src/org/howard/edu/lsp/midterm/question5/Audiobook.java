package org.howard.edu.lsp.midterm.question5;

/**
 * Represents an Audiobook in the streaming service.
 */
public class Audiobook implements Streamable {
    private String title;

    /**
     * Constructor to initialize the audiobook.
     * @param title The title of the audiobook.
     */
    public Audiobook(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }

    /**
     * Sets the playback speed of the audiobook.
     * @param speed The desired playback speed (e.g., 1.5x).
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " to " + speed + "x");
    }
}

