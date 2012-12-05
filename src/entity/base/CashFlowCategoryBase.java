/**
 * 
 */
package entity.base;

/**
 * @author murakamitakuya
 * 
 */
public class CashFlowCategoryBase {
    private Long id;
    private String description;
    private Long parent;

    public Long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Long getParent() {
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
