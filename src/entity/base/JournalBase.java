/**
 * 
 */
package entity.base;

/**
 * @author mura_mi
 * 
 */
public class JournalBase {
    private long id;
    private String name;
    private long userId;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public long getUserId() {
	return userId;
    }

    public void setUserId(long userId) {
	this.userId = userId;
    }

}
