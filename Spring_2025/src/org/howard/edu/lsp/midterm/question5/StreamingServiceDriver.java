package org.howard.edu.lsp.midterm.question5;

/**
 * Driver class to test the Streaming Service.
 */
public class StreamingServiceDriver {
    public static void main(String[] args) {
        // Create instances of different media types
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");

        // Test common behaviors for all media types
        System.out.println("Testing common behaviors for all media types:\n");

        // Test Music
        System.out.println("Testing Music:");
        music.play();    // Expected: Playing music: Still a Friend - Incognito
        music.pause();   // Expected: Paused music: Still a Friend - Incognito
        music.stop();    // Expected: Stopped music: Still a Friend - Incognito
        System.out.println();

        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();    // Expected: Playing movie: Avengers End Game
        movie.pause();   // Expected: Paused movie: Avengers End Game
        movie.stop();    // Expected: Stopped movie: Avengers End Game
        System.out.println();

        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();   // Expected: Playing audiobook: A Promised Land – Barack Obama
        audiobook.pause();  // Expected: Paused audiobook: A Promised Land – Barack Obama
        audiobook.stop();   // Expected: Stopped audiobook: A Promised Land – Barack Obama
        System.out.println();

        // Test unique behaviors for each media type
        System.out.println("Testing Unique Features:\n");

        // Movie-specific behavior: rewind
        Movie movieWithRewind = (Movie) movie;  // Cast to Movie
        movieWithRewind.rewind(30);  // Expected: Rewinding movie: Avengers End Game by 30 seconds
        System.out.println();

        // Audiobook-specific behavior: setPlaybackSpeed
        Audiobook audiobookWithSpeed = (Audiobook) audiobook;  // Cast to Audiobook
        audiobookWithSpeed.setPlaybackSpeed(1.5);  // Expected: Setting playback speed of audiobook: A Promised Land – Barack Obama to 1.5x
        System.out.println();

        // Music-specific behavior: addToPlaylist
        Music musicWithPlaylist = (Music) music;  // Cast to Music
        musicWithPlaylist.addToPlaylist("Favorites");  // Expected: Added Still a Friend - Incognito to Favorites playlist
        System.out.println();
    }
}


/**
 * References:
 * - Java Interfaces: https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html
 * - Java Polymorphism: https://www.geeksforgeeks.org/polymorphism-in-java/
 * - Java Casting: https://www.baeldung.com/java-type-casting
 */

