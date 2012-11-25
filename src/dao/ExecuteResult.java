/**
 * 
 */
package dao;

/**
 * @author murakamitakuya
 * @param E
 *            the type of result
 * 
 */
public class ExecuteResult<E> {
	private boolean succeed;
	private E result;

	/**
	 * Constructor
	 * 
	 * @param succeed
	 *            succeed?
	 * @param result
	 *            the result
	 */
	public ExecuteResult(boolean succeed, E result) {
		this.succeed = succeed;
		this.result = result;
	}

	/**
	 * get the execute is succeed.
	 * 
	 * @return return {@code true} when the execution is succeed.
	 */
	public boolean isSucceed() {
		return this.succeed;
	}

	/**
	 * get the result.
	 * 
	 * @return the result
	 */
	public E getResult() {
		return this.result;
	}

}
