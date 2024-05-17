/**
 * Helper for IncrementerSync
 * Packages up the total in an object with a synchronized increment method
 * @author Tim Pierson, Dartmouth CS 10, provided for Winter 2024
 */
public class IncrementerTotal {
	int total = 0;
	public synchronized void inc() {
		total++;
	}
}