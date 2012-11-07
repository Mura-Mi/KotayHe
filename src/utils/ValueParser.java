/**
 * 
 */
package utils;

/**
 * @author murakamitakuya
 *
 */
public interface ValueParser<E> {
	/**
	 * Parse the value.
	 * @param source
	 * @return the value in type of {@code E}
	 */
	E parse(String source);

}
