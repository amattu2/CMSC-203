/**
 * A simple Television Class
 * 09/23/2019 6:21pm
 * @author github.com/amattu2
 * @version 0.01
 */
public class Television {
	private String manufacturer; // Television Product Manufacturer
	private int screenSize; // Television Screensize (Pixels)
	private boolean power = false; // Television State (Powered: true/false)
	private int channel = 2; // Television State (Channel: >= 0)
	private int volume = 20; // Television State (Volume: >= 0)

	/**
	 * Main constructor method
	 * @param (String) Manufacturer
	 * @param (Int) Screen Size
	 * @author github.com/amattu2
	 * @version 0.01
	 */
	public Television(String m, int s ) {
		this.manufacturer = m;
		this.screenSize = s;
	}

	/**
	 * Set Television Channel
	 * @author github.com/amattu2
	 * @version 0.01
	 */
	public void setChannel(int c) {
		this.channel = (c >= 0 ? c : 0);
	}

	/**
	 * Toggle Television Power (0/1)
	 * @author github.com/amattu2
	 * @version 0.01
	 */
	public void power() {
		this.power = (this.power == true ? false : true);
	}

	/**
	 * Increase Television Volume (+1)
	 * @author github.com/amattu2
	 * @version 0.01
	 */
	public void increaseVolume() {
		this.volume = this.volume + 1;
	}

	/**
	 * Decrease Television Volume (-1)
	 * @author github.com/amattu2
	 * @version 0.01
	 */
	public void decreaseVolume() {
		if (this.volume >= 0) {
			this.volume = this.volume - 1;
		}
	}

	/**
	 * Get Television Channel
	 * @author github.com/amattu2
	 * @version 0.01
	 */
	public int getChannel() {
		return this.channel;
	}

	/**
	 * Get Television Volume
	 * @author github.com/amattu2
	 * @version 0.01
	 */
	public int getVolume() {
		return this.volume;
	}

	/**
	 * Get Television Manufacturer
	 * @author github.com/amattu2
	 * @version 0.01
	 */
	public String getManufacturer() {
		return this.manufacturer;
	}

	/**
	 * Get Television Screen Size
	 * @author github.com/amattu2
	 * @version 0.01
	 */
	public int getScreenSize() {
		return this.screenSize;
	}
}
