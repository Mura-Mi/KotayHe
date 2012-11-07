/**
 * 
 */
package model;

import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;

import com.google.common.collect.Sets;

/**
 * @author murakamitakuya
 * 
 */
public class IncomeRecordClassification extends RecordClassification {
	private static final Set<IncomeRecordClassification> VALUES = Sets
			.newHashSet();

	/**
	 * @param name
	 */
	private IncomeRecordClassification(String name) {
		super(name);
	}

	public static IncomeRecordClassification valueOf(String name) {
		for(IncomeRecordClassification cl:VALUES){
			if(ObjectUtils.equals(name, cl.getName())){
				return cl;
			}
		}
		IncomeRecordClassification newClassification = new IncomeRecordClassification(name);
		VALUES.add(newClassification);
		return newClassification;
	}

}