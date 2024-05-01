import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Short Assignment 3 (SA-3) provided code
 * Use steganography to hide a message in an image by subtly altering the red component of a pixel.
 * Complete hideMessage and getMessage methods.
 *
 * @author Tim Pierson, Dartmouth CS10, Winter 2024
 */
public class Steganography {
    private Character STOP_CHARACTER = '*';
    private int BITS_PER_CHARACTER = 7;
    private int MAX_COLOR = 255;

    /**
     * Hides a message in an image.  First add a stop character to the end of the message so when a message is recovered
     * the recovery operations knows it is at the end of the message when it encounters the stop character.
     * Convert each character in message to "1" and "0" bit.
     * For each bit, alter the red component so that "0" bits result in an even red color, while "1" bits result in an odd
     * red color.  Use Integer.toBinaryString(c) to create a String of "1" and "0" bits from Character c.
     * @param original - BufferedImage holding the image to hide the message in
     * @param message - String message to hide
     * @return - altered BufferedImage result where pixels are even if bit is "0" and odd if bit is "1"
     */
    public BufferedImage hideMessage(BufferedImage original, String message) {
        int x = 0, y = 0;
        message += STOP_CHARACTER;

        //Print an error message if there are not enough pixels in the image to store the entire message and return null
        int totalBits = BITS_PER_CHARACTER * message.length();
        int totalPixels = original.getHeight() * original.getWidth();
        if (totalBits > totalPixels){
            System.out.println("Error: Image is too small to store the message.");
            return null;
        }

        //make copy of original image so we don't alter the original image
        BufferedImage result = new BufferedImage(original.getColorModel(), original.copyData(null), original.getColorModel().isAlphaPremultiplied(), null);

        //loop over each character in the message
        for (char c: message.toCharArray()){
            String bits = Integer.toBinaryString(c);
            while (bits.length() < BITS_PER_CHARACTER){
                bits = "0" + bits; //prepend zeroes until its a total of seven bits
            }

            // Loop over each bit in the character's binary representation
            for (char bit : bits.toCharArray()) {
                int red = new Color(result.getRGB(x, y)).getRed();
                if (bit == '0' && red % 2 != 0) {  // Red is odd, make it even
                    red++;
                    if (red > MAX_COLOR) {
                        red = 0;  // Wrap back to 0
                    }
                } else if (bit == '1' && red % 2 == 0) {  // Red is even, make it odd
                    red--;
                    if (red < 0) {
                        red = MAX_COLOR;  // Wrap back to 255
                    }
                }
                result.setRGB(x, y, new Color(red, new Color(result.getRGB(x, y)).getGreen(), new Color(result.getRGB(x, y)).getBlue()).getRGB());

                x++;
                if (x >= result.getWidth()) {
                    x = 0;
                    y++;
                }
            }
        }

        return result;
    }

    /**
     * Recover message hidden in image.  Loop until stop character is encountered.
     * @param img - BufferedImage with hidden message
     * @return String with recovered message
     */
    public String getMessage(BufferedImage img) {
        String message = "";
        String temp = "";
        int x = 0, y = 0;

        // Loop until the stop character is encountered
        while (!message.endsWith("*")) {
            int red = new Color(img.getRGB(x, y)).getRed();
            temp += (red % 2 == 0) ? "0" : "1";  // Add '0' for even, '1' for odd

            if (temp.length() == BITS_PER_CHARACTER) {
                char lastCharacter = (char) Integer.parseInt(temp, 2);
                message += lastCharacter;
                temp = "";
            }

            x++;
            if (x >= img.getWidth()) {
                x = 0;
                y++;
            }
        }

        return message.substring(0, message.length() - 1);  // Remove the stop character
    }



    public static void main(String[] args) {
        String originalImageFileName = "pictures/Burnham.png";
        String hiddenImageFileName = "pictures/hiddenBurnham.png"; //do not use lossy jpg format, corrupts message, use png
        String message = "Ikenna Nwafor";

        //hide message in image
        System.out.println("Hiding message: " + message);
        BufferedImage image = ImageIOLibrary.loadImage(originalImageFileName);
        Steganography s = new Steganography();
        BufferedImage hiddenMessageImage = s.hideMessage(image, message);
        ImageGUI gui = new ImageGUI("SA-3  Can you tell the difference between images?",image, hiddenMessageImage);

        //save image with hidden message to disk
        ImageIOLibrary.saveImage(hiddenMessageImage, hiddenImageFileName,"png");

        //read image from disk and retrieve message from image
        BufferedImage img = ImageIOLibrary.loadImage(hiddenImageFileName);
        String recoveredMessage = s.getMessage(hiddenMessageImage);
        System.out.println("Recovered message: " + recoveredMessage);

    }
}
