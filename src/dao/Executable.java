/**
 * 
 */
package dao;

/**
 * @author murakamitakuya
 * 
 */
public interface Executable<E> {

	/**
	 * Execute the process.
	 * 
	 * @return the result.
	 */
	ExecuteResult<E> execute();
}
