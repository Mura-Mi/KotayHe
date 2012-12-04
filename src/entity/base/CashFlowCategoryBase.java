/**
 * 
 */
package entity.base;

/**
 * @author murakamitakuya
 * 
 */
public class CashFlowCategoryBase {
    private long id;
    private String description;
    private long parent;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public long getParent() {
	return parent;
    }

    public void setParent(long parent) {
	this.parent = parent;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
