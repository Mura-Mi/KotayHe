/**
 * 
 */
package exception;

/**
 * @author murakamitakuya
 * 
 */
@SuppressWarnings("serial")
public class KotayHeRuntimeException extends RuntimeException {

	/**
	 * @param cause
	 */
	public KotayHeRuntimeException(Exception cause) {
		super(cause);
	}

	/**
	 * @param message
	 */
	public KotayHeRuntimeException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public KotayHeRuntimeException(String message, Exception cause) {
		super(message, cause);
	}

}
